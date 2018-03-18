package Labs.lab2;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Timer
{

    private int hour,
                minutes,
                seconds;


    public void constructing(){
        Data data = (Data) new Date();
        SimpleDateFormat formating = new SimpleDateFormat("hh:mm:ss");
        String temp = formating.format(data);

        this.hour = new Integer(String.valueOf(temp.split(":", 1)));
        this.hour = new Integer(String.valueOf(temp.split(":", 2)));
        this.seconds = new Integer(String.valueOf(temp.split(":", 3)));
    }

    public void DateRand(Timer dateOfCreation){
        Random rand = new Random();

        int temp = rand.nextInt(),
                flag = 0;

        while(true){
            switch (flag){
                case 0:
                    this.hour = temp;
                case 1:
                    this.minutes = temp;
                case 2:
                    this.seconds = temp;
                case 3:
                    flag = 4;
            }
            if(flag == 4 )break;
            else{
                flag++;
                temp = rand.nextInt();
            }
        }
    }
}
