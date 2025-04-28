class gari {
    String shade;
    int velocity;

    void move() {
        System.out.println("Vehicle is moving...");
    }
}

public class Vehicle {
    public static void main(String[] args) {
        gari sportsCar = new gari(); // Correct object creation
        sportsCar.shade = "Blue";
        sportsCar.velocity = 120;
        sportsCar.move();
    }
}
