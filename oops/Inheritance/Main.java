public class Main {
    public static void main(String[] args) {
        Box old = new Box();
        System.out.println(old.l+" "+old.w+" "+old.h);
        Box old1 = new Box(4);
        System.out.println(old1.l+" "+old1.w+" "+old1.h);
        Box old2 = new Box(old1);
        System.out.println(old2.l+" "+old2.w+" "+old2.h);
        Box old3 = new Box(12.5,24.7,455.8);
        System.out.println(old3.l+" "+old3.w+" "+old3.h);

        BoxWeight var = new BoxWeight();
        System.out.println(var.weight+" "+var.l+" "+var.w+" "+var.h);
        
        BoxWeight var2 = new BoxWeight(2,3,4,8);
        System.out.println(var2.weight+" "+var2.l+" "+var2.w+" "+var2.h);
        
        Box var3 = new BoxWeight(2,3,4,55);
        System.out.println(var3.l+" "+var3.w+" "+var3.h);
        
        BoxWeight varr = new BoxWeight(var2);
        System.out.println(varr.weight+" "+varr.l+" "+varr.w+" "+varr.h);

        BoxPrice pr = new BoxPrice();
        System.out.println(pr.price); 
    }

}
