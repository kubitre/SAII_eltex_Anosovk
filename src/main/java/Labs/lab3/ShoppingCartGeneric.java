package Labs.lab3;

import Labs.lab1.Base;
import Labs.lab1.Cap;
import Labs.lab1.ICrudAction;
import TPack.InputInfo;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.UUID;

public class ShoppingCartGeneric<T extends Base> implements ICrudAction{
    protected ArrayList<T> objects;
    private TreeSet<UUID> IDs;
    private String[] args;


    public ShoppingCartGeneric(){
        this.args = new String[]{};
        this.update();
    }

    public ShoppingCartGeneric(String[] args){
        this.args = args;
    }

    public void ShowAllGoods(){
        for (T i: this.objects
                ) {
            i.read ();
        }
    }

    public void findObjectById(UUID id){
        for (UUID i: this.IDs
                ) {
            if(i.equals ( id)){

            }
        }
    }

    @Override
    public void create() {
        this.objects = new ArrayList<T>();

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
/*
        this.objects = InputInfo.Process(this.args);
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
