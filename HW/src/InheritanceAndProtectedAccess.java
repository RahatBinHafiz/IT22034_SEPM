class AnimalType {
    protected String animalKind = "Creature";

    void showDetails() {
        System.out.println("This is an animal.");
    }
}

class DogBreed extends AnimalType {
    void howl() {
        System.out.println(animalKind + " says Woof!");
    }
}

public class InheritanceAndProtectedAccess {
    public static void main(String[] args) {
        DogBreed myPet = new DogBreed();
        myPet.showDetails();
        myPet.howl();
    }
}
