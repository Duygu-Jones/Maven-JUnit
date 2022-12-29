package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AlertsAccept extends TestBase {

 /*
    *Alertleri nasil automate edersin? How to handle alerts in selenium?
    -Alertler javascript ile olusur. Inspect edilemezler. Oncelikle alerte switch etmemiz gerekir.
 */

    @Test
    public void acceptAlertTest() throws InterruptedException {
        //  Siteye git
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //  1.Alert butonuna tıkla
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();

        Thread.sleep(3000);
        //  Alert'i onayla
        driver.switchTo().alert().accept(); // accept() > kabul eder

        //Result ile karşılaştır.
        String actualResult = driver.findElement(By.cssSelector("p[id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";

        Assert.assertEquals(expectedResult,actualResult);
    }
}
