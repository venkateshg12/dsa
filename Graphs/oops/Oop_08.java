package dsa.oops;


public class Oop_08 {
    public static void main(String[] args) {

        // every created new object is referencing to a same one in the memory called instance object;
        
        Singleton obj1 = Singleton.getInstance();

        Singleton obj2 = Singleton.getInstance();

        Singleton obj3 = Singleton.getInstance();

    }
}

 class Singleton {
    private Singleton() {

    }
    public static Singleton instance;

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
