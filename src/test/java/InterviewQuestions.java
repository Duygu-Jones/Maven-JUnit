public class InterviewQuestions {

/*

    Otomasyon adimlari nelerdir?

    1) Test kabul kriterleri dikkatlice okunur
    2) Test case olusturulur
    3) İlk once manuel test edilir
    4) Her sey yolundaysa, otomasyon senaryolarinin testi yapilir
    5) Hata ya da eksiklik varsa developerla konusulur, developer (gelistirici) sorunu duzelttiginde tekrar test edilir
    6) Otomasyon testi tamamlandiginda konuyla ilgili rapor hazirlanir
    i) Html raporu olusturulur
    ii) Raporlar Jıra ya yuklenir
    iii)Rapor hazırlarken, manuel testler icin ek
    Test PASS durumunda;
    Rapor hazırlanip JIRA'ya yuklenir

    Test FAIL durumunda;
    Basarisiz olmasinin nedeni ya veri ya da bug(hata) olabilir
    Hatadan emin olmak icin yeniden test edilir
    Eger bug kaynakli ise developerlarla konusulur ve  hatalari duzeltmeleri icin sure verilir
    Hata duzeltildiginde tekrar test edilir ve rapor JIRA ya yuklenir

    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

* * DROPDOWN * *

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

    4.Bir seçeneğin secili olduğunu otomate etmek icin ne yapilir?
    Ornek : Gun olarak 10'u secdik ama ya secilmediyse ?

    getFirstSelectedOption() methodu ile secili olan seceneği return eder.


  -> Dropdown 2.versiyon :

    -Acilir menu. Birden fazla seçenegi koyabilecegimiz liste.

    ***Dropdown nasil automate edilir? How to handle dropdown?

    Dropdown elementi locate edilir.8 locatordan biri kulllaninbilir.
    Select classi kullanilarak bir Select objesi olusturulur. Select select = new Select(dropdownElement);
    Select objectini kullanarak ugun methodlarla islem yapilir
    selectBylndex(int); index 0 dan baslar
    selectByValue(“String”);
    selectByVisibleText(“String”);
    getOptions(); tum dropdown seçenekleri List<WebElement> olarak return eder
    getFirstSelectedOption(); secili olan ilk secenegi(default) return eder.

    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

* * UTILITIES * *

   -Utilities tekrar tekrar kullanacagimiz class'lari koydugumuz paketin adidir.
        - TestBase
        - Driver -> Sonra
        - ExcelUtil -> Sonra
        - Configuration -> Sonra
   - Utilities paketinde Test case'ler yazilmaz.
   - Sadece tekrar kullanilabilecek destek siniflari(support class) olusturulur.
   - Bu support classlar test caseslerin yazilmasini hizlandirir.

    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

* * ALERT * *

    *Alertleri nasil automate edersin? How to handle alerts in selenium?
    -Alertler javascript ile olusur. Inspect edilemezler. Oncelikle alerte switch etmemiz gerekir.

-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

* * İFRAME * *

    How do you find the number of iframe on a page? Bir sayfadaki toplan iframe sayisini basil buluruz?
    ***Iframe ler iframe tagi kullanılarak oluşturulur. Bu durumda find elements by frame locatorini kullanarak tum iframeleri bulurum
    ***driver.findElements(By.tagName(“iframe”));
    ***driver.findElements(By.xpath(“//iframe”));
    ————————————
    Explain how you can switch back from a main page? Tekrar ana sayfaya nasil donersin?
    ***2 farkli yol vardır.
    ***defaultContent yada parentFrame metotlarını kullarak gecis yapabiliriz.
    ———————————-
    What is the difference between defaultContent and parentFrame? defaultContent ve parentFrame arasindaki farklar nelerdi?
    *** Oncelikle her ikiside framein disina cikmamizi saglar. Ama defaultContent direk ana sayfaya atlatır, parentFrame ise bir üst seviyeye atlatir
    —————————————
    What might be the reason for your test case to fail?Bir test case in fail etme sebepleri neler olabilir?
    Yanlis locator. Cozum : Tekrar elementi locate etmek. Değişken element var ise ona gore dynamic bir xpath yazarız.
    Wait / Syncronization /Bekleme problemi: Cozum : implicit wait de yeterli sure oldugundan emin oluruz. O sureyi arttırabiliriz. 30 saniye verilebilir. Explicit wait kullanilabilir(sonra gore).
    Iframe. Cozum : switch to iframe
    Alert. Cozum : switch to alert
    New window(Yeni pencere) : switch to window

    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

*/






}
