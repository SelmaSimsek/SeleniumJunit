package day13_seleniumwaits_exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Homework08 extends TestBase {
     /*
     ===========Homework 8==========================

    https://demo.guru99.com/test/drag_drop.html adresine gidin

    Sayfayi kesfederek turuncu webelementleri uygun kutulara sürükleyin
    Perfect! yazisinin görüntülendigini test edin
*/

    @Test
    public void test01() {
       //https://demo.guru99.com/test/drag_drop.html adresine gidin
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        waitForSecond(2);
        driver.findElement(By.cssSelector("#save")).click();

       //Sayfayi kesfederek turuncu webelementleri uygun kutulara sürükleyin
        WebElement banka = driver.findElement(By.xpath("(//a[@class='button button-orange'])[5]"));
        WebElement miktar1 = driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
        WebElement sales = driver.findElement(By.xpath("(//a[@class='button button-orange'])[6]"));
        WebElement miktar2 = driver.findElement(By.xpath("(//a[@class='button button-orange'])[4]"));

        WebElement account1 = driver.findElement(By.xpath("//ol[@id='bank']"));
        WebElement account2 = driver.findElement(By.xpath("//ol[@id='loan']"));
        WebElement amount1 = driver.findElement(By.xpath("//li[@class='placeholder'])[1]"));
        WebElement amount2 = driver.findElement(By.xpath("//li[@class='placeholder'])[2]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(banka,account1).dragAndDrop(miktar1,amount1).
                dragAndDrop(sales,account2).dragAndDrop(miktar2,amount2).perform();
        waitForSecond(2);


        //Perfect! yazisinin görüntülendigini test edin
        WebElement perfect = driver.findElement(By.xpath
                ("(//a[@class='button button-green'])[1]"));
        Assert.assertTrue(perfect.isDisplayed());

    }
}
