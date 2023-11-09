package day08_testbase_alert_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Iframe extends TestBase {
    /*
    Bir HTML dökümaninin icine yerlestirilmis baska bir HTML dökümanina inline Frame (iframe) denir
    Iframe i handle etmek icin driver imizi iframe gecis yaptirmamiz gerekir

    üc farkli yöntemle iframe e gecis yapabiliriz
    1) driver.switchTo.frame(sayfadaki iframe in index i) index o dan baslar
    2) driver.switchTo.frame(<iframe> tagindaki id / name attribute degeri
    3) driver.switchTo.frame(iframe in locate)

    Tekrar anasayfaya gecmek istersek defaultContent() methodu ile iframe den cikip ana sayfaya geceriz

    TekrarEger ic ice iframe lere gecis yaptiysak  bir ust frame gecis yaptirmak icin parentFrame() methodunu kullaniriz


     */

//https://testcenter.techproeducation.com/index.php?page=iframe
//Ana sayfadaki 'An iframe with a thin black border:' metninde
    // 'black border' yazisinin oldugunu test edelim
//Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
//Son olarak sayfa başınlığında iframe yazısının olduğunu test ediniz


    @Test
    public void test() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        //Ana sayfadaki 'An iframe with a thin black border:' metninde
        // 'black border' yazisinin oldugunu test edelim
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        String actualText = driver.findElement
                (By.xpath("//*[.='An iframe with a thin black border:']"))
                .getText();
        Assert.assertTrue(actualText.contains("black border"));

        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0); // index kullanarak frame e gecis yaptik
        WebElement applicationsListWE = driver.findElement
                (By.xpath("//*[.='Applications lists']"));
        applicationsListWE.click();
        Assert.assertEquals("Applications lists",applicationsListWE.getText());

        //Son olarak sayfa başınlığında iframe yazısının olduğunu test ediniz
        driver.switchTo().defaultContent();
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("iframe",iframeYazisi.getText());
    }







}
