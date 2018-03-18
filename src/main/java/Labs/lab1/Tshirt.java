package Labs.lab1;

import java.util.Scanner;

public class Tshirt extends Base
{
    private boolean withPrint;
    private String TextOnFace;

    public Tshirt (){
        super();
        this.name = "T-Shirt";
        this.price = 15.34;
        this.manufacturer = "Nike";
        this.withPrint = false;
        this.TextOnFace = "TestTextOnFaceRight";
    }

    @Override
    public void create(){
        this.name = "T-Shirt";
        this.manufacturer = "T-shirt's manufacture";
        this.withPrint = false;
        this.TextOnFace = "TestText On FaceSide in T-Shirt object";
    }

    @Override
    public void update(){
        System.out.print ( "Input main.java.lab2.Cap good's (add the [Price(number with float)] [manufacture(exampletext)] [withPrint(true|false)] [TextOnFaceSide(exampleText)]: \n" );
        super.update();
        Scanner input = new Scanner(System.in);
        if(!input.hasNextLine()){
            if (input.nextBoolean()) this.withPrint = true;
            else this.withPrint = false;
            this.TextOnFace = input.next();
        }
        input.close();
    }

    @Override
    public void read(){
        System.out.print("WithPrint: " + this.withPrint +"\n"+
                "Text on Face Side: " + this.TextOnFace + "\n");
    }
}
