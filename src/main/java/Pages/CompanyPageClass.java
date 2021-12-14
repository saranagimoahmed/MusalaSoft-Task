package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyPageClass extends BaseClass {
    public CompanyPageClass(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public String getUrl() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return driver.getCurrentUrl();
    }

    public void clickFBButton() {

        BaseClass.elementsFooter(3);
        BaseClass.SwitchToWindow();
    }

    public boolean searchSection(String KeyWord) {
        return driver.getPageSource().contains(KeyWord);
    }

}
