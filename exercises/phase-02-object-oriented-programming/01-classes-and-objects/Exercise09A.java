class Student {
    private String name;
    private int age;
    private double grade;

Student() {
    this("Unknown", 0, 0.0);
}

Student(String name) {
    this(name, 0, 0.0);
}

Student(String name, int age, double grade) {
    this.name = name;
    this.age = age;
    this.grade = grade;
}
}