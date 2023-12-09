package Workshops.CssSelectorLocater;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class cssSelectorLocater_1 extends BaseDriver {

//Hello, Our aim in this part of the workshop is learning
    //to discover hard-to-find locators using the Css Selector module.
    //The using of wait commands is only for you to see better.

    @Test
    public void cssSelector1(){

        driver.get("http://demoqa.com/text-box");

        WebElement fullName1 = driver.findElement(By.cssSelector("[placeholder='Full Name']"));
        fullName1.sendKeys("Automation");
        MyFunc.Wait(1);

        WebElement email1 = driver.findElement(By.cssSelector("[class='mr-sm-2 form-control']"));
        email1.sendKeys("testing@gmail.com");
        MyFunc.Wait(1);

        WebElement currentAddress1 = driver.findElement(By.cssSelector("textarea[placeholder='Current Address']"));
        currentAddress1.sendKeys("Testing Current Address");
        MyFunc.Wait(1);

        WebElement permanentAddress1 = driver.findElement(By.cssSelector("[id='permanentAddress']"));
        permanentAddress1.sendKeys("Testing Permanent Address");
        MyFunc.Wait(1);

        WebElement submitBtn1 = driver.findElement(By.cssSelector("[class='btn btn-primary']"));
        submitBtn1.click();

        WebElement assertion1 = driver.findElement(By.cssSelector("[class='border col-md-12 col-sm-12']>:nth-child(1)"));
        Assert.assertTrue(assertion1.getText().contains("Automation"));

        WebElement assertion2 = driver.findElement(By.cssSelector("[class='border col-md-12 col-sm-12']>:nth-child(2)"));
        Assert.assertTrue(assertion2.getText().contains("testing"));

        WaitClose();
    }

}
