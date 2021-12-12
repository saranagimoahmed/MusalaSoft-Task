package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeniorJavaDeveloperPageClass extends BaseClass
{
    public SeniorJavaDeveloperPageClass(WebDriver driver) {
        super();
        this.driver= driver;
    }
     By ApplyButton = By.xpath("//input[@type='button']");
    By NameField =By.cssSelector("//input[@id='cf-1']");
     By EmailField =By.xpath("//input[@id='cf-3']");
    By UploadField =By.xpath("//input[@id='uploadtextfield']");
     By SendButton      = By.xpath("//input[@type='submit']");
   By InvalidMessage = By.xpath("//*[@id=\"wpcf7-f880-o1\"]/form/p[3]/span/span");
    By EmptyMobileMessage = By.xpath("//*[@id=\"wpcf7-f880-o1\"]/form/p[4]/span/span");


    public boolean PageContainsValidation() {
        if(driver.getPageSource().contains("Requirements")
                && driver.getPageSource().contains("General description")
                && driver.getPageSource().contains("Responsibilities")
                && driver.getPageSource().contains("What we offer"))
        {return  true ;}
        else
        {return false;}
    }
    public void clickApplyButton() {
        driver.findElement(ApplyButton).click();
    }
    public void enteringInvalidName(String InvalidName) {
        BaseClass.SwitchToWindow();
        driver.findElement(NameField).clear();
        driver.findElement(NameField).sendKeys(InvalidName);
    }
    public void enterInvalidEmail(String InvalidEmail) {
        BaseClass.SwitchToWindow();
        driver.findElement(EmailField).clear();
        driver.findElement(EmailField).sendKeys(InvalidEmail);
    }
    public void uploadCV(String FilePath) {
        BaseClass.SwitchToWindow();
        driver.findElement(UploadField).sendKeys(FilePath);
    }

    public void clickSendButton() {
        BaseClass.SwitchToWindow();
        driver.findElement(SendButton).click();
    }


    public String getEmailErrorMessage() {
        BaseClass.SwitchToWindow();
        BaseClass.presenceOfElement(driver, 30, InvalidMessage);
        String TheInvalidMessage = driver.findElement(InvalidMessage).getText();
        return TheInvalidMessage;
    }
    public String getMobileErrorMessage() {
        BaseClass.SwitchToWindow();
        BaseClass.presenceOfElement(driver, 30, EmptyMobileMessage);
        String TheInvalidMessage = driver.findElement(EmptyMobileMessage).getText();
        return TheInvalidMessage;
    }
    public boolean applyButtonIsPresented() {
        return driver.findElement(ApplyButton).isDisplayed();
    }
}
