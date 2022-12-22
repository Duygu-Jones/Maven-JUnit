package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver( ).setup( );
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        1 https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

//        2 arama kutusunu locate edelim
        WebElement amazon =driver.findElement(By.id("twotabsearchtextbox"));

//        3 “Samsung headphones” ile arama yapalim
        amazon.sendKeys("Samsung headphones");//Keys.ENTER
        amazon.submit();//Enter'a bastık

//        4 Bulunan sonuc sayisini yazdiralim
        WebElement result = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Arama Sonucu : "+result.getText());//getText webelementin üstündeki yaziyi alir

//        5 Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

//        6 Sayfadaki tum basliklari yazdiralim
        List<WebElement> sfBasliklari = driver.findElements(By.xpath("//h1"));

        for (WebElement w: sfBasliklari){
            System.out.println(w.getText());
        }

//        sfBasliklari.stream().forEach(t-> System.out.println(t.getText())); > Lambda kullanimi

    }
}
