package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {

    //3 yeni window ac ve title larini verify et
    //3 yeni tab ac ve title larini verify et

    @Test
    public void newWindowHandleTest() {

        //1. TechPro education sayfasinin title'inin "Techpro Education" metnini icerdigini test edin.
        driver.get("https://www.techproeducation.com");
        String techProHandle = driver.getWindowHandle();
        System.out.println("techProHandle = " + techProHandle);

        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

        //2. Yeni bir pencerede Amazon sayfasini acip title'in "Amazon" metnini icerdigini test edin.
        waitFor(3);
        driver.switchTo().newWindow(WindowType.TAB);// 1 : Yeni pencere olusturur. 2 : Oraya gecis yapar.
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        driver.close();  // Açılan sayfayı kapatıp kalan sayfayla devam edebiliyoruz * * *
        driver.switchTo().window(techProHandle);
        System.out.println(driver.getTitle());


    //        //3. Yeni bir pencerede LinkedIn sayfasini acip title'in "LinkedIn" metnini icerdigini test edin.
    //        waitFor(3);
    //        driver.switchTo().newWindow(WindowType.WINDOW);// 1 : Yeni pencere olusturur. 2 : Oraya gecis yapar.
    //        driver.get("https://www.linkedin.com");
    //        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
    //
    //        //4. ilk sayfaya geri dönelim
    //        waitFor(3);
    //        driver.switchTo().window(techProHandle);//Aldiğimiz handle degeriyle switchTo() yaparak döneriz.

    }
}
