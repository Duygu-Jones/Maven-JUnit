package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {
     WebDriver driver;

    // Eğer test classında 1den fazla test methodu olusturulmussa @Before kullanilir.

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void selectByIndexTest(){

        // https://testcenter.techproeducation.com/index.php?page=dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // 1. LOCATE dropdown element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

        //2. Select objesi olustur
        Select yearDropdown =new Select(year);

        //3. Select objesini kullanarak 3 farklı sekilde secim yapabiliriz.
        yearDropdown.selectByIndex(22); // Secenek Sırası 0 dan baslar. 2000 yili 23.sırada

        //Ay ismi January
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        Select ayDropdown = new Select(ay);
        ayDropdown.selectByValue("0");//Jaunarynin sırası 1 value değeri 0 olduğu için 0 yazdık

        //Gün numarası 10
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select dayDropdown = new Select(day);
        dayDropdown.selectByVisibleText("10");//10.günün Text değeri 10 olduğu için 10 yazdık ** en cok kullanılan budur
    }

    @Test
    public void printAllTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Tum eyaletleri consala yazdıralım
        WebElement state = driver.findElement(By.xpath("//select[@id='day']"));

        Select stateName= new Select(state);
        List<WebElement> nameList = stateName.getOptions();

        for (WebElement w : nameList){
            System.out.println(w.getText());
        }



    }

    /*
        1. What is dropdown? Dropdown nedir?
        Dropdown liste olusturmak icin kullanilir.
        2. How to handle dropdown elements? Dropdown nasil automate edilir?
        -Dropdown'i Locate ederiz
        -Select objecti'i olustururum
        -Select objecti'i ile istedigim secenegi secerim
        NOT: Select object'i olusturma nedenim, dropdownlarin Select class'i ile olusturulmasi
        3. Tum dropdown seceneklerini nasil prin ederiz?
        -Tum dropdown elementlerini getOptions() methodu ile listeye koyariz
        -sonra secenekleri loop ile yazdirabiliriz.

    */




}


