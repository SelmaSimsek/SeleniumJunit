package day07_assertion_dropdown_testbase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Homework {
//   Yeni odevi
// ebay sayfasına gidiniz
// electronics bölümüne tıklayınız
// Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
// Her sayfanın sayfa başlığını yazdıralım

    protected WebDriver driver ;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.ebay.com/");
    }

    @Test
    public void test01() throws InterruptedException {
        //driver.findElement
        // (By.xpath("//*[@id='gdpr-banner-accept']"));

        // ebay sayfasına gidiniz
        // electronics bölümüne tıklayınız
        driver.findElement
                (By.xpath("(//a[.='Electronics'])[2]")).click();

        //Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        // Her sayfanın sayfa başlığını yazdıralım
        List<WebElement> resimler = driver.findElements
                (By.xpath("//img[@width='225' or height='225']"));

        for (WebElement each : resimler) {
            Thread.sleep(3000);
            WebElement img = each;
            img.click();
            Thread.sleep(3000);
            System.out.println(driver.getTitle());
            driver.navigate().back();

        }
    }


    @After
    public void tearDown() throws Exception {
        driver.close();
    }

}
