public class Exercise06D {
    public static void main(String[] args) {
        Person person1 = new Person();

        person1.setInfo("Justine", 20);
        System.out.println(person1.name + " " + person1.age);
        
    }

    static class Person {
        String name;
        int age;

        void setInfo(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
