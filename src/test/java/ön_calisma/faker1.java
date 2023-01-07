package ön_calisma;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class faker1 extends TestBase {

    @Test
    public void fakerTest() {

        Faker faker = new Faker();

        Actions actions = new Actions(driver);
        driver.get("https://www.facebook.com");
        findId("u_0_0_Ln").click();
        WebElement isim = findCss("input[name='firstname']");

        String fakeEmail =faker.internet().emailAddress();
        actions.click(isim)
                .sendKeys(faker.name().firstName())
                .sendKeys(faker.name().lastName())
                .sendKeys(faker.address().fullAddress())
                .sendKeys(fakeEmail)
                .build()
                .perform();





    }
}
