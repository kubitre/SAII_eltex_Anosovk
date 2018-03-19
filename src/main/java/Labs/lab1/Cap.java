package Labs.lab1;

import Labs.lab1.Base;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        this.name = "main.java.lab2.Cap";
        this.manufacturer = "main.java.lab2.Cap's manufacture";
        this.Color = "TestColor";
        this.Logotype = "TestLogotype";
    }

    @Override
    public void update ( ) {
        System.out.print ( "Input Cap good's (add the [Price] [manufacture] [Color] [Logotype]: \n" );
        super.update ( );
        Scanner input = new Scanner(System.in);
        if(!input.hasNextLine()){
            this.Color = input.next();
            this.Logotype = input.next();
        }
        input.close();
    }
    @Override
    public void read(){
        System.out.print(
                        "Color: " + this.Color+ "\n" +
                        "Logotype: " + this.Logotype+"\n"
        );
    }

}
