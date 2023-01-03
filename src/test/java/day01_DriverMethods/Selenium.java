package day01_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
     /*
        En temel haliyle otomasyon yapmak icin classimiza otomasyona gerekli olan webdriver'in yerini
        göstermemiz gerekir.Bunun icin java kutuphanesinden System.setProperty() methodunun icine
        ilk olarak driver'i yazariz. Daha sonra driverin'in fiziki yolunu kopyalariz
      */
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.techproeducation.com");


        Thread.sleep(3000);
        driver.quit();
    }
}