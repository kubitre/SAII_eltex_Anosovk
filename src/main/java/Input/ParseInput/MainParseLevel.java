package Input.ParseInput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainParseLevel
{
    private enum Comand{
        TEST,
        VIEW,
        EXIT
    }
    private String input;

    public MainParseLevel(String input){
        this.input = input;
    }

    public void ProcessR() throws Exception {
        Pattern pattern = Pattern.compile ( "!(test lab[1-7]|view lab[1-7]:[a-zA-Z0-9]+.java|exit)" );
        Matcher find = pattern.matcher ( this.input );
        String[] finding = pattern.split ( this.input );
        if(find.groupCount () >= 1){
            find.find ();
            System.out.print ( find.group () );
        }
        else {
            throw new Exception ( "Error of parsing request!" );
        }
    }

}
