/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ca_2;

/**
 * Recursive Binary Search (searches for name inside a sorted ArrayList and
 * returns the position if found or -1 if not found.
 *
 * @author Camila
 */
import java.util.ArrayList;

public class BinarySearch {

    //Recursive method to search for a target name
    public static int search(ArrayList<String> names, String target, int left, int right) {

        //Base condition: target was not found
        if (left > right) {
            return -1;
        }

        //Calculate the middle position
        int middle = left + (right - left) / 2;

        //Compara middle element with target ignoring uppercase/lowercase
        int result = names.get(middle).compareToIgnoreCase(target);

        //Target found
        if (result == 0) {
            return middle;
            //Search left side
        } else if (result > 0) {
            return search(names, target, left, middle - 1);
            //Search right side
        } else {
            return search(names, target, middle + 1, right);
        }
    }
}
