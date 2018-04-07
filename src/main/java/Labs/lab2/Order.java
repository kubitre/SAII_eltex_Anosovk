package Labs.lab2;

import Labs.lab1.ICrudAction;

import java.util.Scanner;
import TPack.ConstantlyStates.StatusOrder;

public class Order implements ICrudAction
{
    private StatusOrder statusOrder;
    private Timer dateCreation,
                  dateProcessing;

    private ShoppingCart cart;

    private Credentials account;

    public void CreateOrder(ShoppingCart cart, Credentials account){
        this.cart = cart;

        this.account = account;

        if(dateProcessing == null){
            dateProcessing = new Timer ();
            dateProcessing.DateRand ( dateCreation );
        }
    }

    public void setAccountData(Credentials account){
        this.account = account;
    }

    public void setShoppingCart(ShoppingCart cart){
        this.cart = cart;
    }

    protected void findComplete(){
        if(dateProcessing.isEnd){

        }
    }

    public void change_status(){
        if(statusOrder.equals (StatusOrder.isProcessing)){
            statusOrder = StatusOrder.complete;
        }
    }

    protected ShoppingCart getCart(){
        return this.cart;
    }

    public StatusOrder getStatus(){
        return statusOrder;
    }

    public Timer getDateCreation(){
        return this.dateCreation;
    }

    public Timer getDateProcessing(){
        return this.dateProcessing;
    }



    @Override
    public void create() {
        statusOrder = StatusOrder.isProcessing;

        if(dateCreation == null) {
            dateCreation = new Timer ( );
        }

        dateCreation.constructing ( );
    }

    @Override
    public void read() {
        System.out.print("Status of order: " + this.statusOrder);
    }

    @Override
    public void update() {
        Scanner input = new Scanner(System.in);
        System.out.print("Change curr order? (yes|no)" + "\n");
        this.cart.read();

        String input_temp;

        input_temp = input.next();

        while(true) {
            if (input_temp.contains("y")) {
                ShoppingCart newcart = new ShoppingCart();
                this.cart = newcart;
                break;
            } else if (input_temp.contains("n")) {
                break;
            } else {
                System.out.print("\nunexpected comand! Repeat input please\n");
                continue;
            }
        }
    }

    @Override
    public void delete() {
        statusOrder = StatusOrder.deleted;
    }
}
