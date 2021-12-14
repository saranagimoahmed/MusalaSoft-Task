package Tests;

import Helpers.PropertyManager;
import Helpers.ReadingExcel;
import Pages.HomePageClass;
import Helpers.Listener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners({Listener.class})
public class test1Class {
    public WebDriver driver;
    protected HomePageClass homepage;

    @BeforeMethod(enabled = true)
    public void setup() {
        if (PropertyManager.getInstance().getBrowser().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (PropertyManager.getInstance().getBrowser().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.navigate().to(PropertyManager.getInstance().getURL());
        driver.manage().window().maximize();
        homepage = new HomePageClass(driver);

    }

    @Test(dataProvider = "InvalidData", description = "Verify invalid email address on Contact us form", alwaysRun = true)

    public void invalidEmailsMessage(String InvalidEmail) {
        homepage.ContactUs();
        homepage.fillName();
        homepage.fillEmail(InvalidEmail);
        homepage.fillMessage();
        homepage.fillSubject();
        homepage.SendForm();

        Assert.assertEquals(homepage.ErrorMassage(), "The e-mail address entered is invalid.");


    }

    @DataProvider(name = "invalidEmailsMessage")
    public Object[][] InvalidData() throws InvalidFormatException, IOException {
        ReadingExcel reader = new ReadingExcel();
        return reader.ReadingExcel();
    }

    @AfterMethod
    public void AfterTesting() {
        if (driver != null) driver.quit();
    }


}


