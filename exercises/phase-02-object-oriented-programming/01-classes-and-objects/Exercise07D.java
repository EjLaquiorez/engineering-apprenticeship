public class Exercise07D {
    static class Car{
        String color;
        String brand;

        Car(String color, String brand){
            this.color = color;
            this.brand = brand;
        }

        void displayInfo(){
            System.out.println("Car: ");
            System.out.println("Color: " + color);
            System.out.println("Brand: " + brand);
        }
    }
	public static void main(String[] args) {
		Car car1 = new Car("red", "Toyota");
        Car car2 = new Car("blue", "Honda");
        car1.displayInfo();
        car2.displayInfo();

	}
}
