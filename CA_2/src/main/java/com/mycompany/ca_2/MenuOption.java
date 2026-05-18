/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ca_2;

/**
 * Enum class used to define menu options. Makes the menu more organized and
 * easier to manage.
 * @author Camila
 */
public enum MenuOption {
    //Menu options with assigned
    SORT(1),
    SEARCH(2),
    ADD_RECORD(3),
    CREATE_BINARY_TREE(4),
    EXIT(5);

    //Stores menu option value
    private final int value;

    //Constructor initializes option value 
    MenuOption(int value) {
        this.value = value;
    }

    //Returns menu option value
    public int getValue() {
        return value;
    }

}