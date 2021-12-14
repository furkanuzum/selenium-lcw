package io.furkan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    By emailLocator = new By.ByCssSelector("#LoginEmail");
    By passwordLocator = new By.ByCssSelector("#Password");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void login(String email, String password){
        click(emailLocator);
        type(emailLocator, email);
        click(passwordLocator);
        type(passwordLocator, password);
        pressEnter(passwordLocator);
    }
}
