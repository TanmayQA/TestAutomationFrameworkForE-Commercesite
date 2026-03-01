package com.ui.tests;

import com.ui.listeners.TestListner;
import com.ui.pages.HomePage;
import com.ui.pages.ProductPage;
import com.ui.pages.SearchResultPage;
import com.utillity.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;


@Listeners(TestListner.class)
public class ProductSearchTest extends TestBase {

    Logger logger = LoggerUtility.getLogger(this.getClass());
    private HomePage homePage;
    private ProductPage productPage;
    private SearchResultPage searchResultPage;

    @BeforeMethod(description = "Valid user logs into the application")
    public void setup() {
        homePage = loginPage.doLoginWith("xowam96002@icubik.com", "password1");
        productPage = homePage.clickonProductlink();
    }


    @Test(description = "Verify if the logged in user is able to search for product and correct products search results are displayed", groups = {"E2E", "Sanity"})
    public void verifyProductSearch() {
        String searchKey = "Sleeveless";
        searchResultPage = productPage.searchProduct(searchKey);
        List<String> resultlist = searchResultPage.getSearchResultNames();
        resultlist.forEach(System.out::println);
        for (String product : resultlist) {
            Assert.assertTrue(product.toLowerCase().contains(searchKey.toLowerCase()),
                    "Mismatch product: " + product);
        }
    }

}
