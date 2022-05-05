package poly;

import poly.SingleExpresion;
import poly.Equations ;
import poly.Addition ;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitEquation{
    
    public static ArrayList < Equations > breakEquation(  StringBuffer input ){  

        ArrayList < Equations > mono = new ArrayList < Equations > ();

        int start ;
        int end ;

        Pattern pattern = Pattern.compile( "\\+|-" );

        Matcher m = pattern.matcher( input );
        StringBuffer tem = new StringBuffer();
        if( !String.valueOf( input.charAt( 0 ) ).matches( "\\+|-" )){
            tem.append("+");
            input = tem.append( input );
            m = pattern.matcher( input );
        }
        while(  m.find() ){
            
                tem = new StringBuffer();
                start = m.start();
                tem.append( input.charAt(start) );
                input.deleteCharAt(start) ;
                m = pattern.matcher( input );

            if ( m.find() ){

                end = m.start();
                for( int i = 0 ; i <= end-1 ; i++ ){
                    tem.append( input.charAt(0) ) ;
                    input.deleteCharAt(0) ;
                }
                mono.add( SingleExpresion.split( tem ) ); 
                m = pattern.matcher( input );
            }
    
    }
    mono.add( SingleExpresion.split( tem.append( input ) ) );
    return mono ;
    }
}