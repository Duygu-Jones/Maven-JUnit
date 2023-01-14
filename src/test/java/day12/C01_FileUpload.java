package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {

    @Test
    public void fileUploadTest() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement fileButton = find(By.id("file-upload"));

        //Yuklemek istediginiz dosyayi secelim.
        fileButton.sendKeys(System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\logo.jpeg");
        waitFor(5);

        //Upload butonuna basalim.
        find(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(find(By.xpath("//h3")).isDisplayed());
    }
}
