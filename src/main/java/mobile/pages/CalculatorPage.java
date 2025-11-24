package mobile.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalculatorPage {

    private AppiumDriver driver;

    public CalculatorPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void pressNumber(String number) {
        String id = "com.google.android.calculator:id/digit_" + number;
        driver.findElement(By.id(id)).click();
    }

    public void pressOperator(String op) {

        String id;

        switch (op.toLowerCase()) {
            case "plus":
                id = "com.google.android.calculator:id/op_add";
                break;
            case "minus":
                id = "com.google.android.calculator:id/op_sub";
                break;
            case "multiply":
                id = "com.google.android.calculator:id/op_mul";
                break;
            case "divide":
                id = "com.google.android.calculator:id/op_div";
                break;
            case "equals":
                id = "com.google.android.calculator:id/eq";
                break;
            default:
                throw new IllegalArgumentException("Operador no soportado: " + op);
        }

        driver.findElement(By.id(id)).click();
    }

    public String getResult() {
        WebElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        return result.getText();
    }
}
