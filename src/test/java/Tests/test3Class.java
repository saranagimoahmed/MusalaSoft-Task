package Tests;

import Helpers.Listener;
import Helpers.PropertyManager;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Listener.class})


public class test3Class {
    public WebDriver driver;
    protected HomePageClass homepage;
    protected JoinUsPageClass joinus;
    protected FacebookMuslaSoft FaceBookPage;
    protected CareerPageClass careerpage;
    protected SeniorJavaDeveloperPageClass seniorJavaDeveloperPage;
    private String FilePathCV = PropertyManager.getInstance().getFilePathCV();
    private String currentDir = System.getProperty("user.dir");

    @BeforeMethod(enabled = true)
    public void setup() throws Exception {
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
        FaceBookPage = new FacebookMuslaSoft(driver);
        seniorJavaDeveloperPage = new SeniorJavaDeveloperPageClass(driver);
    }

    @Test(priority = 0, description = "Verify correct URL of JoinUs page")
    public void verifyJoinUsPageURL() throws InterruptedException {

        homepage.openCareerTab();
        careerpage.clickOpenPositions();

        Assert.assertEquals(joinus.getCurrentURL(), "https://www.musala.com/careers/join-us/");
    }

    @Test(priority = 1, description = "Verify main sections are shown on an open position's page")

    public void verifySectionsAreShown() throws InterruptedException {
        homepage.openCareerTab();
        careerpage.clickOpenPositions();
        joinus.chooseFromDropDownList();
        joinus.SelectSeniorJavaDeveloper();

        Assert.assertTrue(seniorJavaDeveloperPage.PageContainsValidation());
    }

    @Test(priority = 2, description = "Verify apply button is present")
    public void verifyApplyButtonIsPresent() throws InterruptedException {
        homepage.openCareerTab();
        careerpage.clickOpenPositions();
        joinus.chooseFromDropDownList();
        joinus.SelectSeniorJavaDeveloper();

        Assert.assertTrue(seniorJavaDeveloperPage.applyButtonIsPresented());
    }

    @Test(priority = 3, description = "Verify Error messages are shown for invalid data on Job application")

    public void verifyApplyErrorMessagesAreShown() throws InterruptedException {
        homepage.openCareerTab();
        careerpage.clickOpenPositions();
        joinus.chooseFromDropDownList();
        joinus.SelectSeniorJavaDeveloper();
        seniorJavaDeveloperPage.clickApplyButton();
        seniorJavaDeveloperPage.enterInvalidEmail("test@test");
        seniorJavaDeveloperPage.uploadCV(currentDir + FilePathCV);
        seniorJavaDeveloperPage.clickSendButton();

        Assert.assertEquals(seniorJavaDeveloperPage.getEmailErrorMessage(), "The field is required.");

        Assert.assertEquals(seniorJavaDeveloperPage.getMobileErrorMessage(), "The telephone number is invalid.");
    }

    @AfterMethod
    public void AfterTesting() {
        if (driver != null) driver.quit();
    }

}
