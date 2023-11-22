package day17_excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.mongodb.client.model.Accumulators.last;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {
        //Örnek 1: Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        //Örnek 2: 3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        //Örnek 3: Kullanılan satır sayısın bulun
        //Örnek 4: Sayfadaki son satırin index ini yazdırınız
        //Örnek 5: Excel sayfasindaki datalari COUNTRY,CAPITALS (Ülke-Başkent) key-value şeklinde console a yazdiriniz
        // {{USA,D.C},{FRANCE,PARIS}....}

        //Örnek 1: Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        String path="src\\test\\java\\resources\\Capitals.xlsx";
        FileInputStream fis=new FileInputStream(path);
        Workbook workbook=WorkbookFactory.create(fis);
        workbook.getSheet("Sheet1").getRow(0).getCell(1);

        //Örnek 2: 3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String actualcellValue = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        //String actualcellValue = workbook.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
        System.out.println("actualcellValue = " + actualcellValue);
        Assert.assertEquals("France",actualcellValue);

        //Örnek 3: Kullanılan satır sayısın bulun
        //getPhysicalNumberOfRows(): methodu icinde data olan satirlarin sayisini verir
        //ve bize bir sayi verdigi icin index 0 dab baslamaz 1 den baslar
        int icindeDataBulunanSatirSayisi = workbook.getSheet("Sheet1").
                getPhysicalNumberOfRows();

        //Örnek 4: Sayfadaki son satırin index ini yazdırınız
        //getLastRowNum(); methodu bir excel calisma sayfasindaki son satirin indexsini verir
        //index 0 dan basladii icin bu sayfada eger toplam 5 satir varsa bu method 4 verir
        System.out.println(workbook.getSheet("Sheet1").getLastRowNum());

        //Örnek 5: Excel sayfasindaki datalari COUNTRY,CAPITALS (Ülke-Başkent) key-value şeklinde console a yazdiriniz
        // {{USA,D.C},{FRANCE,PARIS}....}
       /* String country = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        String capital = workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();

        System.out.println(country+" "+capital);

        String country1 = workbook.getSheet("Sheet1").getRow(1).getCell(0).toString();
        String capital1 = workbook.getSheet("Sheet1").getRow(1).getCell(1).toString();

        System.out.println(country1+" "+capital1);

        String country2 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        String capital2 = workbook.getSheet("Sheet1").getRow(2).getCell(1).toString();

        System.out.println(country2+" "+capital2);*/

        Map<String,String> ülkeBaskentleri = new HashMap<>();

        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            String country = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String capital = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();

            ülkeBaskentleri.put(country,capital);
        }
        System.out.println("ülkeBaskentleri = " + ülkeBaskentleri);





    }


}
