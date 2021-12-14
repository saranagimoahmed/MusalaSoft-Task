package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookMuslaSoft extends BaseClass {

    public FacebookMuslaSoft(WebDriver driver) {
        super();
        this.driver = driver;
    }

    //Elements Locators
    By FBProfilePic = By.xpath("//img[@class='_6tb5 img']");

    public String getUrl() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return driver.getCurrentUrl();
    }

    public boolean checkFBProfilePicture() {
        WebElement MusalaProfileImg = driver.findElement(FBProfilePic);
        BaseClass.hoverOnTheElement(MusalaProfileImg);
        return MusalaProfileImg.isDisplayed();
    }
}
