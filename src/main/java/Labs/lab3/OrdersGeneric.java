package Labs.lab3;

import Labs.lab1.ICrudAction;
import Labs.lab2.Credentials;
import Labs.lab2.Order;
import Labs.lab2.ShoppingCart;
import Labs.lab2.Timer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class OrdersGeneric<T> implements ICrudAction{
        private Credentials accountData;
        private LinkedList<Order> Orders_;
        private Map<Timer, Order> Finders;

        public OrdersGeneric ()
        {

        }

        private void checkout(ArrayList<Order> orders)
        {
            this.accountData.create();
            this.accountData.update();

            for(Order i: this.Orders_){
                this.Orders_.add(i);
            }

        }
        public void AddOrder(T order){
            this.Orders_.add ( T );
        }
        public void delElementCollection(){
            this.Orders_.removeIf(e -> e.equals("complete"));
        }

        public void ShowAllGoods(){
            for (Order i: this.Orders_
                    ) {
                i.read ();
            }
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
            this.accountData.read();

            for (Order i: this.Orders_
                    ) {
                i.read();
            }
        }

        @Override
        public void update() {
            this.accountData = new Credentials();
            this.accountData.update();
            int quanOrders = 0;

            this.Finders = new HashMap<Timer, Order> (  );

            System.out.print("Input a quantaty of orded: ");
            try{
                quanOrders= System.in.read();
                System.in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for(int i =0;i < quanOrders; i++){
                Order temp = new Order(new ShoppingCart ());
                Finders.put ( temp.getDateCreation (), temp );
            }

        }

        @Override
        public void delete() {
            this.accountData.delete();
        }

}
