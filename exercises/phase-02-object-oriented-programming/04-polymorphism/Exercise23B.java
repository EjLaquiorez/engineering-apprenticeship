public class Exercise23B {
	static class Animal {
		public void eat() {
			System.out.println("Animal is eating");
		}
	}

	static class Dog extends Animal {
		public void bark() {
			System.out.println("Dog is barking");
		}
	}

	public static void main(String[] args) {
		Animal animal = new Dog();
		animal.eat();

		Dog dog = new Dog();
		dog.bark();
	}
}
