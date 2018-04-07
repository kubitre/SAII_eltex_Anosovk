package Labs.lab4;

import Labs.lab2.Order;
import TPack.ConstantlyStates;

public class Complete extends ACheck implements Runnable{
    @Override
    public void checkOrderOfTime (ConstantlyStates.StatusOrder status) {
        for(Order i : this.objects.getOrders ()){
            if(i.getStatus ().equals (status )){
                i.delete ();
                this.objects.getOrders ().remove ( i );
            }
        }
    }

    @Override
    public void run ( ) {
        checkOrderOfTime ( ConstantlyStates.StatusOrder.complete );
    }
}
