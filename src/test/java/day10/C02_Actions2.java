package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions2 extends TestBase {

    @Test
    public void hoverOverTest() {

        //Actions Objesi
        Actions actions = new Actions(driver);

        //1. Amazon home sayfasina git
        driver.get("https://www.amazon.com/");

        //2. Account & list e uzerinde bekle
        WebElement accountList = findId("nav-link-accountList");
        actions.moveToElement(accountList).perform();

        //3.Acilan pencerede Account linkine tıkla
        findXPath("//span[.='Account']").click();

        //4.Acilan sayfanin Title inin, your Account oldugunu dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));


    }
}
