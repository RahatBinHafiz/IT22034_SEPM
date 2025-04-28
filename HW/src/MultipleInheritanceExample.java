interface CanFly {
    void fly();
}

interface CanSwim {
    void swim();
}

class Duckling implements CanFly, CanSwim {
    public void fly() {
        System.out.println("Duckling is soaring...");
    }

    public void swim() {
        System.out.println("Duckling is swimming gracefully...");
    }
}

public class MultipleInheritanceExample {
    public static void main(String[] args) {
        Duckling myDuck = new Duckling();
        myDuck.fly();
        myDuck.swim();
    }
}
