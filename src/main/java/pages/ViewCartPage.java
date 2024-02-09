package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewCartPage {

    private WebDriver driver;

    //Constructor
    public ViewCartPage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private By totalAmount = By.xpath("(//table[@class='cart-footer table table-bordered']//td)[2]");

    //Methods
    public String getTotalAmountValue(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(totalAmount)).getText();

    }
}
