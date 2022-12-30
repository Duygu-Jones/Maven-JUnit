package canhocasorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Q03 extends TestBase {

    @Test
    public void windowHandle() throws InterruptedException {

//        url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");

//        ilk pencereyi al
        String firstWindow = driver.getWindowHandle();

//        "Click Here" butonuna tıklayın
        driver.findElement(By.cssSelector("a[target='_blank']")).click();

//        setteki tüm pencereyi al

        // Ne demek istediğinizi anlamadığım için bu adımı bay geçtim Can bey :D

//        diğer pencereye geç
        switchToWindowUrl("https://demo.guru99.com/articles_popup.php");

//        e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        driver.findElement(By.cssSelector("input[name='emailid']")).sendKeys("somepne@gmail.com");
        Thread.sleep(3000);


//        Gönder düğmesine tıklayarak
        driver.findElement(By.cssSelector("input[name='btnLogin']")).click();
        Thread.sleep(3000);


//        ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String text = driver.findElement(By.cssSelector("[align='center'] >h3")).getText();
        Assert.assertEquals("This access is valid only for 20 days.",text);

//        Tekrar ilk pencereye geç
        switchToWindowUrl("https://demo.guru99.com/popup.php");
        Thread.sleep(3000);


//        İlk pencerede olduğunu doğrula
        String lastWindow = driver.getWindowHandle();
        Assert.assertEquals(firstWindow,lastWindow);

 /*
    //  BU METHODU TEST BASE'E EKLEMEZSENIZ KOD ÇALIŞMAZ :) (title'lar aynıydı bende URL den geçtim :))


        public static void switchToWindowUrl(String targetUrl) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().equals(targetUrl)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

 */

    }
}
