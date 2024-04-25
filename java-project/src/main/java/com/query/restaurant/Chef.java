package main.java.com.query.restaurant;
import java.util.HashMap;
import main.java.com.query.dishes.*;

public class Chef {
    public HashMap<String, String> listDishes() {
        HashMap<String, String> dishes = new HashMap<String, String>();

        dishes.put(HoneyChilliPotato.DISH_NAME, HoneyChilliPotato.DESCRIPTION);
        dishes.put(Rasmalai.DISH_NAME, Rasmalai.DESCRIPTION);

        return dishes;
    }
}
