package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BraceletsCatalogPage;
import pages.ViewCartPage;


public class BraceletsCatalogTest extends BaseSetup {

    @Test(description = " GC - Testing Bracelets catalog , searching and add to cart functionality")
    public void testBraceletsCatalog() {
        SoftAssert softAssert = new SoftAssert();
        homePage.hoverOnCatalogDropDown();
        BraceletsCatalogPage braceletsCatalogPage = homePage.clickOnBraceletsCatalog();

        //Verify on page title
        softAssert.assertEquals(driver.getTitle(), "Bracelets", "Assert on page title");
        String searchText = "fa";
        braceletsCatalogPage.searchForItem(searchText);

        //Verify that each search result contains the search text
        for (WebElement product : braceletsCatalogPage.getProducts()) {
            softAssert.assertTrue(product.getText().toLowerCase().contains(searchText.toLowerCase()), "Assert on search results");
        }
        String firstItemPrice = braceletsCatalogPage.getFirstItemPrice();
        braceletsCatalogPage.addFirstItemToCart();
        ViewCartPage viewCartPage = braceletsCatalogPage.clickOnViewCart();

        //Verify that the total amount value equals the added to cart product's amount value
        softAssert.assertEquals(viewCartPage.getTotalAmountValue(), firstItemPrice, "Assert on total amount ");
        softAssert.assertAll();
    }
}
