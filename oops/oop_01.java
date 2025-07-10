package dsa.oops;

public class oop_01 {
    public static void main(String[] args) {
        Student venkatesh = new Student();
        venkatesh.rno = 588;
        venkatesh.name = "Venkatesh Gurugubelli";
        venkatesh.marks = 88.5f;
        System.out.println(venkatesh.rno);
        System.out.println(venkatesh.name);
        System.out.println(venkatesh.marks);
    }
    
}

class Student {
    int rno;
    String name;
    float marks;
}