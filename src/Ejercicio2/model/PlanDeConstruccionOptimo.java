package Ejercicio2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Tomi on 21-Apr-14.
 */
public class PlanDeConstruccionOptimo {

    private ArrayList<Pueblo> pueblosConCentrales;
    private ArrayList<Camino> tuberiasConstruidas;

    /*
        Por la suma de complejidades:
        O(n^2) + O(n-1) + O((n-1)*2(n-1)) = O(n^2) + O(n-1) + O(n^2) = O(n^2)
     */
    public PlanDeConstruccionOptimo(Pueblo[] pueblos, int cantidadDeCentrales){
        tuberiasConstruidas = new ArrayList<Camino>();
        pueblosConCentrales = new ArrayList<Pueblo>();

        /*
            Calcula todas las distancias entre los pueblos para despues accederlas en O(1)
            O(n^2).
         */
        DistanciasEntrePueblos distanciasEntrePueblos = new DistanciasEntrePueblos(pueblos);
        /*
            Arma el agm.
            O((n-1)*2(n-1)) = O(n^2)
         */
        armarMapaConCaminosMinimos(pueblos, distanciasEntrePueblos);

        /*
            Ordeno los tuberiasConstruidas segun las distancias de mayor a menor.
         */
        Collections.sort(tuberiasConstruidas, new Comparator<Camino>() {
            @Override
            public int compare(Camino o1, Camino o2) {
                return Double.compare(o2.getDistancia(), o1.getDistancia());
            }
        });

        boolean[] pueblosDondeSeVanAConstruirCentrales = new boolean[pueblos.length];
        colocarCentrales(cantidadDeCentrales, pueblosDondeSeVanAConstruirCentrales, pueblos);
    }

    private void colocarCentrales(int centralesParaColocar, boolean[] pueblosDondeSeVanAConstruirCentrales, Pueblo[] pueblos) {
        if(centralesParaColocar == 0) return;
        if(tuberiasConstruidas.isEmpty()) return; // Estan todos cubiertos con centrales

        int idPuebloPartida = tuberiasConstruidas.get(0).getPueblosInvolucrados()[0].getId();
        int idPuebloDestino = tuberiasConstruidas.get(0).getPueblosInvolucrados()[1].getId();

        /*
            Casos en que solo me falta poner 1 central.
         */
        if(centralesParaColocar == 1){

            if(pueblosConCentrales.isEmpty()){
                /*
                    Si no se construyo ninguna, entonces la pongo en cualquiera porque todas deben tener electricidad
                */
                pueblosDondeSeVanAConstruirCentrales[idPuebloPartida] = true;
                return;
            } else if(!(pueblosDondeSeVanAConstruirCentrales[idPuebloPartida] || pueblosDondeSeVanAConstruirCentrales[idPuebloDestino])){
                /*
                    Si se construyo alguna en algun lado, pero ninguno de los dos pueblos tiene construida una central,
                    entonces no construyo en ninguna y termino, ya que construir una sola entre dos pueblos sin centrales,
                    no va a mejorar el riesgo, y como me queda una sola central, el riesgo no va a disminuir poniendola
                    en otro lado
                */
                return;
            } else if(pueblosDondeSeVanAConstruirCentrales[idPuebloPartida] ^ pueblosDondeSeVanAConstruirCentrales[idPuebloDestino]){
                /*
                    Si solo uno de los dos tiene central, entonces la pongo en el que no tiene y elimino la tuberia, ya que
                    van a estar los dos pueblos abastecidos
                 */
                if(!pueblosDondeSeVanAConstruirCentrales[idPuebloPartida]){
                    pueblosDondeSeVanAConstruirCentrales[idPuebloPartida] = true;
                    pueblosConCentrales.add(pueblos[idPuebloPartida]);
                }
                else {
                    pueblosDondeSeVanAConstruirCentrales[idPuebloDestino] = true;
                    pueblosConCentrales.add(pueblos[idPuebloDestino]);
                }
                tuberiasConstruidas.remove(0);
                return;
            } else{
                /*
                    Si los dos tienen central, elimino esta tuberia ya que los dos pueblos estan cubiertos, y prosigo
                 */
                tuberiasConstruidas.remove(0);
                colocarCentrales(centralesParaColocar, pueblosDondeSeVanAConstruirCentrales, pueblos);
            }
        }else {

            /*
                Casos en que puedo poner mas de una central, simplemente pongo en los pueblos que no tienen.
             */

            if(!pueblosDondeSeVanAConstruirCentrales[idPuebloPartida]){
                pueblosDondeSeVanAConstruirCentrales[idPuebloPartida] = true;
                pueblosConCentrales.add(pueblos[idPuebloPartida]);
            }
            if(!pueblosDondeSeVanAConstruirCentrales[idPuebloDestino]){
                pueblosDondeSeVanAConstruirCentrales[idPuebloDestino] = true;
                pueblosConCentrales.add(pueblos[idPuebloDestino]);
            }
            tuberiasConstruidas.remove(0);
            colocarCentrales(centralesParaColocar - 2, pueblosDondeSeVanAConstruirCentrales, pueblos);
        }
    }

