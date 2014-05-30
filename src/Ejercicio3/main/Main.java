package Ejercicio3.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by santicamacho on 07/05/14.
 */
public class Main {

    /*
        Comentar la primer parte y descomentar el String input para poner uno fijo, en vez de estar
        poniendo por consola.
     */

    public static void main(String[] args) throws IOException {
		/*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        System.out.print("Tablero de nxn, Ingresa un n:  ");
        int n = Integer.valueOf(br.readLine());
        input += String.valueOf(n) + " ";
        System.out.print("Posicion Inicial \"x y\":  ");
        input += br.readLine() + " ";
        System.out.print("Posicion Final \"x y\":  ");
        input += br.readLine() + " ";
        System.out.print("Potencias Extra \"k\":  ");
        input += br.readLine() + "\n";

        System.out.println("Potencias Max de los casilleros:");

        for(int i = 0; i < n; i++){
            int x = i + 1;
            for(int j = 0; j < n; j++) {
                int y = j + 1;
                System.out.print(x + "," + y + ":  ");
                input += br.readLine() + " ";
            }
            input += "\n";
        }
        */
        String input = "4 4 4 1 1 3\n2 1 1 1 \n1 1 1 1\n1 1 1 1\n1 1 1 1\n";
        Problema3 instance = new Problema3(input);
        System.out.print(instance.resolver());

    }
}
