package io.furkan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class SearchBox extends BasePage {
    By searchBoxLocator = By.id("search_input");
    By submitButtonLocator = By.className("search-box__button");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        click(searchBoxLocator);
        type(searchBoxLocator, text);
        pressEnter(searchBoxLocator);
    }

}
