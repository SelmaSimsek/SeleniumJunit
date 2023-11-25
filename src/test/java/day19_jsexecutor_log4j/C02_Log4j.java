package day19_jsexecutor_log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Log4j extends TestBase {
    /*
    1-Log4j kullanabilmek icin öncelikle Log4j core ve Log4j api dependencyleri xml dosyasina ekleriz
    2- project seviyesinde bir tane log4jxml dosyasi olusturup cobfigürasyon icin xml kodlarini bu dosyaya ekleriz

     */

    @Test
    public void test01() {
        //LogManager.getLogger(C02_Log4j.class); kodu parantez icinde belirtilen class
        // icin bir tane Logger(loglayici) objecti olusturur.
        Logger logger = LogManager.getLogger(C02_Log4j.class);

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        logger.info("Amazon web sayfasina gidildi");

        //arama kutusunda selenium aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        logger.info("Arama kutusu locate edildi");

        searchBox.sendKeys("selenium", Keys.ENTER);
        logger.info("Arama kutusunda selenium aratildi");


    }
}
