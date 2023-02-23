import junit.framework.TestCase;

public class CalculationTest extends TestCase {

    public void testSum() {
        // Arrange
        Calculation calculation = new Calculation();
        double val1 = 2.0, val2 = 3.0, expected = 5.0, actual;

        // Act
        actual = calculation.sum(val1, val2);

        // Assert
        assertEquals(expected, actual);
    }

    public void testMult() {
        // Arrange
        Calculation calculation = new Calculation();
        double val1 = 2.0, val2 = 3.0, expected = 6.0, actual;

        // Act
        actual = calculation.mult(val1, val2);

        // Assert
        assertEquals(expected, actual);
    }
}