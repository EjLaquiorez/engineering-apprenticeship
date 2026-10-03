public class Exercise16C {
    static class Animal {
        private String name;
        private int age;

        public void eat(){
            System.out.println( name + " is eating.");
        }

        public void sleep(){
            System.out.println( name + " animal is sleeping.");
        }

        
    }

    static class Dog extends Animal {
        public void bark(){
            System.out.println("The dog is barking.");
        }
    }

	public static void main(String[] args) {
		Dog dog = new Dog(); // Dog inherits from Animal.
		dog.eat();
		dog.sleep();
		dog.bark();
	}
}
