/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ca_2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Employee Organization System for a Bank
 * Allows sorting, searching, adding employee and creating a binary tree.
 * @author Camila
 */
public class CA_2 {

    // Main metod that starts the application 
    public static void main(String[] args) throws FileNotFoundException {
        //Sccaner used to read user input
        Scanner sc = new Scanner(System.in);

        //Variables used to validate input file
        String fileName = "";
        File checkFile;

        //Keep asking filename until a valid file exists
        do {
            System.out.println("Please enter the filename to read: ");
            fileName = sc.nextLine();

            checkFile = new File(fileName);

            //Display error if file does not exist
            if (!checkFile.exists()) {
                System.out.println("File not found. Please try again.");
            }

        } while (!checkFile.exists());
        System.out.println("File read successfully!");

        //Stores employees added during program execution
        ArrayList<Employee> employees = new ArrayList<>();

        //Stores selected menu option
        int choice = 0;

        //Main program loop continues until Exist is selected
        while (choice != 5) {
            //Display Main Menu Options
            System.out.println("\n===== BANK ORGANIZATION SYSTEM =====");
            System.out.println("1. Sort Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Add Employee");
            System.out.println("4. Create Binary Tree");
            System.out.println("5. Exit");
            
            System.out.println("Select an option:");

            //Validate menu input
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Invalid option. Please enter a number from 1 to 5.");
                sc.nextLine();
                continue;
            }

            //Option 1: Sort employee names alpabetically            
            if (choice == MenuOption.SORT.getValue()) {
                System.out.println("\nSORT selected!!");
                try {
                    File file = new File(fileName);
                    Scanner fileReader = new Scanner(file);
                    ArrayList<String> names = new ArrayList<>();

                    //Skip CSV header line
                    fileReader.nextLine(); // skip header

                    while (fileReader.hasNextLine()) {

                        String line = fileReader.nextLine();

                        if (line.trim().isEmpty()) {
                            continue;
                        }

                        String[] data = line.split(",");

                        if (data.length < 2) {
                            continue;
                        }

                        //Combine first and Last name
                        String fullName = data[0] + " " + data[1];
                        names.add(fullName);
                    }

                    fileReader.close();

                    //Sort names using recursive Merge Sort
                    MergeSort.mergeSort(names);

                    System.out.println("File loaded successfully!");
                    System.out.println("\nFirst 20 sorted employee names:");

                    int limit = Math.min(20, names.size());

                    for (int i = 0; i < limit; i++) {
                        System.out.println(names.get(i));
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");
                }
            //Option 2: Search employee information
            } else if (choice == MenuOption.SEARCH.getValue()) {
                System.out.println("Enter name to search:");
                String target = sc.nextLine();

                ArrayList<String> names = new ArrayList<>();
                ArrayList<Employee> searchEmployees = new ArrayList<>();

                try {
                    File file = new File(fileName);
                    Scanner fileReader = new Scanner(file);

                    fileReader.nextLine();

                    while (fileReader.hasNextLine()) {
                        String line = fileReader.nextLine();

                        if (line.trim().isEmpty()) {
                            continue;
                        }
                        String[] data = line.split(",");

                        if (data.length < 8) {
                            continue;
                        }

                        String fullName = data[0] + " " + data[1];
                        String department = data[5];
                        String managerType = data[7];

                        names.add(fullName);

                        Employee employee = new Employee(fullName, managerType, department);

                        searchEmployees.add(employee);
                    }
                    fileReader.close();

                    MergeSort.mergeSort(names);

                    //Search using recursive Binary Search
                    int result = BinarySearch.search(names, target, 0, names.size() - 1);

                    if (result != -1) {

                        for (Employee emp : searchEmployees) {
                            if (emp.name.equalsIgnoreCase(target)) {
                                System.out.println("\nEmployee found: ");
                                System.out.println("Name: " + emp.name);
                                System.out.println("Manager Type: " + emp.managerType);
                                System.out.println("Department: " + emp.department);
                                break;
                            }
                        }
                    } else {
                        System.out.println(target + " not found.");
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");
                }
            
            //Option 3: Add new employee
            } else if (choice == MenuOption.ADD_RECORD.getValue()) {
                System.out.println("Enter employee name:");
                String name = sc.nextLine();

                //Check is employee name is empty
                if (name.isEmpty()) {
                    System.out.println("\nInvalid name. Name Cannot be empty.");
                    continue;
                }
                int managerChoice;
                //Validate manager option
                do {
                    System.out.println("Choose Manager:");
                    System.out.println("1. Head Manager");
                    System.out.println("2. Assistant Manager");
                    System.out.println("3. Team Lead;");
                    System.out.println("0. Back to Main Menu");

                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid option. Please enter a number from 0 to 3.");
                        sc.nextLine();
                    }
                    managerChoice = sc.nextInt();
                    sc.nextLine();

                    if (managerChoice == 0) {
                        System.out.println("Returning to Main Menu...");
                        continue;
                    }
                    if (managerChoice < 1 || managerChoice > 3) {
                        System.out.println("Invalid option. Please chose from 1 to 3 or 0 to return.");
                    }

                } while (managerChoice < 0 || managerChoice > 3);

                if (managerChoice == 0) {
                    continue;
                }
                String managerType = "";

                if (managerChoice == 1) {
                    managerType = "Head Manager";
                } else if (managerChoice == 2) {
                    managerType = "Assistant Manager";
                } else if (managerChoice == 3) {
                    managerType = "Team Lead";
                }

                int departmentChoice;
                //Validae department selection
                do {
                    System.out.println("Choose Department:");
                    System.out.println("1. HR");
                    System.out.println("2. Finance");
                    System.out.println("3. Customer Service");
                    System.out.println("0. Back to Main Menu");

                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid option.Please enter a number from 0 to 3.");
                        sc.nextLine();
                    }

                    departmentChoice = sc.nextInt();
                    sc.nextLine();

                    if (departmentChoice == 0) {
                        System.out.println("\nReturning to Main Menu...");
                        continue;
                    }

                    if (departmentChoice < 0 || departmentChoice > 3) {
                        System.out.println("\nInvalid option. Please choose from 1 to 3 or 0 to return to Main Menu.");

                    }
                } while (departmentChoice < 0 || departmentChoice > 3);

                if (departmentChoice == 0) {
                    continue;
                }

                String departmentName = "";

                if (departmentChoice == 1) {
                    departmentName = "HR";
                } else if (departmentChoice == 2) {
                    departmentName = "Finance";
                } else if (departmentChoice == 3) {
                    departmentName = "Customer Service";
                }

                //Create employee objrct and store in memory
                Employee newEmployee = new Employee(name, managerType, departmentName);
                employees.add(newEmployee);

                System.out.println(name + " has been added as " +managerType+ " to " +departmentName+" successfully!");

                System.out.println("\nEmployees added:");
                for (Employee emp : employees) {
                    System.out.println(emp.name + " - " + emp.managerType + " - " + emp.department);

                }
                
            //Option 4: Create Binary Tree
            } else if (choice == MenuOption.CREATE_BINARY_TREE.getValue()) {
                BinaryTree tree = new BinaryTree();

                try {
                    File file = new File(fileName);
                    Scanner fileReader = new Scanner(file);
                    fileReader.nextLine();

                    int count = 0;
                    //Insert only first 20 employees
                    while (fileReader.hasNextLine() && count < 20) {
                        String line = fileReader.nextLine();
                        if (line.trim().isEmpty()) {
                            continue;
                        }
                        String[] data = line.split(",");
                        if (data.length < 8) {
                            continue;
                        }
                        String fullName = data[0] + " " + data[1];
                        String department = data[5];
                        String managerType = data[7];

                        Employee employee = new Employee(fullName, managerType, department);

                        //Insert employee using level-order insertion
                        tree.insert(employee);
                        count++;

                    }
                    fileReader.close();
                    System.out.println("Binary Tree created successfully!");

                    System.out.println("\nEmployee Hierarchy: ");
                    tree.display();

                    //Display hierarchy information
                    System.out.println("Total Nodes: " + tree.countNodes(tree.root));
                    System.out.println("Tree Height: " + tree.height(tree.root));

                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");

                }
                
            //Option 5: Exit program
            } else if (choice == MenuOption.EXIT.getValue()) {
                System.out.println("Program closed.");
                    
              //Display message for invalid menu options  
            } else {
                System.out.println("Invalid option. Please enter a number from 1 to 5.");
            }

        }
    }

}
