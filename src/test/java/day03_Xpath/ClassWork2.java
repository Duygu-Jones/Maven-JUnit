package day03_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ClassWork2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //-Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com/");

        //-Arama kutusunu locate ediniz
        String aramaKutusu=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).getTagName();

        //-Arama kutusunun tagName'inin input olduğunu test ediniz
        if (aramaKutusu.equals("input")){
            System.out.println("Test Passed");
        }else
            System.out.println("Test Failed");

        //-Arama kutusunun name atributu'nun değerinin field-keywords olduğunu test ediniz
        String nameAtributeActuel = driver.findElement(By.cssSelector("input[name='field-keywords']")).getAttribute("name");

        String nameAtribute="field-keywords";

        if (nameAtributeActuel.equals(nameAtribute)){
            System.out.println("Test Passed");
        }else
            System.out.println("Test Failed");

        //-Sayfayı kapatınız
        driver.close();





    }
}
