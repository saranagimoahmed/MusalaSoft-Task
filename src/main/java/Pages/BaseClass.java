package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class BaseClass {
    static WebDriver driver;


    public static void SwitchToWindow() {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        java.util.Iterator<String> itr = allWindows.iterator();
        while (itr.hasNext()) {
            String childwindow = itr.next();
            if (!childwindow.equalsIgnoreCase(currentWindow)) {
                driver.switchTo().window(childwindow);
            }
        }
    }



    public static void presenceOfElement(WebDriver driver, int time, By elementName) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementName));
    }



    public static void elementsFooter(int i) {
        By FooterLinks = By.xpath("//div[@class='links-buttons']");
        WebElement footer = driver.findElement(FooterLinks);
        List<WebElement> linksFoot = footer.findElements(By.tagName("a"));
        WebElement elementName = linksFoot.get(i);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(elementName));

        Actions action = new Actions(driver);
        action.moveToElement(elementName).click(elementName).perform();
    }

    public static void hoverOnTheElement(WebElement WebelementName) {
        Actions action = new Actions(driver);
        action.moveToElement(WebelementName).build().perform();
    }
}
