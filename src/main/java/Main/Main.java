package Main;

import Input.ParseInput.MainParseLevel;
import Labs.lab2.ShoppingCart;

public class Main
{
    public static void main(String []args) {
        System.out.print ( "testing output");
        //testiingProgramModule();
        testingParsing ();
    }

    public static void testiingProgramModule(){
        ShoppingCart cart = new ShoppingCart();
        //cart.create();
        cart.update();
    }

    public static void testingParsing(){
        MainParseLevel parse = new MainParseLevel ("testlab1");
        parse.ProcessR ();
    }
}