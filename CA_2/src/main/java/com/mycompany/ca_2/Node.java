/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca_2;

/**
 * Node class used in the Binary Tree.
 * Each node stores employee information and 
 * references to left and right child nodes.
 * @author Camila
 */

public class Node {
    
    // Stores employee data
    Employee employee;
    
    // References to child nodes
    Node left;
    Node right;
    
    // Constructor initializes node data
    public Node(Employee employee){
        this.employee = employee;
        this.left = null;
        this.right = null;
    }
}
