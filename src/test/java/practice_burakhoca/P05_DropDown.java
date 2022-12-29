package practice_burakhoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class P05_DropDown {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();

    }


    @Test
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        WebElement opt = driver.findElement(By.cssSelector("#dropdown"));
        Select select = new Select(opt);

        select.selectByIndex(1);
        System.out.println("Index : "+ select.getFirstSelectedOption().getText());
        Thread.sleep(2000);

        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        select.selectByValue("2");
        System.out.println("Value : "+select.getFirstSelectedOption().getText());
        Thread.sleep(2000);

        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println("Text : "+select.getFirstSelectedOption().getText());
        Thread.sleep(2000);

        // Tüm option'ları yazdırın
        List<WebElement> list = select.getOptions();
        int sayac=1;
        for (WebElement w : list){
            System.out.println(sayac+ ". option : "+w.getText());
            sayac++;
        }

        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int result = 3;
        Assert.assertEquals(result,list.size());

    }
















}
