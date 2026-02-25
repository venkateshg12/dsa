package dsa.oops;

public class oop_05 {
    public static void main(String[] args) {
        final A venky = new A("Venkatesh");
        venky.name = "Gurugubelli";
        
        /* when a non primitive methods is final you cannot reassign it.
        venky = new A("Hello"); */

        System.out.println(venky.name);

       /*  A obj;
        for(int i = 0; i < 1000000000;i++) {
            obj = new A("Random name");
        } */
    }
}

class A {
    final int num = 10;
    String name;
    A(String name) {
        this.name = name;
    }

    protected void finalize() throws Throwable {
        System.out.println("Object is Destroyed");
    }
}