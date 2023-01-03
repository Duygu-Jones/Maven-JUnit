package day01_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverMethods {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver(); //Bos bir browser actik
        driver.get("https://www.amazon.com"); //Istedigimiz sayfaya yonlendirir.

        System.out.println(driver.getTitle()); //Sayfa basligi getirir
        System.out.println(driver.getCurrentUrl()); //Sayfa URL'sini getirir
//      System.out.println(driver.getPageSource()); //Kaynak kodlarini getirir
        System.out.println(driver.getWindowHandle()); //Window'a ait hash degerini verir.Biz bu hash degerlerini
                                                      //bir string'e atayip pencereler arasi gecis yapabiliriz.

    }
}
