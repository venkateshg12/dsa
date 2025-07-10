import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student venkatesh = new Student(588, 89.7f);
        Student kunal = new Student(12, 98.6f);
        Student harkirat = new Student(16, 98.6f);
        Student harry = new Student(21, 97.6f);
        Student hitesh = new Student(61, 99.9f);

        Student[] list = { venkatesh, kunal, harkirat, harry, hitesh };

        System.out.println(Arrays.toString(list));
     /*    Arrays.sort(list, new Comparator<Student>() {
            public int compare(Student o1, Student o2){
                return (int)(o1.marks - o2.marks);
            }
        }); */

        Arrays.sort(list, (o1,o2) -> -(int)(o1.marks - o2.marks));
        System.out.println(Arrays.toString(list));

        // if (venkatesh.compareTo(kunal) < 0) {
        //     System.out.println("Kunal has higher marks");
        // }
    }
}