package Labs.lab1;

import Labs.lab1.Base;

import java.util.Scanner;

public class Cap extends Base {
    private String Color;
    private String Logotype;

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
        System.out.print ( "Input main.java.lab2.Cap good's (add the [Price] [manufacture] [Color] [Logotype]: \n" );
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
