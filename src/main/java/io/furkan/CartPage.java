package io.furkan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;

public class CartPage extends BasePage {
    By productNameLocator = new By.ByCssSelector(".shoppingcart-item");
    By productPriceLocator = new By.ByCssSelector("div.shoppingcart-item span.rd-cart-item-price");
    By productPlusLocator = new By.ByCssSelector("a.plus");
    By productQuantityLocator = new By.ByCssSelector("input.item-quantity-input");
    By productDeleteLocator = new By.ByCssSelector("a.cart-square-link[title=Sil]");
    By productScDeleteLocator = new By.ByCssSelector(".sc-delete");
    By emptyBasketLocator = new By.ByCssSelector(".cart-empty-title");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Boolean checkIfProductAdded() {
        return getProducts().size() > 0;
    }

    private List<WebElement> getProducts() {
        return findAll(productNameLocator);
    }

    public String getProductPrice() {
        return find(productPriceLocator).getText();
    }

    public void incrementCount() {
        click(productPlusLocator);
    }

    public int getQuantity() {
        return Integer.parseInt(find(productQuantityLocator).getAttribute("value"));

    }

    public void deleteBasket() {
        click(productDeleteLocator);
        wait(1000);
        click(productScDeleteLocator);
    }

    public boolean isBasketEmpty() {
        return isDisplayed(emptyBasketLocator);
    }

}