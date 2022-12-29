package day06_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropdownResuable {

    static WebDriver driver;

    // Eğer test classında 1den fazla test methodu olusturulmussa @Before kullanilir.
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Sayfaya git
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    // RESUABLE METHOD :Dropdown icin tekrar tekrar kullanabilecegimiz method olusturalim
    public void selectFromDropDown(WebElement dropdown, String secenek) {
        // driver.findElement(By.xpath("//select[@id='year']")),"2005");
        // driver.findElement(By.xpath("//select[@id='month']")),"January");
        // driver.findElement(By.xpath("//select[@id='day']")),"10");

        List<WebElement> options = dropdown.findElements(By.tagName("option"));//Tum option'lari return eder
        for (WebElement w : options) {
            if (w.getText().equals(secenek)) {
                w.click();
                break;
            }
        }
    }

    @Test
    public void test01() {
        selectFromDropDown(driver.findElement(By.xpath("//select[@id='year']")), "2005");
        selectFromDropDown(driver.findElement(By.id("month")),"November");
        selectFromDropDown(driver.findElement(By.id("day")),"10");
        selectFromDropDown(driver.findElement(By.id("state")),"Texas");
    }

}



