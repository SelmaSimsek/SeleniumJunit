package day13_seleniumwaits_exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Homework01 extends TestBase {
    /*
    ==========Homework 1===========================
//http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
//Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
//Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
//Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
//Çıkan alert'te iptal butonuna basınız
//Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
//Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
//Çıkan mesajı konsola yazdırınız
//Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
*/

    @Test
    public void test01() {
        //http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//p[.='Consent']")).click();
        waitForSecond(3);

        //Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        WebElement clickButton1 = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        clickButton1.click();
        waitForSecond(2);


        //Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        driver.switchTo().alert().accept();

        //Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        WebElement alert2 =driver.findElement(By.xpath("(//a[@class='analystic'])[2]"));
        alert2.click();
        waitForSecond(2);
        WebElement clickButton2 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        clickButton2.click();
        waitForSecond(2);


        //Çıkan alert'te iptal butonuna basınız

        String text = driver.switchTo().alert().getText();
        System.out.println("text = " + text);
        driver.switchTo().alert().dismiss();

        //Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        WebElement alert3 = driver.findElement(By.xpath("(//a[@class='analystic'])[3]"));
        alert3.click();
        WebElement clickButton3 = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        clickButton3.click();
        waitForSecond(2);

        //Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Selma");
        waitForSecond(3);
        driver.switchTo().alert().accept();

        //Çıkan mesajı konsola yazdırınız
        String mesajText = driver.findElement(By.id("demo1")).getText();
        System.out.println("mesajText = " + mesajText);


        //Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assert.assertTrue(mesajText.contains("Hello Selma How are you today"));

    }

}
