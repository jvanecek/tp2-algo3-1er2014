package Ejercicio1.main;

import Otros.Ejercicio;
import Otros.Utils;

public class Cache {
    private class Elemento {
        public Elemento() {
            validMin = false;
            validMax = false;
        }

        public int min;
        public int max;
        public boolean validMin;
        public boolean validMax;
    }

    private Elemento[][] cache;

	public Cache( int cards ) {
        cache = new Elemento[cards][cards];
        for ( int i = 0; i < cards; i++ ) {
            for ( int j = 0; j < cards; j++ )
                cache[i][j] = new Elemento();
        }
    }

    public void set( int start, int end, int turno, int value ) {
        if ( turno == 1 ) {
            cache[start][end].max = value;
            cache[start][end].validMax = true;
        } else {
            cache[start][end].min = value;
            cache[start][end].validMin = true;
        }
    }

    public boolean has( int start, int end, int turno ) {
        if ( turno == 1 )
            return cache[start][end].validMax;
        return cache[start][end].validMin;
    }

    public int get( int start, int end, int turno ) {
        if ( turno == 1 )
            return cache[start][end].max;
        return cache[start][end].min;
    }
}
// vim: set tabstop=4 shiftwidth=4 expandtab autoindent:
