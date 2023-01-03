package day02_DriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebElementsAndLocators {
    static WebDriver driver = new ChromeDriver();


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sitesine git
        driver.get("https://www.amazon.com.tr/");

        //Search bolumunu locate et
        WebElement search =driver.findElement(By.id("twotabsearchtextbox"));

        //Search bolumunde "iphone ara", ve tıkla.
        search.sendKeys("İphone", Keys.ENTER);

      /*
            Eger bir webelementi (Web sayfasindaki her bir buton ya da text/yazi) locate (konumunu belirleme)
            etmek istersek once manual olarak web sayfasini acip sayfa uzerinde sag click yapip incele/inspect butonuna tiklariz.
            Karsimiza cikan HTML code'larindan locator'lardan (konum belirleyiciler) unique (essiz) olani seceriz.
            Genellikle id Attribute'u kullanilir. Sectigimiz attribute degerini findElement() method'u icine
            findElement(BY.id("attribute degeri")) seklinde yazariz.
      */

        //Gidilen sitedeki input-tags sayısı
        List<WebElement> inputTags = driver.findElements(By.tagName("input"));
        System.out.println("Input tag sayısı = " + inputTags.size());

        //Gidilen sitedeki link Sayisi
        List<WebElement> linklerList = driver.findElements(By.tagName("a"));
        System.out.println("link sayisi = " + linklerList.size());

        //Gidilen sitedeki link isimleri
        for (WebElement w : linklerList){
            System.out.println(w.getText()); //getText() methodu textleri yazdirir.
        }

    }
//    WebElement search=find("twotabsearchtextbox");
//    public static WebElement find(String s){
//        return driver.findElement(By.id(s));
//    }

}
