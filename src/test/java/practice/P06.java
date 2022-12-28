package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P06 {

    WebDriver driver;
    List<WebElement> resim ;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
     driver.close();

    }

    @Test
    public void test01() throws InterruptedException {

//        - ebay sayfasına gidiniz
        driver.get("https://ebay.com");

//        - electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

//        - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım

        resim = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));

        for (int i = 0; i < resim.size() ; i++) {

            resim = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));

            resim.get(i).click();
            Thread.sleep(500);
            driver.navigate().back();
            Thread.sleep(500);
            System.out.println(i+1+" .başlık : " + driver.getTitle());
            Thread.sleep(500);
        }

//        - Her sayfanın sayfa başlığını yazdıralım
//        - sayfayı kapatalım

    }
}
