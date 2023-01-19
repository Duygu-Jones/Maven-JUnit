package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {


    @Test
    public void writeExcelTest() throws IOException {

        //  WORKBOOK > WORKSHEET/SHEET (SAYFA) > ROW (SATIR) > CELL (VERI HUCRESI) > YAZDIR > KAYDET

        String path = ".\\src\\test\\java\\resources\\Capitals.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        //  DOSYAYI AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //  EXELL DOSYASINI AC / WORKBOOK AC
        //        Sheet sheet1 = workbook.getSheetAt(0); //index 0 dan baslar. ilk sayfayı ac
        Sheet sheet1 = workbook.getSheet("Sheet1"); //Sheet1 isimli sayfayi ac

        //  ILK SATIRA GIT / ROW
        Row row1 = sheet1.getRow(0); // ilk satıra git

        //  ILK SATIR 3. STUNU CREATE ET
        Cell cell3 = row1.createCell(2);

        //  NUFUS YAZ
        cell3.setCellValue("NUFUS");

        //  2. SATIR 3. STUNU 450000
        sheet1.getRow(1).createCell(2).setCellValue("450000");
        
        //  3. SATIR 3. STUNU 350000
        sheet1.getRow(2).createCell(2).setCellValue("350000");

        //  KAYDET : Kayıt işlemi FileOutputStream işlemi ile yapılır.
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
    }
}
