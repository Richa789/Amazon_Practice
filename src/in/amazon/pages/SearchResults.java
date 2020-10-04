package in.amazon.pages;

import in.amazon.genericLib.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResults extends BaseTest {

    @FindBy(xpath="(//img[@alt='Lenovo Ideapad Slim 3i 10th Gen Intel Core i5 15.6 inch FHD Thin and Light Laptop (8GB/1TB/Windows 10/MS Office/Grey/1.85Kg), 81WE004WIN'])[1]") private WebElement laptop;
    public WebElement getLaptop() {
        return laptop;
    }
    public void selectLaptop() {
        laptop.click();
    }

    public void laptop() {
        laptop.click();
    }

    public SearchResults() {
        PageFactory.initElements(driver, this);
    }
}
