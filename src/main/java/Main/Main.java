package Main;

import Input.ParseInput.MainParseLevel;
import Labs.lab2.ShoppingCart;

public class Main
{
    public static Object r ;
    public static MainParseLevel parse;
    public static String input;

    public static class MyParsing implements Runnable {
        @Override
        public void run(){
            synchronized (r) {
                MainParseLevel parse = new MainParseLevel ( input );
            }
        }
    }
    public static void main(String []args) {
        System.out.print ( "testing output");
        //testiingProgramModule();
        try {
            testingParsing ( );
        }
        catch (Exception e){
            System.out.print ( e.getMessage () );
        }
    }

    public static void testiingProgramModule(){
        ShoppingCart cart = new ShoppingCart();
        //cart.create();
        cart.update();
    }

    public static void testingParsing() throws Exception {
        //Thread Parsing = new Thread ( MyParsing ); //Todo


    }
}