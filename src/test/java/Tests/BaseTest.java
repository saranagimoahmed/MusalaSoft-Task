package Tests;

import Helpers.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    public static String baseURL = "https://www.musala.com/" ;
    public WebDriver driver;

    @AfterMethod

    public void AfterTesting() {
        if (driver != null)
        driver.quit();
    }


}
