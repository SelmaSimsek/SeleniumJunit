package day13_seleniumwaits_exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class Homework04 extends TestBase {

    /*
    ===========Homework 4==========================
    https://testpages.herokuapp.com/ adresine gidiniz
    File Downloads a tiklayiniz
    Acilan sayfada Server Download a tiklayiniz
    Dosyanin basariyla indirildigini test ediniz

     */

    @Test
    public void test01() {
        //https://testpages.herokuapp.com/ adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");
        waitForSecond(2);

        String dosyaYolu = System.getProperty
                ("user.home")+"\\Downloads\\textfile.txt";

        try {
            Files.delete(Paths.get(dosyaYolu));
            System.out.println("Dosya silindi");
            waitForSecond(3);
        } catch (IOException e) {
            System.out.println("Dosya silinmedi!");
        }

        //File Downloads a tiklayiniz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        waitForSecond(3);
        WebElement fileDownloads = driver.findElement
                (By.xpath("//a[@id='download']"));
        fileDownloads.click();

        //Acilan sayfada Server Download a tiklayiniz
        waitForSecond(2);
        driver.findElement(By.xpath
                ("(//button[@class='styled-click-button'])[3]")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        //Dosyanin basariyla indirildigini test ediniz
        waitForSecond(2);
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));





    }
}
