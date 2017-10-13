import java.lang.reflect.InvocationTargetException;

/**
 * Created by USER on 13.10.2017.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        From f;
        f = new From(10, "dgh", (float) 10.24, true);
        To t = new To(32, "sdg", false);

        BeanUnits.assign(t,f);
        System.out.printf(t.getA()+ " " +t.getB()+ " "+t.isK());
    }
}
