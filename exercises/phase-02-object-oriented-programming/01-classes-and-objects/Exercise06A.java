public class Exercise06A {
    static class Dog{
        String name;

        void bark(){
            System.out.println(name + " says Woof!!");
        }
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Bruno";
        dog.bark();
    }
}