package main.java.com.query.restaurant;

import java.util.HashMap;

public class Udupi {
    public void printDishes() {
        Chef chef = new Chef();
        HashMap<String, String> dishes = chef.listDishes();

        System.out.println("-------------- MENU ---------------");
        for (String dishName : dishes.keySet()) {
            System.out.println(dishName + " - " + dishes.get(dishName));
        }
        System.out.println("-----------------------------------");
    }
}
