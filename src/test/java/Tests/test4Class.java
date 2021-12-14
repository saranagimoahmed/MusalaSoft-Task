package Tests;

import Helpers.Listener;
import Helpers.PropertyManager;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Listener.class})
public class test4Class {
    public WebDriver driver;
    protected HomePageClass homepage;
    protected JoinUsPageClass joinus;
    protected CareerPageClass careerpage;

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
        careerpage = new CareerPageClass(driver);
        joinus = new JoinUsPageClass(driver);

    }

    @Test(priority = 0, description = "Print available positions in selected cities")
    public void printAvailablePositionsInCity() throws InterruptedException {

        homepage.openCareerTab();
        careerpage.clickOpenPositions();
        joinus.printIntoConsole();
    }

    @AfterMethod
    public void AfterTesting() {
        if (driver != null)
            driver.quit();
    }

}
