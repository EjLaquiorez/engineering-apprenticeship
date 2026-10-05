class Parent {
	private final String name;

	Parent(String name) {
		this.name = name;
		System.out.println("Parent constructor: " + name);
	}

	void show() {
		System.out.println("Parent method: " + name);
	}
}

class Child extends Parent {
	private final int age;

	Child() {
		this("Alex", 10); // Calls another constructor in this class.
	}

	Child(String name, int age) {
		super(name); // Calls the parent constructor.
		this.age = age;
	}

	@Override
	void show() {
		super.show(); // Calls the parent method.
		System.out.println("Child method: age " + age);
	}
}

public class Exercise19C {
	public static void main(String[] args) {
		Child child = new Child();
		child.show();
	}
}
