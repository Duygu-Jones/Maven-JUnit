package day10;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions4 extends TestBase {
    Actions actions = new Actions(driver);

    @Test
    public void dragAndDropTest() {

    // ** En fazla kullanılan sürükle bırak methodu budur. **

//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0); //iframe olduğu için önce onun içerisine girdik

        WebElement kaynak = findId("draggable");
        WebElement hedef = findId("droppable");

        actions.dragAndDrop(kaynak,hedef).perform();//ilk elementi 2.elementin olduğu bölgeye taşıdık

    }

    @Test
    public void clickAndHoldTest() {

//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0); //iframe olduğu için önce onun içerisine girdik

        WebElement kaynak = findId("draggable");
        WebElement hedef = findId("droppable");

        actions.
                clickAndHold(kaynak).// Elemanı tut
                moveToElement(hedef).// Hedefe koy
                build().// onceki methodlarin iliskisini kur/guclendir. ( Tercihen kullanılması gerekli )
                perform();// islemi gerceklestir
    }

    @Test
    public void moveByOffSetTest() {

//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0); //iframe olduğu için önce onun içerisine girdik

        WebElement kaynak = findId("draggable");

        actions
                .clickAndHold(kaynak)
                .moveByOffset(425,36)
                .release()
                .build()
                .perform();
    }
}
