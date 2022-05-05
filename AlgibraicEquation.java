 
import poly.SplitEquation;
import poly.Equations;
import poly.Multiplication;
import poly.Addition;
import java.io.BufferedReader ;
import java.io.InputStreamReader ;
import java.io.IOException ;
import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AlgibraicEquation {
     
     public static ArrayList < ArrayList < Equations > > divideString ( StringBuffer input ){

        ArrayList < ArrayList < Equations > > exp = new ArrayList < ArrayList < Equations > >();

        Pattern pattern = Pattern.compile( "-\\(" );
        Matcher m = pattern.matcher( input );

        while( m.find() ){
            int end = 1 ;
            if( !String.valueOf( input.charAt( m.start() + 2 ) ).matches( "\\+|-")){
                input.insert( ( m.start() + 2 ) , "+" );
            }
            StringBuffer tem = new StringBuffer();
            tem.append( input.substring(  m.start() + 1 , input.length() ) ); 
        
            end = m.start() + tem.indexOf(")") + end ;
            String k = tem.substring( 0 , tem.indexOf(")")  );
            tem = new StringBuffer();
            tem.append( k );

            Pattern pattern1 = Pattern.compile( "-|\\+" );
                Matcher sign = pattern1.matcher( tem );
                while(  sign.find() ){
                    switch( tem.charAt( sign.start() ) ){
                        case '+':
                            tem.replace( sign.start() , sign.start()+1 , "-" );
                            break;
                        case '-':
                            tem.replace( sign.start() , sign.start()+1 , "+" );
                            break;
                    }

                }
            try{
            input.delete( m.start() , end );
            input.insert( m.start() , String.valueOf( tem ) );
            }
            catch(Exception e ){
                System.out.println( e );
            }            
        }

        while( input.indexOf("(") != -1 || input.indexOf(")") != -1 ){ 
            if( input.indexOf("(") != -1 ){
                input = input.delete( input.indexOf("(") , input.indexOf("(")+1 );
            }
            if( input.indexOf(")") != -1 ){
                input = input.delete( input.indexOf(")") , input.indexOf(")")+1 );
            }
        }

        while ( input.indexOf("*") != -1 ){

            int n = input.length();
            StringBuffer k = new StringBuffer();
            k.append(input.substring(  0 , input.indexOf("*"))  );

            exp.add( Addition.simplifiy( SplitEquation.breakEquation( k ) ) );
            String tem = input.substring( ( input.indexOf("*") + 1 )  , n );
            input.replace( 0 , n , tem ) ;


        }
        exp.add( Addition.simplifiy( SplitEquation.breakEquation(input) ) );
        return exp ;
     }

     public static void main( String[] args ) throws IOException {

         ArrayList < Equations >  result = new ArrayList < Equations >();

         BufferedReader read = new BufferedReader ( new InputStreamReader ( System.in ) );
         StringBuffer input = new StringBuffer();
             System.out.println( "Enter Input String : " ); 
            // input.append( "(2x+y)-(3x-5y)-(3x-5y)" ) ;
            input.append( read.readLine() );
            // input.append("(2xy+4x^2y)*(2x^2y+6xy)") ;
            // input.append( "(2x^2y+3xy^2z-xz^3)*(5xyz+3y^2z-2z)" );
            System.out.println( "Enter Input String : " + input );
            
        
        
        result = Multiplication.calculate( divideString( input ) );
        System.out.println("Simplified Expresion ") ;
        result = Addition.simplifiy( result );
        view ( result );

    }

    public static void view(  ArrayList < Equations >  divEquation ){

        for( int i = 0 ; i < divEquation.size() ; i++ ){
                divEquation.get(i).display();
        }
    }

}

