package design_pattern.creational;

import design_pattern.creational.singleton.DBConnection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {
    
    @Test
    public void testSingletonInstance() {
        DBConnection db1 = DBConnection.getInstance("http://dbconn:8000", "password");
        DBConnection db2 = DBConnection.getInstance("http://dbconn:8000", "password");
        DBConnection db3 = DBConnection.getInstance("http://dbconn:8000", "password");
        
        // Test same instance
        assertSame(db1, db2);
        assertSame(db2, db3);
        assertSame(db1, db3);
        
        // Test hash codes are same
        assertEquals(System.identityHashCode(db1), System.identityHashCode(db2));
        assertEquals(System.identityHashCode(db2), System.identityHashCode(db3));
    }
}