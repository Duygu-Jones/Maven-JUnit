package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C01_ExellRead {

    @Test
    public void readExellTest() throws IOException {

 //  WORKBOOK > WORKSHEET/SHEET (SAYFA) > ROW (SATIR) > CELL (VERI HUCRESI)
        String path = ".\\src\\test\\java\\resources\\Capitals.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

 //  DOSYAYI AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);

 //  EXELL DOSYASINI AC / WORKBOOK AC
 //        Sheet sheet1 = workbook.getSheetAt(0); //index 0 dan baslar. ilk sayfayı ac
        Sheet sheet1 = workbook.getSheet("Sheet1"); //Sheet1 isimli sayfayi ac

 //  ILK SATIRA GIT / ROW
        Row row1 = sheet1.getRow(0); // ilk satıra git

 //  ILK SATIRDAKI ILK VERIYI AL
        Cell cell1 = row1.getCell(0);// ilk hücredeki datayı verir

 //  O VERIYI YAZDIR
        System.out.println(cell1);

 //  1. SATIR 2.STUN 
        Cell cell12 = sheet1.getRow(0).getCell(1);
        System.out.println(cell12);

 //  3. SATIR 1.STUN ve o verinin France olduğunu doğrula
        String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France",cell31);

 //  Exell'deki toplam kullanilan satir sayisini bul
        int toplamSatirSayisi = sheet1.getLastRowNum()+1;//son satir numarasi index 0 dan basladıgı için 1 eksik veriyor +1 ekliyoruz.
        System.out.println("toplamSatirSayisi+1 = " + toplamSatirSayisi);

 //  Kullanilan toplam satir sayisini bul
        int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();// 1 den baslar kullanilan toplam satir sayisini verir
        System.out.println("kullanilanToplamSatirSayisi = " + kullanilanToplamSatirSayisi);

 //  COUNTRY , CAPITALS key ve value'leri map'a alip print edelim
//        COUNTRY, CAPITALS key ve value lari map a alip print et
//        {{USA, D.C},{FRANCE, PARIS},...}

//        Variable olusturalim. Bu variable exceldeki country,capital verilerini tutacak
        Map<String,String> ulkeBaskentleri = new HashMap<>();


        for (int satirSayisi=1;satirSayisi<kullanilanToplamSatirSayisi;satirSayisi++){
            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
        }
        System.out.println(ulkeBaskentleri);

        Map<String,String> ulkeBaskentleri2 = new TreeMap<>(ulkeBaskentleri);
        System.out.println("ulkeBaskentleri2 = " + ulkeBaskentleri2);

    }
}
