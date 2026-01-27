import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // Let Appium auto-detect the emulator
        options.setDeviceName("Android Emulator");

        options.setApp(System.getProperty("user.dir")
                + "/apps/notepad-30-30-01-690.apk");

        // Extra stability in CI
        options.setNewCommandTimeout(Duration.ofSeconds(300));

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/wd/hub"),
                options
        );
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
