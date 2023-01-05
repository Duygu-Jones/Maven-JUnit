package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class H01 extends TestBase {

    @Test
    public void homeWork(){

//        https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

//        sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iFrameList=driver.findElements(By.xpath("//iframe"));
        int iFrameSayi = iFrameList.size();

//        Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String sayfaBaslik = driver.findElement(By.cssSelector(".example>h3")).getText();
        Assert.assertTrue("Test Passed",sayfaBaslik.contains("Editor"));

//        Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        WebElement yazi = driver.findElement(By.cssSelector("body[id='tinymce']>p"));
        yazi.clear();

//        Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        yazi.sendKeys("iframenin icindeyim");

//        Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim.
        driver.switchTo().defaultContent();
        String altKisim = driver.findElement(By.cssSelector("div[style='text-align: center;']")).getText();
        Assert.assertTrue(altKisim.contains("Elemental Selenium"));

    }

}
