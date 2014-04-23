package Otros;

/**
 * Created by Tomi on 20-Apr-14.
 */
public abstract class Problema {

    protected String input;

    public Problema(String input){
        this.input = input;
        interpretarInstancia();
    }

    protected abstract void interpretarInstancia();

    public abstract String resolver();
}
