package day15_screenShot_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_ExtentReport {
    ExtentReports extentReports; //Raporlamayi baslatir
    ExtentHtmlReporter extentHtmlReporter; //html formatinda rapor olusturur
    ExtentTest extentTest; //Test adimlarina bilgi ekler




    @Test
    public void extentReportTemplate() {
        /*
        1- ExtentReport clasindan raporlamayi baslatmasi icin bir obje olusturmaliyiz
        2- ExtentHtmlReporter class indan raporlari html formatinda olusturmasi icin bir object olusturmaliyiz
        3- ExtentTest Classinndan test adimlarina bilgi ekleyebilmek icin bir object olustururuz
         */

        // bu object i raporlari olusturmak ve yönetmek icin kullanacagiz
        extentReports = new ExtentReports();

        //olusturmak istedigimiz html report u projemizde nerede saklamak istiyorsak
        //bir dosya yolu olusturmaliyiz. cünkü bu path i kullanarak bir report olusturacagiz
        //bunun icinde ExtentHtmlReporter classindan bir object olusturmaliyiz

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "target/extentReport/"+date+"htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //ExtentReports a Html raporlayiciyi ekler, bu raporun Html formatinda
        //olusturulmasini saglar
        extentReports.attachReporter(extentHtmlReporter);

        //Html raporunun belge basligini ayarlar, bu baslik sekme üzerinde görünür.
        extentHtmlReporter.config().setDocumentTitle("Batch 189 Test Reports");

        //Raporun adini ayarladik. Bu raporda görünecek olan genel baslik
        extentHtmlReporter.config().setReportName("Smoke Test");

        extentReports.setSystemInfo("Enviroment", "QA");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Test Automation Engineer","Ali Can");

        //"AmazonTest" adinda yeni bir test olusturur ve bu testin aciklamasi olarak "Test Report" ekler.
        extentTest = extentReports.createTest("AmazonTest","Test Report");

        //=============Buraya kadar sablon ayarlamalari bitti=================================

        //Bundan sonra extentTest objesi ile (loglama) rapora detayli islemleri ekleme islemleri yapacagiz

        //Testin basarili oldugunu belirtir ve rapora Pass notu ekler
        extentTest.pass("PASS");

        //Testle alakali bilgilendirici not ekler
        extentTest.info("Bilgilendirme Notu");

        //Testin basarisiz oldugunu belirtir ve rapora Fail notu ekler
        extentTest.fail("Fail Mesaji");

        //Testle ilgili uyari mesaji ekler
        extentTest.warning("uyari mesaji");

        //Testin atlandigini belirtir ve rapora Atlama Mesaji notunu ekler
        extentTest.skip("Atlama Mesaji");

        //Test sirasinda ciddi bir hata oldugunu belirtir
        extentTest.fatal("Ciddi Hata Mesaji");

        extentReports.flush();





    }
}
