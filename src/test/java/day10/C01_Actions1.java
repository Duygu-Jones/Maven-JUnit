package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C01_Actions1 extends TestBase {


    @Test
    public void rightClickTest() {

//    Class: Actions1
        Actions action = new Actions(driver);

//    https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

//    Kutuya sag tıklayın
        WebElement box = findId("hot-spot");
        action.contextClick(box).perform();

//    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

//    Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();
    }
}
