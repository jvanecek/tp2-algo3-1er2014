package Ejercicio3.casos;

import java.util.Arrays;

public class GeneradorCasos {
	private static int random( int min, int max ) {
		return (int) Math.ceil( Math.random() * (double) (max - min) + (double) min );
	}
	
	public String generarCaso( int n, int k ){
		int f0 = 1, c0 = 1, fn = n, cn = n;
		int p = 1;
		
		StringBuilder res = new StringBuilder();
		res.append( implodeArray(new Integer[] {n, f0, c0, fn, cn, k}, " ") + "\n");
		
		Integer[] potencias = new Integer[n];
		
		for( int i = 0; i < n; i++ ) potencias[i] = p;
		for( int i = 0; i < n; i++ ) res.append( implodeArray(potencias, " ") + "\n" ); 
		res.append("0");

		return res.toString();
	}
	
	public static String implodeArray(Integer[] inputArray, String glueString) {

		/** Output variable */
		String output = "";

		if (inputArray.length > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(inputArray[0]);

			for (int i=1; i<inputArray.length; i++) {
				sb.append(glueString);
				sb.append(inputArray[i]);
			}

			output = sb.toString();
		}

		return output;
	}
}
