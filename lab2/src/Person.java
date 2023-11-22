import java.util.Objects;

public final class Person {
    private final String lastName;
    private final String firstName;
    private final int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, age);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Person person &&
                Objects.equals(this.lastName, person.lastName) &&
                Objects.equals(this.firstName, person.firstName) &&
                Objects.equals(this.age, person.age);
    }
}

