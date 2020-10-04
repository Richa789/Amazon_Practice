package in.amazon.pages;

import in.amazon.genericLib.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    public WebElement getSearchBox() {
        return searchBox;
    }

    public void typeInSearchBox(String productName) {
        searchBox.sendKeys(productName);
    }

    @FindBy(xpath = "//input[@type='submit' and @class='nav-input']") private WebElement submitBtn;

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }

    public void search(String productName) {
        searchBox.sendKeys(productName);
        submitBtn.click();
    }

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
}

