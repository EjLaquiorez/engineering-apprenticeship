public class Exercise08C {

    static class Car{
        String brand;
        String model;
        int year;

        Car(String brand, String model, int year){
            this.brand = brand;
            this.model = model;
            this.year = year;            
        }

        Car(){
            this("Toyota", "Corolla", 2020);
        }

        Car(String brand){
            this(brand, "Unknown", 2020);
        }
    }
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("Honda", "Civic", 2021);
        Car car3 = new Car("Ford");
        System.out.println(car1.brand + " " + car1.model + " " + car1.year);
        System.out.println(car2.brand + " " + car2.model + " " + car2.year);
        System.out.println(car3.brand + " " + car3.model + " " + car3.year);

    }
}
