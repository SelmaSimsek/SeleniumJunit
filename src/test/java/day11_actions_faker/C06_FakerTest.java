package day11_actions_faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Locale;

public class C06_FakerTest extends TestBase {

    /*
    Locale locale = new Locale("tr");
    Faker faker1 = new Faker(locale);
    System.out.println("faker1.name().firstName() = " + faker1.name().firstName());

    ==> Eger belli bir bölgeye özel fake datalar olusturmak istersek mesela Türkiye icin
        Locale classindan bir obje olustururuz
    ve olusturmus oldugumuz objeyi faker constructoru icinde beliritiriz
    bu sayade belirtilen bölgeye özel datalar elde edebiliriz
     */


    @Test
    public void name() {
        Locale locale = new Locale("tr");
        Faker faker = new Faker(locale);
        System.out.println("fake ilk isim = " + faker.name().firstName());
    }

    @Test
    public void test() {

        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //"create new account"  butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //"firstName" giris kutusuna bir isim yazin
        Locale locale = new Locale("tr");
        Faker faker = new Faker(locale);
        String lastName = faker.name().lastName();

        WebElement firstName = driver.findElement(By.xpath("//*[@name='firsname']"));
        firstName.sendKeys(faker.name().firstName());

        firstName.sendKeys(faker.name().firstName(), Keys.TAB,lastName,Keys.TAB,
                faker.internet().emailAddress(),
                Keys.TAB,faker.internet().password()
        );

        //"lastname" giris kutusuna bir soyisim yazin
        //"email" giris kutusuna bir email yazin
        //"email" onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
    }

}
