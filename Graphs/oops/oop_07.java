package dsa.oops;

public class oop_07 {
    public static void main(String[] args) {
        Oop_08 obj = new Oop_08(21, "Venkatesh Gurugubelli", 0, false);
        System.out.println(Oop_08.population);
    }
}

class Human {
    int age;
    String name;
    int salary;
    boolean married;
    static long population;
   public Human(int age, String name, int salary, boolean married){
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Oop_08.population += 1;
    }
}
