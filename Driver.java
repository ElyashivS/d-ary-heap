package com.company;
import com.company.Heap;
import java.io.PrintStream;

import java.util.Scanner;
import java.io.*;

public class Driver {
    public static void main(String[] args) {

        System.out.println("Enter the value of d: ");
        Scanner scan = new Scanner(System.in);
        int d = scan.nextInt(); // Get the value of d - number of sons to each node in the heap.

        Heap h1 = new Heap(d); // Create a new empty heap.

        // Build the heap from the input file.
        try {
            File file = new File("input.txt");
            scan = new Scanner(file);

            while (scan.hasNextInt()) {
                h1.insert(scan.nextInt());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        Scanner scan2 = new Scanner(System.in);
        System.out.println("Choose one of the options below: ");
        System.out.println(" 1. Insert \n 2. Extract Max \n 3. Increase Key \n 4. Delete Index \n 5. Print Heap");
        System.out.println("To exit program enter -1");

        int option = 0;

        option = scan2.nextInt();
        while(option != -1) {
            switch (option) {
                case 1:
                    System.out.println("Enter the value to insert: ");
                    h1.insert(scan2.nextInt());
                    System.out.println(h1);
                    break;
                case 2:
                    System.out.println("Max value is " + h1.extractMax() + " , extracted from the heap.");
                    break;
                case 3:
                    System.out.println("Enter index to increase its value: ");
                    int index = scan2.nextInt();
                    System.out.println("Enter the new value: ");
                    int key = scan2.nextInt();
                    h1.increaseKey(index, key);
                    break;
                case 4:
                    System.out.println("Enter an index to delete: ");
                    int delete = scan2.nextInt();
                    h1.delete(delete);
                case 5:
                    System.out.println(h1);
                    break;
            }
            System.out.println("Choose another option, or -1 to exit.");
            option = scan2.nextInt();
        }
    }
}
