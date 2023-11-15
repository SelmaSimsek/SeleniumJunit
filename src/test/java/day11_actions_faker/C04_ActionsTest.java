package day11_actions_faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Locale;

public class C04_ActionsTest extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak
            // selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement (By.xpath("//*[@id='APjFqb']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT). //Arama kutusunda shift tusuna basili tutar
                sendKeys("selenium").
                keyUp(Keys.SHIFT). //shift tusundan parmagini kaldir
                sendKeys(" - java",Keys.ENTER).
                perform();

    }


    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak
        // selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT, " - java",Keys.ENTER);

    }

    @Test
    public void test03() {

        //google sayfasına gidelim
        driver.get("https://google.com");

        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys("Selenium", Keys.ENTER);

        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.CONTROL).
                sendKeys("A").sendKeys("X").
                keyUp(Keys.CONTROL).perform();



        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım

    }
}
