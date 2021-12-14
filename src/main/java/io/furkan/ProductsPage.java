package io.furkan;

import org.openqa.selenium.WebDriver;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    By filterOptionLocator = By.cssSelector("div.filterAndSort");
    By productBoxLocator = new By.ByCssSelector("div.product-item-wrapper>a");
    By loadMoreLocator = By.cssSelector("a.lazy-load-button");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isOnProductPage() {
        return isDisplayed(filterOptionLocator);
    }

    public void selectProduct(int i) {
        getAllProducts().get(i).click();
    }

    public void selectRandomProduct() {
        List<WebElement> allProducts = getAllProducts();
        int length = allProducts.size() - 1;
        int random = (int) (Math.random() * length);
        selectProduct(random);
    }

    private List<WebElement> getAllProducts() {
        return findAll(productBoxLocator);
    }

    public void loadMore() {
        List<WebElement> allProducts = getAllProducts();
        WebElement lastProduct = allProducts.get(allProducts.size() - 1);
        scroll(lastProduct);
        click(loadMoreLocator);
    }

}