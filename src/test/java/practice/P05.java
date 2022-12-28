package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {
    static WebDriver driver;

    @AfterClass
    public static void afterClass() throws Exception {
        //AfterClass ile kapatın
        driver.close();

    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @Before
    public void setUp(){
        //http://www.google.com adresine gidin
        driver.get("http://www.google.com");
    }

    @Test
    public void test01() {

        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.cssSelector("input[title='Ara']")).sendKeys("The God Father", Keys.ENTER);

    }

    @After
    public void tearDown(){
        String [] sonuc = driver.findElement(By.cssSelector("#result-stats")).getText().split(" ");
        System.out.println(sonuc[1]);

    }

    @Test
    public void test02() {
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin

        driver.findElement(By.cssSelector("input[title='Ara']")).sendKeys("Lord of the Rings", Keys.ENTER);

    }

    @Test
    public void test03() {
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.cssSelector("input[title='Ara']")).sendKeys("Kill Bill", Keys.ENTER);
    }
}
