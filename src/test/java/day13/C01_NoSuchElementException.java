package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

/*

>> NoSuchElementException

-NoSuchElementException
-Yanlis locator
-Popup, yeni pencere, iframe…
-Sayfa dolmada problemler ve yavaşlamalar
-Sakli olan elementler

 Cözüm:
-Locatorin dogrulugunu tekrar kontrol et
-Manual test ile iframe, yeni pencere, alert…. gibi elementlerin varliğini kontrol et
-Bekleme problemi olabilir. İmplicit wait bekleme suresini cozmuyor. Bu durumda explicit wait ya da fluent wait kullaniriz

*/

    @Test
    public void noSuchElementTest(){

        driver.get("https://www.techproeducation.com");
        driver.
                findElement(By.xpath("//input[@type='searchh']")).//org.openqa.selenium.NoSuchElementException:
                sendKeys("QA"+ Keys.ENTER);
    }
}
