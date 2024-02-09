package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        return driver.findElement(totalAmount).getText();
    }
}
