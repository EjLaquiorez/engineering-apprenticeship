public class Exercise05A {

    static class Dog{
        String color;
        String breed;
    }

    static void main(String []args){

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        dog1.color = "Brown";
        dog1.breed = "Chihuahua";

        dog2.color = "White";
        dog2.breed = "Poodle";


        System.out.println("Dog: ");
        System.out.println("Color: " + dog1.color + ", Breed: " + dog1.breed);
        System.out.println("Color: " + dog2.color + ", Breed: " + dog2.breed);
    }
}
