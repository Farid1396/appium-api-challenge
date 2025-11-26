package mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.URL;
import java.time.Duration;

public class BaseMobileTest {

    protected AndroidDriver driver;

    @BeforeEach
    @Step("Inicializando Appium Driver")
    public void setup() throws Exception {

        String appPath = System.getProperty("user.dir")
                + "/src/test/resources/apps/calculator.apk";

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("Android")
                .setAutomationName("UiAutomator2")
                .setPlatformName("Android")
                .setApp(appPath)
                .setAppPackage("com.google.android.calculator")
                .setAppActivity("com.android.calculator2.Calculator")
                .setAvdReadyTimeout(Duration.ofSeconds(60));

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/"),
                options
        );
    }

    @AfterEach
    @Step("Cerrando Appium Driver")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}