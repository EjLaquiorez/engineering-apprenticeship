public class Exercise03C {

    static class Dog{
        String color;
        String breed;
    }

    
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();

        dog1.color = "Brown";
        dog1.breed = "Labrador";
        dog2.color = "Black";
        dog2.breed = "German Shepherd";
        dog3.color = "White";
        dog3.breed = "Poodle";

        System.out.println("Dog 1:");
        System.out.println("Color: " + dog1.color);
        System.out.println("Breed: " + dog1.breed);

        System.out.println("Dog 2:");
        System.out.println("Color: " + dog2.color);
        System.out.println("Breed: " + dog2.breed);

        System.out.println("Dog 3:");
        System.out.println("Color: " + dog3.color);
        System.out.println("Breed: " + dog3.breed);
        
        
        
    }
}