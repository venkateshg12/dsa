import java.util.ArrayList;

public class Lambda {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(i * 2);
        }

        Operation sum = (a,b) -> (a + b);
        Operation sub = (a,b) -> (a - b);
        Operation prod = (a,b) -> (a * b);

        Lambda Calculator = new Lambda();

        System.out.println(Calculator.operate(3,5,sum));
        System.out.println(Calculator.operate(3,5,sub));
        System.out.println(Calculator.operate(3,5,prod));

        // list.forEach((lis) -> System.out.println(lis * 2));
    }
    private int operate(int a , int b, Operation op){
        return op.operation(a,b);
    }
    
}

interface Operation {
    int operation (int a, int b);
}