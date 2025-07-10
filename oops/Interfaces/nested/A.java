
public class A {

    public interface NestedInterface {
        boolean isOdd(int num);
    }
    
}

class B implements A.NestedInterface {
    public boolean isOdd(int num) {
        return (num & 1) == 1;
    }
}
