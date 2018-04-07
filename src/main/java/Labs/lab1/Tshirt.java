package Labs.lab1;

import Input.ParseInput.ParsingPatterns;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.print ( "T-Shirt good's (add the [Price(example: 714.51)] [manufacture(isEnabled)] [withPrint(true|false)] [TextOnFaceSide(exampleText)]: \n" );

        String temp = "";
        Scanner input = new Scanner(System.in);

        if (input.hasNextLine ( )) {
            temp = input.nextLine ( );
        }
        parseUpdate ( temp );

    }

    protected void parseUpdate(String parse){
        this.parseAll ( ParsingPatterns.Price, parse, 0);
        this.parseAll ( ParsingPatterns.Manufacturer, parse, 1 );
        this.parseAll ( ParsingPatterns.withPrint, parse, 2 );
        this.parseAll ( ParsingPatterns.TextOnFace, parse, 3 );
    }
    protected void parseAll(String pattern, String inputStr, int Id){
        Pattern price = Pattern.compile ( pattern );
        Matcher finds = price.matcher ( inputStr );

        if(finds.find ()){
            switch (Id){
                case 0:
                    this.price = Double.parseDouble ( finds.group () );
                    break;
                case 1:
                    this.manufacturer = finds.group ();
                    break;
                case 2:
                    this.withPrint = (finds.group () == "yes"? true : false);
                    break;
                case 3:
                    if(this.withPrint == true) {
                        this.TextOnFace = finds.group ( );
                    }
                    break;
            }

        }
    }

    @Override
    public void read(){
        System.out.print("WithPrint: " + this.withPrint +"\n"+
                "Text on Face Side: " + this.TextOnFace + "\n");
    }
}
