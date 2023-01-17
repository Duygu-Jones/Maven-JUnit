package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_Screenshot1 extends TestBase {
    @Test
    public void fullPageScreenshotTest() throws IOException {

 /*
        Selenium tun ekran goruntusu nasil alinir?
    -tum ekran goruntusu seleniumdan gelen getScreenshotAs metotu ile alinir.
    -getScreenshotAs metotu seleniumdaki TakesScreenshot api indan gelir
 */

        //Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");

        //1. Ekran goruntusunu getScreenshotAs methodu ile alip File olarak olusturalim
        File goruntu = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //2. Almis olduğum ekran goruntusunu belirttiğim bir PATH'e kaydet  .dir = directory = dosya
        String currentDate=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        String path = System.getProperty("user.dir")+"\\test-output\\EkranGoruntuleri\\"+currentDate+"image.png";


//      File hedef = new File(path); >> aşağıda "hedef olarak da kullanılabilirdi obje olusturmayı tercih etik"

        //3.Goruntum ile dosyami birleştir
        FileUtils.copyFile(goruntu,new File(path));

        //-“QA” aramasi yap
        find(By.cssSelector("input[title='Search']")).sendKeys("QA", Keys.ENTER);

        //Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: QA”
        WebElement text = find(By.cssSelector("div[class='elementor-widget-container']>h1"));
//                        findXPath("//*[contains(text(),'Search Results for')]");

        Assert.assertEquals("Search Results for: QA",text.getText());

        takeScreenShotOfPage();// > Tum sayfanın ekran goruntusunu alır.

    }
}
