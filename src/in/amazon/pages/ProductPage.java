package in.amazon.pages;

import in.amazon.genericLib.BaseTest;
import in.amazon.genericLib.WebDriverCommonLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage  {

         @FindBy(xpath="//select[@id='quantity']") private WebElement quantity;
        public WebElement getQuantity() {
            return quantity;
        }
        public void clickQuantity() {
            quantity.click();
        }

        @FindBy(id="add-to-cart-button") private WebElement addToCart;
        public WebElement getAddToCart() {
        return addToCart;
         }
        public void clickAddToCart() {
            addToCart.click();
        }

        public void selectQuantity() {
            quantity.click();
            addToCart.click();
            message.click();
        }

        @FindBy(xpath="(//div[@class='a-box-inner a-alert-container' and .='Added to Cart'])[2]") private WebElement message;
        public WebElement getMessage() {
            return message;
        }
        public void successMessage() {
            message.click();
        }



        public ProductPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }


}
