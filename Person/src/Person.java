public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public Person (boolean man, String name) {
        this.man = man;
        this.name = name;
    }
    public  boolean marry(Person person){
        if (this.spouse == person || person.spouse == this) {
            return false;
        }
        if (this.man!=person.man) {
            if(this.spouse!=person.spouse) {
                this.divorse();
                person.divorse();
                this.spouse=person;
                person.spouse=this;
                return true;

            }
            person.spouse=this;
            this.spouse=person;
            return true;

    }
       else return false;
    }
    public boolean divorse(){
        if (spouse!=null) {
            spouse.spouse = null;
            spouse = null;
           // System.out.println("was divorsed");
            return true;
        }
        else return false;

   } }

