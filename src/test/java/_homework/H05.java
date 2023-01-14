package _homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class H05 extends TestBase {
    @Test
    public void test01() {

    //Test01
    //1- amazon gidin
        driver.get("https://www.amazon.com/");

    //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırız

        WebElement aramaSonucu1 = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(aramaSonucu1);
        List<WebElement> options = select.getOptions();
        options.forEach(t-> System.out.println(t.getText()));
        int listSayisi = options.size();

        //dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertEquals(28,listSayisi);

    //Test02
    //dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");

    //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        find(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        String result = find(By.cssSelector(".s-breadcrumb")).getText();
        System.out.println("result = " + result);

    //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(result.contains("iphone"));

    //ikinci ürüne relative locater kullanarak tıklayin

        List<WebElement> iphoneList = driver.findElements(By.cssSelector("span[class='a-size-base-plus a-color-base a-text-normal']"));

        iphoneList.get(1).click();

    //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim

        String addTitle1 = find(By.id("productTitle")).getText();
        addTitle1=addTitle1.split(" ")[1];

        String addPrice1 = find(By.id("corePriceDisplay_desktop_feature_div")).getText();

        find(By.id("add-to-cart-button")).click();

    //Test03
    //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");

    //dropdown’dan bebek bölümüne secin
        WebElement aramaSonucu2 = findPresenceWait(By.id("searchDropdownBox"));
        Select select1 = new Select(aramaSonucu2);
        select1.selectByVisibleText("Baby");

    //bebek puset aratıp bulundan sonuç sayısını yazdırın
        aramaSonucu2.sendKeys(Keys.TAB,"bebek puset",Keys.ENTER);

    //sonuç yazsının puset içerdiğini test edin
        String result2 = find(By.cssSelector("span[class='a-color-state a-text-bold']")).getText();
        Assert.assertTrue(result2.contains("puset"));

    //5-üçüncü ürüne relative locater kullanarak tıklayin
        List<WebElement> list = driver.findElements(By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']"));
        list.get(0).click();

    //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String addTitle2 = find(By.id("productTitle")).getText();
        addTitle2=addTitle2.split(" ")[1];

        String addPrice2 = findPresenceWait(By.id("corePriceDisplay_desktop_feature_div")).getText();

        find(By.id("add-to-cart-button")).click();

    // Test 4
    //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

        find(By.id("nav-cart-count-container")).click();

//        List<WebElement> newTitle =driver.findElements(By.cssSelector("li[class='a-spacing-mini']"));

        List<String> newTitle = getElementsText(By.cssSelector("li[class='a-spacing-mini']"));

//        List<WebElement> newPrice =driver.findElements(By.cssSelector("div[class='sc-item-price-block']"));
        List<String> newPrice = getElementsText(By.cssSelector("div[class='sc-item-price-block']"));

        Assert.assertTrue(newTitle.get(1).contains(addTitle1));
        Assert.assertTrue(newTitle.get(0).contains(addTitle2));

        Assert.assertTrue(newPrice.get(1).contains(addPrice1));
        Assert.assertTrue(newPrice.get(0).contains(addPrice2));


    }
}
