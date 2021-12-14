package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class HomePageClass extends BaseClass {
    //Elements Locators
    By contactUs = By.xpath("//button[@class='contact-label btn btn-1b']");
    By NameField = By.xpath("//input[@id='cf-1']");
    By EmailField = By.xpath("//input[@id='cf-2']");
    By SubjectField = By.xpath("//input[@id='cf-4']");
    By MessageField = By.xpath("//textarea[@id=\"cf-5\"]");
    By SendButton = By.xpath("//input[@type='submit']");
    By ErrorMassage = By.xpath("//*[@id=\"wpcf7-f875-o1\"]/form/p[2]/span/span");

    public HomePageClass(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void ContactUs() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,1000)");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(contactUs).click();

    }

    public void fillName() {

        driver.findElement(NameField).clear();
        driver.findElement(NameField).sendKeys("name");
    }

    public void fillEmail(String EMAIL) {
        driver.findElement(EmailField).clear();
        driver.findElement(EmailField).sendKeys(EMAIL);

    }

    public void fillSubject() {
        driver.findElement(SubjectField).clear();
        driver.findElement(SubjectField).sendKeys("Subject");
    }

    public void fillMessage() {
        driver.findElement(MessageField).clear();
        driver.findElement(MessageField).sendKeys("Message");
    }

    public void SendForm() {
        driver.findElement(SendButton).click();
    }

    public String ErrorMassage() {
        BaseClass.presenceOfElement(driver, 30, ErrorMassage);

        String ErrorMessage = driver.findElement(ErrorMassage).getText();
        return ErrorMessage;
    }

    public void openCompanyTab() {
        WebElement CompanyTab = driver.findElement(By.xpath("//*[@id='menu-main-nav-1']/li[1]/a"));
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(CompanyTab));
        Actions action = new Actions(driver);
        action.moveToElement(CompanyTab);
        action.clickAndHold(CompanyTab);
        action.doubleClick(CompanyTab).perform();


    }

    public void openCareerTab() {
        WebElement CareerTab = driver.findElement(By.xpath("//*[@id='menu-main-nav-1']/li[5]/a"));

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(CareerTab));
        Actions action = new Actions(driver);
        action.click(CareerTab).perform();
    }
}
