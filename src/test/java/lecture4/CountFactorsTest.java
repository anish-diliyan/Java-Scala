package lecture4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CountFactorsTest {
    
    private final lecture4.CountFactors countFactors = new lecture4.CountFactors();
    
    @Test
    void testFactorsOfOne() {
        assertEquals(1, countFactors.factors(1));
    }
    
    @Test
    void testFactorsOfPrimeNumber() {
        assertEquals(2, countFactors.factors(7));
        assertEquals(2, countFactors.factors(13));
    }
    
    @Test
    void testFactorsOfPerfectSquare() {
        assertEquals(3, countFactors.factors(4)); // 1, 2, 4
        assertEquals(3, countFactors.factors(9)); // 1, 3, 9
        assertEquals(5, countFactors.factors(16)); // 1, 2, 4, 8, 16
    }
    
    @Test
    void testFactorsOfCompositeNumber() {
        assertEquals(8, countFactors.factors(24)); // 1, 2, 3, 4, 6, 8, 12, 24
        assertEquals(4, countFactors.factors(6)); // 1, 2, 3, 6
    }
    
    @Test
    void testFactorsOfLargerNumber() {
        assertEquals(9, countFactors.factors(100)); // 1, 2, 4, 5, 10, 20, 25, 50, 100
    }
}
