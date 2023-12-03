package day17_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {
    //mysmoketestdata.xlsx dosyasina STATUS adinda ucuncu bir sutun olusturunuz,
    //Bu sutun altinda satirlara sirasiyla valid valid ve invalid degerlerini yaziniz

    @Test
    public void writeExcel() throws IOException {

        String path = "src\\test\\java\\resources\\mysmoketestdata.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet =  workbook.getSheet("customer_info");
        Row row = sheet.getRow(0);
        //3.sütun basligini olusturduk
        Cell cell3 = row.createCell(2);
        //3.hücreye status atadik
        cell3.setCellValue("STATUS");

        sheet.getRow(1).createCell(2).setCellValue("valid");
        sheet.getRow(2).createCell(2).setCellValue("valid");

        //dördüncü satirın ücüncü hücresını olustur ve degerını invalid olarak ata
        sheet.getRow(3).createCell(2).setCellValue("invalid");

        //Dosyaya yazmak icin bir sistemden cikis akisi olusturur
        FileOutputStream fos = new FileOutputStream(path);

        //Excel dosyasina yapilan degisiklikleri yazar
        workbook.write(fos);
        fis.close();
        fos.close();





    }
}
