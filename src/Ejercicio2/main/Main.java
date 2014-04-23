package Ejercicio2.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by juan on 13/04/14.
 */
public class Main {

    /*
        Comentar la primer parte y descomentar el String input para poner uno fijo, en vez de estar
        poniendo por consola.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        System.out.print("Cantidad de pueblos:  ");
        int cantidadDePueblos = Integer.valueOf(br.readLine());
        input += String.valueOf(cantidadDePueblos) + " ";
        System.out.print("Cantidad de centrales:  ");
        input += br.readLine() + "\n";

        System.out.println("Coordenadas de los " + cantidadDePueblos + " pueblos:");

        for(int i = 0; i < cantidadDePueblos; i++){
            int id = i + 1;
            System.out.print(id + ".  ");
            input += br.readLine() + "\n";
        }

//        String input = "8 3\n2 2\n10 4\n20 2\n3 7\n18 9\n5 12\n8 16\n28 16\n";

        Problema2 instance = new Problema2(input);
        System.out.print(instance.resolver());
    }
}
