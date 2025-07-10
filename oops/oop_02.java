package dsa.oops;

public class oop_02 {
    public static void main(String[] args) {
        Student venkatesh = new Student(88, "Venkatesh Gurugubelli", 88.7f);
        System.out.println(venkatesh.rno);
        System.out.println(venkatesh.name);
        System.out.println(venkatesh.marks);
    }

}

class Student {
    int rno;
    String name;
    float marks;
    /*
     * Student(int rn, String nam, float mark) {
     * rno = rn;
     * name = nam;
     * marks = mark;
     * }
     */

    Student(int rno, String name, float marks) {
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }
}