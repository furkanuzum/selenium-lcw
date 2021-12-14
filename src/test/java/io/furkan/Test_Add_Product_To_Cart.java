package io.furkan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Add_Product_To_Cart extends Base_Test {
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    LoginPage loginPage;
    String priceInProductPage;

    @Test
    @Order(1)
    public void login(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        wait(10000);
        homePage.clickLogin();
        loginPage.login("furkanuzum61@gmail.com", "*Ybkrzg(9%t_YZNb");
    }

    @Test
    @Order(2)
    public void search_a_Product() {
        //login();
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("pantolon");
        wait(3000);
        productsPage.loadMore();
    }

    @Test
    @Order(3)
    public void select_a_Product() {
        //search_a_Product();
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectRandomProduct();
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                " Not on product detail page");
    }

    @Test
    @Order(4)
    public void add_Product_a_cart() {
        //select_a_Product();
        priceInProductPage = productDetailPage.getPrice();
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(),
                " Product count did not increase ");

    }

    @Test
    @Order(5)
    public void go_to_cart() {
        //add_Product_a_cart();
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(),
                " product was not added to cart");
        String priceInCartPage = cartPage.getProductPrice();
        Assertions.assertEquals(priceInProductPage, priceInCartPage, "prices are not equal");

        cartPage.incrementCount();
        wait(3000);
        int quantity = cartPage.getQuantity();
        Assertions.assertEquals(2, quantity, "quantity was not inremented");

        cartPage.deleteBasket();
        Assertions.assertTrue(cartPage.isBasketEmpty(),"Basket is not empty");

    }

}
