import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Smith", "John", 25);

        Gson gson = new Gson();
        String json = gson.toJson(person);

        Person person2 = gson.fromJson(json, Person.class);

        System.out.println("Are objects equal: " + person.equals(person2));
    }
}