package design_pattern.creational;

import design_pattern.creational.builder.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {
    
    @Test
    public void testBuilderPattern() {
        Student student = Student.getBuilder()
                .setName("Akash")
                .setAge(20)
                .setEmail("akash@gmail.com")
                .setPsp(85.5f)
                .build();
        
        assertEquals("Akash", student.name);
        assertEquals(20, student.age);
        assertEquals("akash@gmail.com", student.email);
        assertEquals(85.5f, student.psp, 0.01f);
    }
    
    @Test
    public void testBuilderValidation() {
        // Test age validation
        RuntimeException ageException = assertThrows(RuntimeException.class, () -> {
            Student.getBuilder()
                    .setName("John")
                    .setAge(16)
                    .setEmail("john@gmail.com")
                    .build();
        });
        assertEquals("Students must be above 18", ageException.getMessage());
        
        // Test empty email validation
        RuntimeException emailException = assertThrows(RuntimeException.class, () -> {
            Student.getBuilder()
                    .setName("Jane")
                    .setAge(20)
                    .setEmail("")
                    .build();
        });
        assertEquals("Email can't be empty", emailException.getMessage());
    }
}