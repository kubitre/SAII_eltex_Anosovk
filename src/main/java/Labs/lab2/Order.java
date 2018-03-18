package Labs.lab2;

import Labs.lab1.ICrudAction;

import java.util.Scanner;

public class Order implements ICrudAction
{
    private String statusOrder;
    private Timer dateCreation,
                  dateProcessing;

    private ShoppingCart cart;

    public Order(ShoppingCart cart){
        this.dateCreation = new Timer();
        this.dateCreation.constructing();

        this.cart = cart;

        this.statusOrder = "in processing";

        this.dateProcessing = new Timer();
        this.dateProcessing.DateRand(this.dateCreation);
    }

    private void change_status(){
        if(statusOrder.contains("in processing")){
            statusOrder = "complete";
        }
    }


    public String getStatus(){
        return this.statusOrder;
    }

    public Timer getDateCreation(){
        return this.dateCreation;
    }

    public Timer getDateProcessing(){
        return this.dateProcessing;
    }


    @Override
    public void create() {
        this.statusOrder = "in processing";
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
        this.statusOrder = "deleted";
    }
}
