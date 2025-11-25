package mobile;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class MobileBaseTest {

    protected AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        String appPath = Paths.get("src", "test", "resources", "apps", "calculator.apk")
                .toAbsolutePath()
                .toString();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("app", appPath); // reemplazar con tu APK
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
    }
}
