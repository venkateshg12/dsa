// package Inheritance;

public class BoxWeight extends Box {
    double weight;

    BoxWeight(){
        this.weight = -1;
    }

    BoxWeight(BoxWeight other) {
        super(other);
        weight = other.weight;
    }

    public BoxWeight(double l, double w, double h, double weight) {
        super(l,w,h); // this calls the parent calss constructor and it is initialize values in the parent class.
        this.weight = weight;
    }
}
