package Tests;
import Helpers.PropertyManager;
import Helpers.ReadingExcel;
import Pages.HomePageClass;
import Helpers.Listener ;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners({Listener.class})
public class test1Class extends BaseTest{
 protected HomePageClass homepage ;
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
        driver.navigate().to(BaseTest.baseURL);
        driver.manage().window().maximize();
        homepage = new HomePageClass(driver);

    }

    @Test
            //(dataProvider ="InvalidData",description="Verify invalid email address on Contact us form" )

    public void invaildEmailsMessage(String InvaildEmail) {
        homepage.ContactUs();
        homepage.fillName();
        homepage.fillEmail(InvaildEmail);

    }
    @DataProvider(name="InvalidData")
    public Object[][] InvalidData() throws InvalidFormatException, IOException {
        ReadingExcel reader = new ReadingExcel();
        return reader.ReadingExcel();
    }



    }


