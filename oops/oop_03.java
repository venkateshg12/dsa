package dsa.oops;

public class oop_03 {
    public static void main(String[] args) {
        Student venkatesh = new Student(88, "Venkatesh Gurugubelli", 88.7f);
        System.out.println(venkatesh.rno);
        System.out.println(venkatesh.name);
        System.out.println(venkatesh.marks);

        Student random = new Student(venkatesh);
        System.out.println(random.name);

    }

}

class Student {
    int rno;
    String name;
    float marks;

    Student(int rno, String name, float marks) {
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }

    Student (Student other){
        rno = other.rno;
        name = other.name;
        marks = other.marks;

    }
}
