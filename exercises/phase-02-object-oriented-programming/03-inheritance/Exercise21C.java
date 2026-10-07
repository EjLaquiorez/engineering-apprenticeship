public class Exercise21C {
    static class Car{
        private String brand;
        private Engine engine;

        public Car(String brand) {
            this.brand = brand;
            this.engine = new Engine();
        }
        
        public void drive() {
            System.out.println("Driving " + brand);
            engine.start();
        }
    }

    static class Engine{
        public void start(){
            System.out.println("Engine started");
        }

    }

    public static void main(String[] args) {
        Car car = new Car("Toyota");
        car.drive();
    }
}
