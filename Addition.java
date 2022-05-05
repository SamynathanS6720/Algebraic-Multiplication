package poly;

import poly.Equations;
import java.util.Set;
import java.util.ArrayList;

public class Addition {

    public static boolean compare( ArrayList< StringBuffer > sym1 , ArrayList< StringBuffer > sym2 ){
        
        boolean flag = true ;
        if( sym1.isEmpty() && sym2.isEmpty() ){
            return true ;
        }
        if( sym1.size() == sym2.size() ){

            for( StringBuffer str1 : sym1 ){
                flag = false ;
                for( StringBuffer str2 : sym2 ){
                    if( String.valueOf( str1 ).equals( String.valueOf( str2 ) ) ){
                        flag = true ;
                        break;
                    }
                }
                if( flag ){
                    continue ;
                }
                else{
                    break ; 
                }
            }

        }
        else{
            flag = false ;
        }    
        return flag ;

        
    }
    
    public static ArrayList < Equations > simplifiy( ArrayList < Equations > input ){
        Equations tem = new Equations();
        for( int i = 0 ; i < input.size() - 1 ; i++ ){
            for ( int j = i + 1 ; j < input.size() ; j++  ){
                if( compare( input.get( i ).getSymbol() , input.get( j ).getSymbol() ) ){
                    tem = input.get( i ) ;
                    tem.setCoef( input.get(i).getCoef() + input.get(j).getCoef() );
                    input.remove( j );
                    input.remove( i );
                    input.add( tem );
                }
            }
        }
        return input ; 
    }
}
