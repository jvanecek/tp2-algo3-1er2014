package Otros;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;


public class Utils {

    public static Vector<Integer> parseVector( String line, String delimiter ){
        Vector<Integer> in = new Vector<Integer>();

        StringTokenizer st = new StringTokenizer( line, delimiter );
        while ( st.hasMoreTokens() ) {
            in.add( new Integer( st.nextToken() ) );
        }

        return in;
    }

    public static Vector<Integer> parseVector( String line ) {
        return Utils.parseVector( line, " " );
    }

    public static Vector<String> parseStringVector(String line, String delimiter){
        Vector<String> in = new Vector<String>();

        StringTokenizer st = new StringTokenizer( line, delimiter );
        while ( st.hasMoreTokens() ) {
            in.add( st.nextToken().toString() );
        }

        return in;
    }

    public static Integer[] parseArray( String line, String delim ){
        Vector<Integer> in = parseVector( line, delim );

        return (Integer[]) in.toArray( new Integer[ in.size() ] );
    }

    public static Integer[] parseArray( String line ) {
        return Utils.parseArray( line, " " );
    }

    public static String[] parseStringArray( String line, String delimiter){
        Vector<String> in = parseStringVector(line, delimiter);

        return (String[]) in.toArray( new String[ in.size() ] );
    }

    public static List<Integer> parseList( String line, String delim ){
        String[] arr = line.split(delim);
        List<Integer> li = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++){
            li.add(Integer.valueOf(arr[i]));
        }
        return li;
    }

    public static List<Integer> parseList( String line ) {
        return Utils.parseList(line, " ");
    }

    public static int[] parseArrayI( String line ) {
        Vector<Integer> in = parseVector( line );
        int[] v = new int[  in.size() ];

        for ( int i = 0; i < v.length; i++ ) {
            v[ i ] = in.get( i ).intValue();
        }

        return v;

    }
}
// vim: set tabstop=4 shiftwidth=4 expandtab autoindent:
