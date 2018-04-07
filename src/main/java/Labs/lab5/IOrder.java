package Labs.lab5;

import java.rmi.server.UID;

public interface IOrder {

    void readById(UID id);
    void saveById(UID id);
    void readAll();
    void saveAll();

}
