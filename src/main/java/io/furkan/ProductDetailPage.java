package io.furkan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductDetailPage extends BasePage{
    By addToCartButtonLocator = By.id("pd_add_to_cart");
    By sizeLocator = By.cssSelector("div#option-size > a:not(.disabled)");
    By lengthLocator = By.cssSelector("div#option-height>a:not(.disabled)");
    By priceLocator = By.cssSelector("div.row div.price-area:not(.mobile) span.price");

    public ProductDetailPage(WebDriver driver){super(driver);}

    public Boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        List<WebElement> sizeElements = findAll(sizeLocator);
        WebElement selectedElement = sizeElements.get(0);
        selectedElement.click();
        
        List<WebElement> lengthElements = findAll(lengthLocator);
        if(lengthElements.size() > 0){
            lengthElements.get(0).click();
        }
        click(addToCartButtonLocator);
    }
    public String getPrice(){
        return find(priceLocator).getText();
    }
    

}