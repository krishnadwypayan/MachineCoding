import model.Person;

/**
 * Created by Krishna Kota on 22/05/21
 */
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Krishna", 1);
        Person p2 = new Person("Krishna", 1);
        System.out.println("p1 hashcode: " + p1.hashCode());
        System.out.println("p1 hashcode: " + p1.hashCode());
        System.out.println("p2 hashcode: " + p2.hashCode());
    }
}
