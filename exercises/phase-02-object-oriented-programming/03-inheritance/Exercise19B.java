public class Exercise19B{
    static class Animal{
        private String name;
        private int age;

        public Animal(String name, int age){
            this.name = name;
            this.age = age;
        }
        
        public void eat(){
            System.out.println(name + " is eating.");
        }

        public void sleep(){
            System.out.println(name + " is sleeping.");
        }

        public String getName(){
            return name;
        }

        public int getAge(){
            return age;
        }
    }

    static class Dog extends Animal{
        private final String breed;

        Dog(String name, int age, String breed){
            super(name, age);
            this.breed = breed;
        }

        public void bark(){
            System.out.println("Dog says bark.");
        }

        public void displayInfo(){
            System.out.println("Dog: Name = " + getName() + ", Age = " + getAge() + ", Breed = " + breed);
        }

        public void eat(){
            super.eat();
            System.out.println("Dog is eating.");
        }

    }

    public static void main(String []args){
        Dog dog1 = new Dog("Doggy", 3, "Labradog");

        dog1.bark();
        dog1.eat();
        dog1.sleep();
        dog1.eat();
        dog1.displayInfo();
    }
}