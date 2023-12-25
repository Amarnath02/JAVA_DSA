package AbstractClass;

/*

    parent class just give a what to do, not how to do.

    when a parent class have a function which doesn't have an body,
    which must be overridden in child class for that function.
    child class must be overridden the all necessary things for that function.

    you cannot create static abstract method, but static method can
 */

public class AbstractDemo {
    public static void main(String[] args) {
        son s = new son(23);
        s.career("doctor");
//        s.partner("ram", 21);
        s.normal();

        daughter d = new daughter(21);
        d.career("teacher");
//        d.partner("harini", 19);

/*
        parent p = new parent();
        You cannot create an object for abstract class
*/

        parent.hello();
    }
}

/*
 Any class that contains one or more abstract methods
 class also must be declared as abstract.
 Ex : abstract class parent
*/

abstract class parent{

    int age;

    public parent(int age) {
        this.age = age;
    }

    // similar to the abstract class, you can't create abstract constructor

    abstract void career(String name);
    abstract void partner(String name, int age);

    /*
     All the child class must be overridden this method
     why? If you definitely know that methods or functions in parents class,
     needs to be overridden, to make those abstract
    */

    // abstract static method cannot be created
    // but static method can

    static void hello(){
        System.out.println("hey");
    }
    // this also be can
    void normal(){
        System.out.println("normal");
    }
}

class son extends parent{
    //You can create an constructor for normal properties
    public son(int age) {
        super(age);
//        this.age = age;
    }

    @Override
    void normal() {
        super.normal();
    }

    @Override
    void career(String name) {
        System.out.println("I am going to be an "+name);
    }

    @Override
    void partner(String name, int age) {
        System.out.println("My name is " + name + ", and my age is "+age);
    }
}

/*
 "extends" keyword that inherits the properties and methods
 from an parents class to access those things
*/

class daughter extends parent{

    public daughter(int age) {
        super(age);
//        this.age = age;
    }

    @Override
    void career(String name) {
        System.out.println("I am going to be an "+name);
    }

    @Override
    void partner(String name, int age) {
        System.out.println("My name is " + name + ", and my age is "+age);
    }
}