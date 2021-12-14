package io.furkan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    SearchBox searchBox;
    By cartCountLocator = By.id("spanCart");
    By cartCountainerLocator = By.cssSelector("a.header-cart");
    By loginButtonLocator = By.cssSelector(".dropdown.cart-dropdown:first-child>a");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public Boolean isProductCountUp() {
        wait(1000);
        return getCartCount() > 0;
    }

    public void goToCart() {
        click(cartCountainerLocator);
    }

    private int getCartCount() {
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }
    
    public void clickLogin(){
        click(loginButtonLocator);
    }
}