package _homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class H03 extends TestBase {
    @Test
    public void test01() {

    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

    //2- Hover over Me First" kutusunun ustune gelin
        WebElement firstBox = find(By.xpath("//button[text()='Hover Over Me First!']"));
        hoverOverOnElementActions(firstBox);

    //Link 1" e tiklayin
        driver.findElement(By.linkText("Link 1")).click();

    //Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

    //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

    //“Click and hold" kutusuna basili tutun
       Actions actions = new Actions(driver);
       WebElement clickBox = find(By.id("click-box"));
       actions.clickAndHold(clickBox).perform();

    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickBox.getText());

    //8- “Double click me" butonunu cift tiklayin
        doubleClick(find(By.id("double-click")));

    }
}
