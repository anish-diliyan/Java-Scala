package design_pattern.creational.builder;

public class Student {
    public String name;
    public int age;
    public float psp;
    public String email;

    Student(StudentBuilder sb){
        if(sb.email == null || sb.email.isEmpty()){
            throw new RuntimeException("Email can't be empty");
        }
        if(sb.age < 18){
            throw new RuntimeException("Students must be above 18");
        }
        this.name = sb.name;
        this.age = sb.age;
        this.psp = sb.psp;
        this.email = sb.email;
    }

    public static StudentBuilder getBuilder(){
        return new StudentBuilder();
    }
}
