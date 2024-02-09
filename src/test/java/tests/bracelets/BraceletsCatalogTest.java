package tests.bracelets;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BraceletsCatalogPage;
import pages.ViewCartPage;
import tests.base.BaseSetup;


public class BraceletsCatalogTest extends BaseSetup {

    @Test(description = " GC - Testing Bracelets catalog , searching and add to cart functionality")
    public void testBraceletsCatalog() {

        SoftAssert softAssert = new SoftAssert();

        //hover on catalog dropdown
        homePage.hoverOnCatalogDropDown();

        //click on Bracelets catalog
        BraceletsCatalogPage braceletsCatalogPage = homePage.clickOnBraceletsCatalog();

        //Verify the opening of the Bracelets page
        softAssert.assertEquals(driver.getTitle(), "Bracelets", "Assert on page title");
        String searchText = "fa";

        //search for the text "fa"
        braceletsCatalogPage.searchForItem(searchText);

        //Verify that each search result contains the search text
        for (WebElement product : braceletsCatalogPage.getProducts()) {
            softAssert.assertTrue(product.getText().toLowerCase().contains(searchText.toLowerCase()), "Assert on search results");
        }
        String firstItemPrice = braceletsCatalogPage.getFirstItemPrice();

        //add the first displayed product to the cart
        braceletsCatalogPage.addFirstItemToCart();

        //click on view cart
        ViewCartPage viewCartPage = braceletsCatalogPage.clickOnViewCart();

        //Verify that the total amount value equals the added to cart product's amount value
        softAssert.assertEquals(viewCartPage.getTotalAmountValue(), firstItemPrice, "Assert on total amount ");
        softAssert.assertAll();
    }
}
