package _homework;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class H06 extends TestBase {
/*
    Faker Kutuphanesi HOMEWORK
    Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
    degerler uretmemize imkan tanir.
    Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.

 */

    @Test
    public void testFaker() {
        Faker faker = new Faker();

        //"https://facebook.com"  Adresine gidin
         driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        find(By.cssSelector("a[rel='async']")).click();

        //“firstName” giris kutusuna bir isim yazin
        find(By.cssSelector("input[name='firstname']")).sendKeys(faker.name().firstName());

        //“surname” giris kutusuna bir soyisim yazin
        find(By.cssSelector("input[name='lastname']")).sendKeys(faker.name().lastName());

        //“email” giris kutusuna bir email yazin
         find(By.cssSelector("input[name='reg_email__']")).sendKeys(faker.internet().emailAddress());

        //“email” onay kutusuna emaili tekrar yazin
        find(By.cssSelector("input[name='reg_email_confirmation__']")).sendKeys(faker.internet().emailAddress());

        //Bir sifre girin
        find(By.cssSelector("input[name='reg_passwd__']")).sendKeys(faker.internet().password());

        //Tarih icin gun secin
        find(By.id("day")).sendKeys(String.valueOf(faker.number().numberBetween(1,31)));

        //Tarih icin ay secin
        Select dropDown = new Select(find(By.id("month")));
        dropDown.selectByVisibleText("Şub");

        //Tarih icin yil secin
        find(By.id("year")).sendKeys(String.valueOf(faker.number().numberBetween(1907,1992)));

        //Cinsiyeti secin
        WebElement erkek = find(By.cssSelector("input[value='2']"));
        erkek.click();

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.

        assertTrue(erkek.isSelected());
        assertFalse(find(By.cssSelector("input[value='1']")).isSelected());
        assertFalse(find(By.cssSelector("input[value='-1']")).isSelected());

    }

}
