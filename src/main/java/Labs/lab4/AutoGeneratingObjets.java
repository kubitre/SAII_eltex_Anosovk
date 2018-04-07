package Labs.lab4;

import Labs.lab2.Orders;
import Labs.lab2.Timer;

public class AutoGeneratingObjets
{
    private Orders generating;
    private Timer timeRangeGenerating;
    private int countObjects;

    public AutoGeneratingObjets(Timer timerRanging, int CountObjects){
        timeRangeGenerating = timerRanging;
        countObjects = CountObjects;
    }

    public void Generating(){
        for(int i = 0; i < countObjects; i++){
            this.generating.update ();
            try{
                Thread.sleep ( 1000 * timeRangeGenerating.getSeconds());
            }
            catch (InterruptedException e){
                System.out.print ( "Error! "+ e.getMessage () );
            }
        }
    }
}
