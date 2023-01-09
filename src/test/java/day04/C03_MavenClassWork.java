package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_MavenClassWork {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//    1 - https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

//    2 - Sayfa basliginin “Google” ifadesi icerdigini test edin
        boolean baslik = driver.getTitle().contains("Google");
        if (baslik){
            System.out.println("Başlık Test Passed");
        }else
            System.out.println("Başlık Test Failed");

//    3 - Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        Thread.sleep(1000);

//    4 - Bulunan sonuc sayisini yazdirin
        WebElement rslt = driver.findElement(By.id("result-stats"));
        String sonucSayisi = rslt.getText().split(" ")[1].replaceAll("\\.","");

        int sayi=Integer.parseInt(sonucSayisi);
        System.out.println("Arama Sonuç Sayısı : "+sayi);

//    5 - Sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        if (sayi>10000000){
            System.out.println("Sonuç sayısı 10000000'dan fazla ");
        }else
            System.out.println("Sonuç sayısı 10000000'dan az ");

//    6 - Sayfayi kapatin
        driver.quit();

    }
}
