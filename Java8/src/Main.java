import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Person> someCollection = new ArrayList<>();
        someCollection.add(new Person("Alex", 21));
        someCollection.add(new Person("Michael", 24));
        someCollection.add(new Person("Alena", 12));


        Map m = myStream.of(someCollection)
                .filter(p -> p.getAge() > 20)
                .transform(p -> new Person(p.getAge() + 30))
                .toMap(p -> p.getName(), p -> p);
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person(int i) {
            this.age = i;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
