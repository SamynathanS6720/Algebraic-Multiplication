package poly ;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class Equations { 
    
    private int coef = 1;
    private ArrayList < StringBuffer > symbol = new ArrayList< StringBuffer >() ;
    private HashMap < Character , Integer > equatList = new LinkedHashMap < Character , Integer > ();

    public void setCoef( int coef ){
        this.coef = coef ;
    }

    public void setSymbol( StringBuffer str ){
        this.symbol.add( str ) ;
    }
    
    public void addValues( Character sym , int pow ){
        this.equatList.put( sym , pow );
    }
    
    public int getCoef( ){
        return this.coef ;
    }

    public ArrayList <StringBuffer> getSymbol(){
        return this.symbol ;
    }

    public HashMap < Character , Integer > getEqualtionValues (){
        return this.equatList ;
    } 

    public void display(){
        if( this.coef < 0 ){
            System.out.print( this.coef );
        }
        else if( this.coef == 1 ){
            System.out.print( "+" );
        }
        else{
            System.out.print( "+" + this.coef );
        }
        if( this.coef > 0 && this.equatList.isEmpty() ){
            System.out.print( this.coef );
        }
        if( this.coef != 0 ){   
            for( Character key : this.equatList.keySet() ){
                if( this.equatList.get(key) > 1 )
                    System.out.print( key + "^" + this.equatList.get(key) );
                else
                    System.out.print( key );
            }
        }
    }

}
