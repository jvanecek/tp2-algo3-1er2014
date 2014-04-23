package Otros;

/**
 * Created by juan on 02/04/14.
 */
public interface Ejercicio {

    /*
        No lo uso. La input se lo paso con un constructor. No me parece copado que un solo objeto represente varias instancias.
        Desperdicia mas memoria tener un objeto para muchos usos, que crear uno distinto por poco tiempo.
    */
    public void receiveInput(String input);

    /*
        Uso otro metodo resolve que devuelve el String
    */
    public void resolve();

    /*
        No hace falta resetearlo
    */
    public void reset();

    /*
        El resolve devuelve un string que cumple con el output de la solucion
    */
    public String getOutput();
}






// vim: set tabstop=4 shiftwidth=4 expandtab autoindent:
