package day13_seleniumwaits_exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Homework05 extends TestBase {
   /*
    ===========Homework 5==========================
    https://testpages.herokuapp.com/styled/challenges/growing-clickable.html adresine
    gidiniz click me buttonu na tiklayiniz
    "Event Triggered" yazisinin görüntülendigini dogrulayiniz
*/

    @Test
    public void test01() {
        //https://testpages.herokuapp.com/styled/challenges/growing-clickable.html adresine gidiniz
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
        waitForSecond(2);

        // click me buttonu na tiklayiniz
        driver.findElement(By.xpath
                ("//button[@class='styled-click-button showgrow grown']")).click();
        waitForSecond(2);

        //"Event Triggered" yazisinin görüntülendigini dogrulayiniz
        WebElement text = driver.findElement(By.id("growbuttonstatus"));
        Assert.assertTrue(text.isDisplayed());
    }
}
