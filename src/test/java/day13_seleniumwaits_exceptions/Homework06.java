package day13_seleniumwaits_exceptions;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Homework06 extends TestBase {
     /*
===========Homework 6==========================
    https://testpages.herokuapp.com/styled/basic-html-form-test.html adresine gidin.
    Username adını, Password ve textArea bolumlerini faker ile doldurun
    Bir dosya seçin ve yükleyin
    Tüm checkbox lari secin
    Radio button da radio 1 i secin
    Dropdown menü den 2'yi seçin
    submit'e tıklayın
    Yüklenen dosyanin Form bilgilerinde yer aldığını doğrulayın

*/

    @Test
    public void test01() {
        //https://testpages.herokuapp.com/styled/basic-html-form-test.html adresine gidin.
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        waitForSecond(2);

        //Username adını, Password ve textArea bolumlerini faker ile doldurun
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@name='username']")).
                sendKeys(faker.name().username(),
                        Keys.TAB, faker.internet().password(),
                        Keys.TAB, faker.lorem().paragraph());
        waitForSecond(2);

        //Bir dosya seçin ve yükleyin
        WebElement dosyaSec = driver.findElement
                (By.xpath("//input[@name = 'filename']"));
        String dosyaYolu = System.getProperty("user.home") + "\\Downloads\\textfile.txt";
        dosyaSec.sendKeys(dosyaYolu);
        waitForSecond(2);

        //Tüm checkbox lari secin
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@value='cb1']"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@value='cb2']"));
        WebElement checkBox3 = driver.findElement(By.xpath("//input[@value='cb3']"));
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }
        if (!checkBox3.isSelected()) {
            checkBox3.click();
        }

        //Radio button da radio 1 i secin
        WebElement radioButton1 = driver.findElement(By.xpath("//input[@value='rd1']"));
        radioButton1.click();

        //Dropdown menü den 2'yi seçin
        WebElement ddm = driver.findElement(By.xpath("//select[@name='multipleselect[]']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Selection Item 2");

        //submit'e tıklayın
        driver.findElement(By.xpath
                ("(//input[@name='submitbutton'])[2]")).click();
        waitForSecond(2);

        //Yüklenen dosyanin Form bilgilerinde yer aldığını doğrulayın
        String yüklenenDosya = driver.findElement(By.id("_valuefilename")).getText();
        Assert.assertEquals("textfile.txt",yüklenenDosya);
    }
}