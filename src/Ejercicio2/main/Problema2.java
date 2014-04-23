package Ejercicio2.main;

import Ejercicio2.model.Camino;
import Ejercicio2.model.PlanDeConstruccionOptimo;
import Ejercicio2.model.Pueblo;
import Otros.Problema;

import java.util.ArrayList;

/**
 * Created by Tomi on 20-Apr-14.
 */
public class Problema2 extends Problema {

    private Pueblo[] pueblos;
    private int cantidadDeCentrales;

    public Problema2(String input) {
        super(input);
    }

    @Override
    protected void interpretarInstancia() {
        String[] lineas = input.split("\n");
        String[] primerLinea = lineas[0].split(" ");
        int cantidadDePueblos = Integer.valueOf(primerLinea[0]);
        cantidadDeCentrales = Integer.valueOf(primerLinea[1]);

        pueblos = new Pueblo[cantidadDePueblos];

        for (int id = 0; id < cantidadDePueblos; id++) {
            String[] coordenadas = lineas[id+1].split(" ");
            pueblos[id] = new Pueblo(Integer.valueOf(coordenadas[0]), Integer.valueOf(coordenadas[1]), id);
        }
    }

    public String resolver(){
        PlanDeConstruccionOptimo planDeConstruccionOptimo = new PlanDeConstruccionOptimo(pueblos, cantidadDeCentrales);
        ArrayList<Pueblo> pueblosConCentrales = planDeConstruccionOptimo.getPueblosConCentrales();
        ArrayList<Camino> tuberiasConstruidas = planDeConstruccionOptimo.getTuberiasConstruidas();
        String output = pueblosConCentrales.size() + " " + tuberiasConstruidas.size() + "\n";
        for(Pueblo pueblo : pueblosConCentrales)
            output += String.valueOf(pueblo.getId() + 1) + "\n";
        for(Camino camino : tuberiasConstruidas){
            output += String.valueOf(camino.getPueblosInvolucrados()[0].getId()+1) + " " + String.valueOf(camino.getPueblosInvolucrados()[1].getId()+1) + "\n";
        }
        return output;
    }
}
