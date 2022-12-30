package canhocasorular;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q04 extends TestBase {

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        List<WebElement> list = driver.findElements(By.xpath("//iFrame"));
        int a = list.size();
        System.out.println(a);

    }
}
