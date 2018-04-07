package TPack;

import Labs.lab1.Base;
import Labs.lab1.Cap;
import Labs.lab1.Tshirt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputInfo
{
    private static String[] returnTypeInput(String[] args){
        if(args.length == 0 || args[0] == null){
            System.out.print("Input the initial parameters in type: [type view(Cap|tshirt)] [quantaty]"); //Example of input: cap N tshirt M
            Scanner input = new Scanner(System.in);
            return input.nextLine().trim().split("\\s+");
        }
        else return args;
    }

    public static ArrayList<Base> Process(String[] args) {
        int quan = 0;
        ArrayList<Base> array_goods = null;

        String []arg = returnTypeInput(args);
        quan = arg.length;

        if(arg.length >= 2) {
            array_goods = new ArrayList<Base>();
            for(int i = 0; i < quan; i++) {
                if ((arg[0].equals("cap") && (i < Integer.parseInt(arg[1].trim())))) {

                    array_goods.add(inputCap());
                }
                else if(arg[0].equals("tshirt") && (i < Integer.parseInt(arg[1].trim()))){
                    array_goods.add(inputTshirt());
                }
                else if(arg.length == 4){
                    if(arg[2].equals("cap")){
                        array_goods.add(inputCap());
                    }
                    else if(arg[2].equals("tshirt")){
                        array_goods.add(inputTshirt());
                    }
                    else{
                        System.out.print("Error input!");
                    }
                }
                else{
                    System.out.print("Error input!");
                }
            }
        }
        else{
            System.out.print("Error input!");
        }

        return array_goods;
    }

    private static int[] returnInputD(String[] args) {

        String type_cap = "cap",
                type_tshirt = "tshirt",
                temp_type;


        int quantaty_caps = 0,
                quantaty_tshirt = 0;


        int [] result = new int[2];

        if (args.length == 2) {
            temp_type = args[0].trim();
            if (temp_type.contains(type_cap)) {
                quantaty_caps = Integer.parseInt(args[1]);
            } else if (temp_type.contains(type_tshirt)) {
                quantaty_tshirt = Integer.parseInt(args[1]);
            } else {
                System.out.print("Unexpected type input!");
                return null;
            }
        } else if (args.length == 4) {
            temp_type = args[0].trim();
            if (temp_type.contains(type_cap)) {
                temp_type = args[2].trim();
                if (temp_type.contains(type_tshirt)) {
                    quantaty_caps = Integer.parseInt(args[1].trim());
                    quantaty_tshirt = Integer.parseInt(args[3].trim());
                } else {
                    System.out.print("error input! ");
                }
            } else if (temp_type.contains(type_tshirt)) {
                temp_type = args[2];
                if (temp_type.contains(type_cap)) {
                    quantaty_caps = Integer.parseInt(args[3].trim());
                    quantaty_tshirt = Integer.parseInt(args[1].trim());
                } else {
                    System.out.print("error input!");
                    return null;
                }
            } else {
                System.out.print("error input!");
                return null;
            }
        }
        result[0] = quantaty_caps;
        result[1] = quantaty_tshirt;

        return result;
    }

    private static Cap inputCap() {
        Cap res = new Cap ();

        res.create();
        res.update ();

        return res;
    }
    private static Tshirt inputTshirt() {
        Tshirt res = new Tshirt();

        res.create();
        res.update();

        return res;
    }
}
