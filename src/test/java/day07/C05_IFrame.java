package day07;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    @Test
    public void iFrameTest() {
//        https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //tag[.='metin']; Bana taglı metni ver
        //tag[text()='metin']; ile aynı işi yapar

//        Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim

        String text = driver.findElement(By.cssSelector(".example > p")).getText();
                                      // (By.xPath(p[.='An iframe with a thin black border:']))
        String expText ="black border";
        Assert.assertTrue("Text sonucu : ",text.contains(expText));

//        Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0); //index 0dan baslar.iframe switch yapmam şart
        String icMetin=driver.findElement(By.cssSelector(".display-5.fw-bold")).getText();
        String expText1 = "Applications lists";
        Assert.assertEquals(icMetin,expText1);

//        Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
//        Ana sayfadaki Povered By yazinisi test etmek istiyorum Ama driver hala iframein icinde
//        Iframein disina cikmak icin driver.switchTo().defaultContent/parentFrame

        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));


    }
}
