package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class BraceletsCatalogPage {

    private WebDriver driver;

    //Constructor
    public BraceletsCatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By searchField = By.name("search");
    private By searchGoButton = By.xpath("//input[@type='button'and @value='Go']");
    private By productsTitle = By.className("product-title");
    private By firstAddToCartIcon = By.xpath("(//*[@class='fa fa-cart-plus'])[1]");
    private By firstItemPrice = By.xpath("(//*[@class='sale-price'])[1]");
    private By cartIcon = By.xpath("//i[contains(@class,'fa-shopping-cart')]");

    //Methods
    public String getFirstItemPrice() {
        return driver.findElement(firstItemPrice).getText();
    }

    public BraceletsCatalogPage searchForItem(String itemName) {
        driver.findElement(searchField).sendKeys(itemName);
        driver.findElement(searchGoButton).click();
        return this;
    }

    public List<WebElement> getProducts() {
        List<WebElement> products = driver.findElements(productsTitle);
        return products;
    }

    public BraceletsCatalogPage addFirstItemToCart() {
        driver.findElement(firstAddToCartIcon).click();
        return this;
    }

    public ViewCartPage clickOnViewCart() {
        driver.findElement(cartIcon).click();
        return new ViewCartPage(driver);
    }

}
