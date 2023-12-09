package Workshops.ShoppingDemo;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Utility.BaseDriver.WaitClose;
import static Utility.BaseDriver.driver;

public class ShoppingDemo extends BaseDriver {

    //The using of wait commands is only for you to see better.

    @Test
    public void Shopping(){

        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        MyFunc.Wait(2);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        MyFunc.Wait(2);

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        MyFunc.Wait(2);

        WebElement labsBackpack = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        labsBackpack.click();
        MyFunc.Wait(2);

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        MyFunc.Wait(2);

        WebElement backToProducts = driver.findElement(By.cssSelector("[id='back-to-products']"));
        backToProducts.click();
        MyFunc.Wait(2);

        WebElement boltTshirt = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        boltTshirt.click();
        MyFunc.Wait(2);

        WebElement shoppingCart = driver.findElement(By.cssSelector("[class='shopping_cart_link']"));
        shoppingCart.click();
        MyFunc.Wait(2);

        WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkout.click();
        MyFunc.Wait(2);

        WebElement firstName = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        firstName.sendKeys("Selenium");
        MyFunc.Wait(2);

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Testing");
        MyFunc.Wait(2);

        WebElement postalCode = driver.findElement(By.xpath("//input[@name='postalCode']"));
        postalCode.sendKeys("1234");
        MyFunc.Wait(2);

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
        MyFunc.Wait(2);

        List<WebElement> itemPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        double total = 0;

        for (WebElement e: itemPrices){

            System.out.println("Item Price: " + e.getText()); //Output = $29.99
            total = total + Double.parseDouble(e.getText().substring(1));

        }

        System.out.println("Total price = " + total);

        WebElement itemTotal = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        System.out.println("Item Total = " + itemTotal.getText());

        double itemTotalPrice = Double.parseDouble(itemTotal.getText().replaceAll("[^0-9,.]",""));

        Assert.assertTrue("Totals are not equals", (total==itemTotalPrice));

        WaitClose();

    }

}
