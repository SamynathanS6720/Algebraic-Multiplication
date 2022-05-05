package poly;

import poly.Equations;
import java.util.LinkedHashMap;
import java.util.HashMap;

public class SingleExpresion{

    public static Equations split( StringBuffer input ){
        
        Equations newObj = new Equations();
        StringBuffer equ = new StringBuffer();
        
        while( input.indexOf("^") != -1 ){
            input.deleteCharAt( input.indexOf("^") );
        }

        int n = input.length();
        int i = 0;  
        int coef ;
        int start = 0 ;
        if( String.valueOf( input.charAt( start ) ).equals("+") || String.valueOf( input.charAt( start ) ).equals("-") ){
            equ.append( input.charAt( start ) );
            i = i + 1 ;
        } 
        if( !String.valueOf(input.charAt( i ) ).matches("[1-9]") ){
            equ.append( "1" );
        }
        else{    
            while( i < n && String.valueOf(input.charAt( i ) ).matches("[1-9]") ){
                    equ.append( input.charAt(i) );
                    i++;
            }
        }

        try{
            coef = Integer.parseInt( String.valueOf ( equ ) );
            newObj.setCoef( coef );
        }catch( Exception e){}

        StringBuffer symbol ;
        
        if( i < n ){
            while( i < n){
                symbol = new StringBuffer();
                symbol.append( input.charAt(i) );
                char k ;
                int pow = 1 ;
                k = input.charAt( i );
                i = i + 1 ;
                StringBuffer tem = new StringBuffer();
                while( i < n && String.valueOf(input.charAt( i ) ).matches("[1-9]") ){
                    tem.append( input.charAt(i) );
                    symbol.append( input.charAt(i) );
                    i++;
                }
                try{
                    pow = Integer.parseInt( String.valueOf( tem ) );
                }catch( Exception e ){}
                newObj.setSymbol( symbol );
                newObj.addValues( k , pow );
            }
        }

        return newObj ;
    }

}