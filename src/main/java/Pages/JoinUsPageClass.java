package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class JoinUsPageClass extends BaseClass {
    public JoinUsPageClass(WebDriver driver) {
        super();
        this.driver = driver;
    }

    //Elements Locators
    By SeniorJavaDeveloper = By.xpath("//a[contains(.,'Senior Java Developer')]");

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void chooseFromDropDownList() {
        By LocationDopDownList = By.xpath("//select[@id=\"get_location\"]");
        WebElement LocationDopDownListWebelemnt = driver.findElement(LocationDopDownList);
        Select Locations = new Select(LocationDopDownListWebelemnt);
        Locations.selectByValue("Anywhere");
    }

    public void SelectSeniorJavaDeveloper() {
        driver.findElement(SeniorJavaDeveloper).click();
    }

    public void printIntoConsole() {


        String Location;
        for (int j = 0; j < 1; j++) {
            Location = "Sofia";
            {
                By JobsListLocator = By.xpath("//p[contains(.,'" + Location + "')]");
                List<WebElement> JobList = driver.findElements(JobsListLocator);
                int JobListSize = JobList.size();
                System.out.println(Location);
                for (i = 1; i <= JobListSize; i++) {
                    By JobsTitelocator = By.xpath("//*[@id='content']/section/div[2]/article[" + i + "]/div/a/div/div[1]/h2");
                    String JobTitle = driver.findElement(JobsTitelocator).getText();
                    By JobsLinkLocator = By.xpath("//*[@id='content']/section/div[2]/article[" + i + "]/div/a");
                    String JobLink = driver.findElement(JobsLinkLocator).getAttribute("href");
                    System.out.println("Position: " + JobTitle);
                    System.out.println("More info: " + JobLink);
                }
                System.out.println("--------------------------------------------------------------------------");
            }

            Location = "Skopje";
            {
                By JobsListLocator = By.xpath("//p[contains(.,'" + Location + "')]");
                List<WebElement> JobList = driver.findElements(JobsListLocator);
                int JobListSize = JobList.size();
                System.out.println(Location);
                for (i = 1; i <= JobListSize; i++) {
                    By JobsTitelocator = By.xpath("//*[@id='content']/section/div[2]/article[" + i + "]/div/a/div/div[1]/h2");
                    String JobTitle = driver.findElement(JobsTitelocator).getText();
                    By JobsLinkLocator = By.xpath("//*[@id='content']/section/div[2]/article[" + i + "]/div/a");
                    String JobLink = driver.findElement(JobsLinkLocator).getAttribute("href");
                    System.out.println("Position: " + JobTitle);
                    System.out.println("More info : " + JobLink);
                }
            }
        }

    }

    int i;
}
