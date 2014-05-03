package Ejercicio1.main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        String line;
        while ( (line = reader.readLine()) != null ) {
            if ( line.equals( "" ) )
                break;
            InstanceEj1 ej1 = new InstanceEj1();
            ej1.receiveInput( line );
            ej1.resolve();
            System.out.print( ej1.getOutput() );
        }
    }
}
// vim: set tabstop=4 shiftwidth=4 expandtab autoindent:
