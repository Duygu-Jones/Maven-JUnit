package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_JSExecutor_Type extends TestBase {
    //Techpro education ana sayfasina git
    //	2)Techpro education ana sayfasina git
    //	3)Arama kutusuna QA yaz
    @Test
    public void typeTest() {
        driver.get("https://techproeducation.com");
        waitFor(3);
        jsSendKeys(By.xpath("//input[@type='search']"),"QA");
    }

    //    *****ODEV*****

    //	1)getValueTest metotu olustur
    //	2)https://www.priceline.com/ a git
    //	3)Tarih kısmındaki Yazili metinleri al ve yazdır

}