    private void armarMapaConCaminosMinimos(Pueblo[] pueblos, DistanciasEntrePueblos distanciasEntrePueblos) {
        int[] masProximo = new int[pueblos.length-1];
        double[] distanciaMinima = new double[pueblos.length-1];

        /*
            Inicializo los arreglos teniendo en cuenta que solo coloque el primer pueblo de id = n-1
            Coloco ese primero para que me quede alineado con las ids los arreglos masProximo y distanciaMinima
            O(n-1)
         */
        for(int idPueblo = 0; idPueblo < pueblos.length-1; idPueblo++){
            masProximo[idPueblo] = pueblos.length - 1;
            distanciaMinima[idPueblo] = distanciasEntrePueblos.getDistancia(pueblos[idPueblo], pueblos[pueblos.length-1]);
        }

        /*
            Hago un ciclo hasta agregar todos los caminos que necesito en el mapa.
            O(n-1)
         */
        for(int caminosAgregados = 0; caminosAgregados < pueblos.length - 1; caminosAgregados++){
            double min = Double.MAX_VALUE;
            int idPuebloConDistanciaMinima = pueblos.length; // Este pueblo va a ser siempre invalido, pero necesitaba inicializarlo

            /*
                Recorro todos los pueblos (menos el que puse al principio) para ver cual es el que tiene una ciudad mas cerca
                O(n-1)
             */
            for(int idPueblo = 0; idPueblo < pueblos.length - 1; idPueblo++) {
                if (distanciaMinima[idPueblo] < min && distanciaMinima[idPueblo] != 0) {
                    min = distanciaMinima[idPueblo];
                    idPuebloConDistanciaMinima = idPueblo;
                }
            }

            /*
                Agrego el camino entre el que encontre recien y el mas proximo a ese mismo, que ya se encontraba en el mapa
             */
            tuberiasConstruidas.add(new Camino(pueblos[idPuebloConDistanciaMinima], pueblos[masProximo[idPuebloConDistanciaMinima]], min));
            distanciaMinima[idPuebloConDistanciaMinima] = 0;

            /*
                Recorro de nuevo todos los pueblos (menos el que puse al principio) para actualizar los mas proximos a cada pueblo
                ahora que agregue uno nuevo al mapa. Tambien actualizo las distancias.
                O(n-1)
             */
            for(int idPueblo = 0; idPueblo < pueblos.length - 1; idPueblo++){
                if(distanciasEntrePueblos.getDistancia(pueblos[idPueblo], pueblos[idPuebloConDistanciaMinima]) < distanciaMinima[idPueblo]){
                    distanciaMinima[idPueblo] = distanciasEntrePueblos.getDistancia(pueblos[idPueblo], pueblos[idPuebloConDistanciaMinima]);
                    masProximo[idPueblo] = idPuebloConDistanciaMinima;
                }
            }
        }
    }

    public ArrayList<Camino> getTuberiasConstruidas() {
        return tuberiasConstruidas;
    }

    public ArrayList<Pueblo> getPueblosConCentrales() {
        return pueblosConCentrales;
    }
}
