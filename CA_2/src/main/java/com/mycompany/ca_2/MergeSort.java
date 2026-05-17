/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ca_2;

import java.util.ArrayList;

/**
* Recursive Merge Sort algorithm used to sort
* employee names alphabetically.
*/
public class MergeSort {

    // Recursive method to divide the list into smaller parts
    public static void mergeSort(ArrayList<String> names) {

        // Base condition: stop if list has one element
        if (names.size() <= 1) {
            return;
        }

        // Finf middle position
        int middle = names.size() / 2;

        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();

        // Split left side
        for (int i = 0; i < middle; i++) {
            left.add(names.get(i));
        }
        // Split right side
        for (int i = middle; i < names.size(); i++) {
            right.add(names.get(i));
        }

        //Recursive calls
        mergeSort(left);
        mergeSort(right);

        //Merge sorted lists
        merge(names, left, right);
    }

    // merge two sorted lists into one
    public static void merge(ArrayList<String> names,
            ArrayList<String> left,
            ArrayList<String> right) {

        int i = 0;
        int j = 0;
        int k = 0;

        // Compare elements and merge alphabetically
        while (i < left.size() && j < right.size()) {

            if (left.get(i).compareToIgnoreCase(right.get(j)) < 0) {
                names.set(k, left.get(i));
                i++;

            } else {
                names.set(k, right.get(j));
                j++;
            }

            k++;
        }

        // Add remaining left elements
        while (i < left.size()) {
            names.set(k, left.get(i));
            i++;
            k++;
        }

        //Add remaining right elements
        while (j < right.size()) {
            names.set(k, right.get(j));
            j++;
            k++;
        }
    }
}
