public class Exercise05B {

    static class Dog{
        String name;
    }

    static void main(String []args){

        Dog dog1 = new Dog();
        Dog dog2 = dog1;

        dog1.name = "Buddy";

        System.out.println("Name using dog1: " + dog1.name);
        System.out.println("Name using dog2: " + dog2.name);

        dog2.name = "Max";

        System.out.println("Name using dog1: " + dog1.name);
        System.out.println("Name using dog2: " + dog2.name);
    }
}
