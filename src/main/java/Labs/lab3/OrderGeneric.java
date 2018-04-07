package Labs.lab3;

import Labs.lab1.Base;
import Labs.lab2.Order;
import Labs.lab2.ShoppingCart;

public class OrderGeneric<T extends Base> extends Order
{
    private ShoppingCartGeneric<T> cart;

    public void setShoppingCartGeneric(ShoppingCartGeneric<T> cart){
        this.cart = cart;
    }
}
