package Labs.lab4;

import Labs.lab1.Base;
import Labs.lab3.OrderGeneric;
import Labs.lab3.OrdersGeneric;
import TPack.ConstantlyStates;

public class ACheck {
    protected OrdersGeneric<Base> objects;

    public void checkOrderOfTime(ConstantlyStates.StatusOrder status){
        for(OrderGeneric<Base> i : objects.getOrders ()){
            if(i.getStatus ().equals ( status )){

            }
        }
    }

}
