/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BinaryTree class used to create the employee hierarchy Each node stores
 * employee information: Name, Manager Type and Department.
 *
 * @author Camila
 */
public class BinaryTree {

    Node root;

    //Constructor initializes an empty tree
    public BinaryTree() {
        root = null;
    }

    // Level-order insertion using Breadth First Search (BFS)
    // Inserts employees from left to right
    public void insert(Employee employee) {
        Node newNode = new Node(employee);

        //Insert as root if tree is empty
        if (root == null) {
            root = newNode;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            //Insert on left child
            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }
            //Insert on right child
            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }

    }

    //Display employee hierarchy using level-order travesal
    public void display() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            System.out.println("\nLevel " + level);
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                System.out.println(current.employee.name + " - " + current.employee.managerType + " - " + current.employee.department);

                //Add left child to queue
                if (current.left != null) {
                    queue.add(current.left);
                }
                //Add right child to queue
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            level ++;
        }
    }
        //Count total number of nodes
    public int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    //Calculate tree height
    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

}
