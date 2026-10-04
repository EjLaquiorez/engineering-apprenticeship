public class Exercise18A{
    static class Animal{
        private String name;
        private int age;

        Animal(String name, int age){
            this.name = name; 
            this.age = age;
        }

        public void eat(){
            System.out.println("Animal is eating.");
        }

        public void sleep(){
            System.out.println("Animal is sleeping.");
        }
    }

    static class Dog extends Animal{

        Dog(String name, int age){
            super(name, age);
            

        }
    }

    static class Cat extends Animal{
        Cat(String name, int age){
            super(name, age);
        }

    }

    
    public static void main(String [] args){
        Dog dog1 = new Dog("browny", 3);
        Cat cat1 = new Cat("Mawmaw", 2);

        dog1.eat();
        dog1.sleep();
        

        cat1.eat();
        cat1.sleep();
       
    }
}