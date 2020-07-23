package sample;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeNames {
    private static String ObjectArrays;


    public static int removeDuplicateElements(int arr[], int n){
        if (n==0 || n==1){
            return n;
        }
        int[] temp = new int[n];
        int j = 0;
        for (int i=0; i<n-1; i++){
            if (arr[i] != arr[i+1]){
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n-1];
        // Changing original array
        for (int i=0; i<j; i++){
            arr[i] = temp[i];
        }
        return j;
    }

    public static String[] uniqueNames(String[] names1, String[] names2) {


        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};

        int aLen = names1.length;
        int bLen = names2.length;
        String [] joinedArray = new String[aLen + bLen];

        System.arraycopy(names1, 0, joinedArray, 0, aLen);
        System.arraycopy(names2, 0, joinedArray, aLen, bLen);
        System.out.println(joinedArray);


        ArrayList<String> strArrayList = new ArrayList<String>();
        for(int i=0;i<names1.length;i++)
            strArrayList.add(names1[i]);
        for(int i=0;i<names2.length;i++)
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
        String[] names1 = new String[] {"Ava", "Emma", "Olivia","Olivia", "Masha"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2)));
    }
}