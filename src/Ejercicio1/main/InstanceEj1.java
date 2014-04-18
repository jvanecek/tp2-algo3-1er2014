package Ejercicio1.main;

import Otros.Ejercicio;
import Otros.Utils;

public class InstanceEj1 implements Ejercicio {
    private int[] cartas; /**< Cartas del juego. */
    private int puntos; /**< Puntaje del jugador 1 del juego finalizado. */

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
    }

    private int max( int a, int b ) { return a < b ? b : a; }
    private int min( int a, int b ) { return a < b ? a : b; }
    private int otroTurno( int turno ) { return turno == MI_TURNO ? TU_TURNO : MI_TURNO; }

    private int resolverDesdeLaIzquierda( int first, int last, int turno ) {
        if ( first > last ) return 0;

        int puntos = 0;
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
        for ( int i = first; i <= last; i++ ) {
            puntos += cartas[i];
            int puntosDesdeLaIzquierda = resolverDesdeLaIzquierda( i + 1, last, otroTurno( turno ) );
            int puntosDesdeLaDerecha = resolverDesdeLaDerecha( i + 1, last, otroTurno( turno ) );
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
            int puntosDesdeLaIzquierda = resolverDesdeLaIzquierda( first, i - 1, otroTurno( turno ) );
            int puntosDesdeLaDerecha = resolverDesdeLaDerecha( first, i - 1, otroTurno( turno ) );
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
        int puntosDesdeLaIzquierda = resolverDesdeLaIzquierda( 0, cartas.length - 1, MI_TURNO );
        int puntosDesdeLaDerecha = resolverDesdeLaDerecha( 0, cartas.length - 1, MI_TURNO );
        puntos = max( puntosDesdeLaIzquierda, puntosDesdeLaDerecha );
    }

    public void reset(){
    }

    public String getOutput(){
        return String.valueOf( puntos );
    }
}
// vim: set tabstop=4 shiftwidth=4 expandtab autoindent:
