package day18_jsexecutor_log4j;

import com.google.j2objc.annotations.Weak;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JsExecutorScroll extends TestBase {
    @Test
    public void scrollwithJS() {
        //https://testpages.herokuapp.com/ adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");
        //Challenges a kadar scroll yapiniz
        WebElement challengesWebElement = driver.findElement(By.xpath("//h2[.='Challenges']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",challengesWebElement);
    }

    @Test
    public void scrollWithjs2() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //sayfaninen altina scroll yapalim
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        /*
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); kodu ile
        specific olarak bir webelemente scroll yapmadigimiz icin arguments degil
        window le baslattik ve scrollTo methodu ile x veya y koordinatlari belirttik
        x==> 0  degerini aldigi icin yatay eksende kaydirma yapmaz
        y==> document.body.scrollHeight kodunu yazdigimiz icin dynamic olarak
        sayfanin en altina scroll yapar
         */

        //sayfanin en üstüne scroll yapalim
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    public void scrollWithjs3() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Sayfanin en altina scroll yapalim
        jsScrollToEnd();
        waitForSecond(2);
        //sayfanin enüstüne scroll yapalim
        jsScrollToHome();
    }

    }
