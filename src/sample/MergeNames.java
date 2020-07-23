package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeNames {
    private static String ObjectArrays;


    public static String[] uniqueNames(String[] names1, String[] names2) {

        ArrayList<String> strArrayList = new ArrayList<String>();
        for (int i = 0; i < names1.length; i++)
            strArrayList.add(names1[i]);
        for (int i = 0; i < names2.length; i++)
            strArrayList.add(names2[i]);

// Create a new ArrayList
        ArrayList<String> newList = new ArrayList<String>();

        // Traverse through the first list
        for (String element : strArrayList) {

            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        return newList.toArray(new String[newList.size()]);
    }

    public static void main(String[] args) {
        String[] names1 = new String[]{"Ava", "Emma", "Olivia", "Olivia", "Masha"};
        String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2)));
    }
}