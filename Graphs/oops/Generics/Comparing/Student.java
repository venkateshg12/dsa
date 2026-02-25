public class Student {

    int rollNo;
    float marks;

    public Student(int rollNo, float marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public String toString() {
        // return rollNo + "";
        return marks + "";
        // return "Student{" + "rollNo="+ rollNo + ", marks="+marks + '}';
    }

    // public int compareTo(Student o) {
    //     int diff = (int)(this.marks - o.marks);
    //     return diff;

    // } 
}