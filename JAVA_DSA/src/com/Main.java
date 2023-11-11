package com.linkedList.singly;

public class Main {
    public static void main(String[] args) {

        sample1 list = new sample1();

        //  InsertFirst

        list.insertOrderWise(23);
        list.insertOrderWise(31);
        list.insertOrderWise(56);
        list.insertOrderWise(98);
        list.insertOrderWise(123);

        list.insert(72, 3);     // Insert at any position
        list.insertLast(209);       // Insert at last
        list.display();

        // Delete the first element

        System.out.println("\nDeleted value : " + list.deleteFirst());
        list.display();

        // Delete the last element

        System.out.println("\nDeleted value : " + list.deleteLast());
        list.display();

        // Delete at any index

        System.out.println("\nDeleted index : " + list.delete(2));
        list.display();
        
        // Find the node

        System.out.println("\nFind the value : " + list.find(98));
        list.display();
    }
}
