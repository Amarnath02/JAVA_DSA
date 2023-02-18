package com.amar;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // specify the array length
        int[] arr = new int[n]; // create an array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt(); // getting elements in the array
        }
        int target = in.nextInt();
        int ans = LinearInteger(arr, target);
        System.out.println(ans);


//        String name = in.next();
//        char target1 = in.next().trim().charAt(0);
//        System.out.println(Arrays.toString(name.toCharArray()));
//        int sol = LinearString(name, target1);
//        System.out.println(sol);
    }
    static int LinearInteger(int[] arr, int target){
        if (arr.length == 0){
            return -1;
            // return a value -1, if array length is equal to 0,
            // because of array index start from 0,
            // so here the value can be mentioned as -1.
        }
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            // val : for clear explanation to create.
            if (val == target){
                return i;
                // return the searching element's index.
            }
        }
        return -1;
        // returns a value -1,
        // if searching element is not in an array.
    }
    static int LinearString(String name, char target){
        if (name.length() == 0){
            return -1;
        }
        for (int i = 0; i < name.length(); i++){
            int val = name.charAt(i);
            if (val == target){
                return i;
            }
        }
        return -1;
    }

    /*

    Example :

        6
        23 54 65 23 23 54
        23
        0

        amar
        a
        [a, m, a, r]
        0

        if repeated also present in the array or string,
        specifies which index of the same element is present first,
        because linear search, search the element in an sequential order.
     */
}
