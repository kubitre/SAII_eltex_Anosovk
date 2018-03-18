package Labs.lab2;

import Labs.lab1.ICrudAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class Credentials implements ICrudAction
{
    protected UUID ID;

    private String FirstName,
                   secondName,
                    thirdName,
                    email;

    public Credentials() {
        this("FirsNameD","SecondNameD" ,"ThirdNameD" ,"example@exm.ex" );
        this.ID = UUID.randomUUID();
    }

    public Credentials(String FirstName, String SecondName, String ThirdName, String email){
        this.FirstName = FirstName;
        this.secondName = SecondName;
        this.thirdName = ThirdName;
        this.email = email;
    }

    public void rebaseAccouunt(Credentials newAccount){
        this.ID = newAccount.ID;
        this.FirstName = newAccount.FirstName;
        this.secondName = newAccount.secondName;
        this.thirdName = newAccount.thirdName;
        this.email = newAccount.email;
    }

    @Override
    public void create() {
        this.ID = UUID.randomUUID();
        this.FirstName = "FirstName";
        this.secondName = "SecondName";
        this.thirdName = "ThirdName";
        this.email = "email";
    }

    @Override
    public void read() {
        System.out.print("Account information: " + "\n"+
                         "ID: " + this.ID + "\n"+
                         "FirstName: " + this.FirstName + "\n"+
                         "SecondName: " + this.secondName + "\n" +
                         "ThirdName: " + this.thirdName + "\n"+
                         "Email: " + this.email + "\n"
        );

    }

    @Override
    public void update() {
        System.out.print("Input account information in type([FirstName] [SecondName] [ThirdName] [Email])");
        try{
            String temp;
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in, "utf8"));
            do{
                temp = buff.readLine().trim();
            }while(!temp.equals("\n"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        this.ID = null;
        this .email = "deleted";
        this.thirdName = "deleted";
        this.secondName = "deleted";
        this.FirstName = "deleted";
    }

}
