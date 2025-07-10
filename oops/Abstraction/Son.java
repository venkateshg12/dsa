
public class Son extends Parent {

    public Son(int age){
        super(age);
        /* Or */
        //  this.age = age;
    }

    void career() {
        System.out.println("I am going out to be an engineer");
    }

    void normal() {
        super.normal();
    }

    void partner() {
        System.out.println("I love Spider Man");
    }

}
