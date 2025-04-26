// A simple Java program to demonstrate Encapsulation
class Person {
    // Private fields (data members) - cannot be accessed directly outside this class
    private String name;
    private int age;

    // Public method to set the name
    public void setName(String name) {
        this.name = name;
    }

    // Public method to get the name
    public String getName() {
        return name;
    }

    // Public method to set the age
    public void setAge(int age) {
        if (age > 0) { // Basic validation
            this.age = age;
        } else {
            System.out.println("Age must be positive.");
        }
    }

    // Public method to get the age
    public int getAge() {
        return age;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an object of Person
        Person p = new Person();

        // Setting values using setter methods
        p.setName("John");
        p.setAge(25);

        // Getting values using getter methods
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
    }
}
