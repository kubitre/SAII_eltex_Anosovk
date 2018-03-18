package Main;

import Labs.lab2.ShoppingCart;

public class Main
{
    public static void main(String []args) {
        testiingProgramModule();
    }

    public static void testiingProgramModule(){
        ShoppingCart cart = new ShoppingCart();
        cart.create();
        cart.update();
    }

}