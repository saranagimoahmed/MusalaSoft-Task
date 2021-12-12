package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class BaseClass {
    static WebDriver driver;


    public static void SwitchToWindow (){
        String currentwindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        java.util.Iterator<String> itr = allWindows.iterator();
        while(itr.hasNext()){
            String childwindow = itr.next();
            if(!childwindow.equalsIgnoreCase(currentwindow)){
                driver.switchTo().window(childwindow);
            }
        }
    }
    public  static void waitForVisibility(WebDriver driver , int time , By elementName) {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementName));
    }
    public void WaitForClickability(WebDriver driver , int time , By elementName) {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(elementName));
    }
    public  static void presenceOfElement(WebDriver driver , int time , By elementName) {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementName));
    }
    public void HoverElements (WebElement WebelementName) {
        Actions action = new Actions(driver);
        action.moveToElement(WebelementName).build().perform();
    }

    public void  ScrollView(WebElement elementName) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView()",elementName);

    }
    public static void  footerElements(int i) {
        By FooterLinks = By.xpath("//div[@class='links-buttons']");
        WebElement footer = driver.findElement(FooterLinks);
        List<WebElement> footlinks=footer.findElements(By.tagName("a"));
        WebElement elementName = footlinks.get(i);

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(elementName));

        Actions action = new Actions(driver);
        action.moveToElement(elementName).click(elementName).perform();
    }
    public static void hoverOnTheElement(WebElement WebelementName) {
        Actions action = new Actions(driver);
        action.moveToElement(WebelementName).build().perform();
    }
}
