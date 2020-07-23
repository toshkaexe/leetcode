package sample;

import java.util.HashMap;

public class Panrty {

    public static void main(String[] args) {

        HashMap<String, Integer> pantry = new HashMap<>();
        pantry.put("Apples", 3);
        pantry.put("Oranges", 2);

        int currentApples = pantry.get("Apples");
        pantry.put("Apples", currentApples +40);
        System.out.println(String.format("Number is %d",pantry.get("Apples")));


    }
}
