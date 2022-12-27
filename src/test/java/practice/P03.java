package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();

//        WebElement acceptCookies =driver.findElement(By.xpath("//*[@id='ez-accept-all']"));
//        acceptCookies.click();

        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculate under Micro Apps
        driver.findElement(By.cssSelector("#calculatetest")).click();

        // Type any number in the first input
        // Type any number in the second input
        WebElement first = driver.findElement(By.cssSelector("#number1"));
        first.sendKeys("30", Keys.TAB, Keys.TAB,"60",Keys.ENTER);

        // Click on Calculate
        // Print the result
        WebElement result = driver.findElement(By.cssSelector("span#answer"));
        System.out.println("Sonuç  = " + result.getText());

        // close driver
        driver.close();
    }
}
