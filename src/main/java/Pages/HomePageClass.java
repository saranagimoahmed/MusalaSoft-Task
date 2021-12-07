package Pages;

import Helpers.PropertyManager;
import Helpers.ReadingExcel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HomePageClass extends BaseClass
{
    //Elements
    @FindBy(xpath = "//button[@class='contact-label btn btn-1b']")
    WebElement ContactUs;
    @FindBy(xpath = "//input[@id='cf-1']")
    WebElement NameField;
    @FindBy(xpath = "//input[@id='cf-2']")
    WebElement EmailField;

    @FindBy(xpath = "//input[@id='cf-4']")
    WebElement SubjectField;

    @FindBy(xpath = "//textarea[@id=\"cf-5\"]")
    WebElement MessageField;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    WebElement SendButton ;

    public HomePageClass(WebDriver driver) {
        super();
    }

    public void ContactUs() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0,1000)");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ContactUs.click();
}
public void fillName() {
        NameField.clear();
        NameField.sendKeys("name");

}
public void fillEmail(String EMAIL ) {
    EmailField.clear();
    EmailField.sendKeys(EMAIL);
}
public void fillSubject() {
        SubjectField.clear();
        SubjectField.sendKeys("Subject");
}
public void fillMessage(){
        MessageField.clear();
        MessageField.sendKeys("Message");
}

}
