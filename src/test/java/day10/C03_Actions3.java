package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions3 extends TestBase {

    @Test
    public void scrollUpDown() {
        Actions actions=new Actions(driver);

        //https://techproeducation.com a git
        driver.get("https://techproeducation.com");

        //Sayfanin altına doğru gidelim
        actions.sendKeys(Keys.PAGE_DOWN).perform(); // Aşağı in

        actions
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN).perform(); // 3 kere ağaşı in :)

        //ARROW_DOWN PAGE_DOWN'dan daha az mesaja gider
        actions.sendKeys(Keys.ARROW_DOWN).perform(); //PAGE_DOWN'dan daha az aşağı in

        //Sonra sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP).perform(); // Yukarı çık

        actions.sendKeys(Keys.ARROW_UP).perform(); // Daha az yukarı çık

//        actions.sendKeys(Keys.ARROW_RIGHT).perform(); // Biraz Sağa git
//        actions.sendKeys(Keys.ARROW_LEFT).perform(); // Biraz Sola git








    }
}
