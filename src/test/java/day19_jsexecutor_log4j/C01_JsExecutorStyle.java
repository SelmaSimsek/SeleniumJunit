package day19_jsexecutor_log4j;

import com.google.j2objc.annotations.Weak;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JsExecutorStyle extends TestBase {
    @Test
    public void test01() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //aramakutusunun style özelliklerini degistirelim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        //searchBok webelementinin etrafina 5 pixel kalinliginda bir cerceve ekledik
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='5px solid red'",searchBox);

        //searchBok webelementinin arka plan rengini yesil yaptik
        js.executeScript("arguments[0].style.backgroundColor='green'",searchBox);

        //searchBok webelementinin metin rengini beyaza cevirdik
        js.executeScript("arguments[0].style.color='white'",searchBox);

        //sayfanin ekran görüntüsünü alalim
        screenShot();

    }
}
