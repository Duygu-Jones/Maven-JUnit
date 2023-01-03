package day01_DriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ClassWork3 {

    public static void main(String[] args) {

     /*
         1. Yeni bir Class olusturalim.
         2. Amazon soyfasina gidelim. https://www.amazon.com/
         3. Sayfanin konumunu ve boyutlarini yazdirin
         4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
         5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
         6. Sayfayi kapatin
     */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
        int xCordinate = driver.manage().window().getPosition().getX();
        int yCordinate = driver.manage().window().getPosition().getY();

        int hHeight = driver.manage().window().getSize().getHeight();
        int wWidth = driver.manage().window().getSize().getWidth();

        System.out.println("Position x,y : "+xCordinate + " , " + yCordinate );
        System.out.println("Size h,w : "+hHeight + " , " + wWidth );

        driver.manage().window().setPosition(new Point(40,20));
        driver.manage().window().setSize(new Dimension(850,600));

         xCordinate = driver.manage().window().getPosition().getX();
         yCordinate = driver.manage().window().getPosition().getY();

         hHeight = driver.manage().window().getSize().getHeight();
         wWidth = driver.manage().window().getSize().getWidth();

        System.out.println("Position x,y : "+xCordinate + " , " + yCordinate );
        System.out.println("Size h,w : "+hHeight + " , " + wWidth);

        if (xCordinate==40 && yCordinate==20){
             System.out.println("Position Test is Passed");
         }else
             System.out.println("Position Test is Failed");

        if (hHeight==600 && wWidth==850){
            System.out.println("Size Test is Passed");
        }else
            System.out.println("Size Test is Failed");

        driver.close();
    }
}
