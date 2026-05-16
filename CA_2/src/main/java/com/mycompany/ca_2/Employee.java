/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ca_2;

/**
 * Employee class used to store employee information. Each employee contains a
 * name, manager type and department.
 * @author Camila
 */
public class Employee {

    //Stores employee details
    String name;
    String managerType;
    String department;

    //Constructor initializes employee information
    public Employee(String name, String managerType, String department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }

}
