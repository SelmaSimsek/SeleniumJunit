package day12_files_seleniumwait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;

public class C03_UploadFile extends TestBase {
    @Test
    public void uploadTest() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement choosFile = driver.findElement(By.id("file-upload"));

        //Yuklemek istediginiz dosyayi secelim.
        //"C:\Users\selma\Downloads\b10 all test cases, code.docx"
        String dosyaYolu = System.getProperty("user.home") +
                "\\Downloads\\b10 all test cases, code.docx";
        choosFile.sendKeys(dosyaYolu);
        waitForSecond(2);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim.
        String actualText = driver.findElement
                (By.xpath("//h3[.='File Uploaded!']")).getText();
        Assert.assertEquals("File Uploaded!" , actualText);
        //Assert.assertTrue(actualText.contains("File Uploaded!"));



    }
}
