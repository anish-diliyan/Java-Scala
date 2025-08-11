package design_pattern.creational.builder;

public class Client {
    public static void main(String[] args) {
        Student student = Student.getBuilder()
                .setAge(20)
                .setName("Akash")
                .setEmail("aksgh.pal95@gmail.com")
                .build();

        // Test student object is created
        System.out.println("Student created: " + student.name);
        System.out.println("Age: " + student.age);
        System.out.println("Email: " + student.email);
        System.out.println("PSP: " + student.psp);
    }
}
