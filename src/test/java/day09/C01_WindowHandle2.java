package day09;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {

    @Test
    public void windowHandleTest() {

//        https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

//        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertEquals("Opening a new window",findXPath("//h3").getText());

//        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals("The Internet",driver.getTitle());

//        Click Here butonuna basın.
        findCss("a[href='/windows/new']").click();

//        Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        switchToWindow(1);
        Assert.assertEquals("New Window",findXPath("//h3").getText());
    }
}
