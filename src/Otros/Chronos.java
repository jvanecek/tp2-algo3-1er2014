package Otros;

/**
 * Created by juan on 02/04/14.
 */
public class Chronos {

    public static long now(){
        return System.nanoTime();
//        return System.currentTimeMillis();
    }

    public static long tiempoPromedioResolve(Ejercicio ej, int iter) throws Exception{

        System.out.printf( "Resolviendo " + ej.getClass().getName() + "...");
        long startTime, estimatedTime = 0;

        for( int i = 1; i <= iter; i++ ) {
            ej.reset();

            startTime = Chronos.now();
            ej.resolve();
            estimatedTime += Chronos.now() - startTime;
        }

        System.out.printf("%d\n", estimatedTime/iter);

        return estimatedTime/iter;
    }
    
    public static long runResolve(Problema ej, int iter) {
    	long startTime, estimatedTime = 0;

        for( int i = 1; i <= iter; i++ ) {
            ej.resetear();

            startTime = Chronos.now();
            ej.resolver();
            estimatedTime += Chronos.now() - startTime;
        }

        return estimatedTime/iter;

    }
}
// vim: set tabstop=4 shiftwidth=4 expandtab autoindent:
