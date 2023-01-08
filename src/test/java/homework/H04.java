package homework;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class H04 extends TestBase {
    @Test
    public void test01() {

    //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

    //video’yu gorecek kadar asagi inin
        scrollDownActions();
        scrollDownActions();

    //videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(0);
        findCss("button[class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']").click();

    //videoyu calistirdiginizi test edin
        Assert.assertTrue(findCss("a[title='youtube.com sitesinde izle']").isDisplayed());

    }
}
