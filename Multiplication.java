package poly;

import poly.Equations;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Multiplication{

    public static Equations  spliting( Equations exp1 , Equations exp2 ){
        
        Equations tem = new Equations();

        tem.setCoef( exp1.getCoef()*exp2.getCoef() );

        HashMap < Character , Integer > tem1 = exp1.getEqualtionValues();
        HashMap < Character , Integer > tem2 = exp2.getEqualtionValues();
        StringBuffer sym = new StringBuffer();

        int pow ;
        for( Character key1 : tem1.keySet() ){
            sym = new StringBuffer();
            if( tem2.containsKey( key1 ) ){
                    pow = tem1.get(key1) + tem2.get(key1);
                    sym.append( key1 );
                    sym.append(pow);
                    tem.addValues( key1 , pow );
                    tem.setSymbol( sym ); 

                }
                else{
                    tem.addValues( key1 , tem1.get(key1));
                    sym.append( key1 );
                    sym.append( tem1.get(key1) );
                    tem.setSymbol( sym ); 
                }
           
        }
        for( Character key2 : tem2.keySet() ){
            sym = new StringBuffer();
            if( tem1.containsKey( key2 ) ){
                continue ;
            }
            else{
                tem.addValues( key2 , tem2.get(key2));
                sym.append( key2 );
                sym.append( tem2.get(key2) );
                tem.setSymbol( sym );
            }
        }
        
        return tem ;
    }

    public static ArrayList < Equations > multiply( ArrayList < Equations > equ1 , ArrayList < Equations > equ2 ){

        ArrayList < Equations > result = new ArrayList < Equations >();

        for( int i = 0 ; i < equ1.size() ; i++ ){
            for( int j = 0 ; j < equ2.size() ; j++){
                result.add( spliting( equ1.get(i) , equ2.get(j) ) );
            }
        }
        return result ;
    }

     public static ArrayList< Equations > calculate( ArrayList< ArrayList < Equations > > input ){
        
        ArrayList < Equations > result = input.get(0); 

        for( int i = 1 ; i < input.size() ; i++ ){            
            result =  Multiplication.multiply(result , input.get(i) ) ;
        }

        return result ;
    }
    
}