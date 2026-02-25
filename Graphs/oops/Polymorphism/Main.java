// package dsa.oops.Polymorphism;

// import com.venkatesh.shape.circle;

public class Main {
    public static void main(String[] args) {

        Shapes shape = new Shapes();
        
        Circle circle = new Circle();

        Square square = new Square();

        Shapes squaree = new Square();

        shape.area();
        circle.area();
        square.area();
        squaree.area();
        
    }
}
