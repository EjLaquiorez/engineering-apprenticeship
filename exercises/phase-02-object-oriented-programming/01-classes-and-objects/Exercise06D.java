public class Exercise06D {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "Justine";
        person1.age = 20;
        

        System.out.println("My name is " + person1.name + " and my age is " + person1.age);
    }

    static class Person{
        String name;
        int age;

        void setInfo(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
}

