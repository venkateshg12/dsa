
public class Basic {
    enum Week {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;

        Week() {
            System.out.println("Constructor " + this);
        }
        // this is not public or protectd.
        // only private or default
        // because we don't want to create new objects.
        
    }
    // these are enum constants
    // public static and final
    // since its final you can create child enums

    public static void main(String[] args) {
        Week week;
        week = Week.Monday;

        // for(Week day : Week.values()){
        // System.out.println(day);
        // }

        // System.out.println(week.ordinal());
    }
}