package day13_seleniumwaits_exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C05_NullPointerException {

    Faker faker;

    /*
    NullPointerException
    Eger bir obje ya da variable olusturup bu olusturdugumuz obje ya da variable a assignment yapmadan
    kullanmak istersek bu Exception i aliriz
    Henüz olusturulmamis degeri null olan bir obje üzerinde islem yapmaya kalktigimizda bu hatayi aliriz

     */

    @Test
    public void test01() {
        faker = new Faker();
        System.out.println(faker.name().fullName());

    }
}
