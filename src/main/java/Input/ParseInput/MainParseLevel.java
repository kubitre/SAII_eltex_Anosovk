package Input.ParseInput;

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

    public void ProcessR(){
        Pattern pattern = Pattern.compile ( "[a-zA-Z1-7:.]" );
        String[] finding = pattern.split ( this.input );
        for(String word: finding){
            System.out.print ( word );
        }
    }

}
