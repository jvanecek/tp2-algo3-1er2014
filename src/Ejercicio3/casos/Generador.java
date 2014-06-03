package Ejercicio3.casos;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;

import Otros.Chronos;
import Ejercicio3.main.Problema3;

public class Generador {
	 
	static int veces = 200; // veces a repetir cada experimento
	
	/**
	 * k = 0; p = 1; n variable. 
	 * Complejidad esperada: O(n^2)
	 */
	public static void primerCasoTest() throws Exception{
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("n inicial: ");
        int n_desde = Integer.parseInt( br.readLine() );

        System.out.print("n final: ");
        int n_hasta = Integer.parseInt( br.readLine() );
		
		GeneradorCasos generador = new GeneradorCasos();
		
		String file_name = String.format("ej3_ndesde%d_nhasta%d_k0_p1.txt", n_desde, n_hasta);
		PrintStream outstream = new PrintStream( new File(file_name) );
        outstream.println("n\ttiempo");
        
        System.out.printf("Calculando");
		for ( int n = n_desde; n <= n_hasta; n++ ) {
			System.out.printf(".");
			long tiempo_promedio = Chronos.runResolve( new Problema3(generador.generarCaso(n, 0) ), veces );

			outstream.printf("%d\t%d\n", n , tiempo_promedio );
		}
		System.out.printf("Terminado!");
	}
	
	/**
	 * p = 1; n fijo; k variable. 
	 * Complejidad esperada: O(n^2)
	 */
	public static void segundoCasoTest() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("n fijo: ");
		int n = Integer.parseInt( br.readLine() );
		
		System.out.print("k inicial: ");
        int k_desde = Integer.parseInt( br.readLine() );

        System.out.print("k final: ");
        int k_hasta = Integer.parseInt( br.readLine() );
		
		GeneradorCasos generador = new GeneradorCasos();
		
		String file_name = String.format("ej3_kdesde%d_khasta%d_n%d_p1.txt", k_desde, k_hasta, n);
		PrintStream outstream = new PrintStream( new File(file_name) );
        outstream.println("n\tk\ttiempo");
        
        System.out.printf("Calculando");
		for ( int k = k_desde; k <= k_hasta; k++ ) {
			System.out.printf(".");
			long tiempo_promedio = Chronos.runResolve( new Problema3(generador.generarCaso(n, k) ), veces );

			outstream.printf("%d\t%d\t%d\n", n, k , tiempo_promedio );
		}
		System.out.printf("Terminado!");
	}
	
	public static void main( String[] args ) throws Exception {
		primerCasoTest();
		segundoCasoTest();
	}
}
