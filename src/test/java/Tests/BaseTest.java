package Tests;

import Helpers.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    static final String baseURL = PropertyManager.getInstance().getURL();
    protected WebDriver driver;

    @AfterMethod

    public void AfterTesting() {
        driver.quit();
    }


}
