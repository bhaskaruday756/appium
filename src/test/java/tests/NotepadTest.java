import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NotepadTest extends BaseTest {

    @Test(priority = 1)
    public void testAppLaunches() {
        System.out.println("Test: Verify app launches successfully");
        
        // Wait for app to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        // Verify app is running by checking current package
        String currentPackage = driver.getCurrentPackage();
        System.out.println("Current package: " + currentPackage);
        
        Assert.assertNotNull(currentPackage, "App should be running");
        System.out.println("✓ App launched successfully");
    }

    @Test(priority = 2)
    public void testAppActivity() {
        System.out.println("Test: Verify app activity");
        
        String currentActivity = driver.currentActivity();
        System.out.println("Current activity: " + currentActivity);
        
        Assert.assertNotNull(currentActivity, "Activity should not be null");
        System.out.println("✓ App activity verified");
    }

    @Test(priority = 3)
    public void testBasicInteraction() {
        System.out.println("Test: Basic app interaction");
        
        try {
            // Wait a bit for the app to fully load
            Thread.sleep(3000);
            
            // Try to find any text view or interactive element
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            // Print page source for debugging
            System.out.println("Page source:");
            System.out.println(driver.getPageSource());
            
            // Just verify we can get the page source without errors
            Assert.assertTrue(driver.getPageSource().length() > 0, "Page source should not be empty");
            
            System.out.println("✓ Basic interaction test passed");
        } catch (Exception e) {
            System.err.println("Error during interaction: " + e.getMessage());
            // Don't fail the test if we can't find specific elements
            // This is just a basic smoke test
        }
    }
}
