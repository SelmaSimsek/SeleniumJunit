package day13_seleniumwaits_exceptions;

import org.checkerframework.framework.qual.DefaultQualifier;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Homework03 extends TestBase {
     /*
        ===========Homework 3==========================
    https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.
    */

    @Test
    public void test01() {

    //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement
                (By.xpath("//select[@id='dropdown']"));
        ddm.click();
        Select select = new Select(ddm);
        waitForSecond(2);
        select.selectByIndex(1);
        System.out.println("Option1 = "+select.getOptions().get(1).getText());


    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        waitForSecond(2);
        select.selectByValue("2");
        System.out.println("Option2 =" + select.getOptions().get(2).getText());


        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        waitForSecond(2);
        select.selectByVisibleText("Option 1");
        System.out.println("Option1 =" + select.getOptions().get(1).getText());

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> ddmList = select.getOptions();

        int counter= 1;
        for (WebElement w :ddmList ) {
            System.out.println(counter + "Option " +w.getAttribute("value"));
            counter++;
        }
    //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    //False yazdırın.
        int dropdownBoyutu = ddmList.size();
        System.out.println("dropdownBoyutu = " + dropdownBoyutu);
        String sonuc = dropdownBoyutu == 4 ? "True" : "False";
        System.out.println("sonuc = " + sonuc);
    }
}
