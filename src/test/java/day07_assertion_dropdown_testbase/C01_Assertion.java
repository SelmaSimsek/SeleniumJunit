package day07_assertion_dropdown_testbase;

import org.junit.Assert;
import org.junit.Test;

public class C01_Assertion {
    /*
    Assertion, bir test sirasinda beklenen(expected) ve gercek(actual)
    sonuclar arasindaki uyumu dogrulamak icin kullanilir
    Eder beklenen sonuc gerceklesen sonuc ile uyusmuyorsa assertion exception
    firlatilir ve test failed(basarisiz) olur
    Junit te bir assertion basarisiz oldigunda o anda calismakta olan test
    methodu durdurulur ve bir assertionError firlatilir
    bu ilgili testin basarisiz oldugu anlamina geir
    Ancak test sinifi icindeki diger test methodlari bu durumdan etkilenmez ve kendi
    icindeki assertionlar basarisiz olmadikca calismaya devam ederler
     */
    // 1.assertion Equals(expected, actual): parantezi icinde belirtilen iki degerin
    //esit olup olmadigini kontrol eder esitse test basarili olur degilse basarisiz olur


    @Test
    public void test01() {
        String expectedData = "selenium";
        String actualData = "selenium";
        Assert.assertEquals(expectedData,actualData);
    }
    //2.assertTrue(boolean); parantezi icinde belirtilen kosulun dogru olup
    //olmadigini kontrol eder, eger parantez icindeki deger
    // true ise test basarili olur, degilse basarisiz olur


    @Test
    public void test02() {
        Assert.assertTrue("selenium".contains("e"));
    }

    // 3. assertFalse(boolean);parantezi icinde belirtilen kosulun yanlis
    // olup olmadigini kontrol eder, eger parantez icindeki deger
    // false ise test basarili olur, degilse basarisiz olur.


    @Test
    public void test03() {
        Assert.assertFalse("JAVA".contains("E"));
        Assert.assertFalse("SELENIUM".contains("A"));
    }
    // 4. assertionNotEquals(expected, actual);parantezi icinde belirtilen iki degerin
    //    //esit olup olmadigini kontrol eder, esit degilse test basarili olur
    //    asitse basarisiz olur


    @Test
    public void test04() {
        Assert.assertNotEquals("SELENIUM","JAVA"); //gecer
        Assert.assertNotEquals("SELENIUM","SELENIUM"); //kalir


    }
}
