package Input.InputChain;

import Labs.lab1.Cap;
import Labs.lab1.ICrudAction;
import Labs.lab1.Tshirt;

import java.io.IOException;

public class TestLab1Builder extends Builder {
    public TestLab1Builder(){
        super(InputGroup.InputSteps.TESTLAb1);
    }
    @Override
    public void buildImpl(String[] args){
        //System.out.print ( "There are will be teset module of laboratory work 1" );
        if(testing_module ( args )){
            System.out.print ( "Test was succesful in lab 1 with params: "  );
            for (String i: args
                 ) {
                System.out.print ( i );
            }
        }
    }

    private static Boolean testing_module(String [] args) {
        int quan = 0;
        ICrudAction[] array_goods = null;

        //String []arg = returnTypeInput(args);

        if(args.length >= 2) {
            quan = Integer.parseInt(args[1].trim()) + (args.length == 4?  Integer.parseInt(args[3].trim()): 0);
            array_goods = new ICrudAction[quan];
            for(int i = 0; i < quan; i++) {
                if ((args[0].contains("cap") && (i < Integer.parseInt(args[1].trim())))) {
                    array_goods[i] = inputCap();
                }
                else if(args[0].contains("tshirt") && (i < Integer.parseInt(args[1].trim()))){
                    array_goods[i] = inputTshirt();
                }
                else if(args.length == 4){
                    if(args[2].contains("cap")){
                        array_goods[i] = inputCap();
                    }
                    else if(args[2].contains("tshirt")){
                        array_goods[i] = inputTshirt();
                    }
                    else{
                        System.out.print("Error input!");
                        return false;
                    }
                }
                else{
                    System.out.print("Error input!");
                    return false;
                }
            }
        }
        else{
            System.out.print("Error input!");
            return false;
        }
        System.out.print("\n");
        for(int i=0; i< quan; i++){
            array_goods[i].read();
        }
        return true;
    }
    private static int[] returnInputD(String[] args) {
        String type_cap = "cap";
        String type_tshirt = "tshirt";
        String temp_type;
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
