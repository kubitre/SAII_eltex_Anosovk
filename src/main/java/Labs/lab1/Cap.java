package Labs.lab1;

import Input.ParseInput.ParsingPatterns;
import Labs.lab1.Base;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cap extends Base {
    private String Color;
    private String Logotype;

    enum Colors{
        X1("black"),
        X2("white"),
        X3("orange"),
        X4("purple"),
        X5("red"),
        X6("green"),
        X7("blue");

        private static class Holder{
            static Map<String, Colors> map = new HashMap<> (  );
        }

        Colors (String val) {
            Holder.map.put ( val, this );
        }

        public static Colors Find(String val){
            Colors t = Holder.map.get(val);
            if(t == null){
                throw new IllegalStateException ( String.format ( "Unsupported type %s.", val ) );
            }
            return t;
        }
    } //main list suppotring colors in input field


    public Cap ( ) {
        super ( );
        this.Color = "TestColor";
        this.Logotype = "TestLogotype";
    }
    public Cap(String Color, String Logotype){
        super();
        this.Color= Color;
        this.Logotype = Logotype;
    }

    @Override
    public void create ( ) {
        super.create ( );
        this.name = "Cap";
        this.manufacturer = "Cap's manufacture";
        this.Color = "TestColor";
        this.Logotype = "TestLogotype";
    }

    @Override
    public void update ( ) {
        System.out.print ( "Input Cap good's (add the [Price] [manufacture] [Color] [Logotype]): \n" );

        String temp = "";
        Scanner input = new Scanner ( System.in );
        if (input.hasNextLine ( )) {
            temp = input.nextLine ( );
        }
        parseUpdate ( temp );
    }

    protected void parseUpdate(String parse){
        this.parseAll ( ParsingPatterns.Price, parse, 0);
        this.parseAll ( ParsingPatterns.Manufacturer, parse, 1 );
        this.parseAll ( ParsingPatterns.Colors, parse, 2 );
        this.parseAll ( ParsingPatterns.Logotypes, parse, 3 );
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
                    this.Color = finds.group ();
                    break;
                case 3:
                    this.Logotype = finds.group ();
                    break;
            }

        }
    }
    @Override
    public void read(){
        super.read ();
        System.out.print(
                        "Color: " + this.Color+ "\n" +
                        "Logotype: " + this.Logotype+"\n"
        );
    }

}
