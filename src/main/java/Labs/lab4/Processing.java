package Labs.lab4;

import Labs.lab2.Order;
import TPack.ConstantlyStates;

public class Processing extends ACheck implements Runnable
{
    @Override
    public void checkOrderOfTime (ConstantlyStates.StatusOrder status) {
        for(Order i : this.objects.getOrders ()){
            if(i.equals ( ConstantlyStates.StatusOrder.isProcessing )){
                i.change_status ();
            }
        }
    }

    @Override
    public void run ( ) {
        checkOrderOfTime ( ConstantlyStates.StatusOrder.isProcessing );
    }
}
