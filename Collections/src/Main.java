import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {
        MyList mask = new MyList(5);
        mask.add(10);
        mask.add(11);
        mask.add(12);
        mask.add(13);
        mask.add(14);
        mask.add(15);
        mask.remove(3);
        for(int i=0;i<mask.size(); i++) {
            System.out.println(mask.get(i));
        }



    }
}
