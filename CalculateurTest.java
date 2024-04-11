import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculateurTest {

    @Test
    public void testAddition() {
        double result = Calculateur.calculer(2, 3, '+');
        assertEquals(5, result);
    }

    @Test
    public void testSubtraction() {
        double result = Calculateur.calculer(5, 3, '-');
        assertEquals(2, result);
    }

    @Test
    public void testMultiplication() {
        double result = Calculateur.calculer(2, 3, '*');
        assertEquals(6, result);
    }

    @Test
    public void testDivision() {
        double result = Calculateur.calculer(6, 2, '/');
        assertEquals(3, result);
    }

    @Test
    public void testInvalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculateur.calculer(2, 3, '%');
        });
    }
}
