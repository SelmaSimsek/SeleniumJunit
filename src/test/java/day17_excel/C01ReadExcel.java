package day17_excel;

import com.github.javafaker.File;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01ReadExcel {
    @Test
    public void test01() throws IOException {
        //1-Projemize resouces packege i altida bulunan excel dosyamizin yolunu belirtmeliyiz
        String path = "src\\test\\java\\resources\\Capitals.xlsx";

        //2-FileInputStream classini kullanarak bir stream olusturduk ve akis ile
        //dosyamizdan geken datayi java ortamina aktaracagiz.
        FileInputStream fis = new FileInputStream(path);

        //3-fis objemiz üzerinden bir excel dosyasi olusturduk
        //Excel dosyasindan verileri okuyabilmek icin bu dosyayi java ortaminda actik
        Workbook workbook = WorkbookFactory.create(fis);

        //4-Bir excel (=workbook) dosyasinda birden fazla sayfa bulunabilir, bu nedenle
        //"Sheet1" adli calisma sayfasini acmak ve bu sayfadaki datalarla calisabilmek icin
        //bu kodu yazdik
        Sheet sheet = workbook.getSheet("Sheet1");

        //5- Bir excel sayfasinda birden fazla row yani satir bulunur, belirtmis oldugumuz
        //sayfadaki satir bilgisini sacmemiz gerekir
        //BU yazmis oldugumuz kod ile excel dosyamizin ilgili sayfasindaki ilk satiri sectik
        Row row = sheet.getRow(0);

        //6-Bir satir birden fazla cell icerdigi icin hangi cell ile calismak istedigimizi
        //javaya asagidaki kod ile belirttik. NOT. index 0 dan baslar
        Cell cell = row.getCell(0);
        System.out.println("cell = " + cell);

    }

    @Test
    public void test02() throws IOException {
        String path = "src\\test\\java\\resources\\Capitals.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        workbook.getSheet("Sheet1").getRow(0).getCell(0);
    }
}
