package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {

//    TestBase i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum
//    TestBase testBase = new TestBase(); -> YAPILAMAZ
//    Amacim bu sinifi extend etmek ve icindeki hazir metodlari kullanmak
//    driver objesini olustur. Driver ya public yada protected olmali.
//    Sebepi child classlarda gorulebilir olmasi

    //  driver objesini olustur.
    protected static WebDriver driver;

    //  setUp
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //  tearDown
    @After
    public void tearDown()  {
        waitFor(5);
//        driver.quit();
    }

    //    MULTIPLE WINDOW
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    //    MULTIPLE WINDOW URL
    public static void switchToWindowUrl(String targetUrl) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().equals(targetUrl)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    //    MULTIPLE WINDOW INDEX
    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    public static WebElement findId(String key){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(key)));
        return element;
    }
    public static WebElement findCss(String key){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(key)));
        return element;
    }

    public static WebElement findXPath(String key){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(key)));
        return element;
    }

    /*   HARD WAIT:
        @param : second
    */
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    ACTIONS_RIGHT CLICK
    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
    //    ACTIONS_DOUBLE CLICK
    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }
    //    ACTIONS_HOVER_OVER
    public static void hoverOverOnElementActions(WebElement element) {
    //        Actions actions = new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }
    //    ACTIONS_SCROLL_DOWN
    public static void scrollDownActions() {
    //        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }
    //    ACTIONS_SCROLL_UP
    public static void scrollUpActions() {
    //        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }
    //    ACTIONS_SCROLL_RIGHT
    public static void scrollRightActions(){
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }
    //    ACTIONS_SCROLL_LEFT
    public static void scrollLeftActions(){
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }
    //    ACTIONS_DRAG_AND_DROP
    public static void dragAndDropActions(WebElement source, WebElement target) {
    //        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source,target).perform();
    }
    //    ACTIONS_DRAG_AND_DROP_BY
    public static void dragAndDropActions(WebElement source, int x, int y) {
    //        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source, x, y).perform();
    }
}
