package mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class CalculatorPage {

    private final AndroidDriver driver;

    public CalculatorPage(AndroidDriver driver) {
        this.driver = driver;
    }

    @Step("Press digit {digit}")
    public void pressDigitChar(char c) {
        // digits are id'd as digit_0 .. digit_9
        String id = "com.google.android.calculator:id/digit_" + c;
        driver.findElement(AppiumBy.id(id)).click();
    }

    @Step("Press number {number}")
    public void pressNumber(int number) {
        String s = Integer.toString(number);
        for (char c : s.toCharArray()) {
            pressDigitChar(c);
        }
    }

    @Step("Press add {add}")
    public void pressAdd() {
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add")).click();
    }

    @Step("Press subtract {subtract}")
    public void pressSubtract() {
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_sub")).click();
    }

    @Step("Press multiply {multiply}")
    public void pressMultiply() {
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_mul")).click();
    }

    @Step("Press divide {divide}")
    public void pressDivide() {
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_div")).click();
    }

    @Step("Press equals {equals}")
    public void pressEquals() {
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();
    }

    @Step("Get result as Int")
    public int getResultAsInt() {
        WebElement res = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final"));
        String text = res.getText().replaceAll("[^0-9-]", "").trim();
        if (text.isEmpty()) return 0;
        return Integer.parseInt(text);
    }
}
