package com.linkedList.singly;

public class sample1 {
    private Node head;
    private Node tail;
    private int size;

    public sample1(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node n = new Node(val);
        n.next = head;
        head = n;

        if (tail == null){
            tail = head;
        }
        size++;
    }

    public int deleteFirst(){
        int val = head.data;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public void insertLast(int val){
        if (tail == null){
            insertFirst(val);
            return;
        }
        Node n = new Node(val);
        tail.next = n;
        tail = n;
        size++;
    }

    public Node get(int ind){
        Node n = head;
        for (int i = 0; i < ind; i++) {
            n = n.next;
        }
        return n;
    }

    public int deleteLast(){
        if (size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.data;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public void insert(int val, int ind){
        if (ind == 0){
            insertFirst(val);
            return;
        }
        if (ind == size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < ind; i++) {
            temp = temp.next;
        }
        Node n = new Node(val, temp.next);
        temp.next = n;

        size++;
    }

    public int delete(int ind){
        if (ind == 0){
            return deleteFirst();
        }
        if (ind == size - 1){
            return deleteLast();
        }

        Node prev = get(ind - 1);
        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return ind;
    }

    public void insertOrderWise(int val){
        Node n = new Node(val);

        if (head == null){
            head = n;
        }
        else {
            tail.next = n;
        }
        tail = n;
        size++;
    }

    public Node find(int value){
        Node temp = head;
        while (temp != null){
            if (temp.data == value){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void display(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println(size);
    }
    public class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}











