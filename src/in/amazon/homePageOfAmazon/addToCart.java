package in.amazon.homePageOfAmazon;

import in.amazon.genericLib.BaseTest;
import in.amazon.genericLib.FileLib;
import in.amazon.genericLib.WebDriverCommonLib;
import in.amazon.pages.HomePage;
import in.amazon.pages.ProductPage;
import in.amazon.pages.SearchResults;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Listeners(in.amazon.genericLib.MyListener.class)
public class addToCart extends BaseTest {
    @Test
    public void addingProduct() throws IOException, InterruptedException {
        HomePage hp = new HomePage();
        FileLib flib = new FileLib();
        SearchResults sr = new SearchResults();
        WebDriverCommonLib wlib = new WebDriverCommonLib();
        wlib.waitForPageTitle(flib.getPropKeyValue(PROPERTY_pATH, "homeTitle"));
        wlib.verifyPage(wlib.getPageTitle(), flib.getPropKeyValue(PROPERTY_pATH, "homeTitle"), "Home Title");
        hp.search("laptop");
        Thread.sleep(6000);
        wlib.waitForPageTitle(flib.getPropKeyValue(PROPERTY_pATH, "searchResult"));
        wlib.verifyPage(wlib.getPageTitle(), flib.getPropKeyValue(PROPERTY_pATH, "searchResult"), "Search Result Page");
        Thread.sleep(6000);
        sr.laptop();
        Thread.sleep(6000);
        Set<String> newWindow = driver.getWindowHandles();
        for (String nw : newWindow) {
            String titleOfNewWindow = driver.switchTo().window(nw).getTitle();
            if (titleOfNewWindow.equals(flib.getPropKeyValue(PROPERTY_pATH, "productPageTitle"))) {
                wlib.verifyPage(wlib.getPageTitle(), flib.getPropKeyValue(PROPERTY_pATH, "productPageTitle"), "Product page title");
                driver.switchTo().window(nw);
                Thread.sleep(4000);
                ProductPage pp = new ProductPage(driver);
                pp.clickQuantity();
                wlib.selectOption(pp.getQuantity(), "5");
                pp.clickAddToCart();
                Thread.sleep(4000);
                if (pp.getMessage().isDisplayed()) {
                    Reporter.log("Successfully added products message is displayed", true);
                } else {
                    Reporter.log("Message is not displayed", true);
                }
            }
        }
    }
}


