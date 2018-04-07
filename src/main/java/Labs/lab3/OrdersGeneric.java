package Labs.lab3;

import Labs.lab1.Base;
import Labs.lab1.ICrudAction;
import Labs.lab2.Credentials;
import Labs.lab2.Order;
import Labs.lab2.ShoppingCart;
import Labs.lab2.Timer;

import java.util.LinkedList;
import java.util.Map;

public class OrdersGeneric<T extends Base> implements ICrudAction {

    private Credentials accountData;
    private LinkedList<ShoppingCartGeneric<T>> shoppingCarts;
    private LinkedList<OrderGeneric<T>> Orders;
    private Map<Timer, OrderGeneric<T>> Finders;

    public LinkedList<OrderGeneric<T>> getOrders ( ) {
        return Orders;
    }

    public OrdersGeneric ()
    {

    }

    private void checkout(ShoppingCartGeneric<T> newCart)
    {
        if(!(accountData == null)) {
            this.accountData.create ( );
            this.accountData.update ( );
        }
        addNewOrder (newCart);

    }

    private void addNewOrder(ShoppingCartGeneric<T> newCart){
        OrderGeneric<T> temp = new OrderGeneric<T> ();

        temp.create ();

        temp.setAccountData ( this.accountData );

        if(!shoppingCarts.contains ( newCart )){
            shoppingCarts.add ( newCart );
            temp.setShoppingCartGeneric ( newCart );
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
