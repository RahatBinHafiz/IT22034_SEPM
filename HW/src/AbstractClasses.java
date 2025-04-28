abstract class Creature {
    abstract void makeNoise();

    void rest() {
        System.out.println("Resting...");
    }
}

class DogBred extends Creature {
    void makeNoise() {
        System.out.println("Woof Woof");
    }
}

public class AbstractClasses {
    public static void main(String[] args) {
        DogBred dog = new DogBred();
        dog.makeNoise();
        dog.rest();
    }
}
