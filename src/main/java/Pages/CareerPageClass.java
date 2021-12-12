package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class CareerPageClass extends BaseClass
{
    public CareerPageClass(WebDriver driver) {
        super();
        this.driver= driver;
    }
    By ourOpenPositionButton = By.xpath("//*[@id=\"content\"]/div[1]/div/div[1]/div/section/div/a/button");

    public void clickOpenPositions() throws InterruptedException {
        driver.findElement(ourOpenPositionButton).click();

    }
}
