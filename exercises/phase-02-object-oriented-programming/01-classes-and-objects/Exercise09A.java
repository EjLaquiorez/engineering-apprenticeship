public class Exercise09A{
    static class Dog{
        String name;
        String color;
        String breed;

        Dog(String name, String color, String breed){
            this.name = name;
            this.color = color;
            this.breed = breed;
        }
        Dog(String name){
            this(name, "Brown", "Labrador");

        }
        void bark(){
            System.out.println(name + ", says woof!");
        }

        void sit(){
            System.out.println(name + ", is sitting.");
        }

        void stay(){
            System.out.println(name + ", is staying.");
        }
        
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog("brownie");

        dog1.bark();
        dog1.sit();
        dog1.stay();
        
    }
}