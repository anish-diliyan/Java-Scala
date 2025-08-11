package lecture4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeNumberTest {
    
    private final PrimeNumber primeNumber = new PrimeNumber();
    
    @Test
    void testCheckPrimeWithPrimeNumbers() {
        assertTrue(primeNumber.checkPrime(2));
        assertTrue(primeNumber.checkPrime(3));
        assertTrue(primeNumber.checkPrime(7));
        assertTrue(primeNumber.checkPrime(13));
    }
    
    @Test
    void testCheckPrimeWithCompositeNumbers() {
        assertFalse(primeNumber.checkPrime(4));
        assertFalse(primeNumber.checkPrime(6));
        assertFalse(primeNumber.checkPrime(9));
        assertFalse(primeNumber.checkPrime(24));
    }
    
    @Test
    void testCheckPrimeWithOne() {
        assertTrue(primeNumber.checkPrime(1));
    }
    
    @Test
    void testFactorsCount() {
        assertEquals(1, primeNumber.factors(1));
        assertEquals(2, primeNumber.factors(7));
        assertEquals(3, primeNumber.factors(4));
        assertEquals(8, primeNumber.factors(24));
    }
}
