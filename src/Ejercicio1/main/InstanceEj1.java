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
    private int otroTurno( int turno ) { return turno == MI_TURNO ? TU_TURNO : MI_TURNO; }

    private int resolverDesdeLaIzquierdaCache( int first, int last, int turno ) {
        if ( first > last ) return 0;

        if ( cacheIzquierda.has( first, last, turno ) )
            return cacheIzquierda.get( first, last, turno );
        cacheIzquierda.set( first, last, turno, resolverDesdeLaIzquierda( first, last, turno ) );
        return cacheIzquierda.get( first, last, turno );
    }

    private int resolverDesdeLaDerechaCache( int first, int last, int turno ) {
        if ( first > last ) return 0;

        if ( cacheDerecha.has( first, last, turno ) )
            return cacheDerecha.get( first, last, turno );
        cacheDerecha.set( first, last, turno, resolverDesdeLaDerecha( first, last, turno ) );
        return cacheDerecha.get( first, last, turno );
    }

    private int resolverDesdeLaIzquierda( int first, int last, int turno ) {
        if ( first > last ) return 0;

        int puntos = 0;
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
        for ( int i = first; i <= last; i++ ) {
            puntos += cartas[i];
            int puntosDesdeLaIzquierda = resolverDesdeLaIzquierdaCache( i + 1, last, otroTurno( turno ) );
            int puntosDesdeLaDerecha = resolverDesdeLaDerechaCache( i + 1, last, otroTurno( turno ) );
            if ( turno == MI_TURNO ) {
                maximo = max( maximo, puntos + min( puntosDesdeLaIzquierda, puntosDesdeLaDerecha ) );
            } else {
                minimo = min( minimo, max( puntosDesdeLaIzquierda, puntosDesdeLaDerecha ) );
            }
        }

        if ( turno == MI_TURNO )
            return maximo;
        return minimo;
    }

    private int resolverDesdeLaDerecha( int first, int last, int turno ) {
        if ( first > last ) return 0;

        int puntos = 0;
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
        for ( int i = last; i >= first; i-- ) {
            puntos += cartas[i];
            int puntosDesdeLaIzquierda = resolverDesdeLaIzquierdaCache( first, i - 1, otroTurno( turno ) );
            int puntosDesdeLaDerecha = resolverDesdeLaDerechaCache( first, i - 1, otroTurno( turno ) );
            if ( turno == MI_TURNO ) {
                maximo = max( maximo, puntos + min( puntosDesdeLaIzquierda, puntosDesdeLaDerecha ) );
            } else {
                minimo = min( minimo, max( puntosDesdeLaIzquierda, puntosDesdeLaDerecha ) );
            }
        }

        if ( turno == MI_TURNO )
            return maximo;
        return minimo;
    }

    public void resolve(){
        int puntosDesdeLaIzquierda = resolverDesdeLaIzquierdaCache( 0, cartas.length - 1, MI_TURNO );
        int puntosDesdeLaDerecha = resolverDesdeLaDerechaCache( 0, cartas.length - 1, MI_TURNO );
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
