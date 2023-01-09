package _homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class H02 extends TestBase {
    @Test
    public void windowHandleTest() {

//    https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

//    Title in ‘Windows’ oldugunu test edin
        Assert.assertEquals("Windows",driver.getTitle());

//    Click here a tiklayin
        driver.findElement(By.cssSelector("a[target='_blank']")).click();

//        String ilkSfHandle = driver.getWindowHandle();
//        Set<String> allWindow= driver.getWindowHandles();
//        for (String w : allWindow){
//            if(!w.equals(ilkSfHandle)){
//                driver.switchTo().window(w);
//            }
//        }

        switchToWindow("New Window");

//    Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        Assert.assertEquals("New Window",driver.getTitle());
    }
}