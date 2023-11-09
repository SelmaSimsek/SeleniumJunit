package day08_testbase_alert_iframe;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class HomeworkIframe extends TestBase {
    //https://html.com/tags/iframe/ sayfasina gidiniz
    // sayfada bulunan youtube videosunu baslatiniz


    @Test
    public void test01() {
        //https://html.com/tags/iframe/ sayfasina gidiniz
        driver.get("https://html.com/tags/iframe/");

        // sayfada bulunan youtube videosunu baslatiniz
        driver.switchTo().frame(0);
        driver.findElement
                (By.xpath("//*[@id='movie_player']/div[4]/button"))
                .click();

    }
}
