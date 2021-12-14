package io.furkan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class BasePage {
    WebDriver driver;
    
    public BasePage(WebDriver driver){
        this.driver =driver ; 
    }
    public WebElement find(By locator){
        return driver.findElement(locator);
    }
    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
    public void click(By locator){
        find(locator).click() ; 
    }
    public void type(By locator , String text){
        find(locator).sendKeys(text);
    }
    public void pressEnter(By locator){
        find(locator).sendKeys(Keys.RETURN);
    }
    public Boolean  isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
    public void scroll(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait(1000);
    }
    public void wait(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}