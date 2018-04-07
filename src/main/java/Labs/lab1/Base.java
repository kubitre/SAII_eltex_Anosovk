package Labs.lab1;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;


/**
 *
 */
public abstract class Base implements ICrudAction {

    public UUID ID;
    protected String name;
    protected double price;
    protected static int counter = 0;
    protected String manufacturer;



    public Base () {
        this.ID = UUID.randomUUID();
    }

    @Override
    public void create() {
        Random rand = new Random();
        this.price = rand.nextDouble();
        counter++;
    }

    @Override
    public void read() {
        System.out.print("\n" + "Info of object" + "\n" +
                "Indentificator of good: " + this.ID + "\n" +
                "Name of good: " + this.name + "\n" +
                "Price: " + this.price + "\n" +
                "Counts of all objects: " + counter + "\n" +
                "Manufactured: " + this.manufacturer + "\n"
        );
    }

    @Override
    public void update() {
        String temp;
        Scanner input = new Scanner(System.in);

        this.price = input.nextDouble();


        if (input.hasNextLine()) {
            temp = input.nextLine().trim();
            if (temp.length() != 0) {
                this.manufacturer = temp;
            }
        }
    }

    @Override
    public void delete() {
        this.ID = null;
        this.name = null;
        this.manufacturer = null;
        counter--;
        this.price = 0;
    }
}
