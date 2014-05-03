package Ejercicio1.model;

public class Cache {
    private class Elemento {
        public int min;
        public int max;
    }

    private Elemento[][] cache;

	public Cache( int []cartas ) {
        int n = cartas.length;
        cache = new Elemento[n][n];
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                cache[i][j] = new Elemento();
                if ( i == j ) {
                    cache[i][i].min = 0;
                    cache[i][i].max = cartas[i];
                }
            }
        }
    }

    public void set( int start, int end, int turno, int value ) {
        if ( turno == 1 )
            cache[start][end].max = value;
        else
            cache[start][end].min = value;
    }

    public int get( int start, int end, int turno ) {
        if ( turno == 1 )
            return cache[start][end].max;
        return cache[start][end].min;
    }
}
// vim: set tabstop=4 shiftwidth=4 expandtab autoindent:
