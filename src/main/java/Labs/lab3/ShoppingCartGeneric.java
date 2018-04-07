package Labs.lab3;

import Labs.lab1.Base;
import Labs.lab1.ICrudAction;
import TPack.InputInfo;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.UUID;

public class ShoppingCartGeneric<T extends Base> implements ICrudAction
{
    protected ArrayList<T> objects;
    private TreeSet<UUID> IDs;


    public ShoppingCartGeneric (){
        /*this.args = new String[]{"cap", "3"};
        this.update();
        for (Base i: objects
             ) {
            IDs.add ( i.ID );
        }*/
    }

    public ShoppingCartGeneric (String[] args){
        /*this.args = args;
        this.update ();
        for (Base i: objects
                ) {
            IDs.add ( i.ID );
        }
        */
    }

    public void addItemT(T newItem){
        this.objects.add ( newItem );
    }
    public void deleteItemT(UID idDelete){
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
        for (T i: this.objects
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
        this.objects = new ArrayList<T>();

        for (T i: objects
                ) {
            this.IDs.add(i.ID);
        }


    }

    @Override
    public void read() {
        for (T i: objects
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
        ArrayList<Base> objects_temp = InputInfo.Process(null);

        for(T i : objects){
            IDs.add ( i.ID );
        }
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