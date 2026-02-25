
public class Main {
    public static void main(String[] args) {
        Son son = new Son(21);
        son.normal();
        son.career();

        Daughter daughter = new Daughter(12);
        daughter.career();

        Parent.hello();
    }
    
}
