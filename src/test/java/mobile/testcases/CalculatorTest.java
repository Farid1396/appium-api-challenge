package mobile.testcases;

import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import mobile.BaseMobileTest;
import mobile.pages.CalculatorPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.JsonReader;
import utils.Operation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Mobile Tests")
@Feature("Calculator")
@ExtendWith({AllureJunit5.class})
public class CalculatorTest extends BaseMobileTest {

    static List<Operation> operationsProvider() {
        return JsonReader.readOperations("data/calcOperations.json");
    }

    @Story("Operations")
    @Description("Validate a basic operations")
    @Severity(SeverityLevel.CRITICAL)
    @ParameterizedTest
    @MethodSource("operationsProvider")
    void testOperations(Operation op) throws InterruptedException {

        CalculatorPage calc = new CalculatorPage(driver);

        calc.pressNumber(op.getA());

        switch (op.getOperation()) {
            case "add": calc.pressAdd(); break;
            case "subtract": calc.pressSubtract(); break;
            case "multiply": calc.pressMultiply(); break;
            case "divide": calc.pressDivide(); break;
        }

        calc.pressNumber(op.getB());
        calc.pressEquals();

        Thread.sleep(500);

        int result = calc.getResultAsInt();
        assertEquals(op.getExpected(), result);
    }
}
