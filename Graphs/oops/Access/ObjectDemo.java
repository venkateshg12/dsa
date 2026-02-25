// package dsa.oops.Access;

public class ObjectDemo {

    int num;
    float gpa;

    public ObjectDemo(int num, float gpa) {
        this.num = num;
        this.gpa = gpa;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        return this.num == ((ObjectDemo)obj).num;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        ObjectDemo obj1 = new ObjectDemo(12,56.8f);
        ObjectDemo obj2 = new ObjectDemo(12,78.9f);

        if(obj1.equals(obj2)){
            System.out.println("obj is equal to obj2");
        }

        System.out.println(obj1.getClass().getName());

        System.out.println(obj1.hashCode());
    }
    
}
