import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Person Daria = new Person(false, "Daria");
        Person Anna = new Person(false, "Anna");
        Person Michael = new Person(true, "Michael");
        Person Gor = new Person(true, "Gor");

        System.out.println(Anna.marry(Daria));
        System.out.println(Gor.marry(Daria));
        System.out.println(Anna.marry(Michael));
        System.out.println(Michael.marry(Daria));
       // System.out.println(Anna.marry(Gor));
       System.out.println(Gor.getSpouse());
        //System.out.println(Gor.getSpouse().getName());
       // System.out.println(Daria.getSpouse().getName());
        //System.out.println(Michael.getSpouse().getName());
     }
}
