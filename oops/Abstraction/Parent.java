
public abstract class Parent {
    int age;

    public Parent(int age) {
        this.age = age;
    }
    
    static void hello() {
        System.out.println("Hello");
    }

    void normal() {
        System.out.println("It's a normal method");
    }

    abstract void career();
    abstract void partner();
}
