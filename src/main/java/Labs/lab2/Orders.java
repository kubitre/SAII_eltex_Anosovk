package Labs.lab2;

import Labs.lab1.ICrudAction;

import java.io.Console;
import java.io.IOException;
import java.util.*;

public class Orders implements ICrudAction {

    private Credentials accountData;
    private LinkedList<ShoppingCart> shoppingCarts;
    private LinkedList<Order> Orders;
    private Map<Timer, Order> Finders;


    public Orders ()
    {

    }

    private void checkout(ShoppingCart newCart)
    {
        if(!(accountData == null)) {
            this.accountData.create ( );
            this.accountData.update ( );
        }
        addNewOrder (newCart);

    }

    private void addNewOrder(ShoppingCart newCart){
        Order temp = new Order ();

        temp.create ();

        temp.setAccountData ( this.accountData );

        if(!shoppingCarts.contains ( newCart )){
            shoppingCarts.add ( newCart );
            temp.setShoppingCart ( newCart );
        }

        Orders.add ( temp );
    }

    public void delElementCollection(){
        this.Orders.removeIf(e -> (e.equals("complete")||e.getDateProcessing ().isEnd));
    }

    public void ShowAllGoods(){
        for (Order i: this.Orders
             ) {
            i.read ();
        }
    }

    public void CheckNewCart(){
        ShoppingCart temp_cart = new ShoppingCart (  );
    }

    @Override
    public void create() {
        this.accountData = new Credentials();
        this.accountData.create();

    }

    @Override
    public void read() {
        System.out.print("Orders info: " + "\n"
                );

        if(accountData != null) {
            this.accountData.read ( );
        }
        else{
            System.out.print ("Accound Data not input for the objects " + this.getClass ());
        }

        if(Orders != null || Orders.size () != 0) {
            for (Order i : this.Orders
                    ) {
                i.read ( );
            }
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
        this.accountData.delete();
    }
}
