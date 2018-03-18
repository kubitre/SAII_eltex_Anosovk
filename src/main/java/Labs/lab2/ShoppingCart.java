package Labs.lab2;

import java.util.*;
import Labs.lab1.Base;
import Labs.lab1.ICrudAction;
import TPack.InputInfo;

public class ShoppingCart implements ICrudAction
{
    protected ArrayList<Base> objects;
    private TreeSet<UUID> IDs;

    public ShoppingCart(){
        this.update();
    }

    @Override
    public void create() {
        this.objects = new ArrayList<Base>();

        for (Base i: objects
                ) {
            this.IDs.add(i.ID);
        }


    }

    @Override
    public void read() {
        for (Base i: objects
             ) {
            i.read();
        }

        System.out.print("\nIDs\n");

        for(UUID i: IDs){
            System.out.print(i.toString() + "\n");
        }
    }

    @Override
    public void update() {

        this.objects = InputInfo.Process(null);
        for(Base i: objects){
            this.IDs.add(i.ID);
        }
    }


    @Override
    public void delete()
    {
        this.objects = null;
    }
}
