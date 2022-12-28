package practice_burakhoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class P01 {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/ ");

        // dropdown'dan "Books" secenegini secin
        WebElement ddm = driver.findElement(By.cssSelector("select[id='searchDropdownBox']"));

        //Select objesi olusturalim
        Select select =new Select(ddm);
        select.selectByVisibleText("Books");

        // arama cubuguna "Java" aratın

        driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
        WebElement result = driver.findElement(By.cssSelector("div[class='sg-col-14-of-20 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12'] span:nth-child(3)"));

        String result1 = result.getText();
        Assert.assertTrue(result1.contains("Java"));

    }
}
