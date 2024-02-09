package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    //Constructor
    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By braceletsCatalogLocator = By.xpath("//*[@data-id='113']");
    private By catalogDropDown = By.xpath("//*[@data-id='111']");

    //Methods
    public HomePage hoverOnCatalogDropDown(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(catalogDropDown)).perform();
        return this;
    }

    public BraceletsCatalogPage clickOnBraceletsCatalog(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(braceletsCatalogLocator)).click();
        return new BraceletsCatalogPage(driver);
    }
}
