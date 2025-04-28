interface Creature1 {
    void speak();
}

class Kitty implements Creature1 {
    public void speak() {
        System.out.println("Purr");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Kitty myKitty = new Kitty();
        myKitty.speak();
    }
}
