package day08_testbase_alert_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C02_Alert extends TestBase {
    /*
    Eger bir sayfadaki bir butona tikladiginizda bir uyari cikiyorsa ve bu cikan
    uyariya sag click yaparak locate alamiyorsak, bu bir JS Alert'tür
    JS alert ü handle edebilmek icin driver imizi o acilan pencereye gecirmemiz gerekir
    driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak
    js alerte gecis yapmis oluruz

    1) accept() ya da dismiss() methoduyla JS Alert ü onaylar ya da iptal ederek kapatiriz

    accept() --> onaylar
    dismiss() --> iptal eder
     */

    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts
    adresine gidin.

    Bir metod olusturun: acceptAlert
       1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
       "You successfully clicked an alert" oldugunu test edin.

    Bir metod olusturun: dismissAlert
       2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
       "successfuly" icermedigini test edin.

    Bir metod olusturun: sendKeysAlert
       3. butona tıklayın, uyarıdaki  metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

    @Test
    public void acceptAlert() {
       // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
       // "You successfully clicked an alert" oldugunu test edin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button)[1]")).click();
        waitForSecond(2);

        driver.switchTo(). // driver a gecis yaptirmak icin kullanilir
                alert().  // driver i alert e gecis yaptirdik
                accept(); // Alert i onayladik

       // result mesajının
        //"You successfully clicked an alert" oldugunu test edin.
        String actualResultMessage =  driver.findElement
                (By.cssSelector("#result")).getText();
        String expectedResultMesaage = "You successfully clicked an alert";
        Assert.assertEquals(expectedResultMesaage,actualResultMessage);
    }

    @Test
    public void dissmissAlert() {
       // 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button)[2]")).click();
        waitForSecond(2);

        driver.switchTo().alert().dismiss(); //acilan alertten cancel tusuna bastik
        // "successfuly" icermedigini test edin.
        String actualResultMessage = driver.findElement(By.xpath("(//p)[2]")).getText();
        String unexpectedResultMessage = "successfuly";
        Assert.assertFalse(actualResultMessage.contains(unexpectedResultMessage));

    }

    @Test
    public void sendKeysAlert() {
        // 3. butona tıklayın, uyarıdaki  metin kutusuna isminizi yazin, OK butonuna
        //    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button)[3]")).click();
        waitForSecond(2);

        driver.switchTo().alert().sendKeys("selma");
        driver.switchTo().alert().accept();

        //result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResultMessage = driver.findElement
                (By.xpath("(//p)[2]")).getText();
        Assert.assertTrue(actualResultMessage.contains("selma"));


    }
}




