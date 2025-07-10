public class Box {
    double l;
    double w;
    double h;

    Box() {
        this.l = -1;
        this.w = -1;
        this.h  = -1;
    }
    Box(double side){
        this.l = side;
        this.w = side;
        this.h = side;
    }
    Box (Box old){
        this.l = old.l;
        this.w = old.w;
        this.h = old.h;
    }
    Box(double l, double w, double h) {
        this.l = l;
        this.w = w;
        this.h = h;
    }

    public void information() {
        System.out.println("Running the Box");
    }
}
