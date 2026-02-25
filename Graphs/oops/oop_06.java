package dsa.oops;

public class oop_06 {
    public static void main(String[] args) {
        A obj = new A("Venkatesh");
        System.out.println(obj);
        
    }
}
 
class A {
    String name;
    A(String name) {
        this.name = name;
    }
}
