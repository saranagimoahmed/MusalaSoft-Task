package Tests;

import Helpers.Listener;
import Helpers.PropertyManager;
import Pages.CompanyPageClass;
import Pages.FacebookMuslaSoft;
import Pages.HomePageClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class test2Class {
    public WebDriver driver;
    protected HomePageClass homepage;
    protected CompanyPageClass companypage;
    private FacebookMuslaSoft FaceBookPage;
    String SearchingkeyWord = "Leadership";

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
        companypage = new CompanyPageClass(driver);
        FaceBookPage = new FacebookMuslaSoft(driver);
    }

    @Test(priority = 0, description = "Verify correct URL of company page")
    public void verifyCompanyPageURL() {

        homepage.openCompanyTab();

        Assert.assertEquals(companypage.getUrl(), "https://www.musala.com/company/");
    }

    @Test(priority = 1, description = "Verify the presence of Leadership section")
    public void verifyLeadershipSection() {
        homepage.openCompanyTab();
        Assert.assertTrue(companypage.searchSection(SearchingkeyWord));
    }

    @Test(priority = 2, description = "Verify correct URL and profile picture of Facebook page")
    public void verifyFBURLAndPorfileImg() {

        homepage.openCompanyTab();
        companypage.clickFBButton();

        Assert.assertEquals(FaceBookPage.getUrl(), "https://www.facebook.com/MusalaSoft?fref=ts");

        Assert.assertTrue(FaceBookPage.checkFBProfilePicture());
    }

    @AfterMethod
    public void AfterTesting() {
        if (driver != null) driver.quit();
    }

}
