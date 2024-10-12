package org.example.models;

import org.json.JSONTokener;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    //eklenmeye veya silinmeye çalışan eleman/lar listede var mı checkmethodu
    public static boolean checkItemsInList(String input) {
        return groceryList.contains(input);
    }

    public static void addItems(String input) {
        //"armut,elma,portakal" => "armut", "elma", "portakal";
        // => ["armut", "elma", "portakal"]
        // => ["portakal"]

        //Argüman olarak bosluk geliyorsa boslukları kaldir:
        String inputWithFilledGaps = input.replaceAll("\\s+", "");

        //if kısmı virgülle çoklu meyve girişi yapılıyorsa.NOT:SCANNER'A BAKILMALI, OLMADI! "ELMA, ARMUT" gibi boşluklu girince Invalid Type atıyor.

        if (inputWithFilledGaps.contains(",")) {
            String[] splittedFruitsArr = inputWithFilledGaps.split(",");

            for (String fruit : splittedFruitsArr) {
                if (!(groceryList.contains(fruit))) {
                    groceryList.add(fruit);
                }
            }
        } else {
            if (!(groceryList.contains(inputWithFilledGaps))) {
                groceryList.add(inputWithFilledGaps);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String inputWithFilledGaps = input.replaceAll("\\s+", "");

        if (inputWithFilledGaps.contains(",")) {
            String[] splittedFruitsArr = inputWithFilledGaps.split(",");
            for (String fruit : splittedFruitsArr) {
                if (groceryList.contains(fruit)) {
                    groceryList.remove(fruit);
                }
            }

        } else {
            if (groceryList.contains(inputWithFilledGaps)) {
                groceryList.remove(inputWithFilledGaps);
            }
        }

        Collections.sort(groceryList);
    }


    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }


    public void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Please enter a number between 0 and 2: ");
                int userNumberInput = scanner.nextInt();
                if (userNumberInput <= 0 || userNumberInput > 2) {
                    System.out.println("Uygulama durduruldu");
                    return;
                } else if (userNumberInput == 1) {
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemToAdd = scanner.next();
                    addItems(itemToAdd);
                } else if (userNumberInput == 2) {
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String itemToRemove = scanner.next();
                    removeItems(itemToRemove);
                } else {
                    System.out.println("Bir takim hatalar oldu");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid Type");
                break;
            }
        }

    }

}
