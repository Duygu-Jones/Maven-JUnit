package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

       /*

   UTILITIES
   -Utilities tekrar tekrar kullanacagimiz class'lari koydugumuz paketin adidir.
        - TestBase
        - Driver -> Sonra
        - ExcelUtil -> Sonra
        - Configuration -> Sonra
   - Utilities paketinde Test case'ler yazilmaz.
   - Sadece tekrar kullanilabilecek destek siniflari(support class) olusturulur.
   - Bu support classlar test caseslerin yazilmasini hizlandirir.

     */

    @Test
    public void test01(){
//      techproeducation ana sayfasina git ve title'in "Bootcamps" kelimesini içerdiğini kontrol edin
        driver.get("https://www.techproeducation.com");
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Bootcamp"));

    }

}
