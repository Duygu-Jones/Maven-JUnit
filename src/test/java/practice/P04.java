package practice;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P04 {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        WebElement sas = driver.findElement(By.cssSelector("button[onclick='addElement()']"));

        for (int i = 0; i <100 ; i++) {
            sas.click();
        }

        // 100 defa basıldığını test ediniz
        List<WebElement> delete =driver.findElements(By.cssSelector("button[class='added-manually']"));
        Assert.assertEquals(100, delete.size());


        // 90 defa delete butonuna basınız
        for (int i = 0; i <90; i++) {
            driver.findElement(By.cssSelector("button[class='added-manually']")).click();
        }

        // 90 defa basıldığını doğrulayınız
        List<WebElement> delete3 =driver.findElements(By.cssSelector("button[class='added-manually']"));
        Assert.assertEquals(10,delete3.size());


        // Sayfayı kapatınız
        driver.close();
    }
}
