package Labs.lab2;

import java.rmi.server.UID;
import java.util.*;
import Labs.lab1.Base;
import Labs.lab1.ICrudAction;
import TPack.InputInfo;

public class ShoppingCart implements ICrudAction
{
    protected ArrayList<Base> objects;
    private TreeSet<UUID> IDs;


    public ShoppingCart(){
        /*this.args = new String[]{"cap", "3"};
        this.update();
        for (Base i: objects
             ) {
            IDs.add ( i.ID );
        }*/
    }

    public ShoppingCart(String[] args){
        /*this.args = args;
        this.update ();
        for (Base i: objects
                ) {
            IDs.add ( i.ID );
        }
        */
    }

    public void addItem(Base newItem){
        this.objects.add ( newItem );
    }
    public void deleteItem(UID idDelete){
        int indexDelete = -1;
        int index = 0;

        for (UUID i: IDs
             ) {
            if(i.equals ( idDelete )){
                indexDelete = index;
                break;
            }
            index ++;
        }

        this.objects.remove ( indexDelete );
        this.IDs.remove ( idDelete );
    }

    public void ShowAllGoods(){
        for (Base i: this.objects
             ) {
             i.read ();
        }
    }

    public UUID findObjectById(UUID id){
        for (UUID i: this.IDs
             ) {
            if(i.equals ( id)){
                return i;
            }
        }
        return null;
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
        /*for(Base i: objects){
            this.IDs.add(i.ID);
        }*/
    }


    @Override
    public void delete()
    {
        this.objects = null;
    }
}
