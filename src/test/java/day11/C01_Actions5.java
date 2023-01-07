package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions5 extends TestBase {

    @Test
    public void keyboardActionsTest() {
        Actions actions = new Actions(driver);

        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        WebElement nameBox = driver.findElement(By.name("q"));

        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        // Ve ENTER tusuna bas
        actions
                .keyDown(nameBox, Keys.SHIFT) //arama kutusunun üstünde shift tusuna bas
                .sendKeys("IPHONE X fiyatlari") //shifte basiliyken yazi yaz
                .keyUp(nameBox,Keys.SHIFT) //shifti bırak
                .sendKeys(" cok pahali"+Keys.ENTER) //shift'siz olarak "çok pahali" yaz
                .build() //birden fazla actions methodu kullanildiğinde tercihen build() kullanilir.
                .perform();
    }
}
