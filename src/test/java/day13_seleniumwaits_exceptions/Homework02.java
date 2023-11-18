package day13_seleniumwaits_exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Homework02 extends TestBase {
    /*
===========Homework 2==========================
- http://szimek.github.io/signature_pad/ sayfasına gidiniz
- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
- Çizimden sonra clear butonuna basınız
- Sayfayi kapatiniz

         */
    @Test
    public void test01() {
        // http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        // Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement bosAlan = driver.findElement
                (By.xpath("//canvas[@style='touch-action: none; user-select: none;']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(bosAlan).
                moveToElement(bosAlan,50,50).
                moveToElement(bosAlan,80,180).
                moveToElement(bosAlan,-80,-50).
                moveToElement(bosAlan,30,70).
                moveToElement(bosAlan,-100,-20).
                moveToElement(bosAlan,100,25).
                moveToElement(bosAlan,-50,-80).
                moveToElement(bosAlan,140,180).
                moveToElement(bosAlan,-220,-220).
                moveToElement(bosAlan,80,280).perform();


        // Çizimden sonra clear butonuna basınız
        WebElement clearButton = driver.findElement
                (By.xpath("//button[@class='button clear']"));
        clearButton.click();

        // Sayfayi kapatiniz
        driver.close();



    }
}
