package mobile;

import mobile.pages.CalculatorPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest extends MobileBaseTest {

    @Test
    public void testAddition() {
        CalculatorPage calc = new CalculatorPage(driver);
        calc.pressNumber("2");
        calc.pressOperator("plus");
        calc.pressNumber("3");
        calc.pressOperator("equals");
        assertEquals("5", calc.getResult());
    }
}
