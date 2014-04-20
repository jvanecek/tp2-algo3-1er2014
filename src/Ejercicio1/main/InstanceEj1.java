package Ejercicio1.main;

import Otros.Ejercicio;
import Otros.Utils;

public class InstanceEj1 implements Ejercicio {
    private int[] cartas; /**< Cartas del juego. */
    private int puntos; /**< Puntaje del jugador 1 del juego finalizado. */
    private Cache cacheDerecha, cacheIzquierda;

    private static final int MI_TURNO = 1;
    private static final int TU_TURNO = 2;
    private static final int HACIA_LA_DERECHA = +1;
    private static final int HACIA_LA_IZQUIERDA = -1;

    private int _tu, _yo;

    public void receiveInput( String input ){
        boolean primero = true;
        int indice = 0;
        for ( String str : input.split( " " ) ) {
            if ( primero ) {
                cartas = new int[Integer.parseInt(str)];
                primero = false;
                continue;
            }
            cartas[indice++] = Integer.parseInt(str);
        }

        cacheDerecha = new Cache( cartas.length );
        cacheIzquierda = new Cache( cartas.length );
    }

    private int max( int a, int b ) { return a < b ? b : a; }
    private int min( int a, int b ) { return a < b ? a : b; }

    private void resolverDesdeLaIzquierdaCache( int first, int last ) {
        if ( first > last ) {
            _yo = _tu = 0;
            return ;
        }

        if ( cacheIzquierda.has( first, last, MI_TURNO ) ) {
            _yo = cacheIzquierda.get( first, last, MI_TURNO );
            _tu = cacheIzquierda.get( first, last, TU_TURNO );
            return;
        }
        resolverDesdeLaIzquierda( first, last );
        cacheIzquierda.set( first, last, MI_TURNO, _yo );
        cacheIzquierda.set( first, last, TU_TURNO, _tu );
    }

    private void resolverDesdeLaDerechaCache( int first, int last ) {
        if ( first > last ) {
            _yo = _tu = 0;
            return ;
        }

        if ( cacheDerecha.has( first, last, MI_TURNO ) ) {
            _yo = cacheDerecha.get( first, last, MI_TURNO );
            _tu = cacheDerecha.get( first, last, TU_TURNO );
            return;
        }
        resolverDesdeLaDerecha( first, last );
        cacheDerecha.set( first, last, MI_TURNO, _yo );
        cacheDerecha.set( first, last, TU_TURNO, _tu );
    }

    private void resolverDesdeLaIzquierda( int first, int last ) {
        if ( first > last ) {
            _yo = _tu = 0;
            return;
        }

        int puntos = 0;
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
        for ( int i = first; i <= last; i++ ) {
            puntos += cartas[i];
            resolverDesdeLaIzquierdaCache( i + 1, last );
            int puntosDesdeLaIzquierdaYo = _yo;
            int puntosDesdeLaIzquierdaTu = _tu;
            resolverDesdeLaDerechaCache( i + 1, last );
            int puntosDesdeLaDerechaYo = _yo;
            int puntosDesdeLaDerechaTu = _tu;
            maximo = max( maximo, puntos + min( puntosDesdeLaIzquierdaTu, puntosDesdeLaDerechaTu ) );
            minimo = min( minimo, max( puntosDesdeLaIzquierdaYo, puntosDesdeLaDerechaYo ) );
        }

        _tu = minimo;
        _yo = maximo;
    }

    private void resolverDesdeLaDerecha( int first, int last ) {
        if ( first > last ) {
            _yo = _tu = 0;
            return;
        }

        int puntos = 0;
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
        for ( int i = last; i >= first; i-- ) {
            puntos += cartas[i];
            resolverDesdeLaIzquierdaCache( first, i - 1 );
            int puntosDesdeLaIzquierdaYo = _yo;
            int puntosDesdeLaIzquierdaTu = _tu;
            resolverDesdeLaDerechaCache( first, i - 1 );
            int puntosDesdeLaDerechaYo = _yo;
            int puntosDesdeLaDerechaTu = _tu;
            maximo = max( maximo, puntos + min( puntosDesdeLaIzquierdaTu, puntosDesdeLaDerechaTu ) );
            minimo = min( minimo, max( puntosDesdeLaIzquierdaYo, puntosDesdeLaDerechaYo ) );
        }

        _tu = minimo;
        _yo = maximo;
    }

    public void resolve(){
        resolverDesdeLaIzquierdaCache( 0, cartas.length - 1 );
        int puntosDesdeLaIzquierda = _yo;
        resolverDesdeLaDerechaCache( 0, cartas.length - 1 );
        int puntosDesdeLaDerecha = _yo;
        puntos = max( puntosDesdeLaIzquierda, puntosDesdeLaDerecha );
    }

    public void reset(){
        cacheDerecha = new Cache( cartas.length );
        cacheIzquierda = new Cache( cartas.length );
    }

    public String getOutput(){
        return String.valueOf( puntos );
    }
}
// vim: set tabstop=4 shiftwidth=4 expandtab autoindent:
