package practice;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    //-"amazon.com" adresine gidelim
        driver.get("https://amazon.com");

    //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String baslik = driver.getTitle();
        System.out.println(baslik);
        String url = driver.getCurrentUrl();
        System.out.println(url);

    //-title ve url'nin "Spend" kelimesinin icerip icermedigini kontrol edelim

        Assert.assertFalse(baslik.contains("Spend") && url.contains("Spend"));

    //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://trendyol.com");

    //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String baslik2 = driver.getTitle();
        Assert.assertTrue(baslik2.contains("Sitesi"));

    //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

    //-sayfayi yenileyelim
        driver.navigate().refresh();

    //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();
        driver.close();

    }


}
