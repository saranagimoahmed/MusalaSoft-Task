package Tests;

import Helpers.PropertyManager;
import Pages.HomePageClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2Class {
    public WebDriver driver;
    public HomePageClass homepage;
    @Test
    public void invaildEmailsMessage(String InvaildEmail) {
        homepage.ContactUs();
        homepage.fillName();
        homepage.fillEmail(InvaildEmail);

    }
    @BeforeMethod
    public void setup() {
        if (PropertyManager.getInstance().getBrowser().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        else if (PropertyManager.getInstance().getBrowser().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        homepage = new HomePageClass(driver);

    }
}
