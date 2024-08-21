package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        Object testClass = result.getInstance();
        WebDriver driver = Driver.getDriver();
        String screenshotPath = ReusableMethods.takeScreenshot(driver, result.getName());
        System.out.println("Screenshot saved at: " + screenshotPath);
    }
}
