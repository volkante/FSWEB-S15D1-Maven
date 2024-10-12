package org.example.models;

public class MainGrocery {
    public static void main(String[] args) {
        Grocery myGrocery = new Grocery();
        System.out.println(myGrocery.groceryList);
        myGrocery.startGrocery();
        System.out.println(myGrocery.groceryList);

    }
}
