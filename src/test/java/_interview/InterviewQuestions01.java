package _interview;

public class InterviewQuestions01 {

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

    3. Tum dropdown seceneklerini nasil print ederiz?
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

* * ACTIONS * *

 ACTIONS CLASS'ı NEDİR? HANGİ METHODLAR İLE  NASIL KULLANILIR?..

//   Actions classını kullanarak klavye ve mouse ile yapabileciğiz tüm işlemleri otomosyonda da  yapmamızı sağlamaktayız..!!
//   Bu classa ait metdodlar kısaca aşağıdaki gibidir....

//       actions.doubleClick () :   WebElement'e çift tıklama yapar
//       actions.clickAndHold () :  Uzerinde click yapili olarak bekler
//       actions .dragAndDrop () :  Bir noktadan diğerine sürükler ve bırakır
//       actions.moveToElement () : Mouse'u istedigimiz WebElement'in uzerinde tutar
//       actions.contextClick ():   Mouse ile istedigimiz WebElement'e sag tiklama yapar.
//       actions.sendKeys() :       Öğeye bir dizi anahtar gönderir
//       actions.keyDown () :       Klavyede tuşa basma işlemi gerçekleştirir
//       actions.keyUp () :         Klavyede tuşu serbest bırakma işlemi gerçekleştirir
//
//
//        !!!!Actions classını kullanmak için üç aşama vardır.

//     1.Action classından obje üretiriz.
//     (Actions actions= new Actions(driver);)
//     2.actions objesi ile kullanacağımız web elementi locate ederiz...
//     3.istediğimiz methodları action objesi ile kullanırız.
//     actions.doubleClick(element ismi).perform;


1- Actions nedir? Actions Class nedir ?

*Actions selenium dan gelen bir kütüphanedir.
Mouse ve Keyboard islemlerini gerçekleştirmek icin kullandigimiz hazır bir selenium kutuphanesidir.
Ornegin, sag tiklamak(contextClick), çift tıklamak(doubleClick),
elementin uzerine gitmek(moveToElement) gibi mouse islemlerini gerçekleştirebiliriz.
Ayni zamanda, shift, control, delete, enter gibi keyboard tuslarinada actions yardımıyla basabiliriz.
Bu tur islemlerde sendKeys metodu kullaninir.

2- Ne tur methodlar kullandin?
Actions metotlari onemlidir. Ve tekrar tekrar kullanmam gerektiğinden,
Actions metotlarını içeren Reusable metodları oluşturdum. Ve gerektiğinde bu reusable metodları kullanıyorum.
Ornegin rightClick methodunu bir elemente raga tiklamak icin test classimda vagira bilirim.

3- Hangi methodlari kullandin ne ne ise yarar?
Ornegin, sag tiklamak(contextClick), çift tıklamak(doubleClick),
elementin uzerine gitmek(moveToElement) gibi mouse islemlerini gerçekleştirebiliriz.
Ayni zamanda, shift, control, delete, enter gibi keyboard tuslarinada actions yardımıyla basabiliriz.
Bu tur islemlerde sendKeys metodu kullaninir.

    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

* * FAKER * *

    TEST DATA : kullanicai adi, sifre, tel no, email, sehir, kredi kart no,...
    Test datalarini kimden alinir?
    1. BA-Business analyst (Acceptance Criteria lari yazar)
    2. Test Lead
    3. Manual Tester
    4. Tech Lead & Team Lead & Dev Lead
    5. Developer
    6. Database
    7. API call lar
    8. Documantasyonlar. Ognegin, API swagger documani.
    9. Java Faker da fake data almak icin kullanyoruz
    NERDEN GELMEZ : end user -kullanicidan, scrum master

    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

* * IMPLICTY and EXPLICIT WAIT * *

impicitly wait : Sayfa üzerindeki tüm öğeler için zaman aşımı
explicitly wait  : belirli elementler için zaman aşımı

    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

* * COOKIES (Çerezler) * *

        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.

        Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
        daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
        kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.

    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

* * MAVEN, JUNIT, DROPDOWN

Maven : Bir projenin inşa edilebilmesi için gerekli tüm bilgileri içeren proje yönetim aracıdır.

JUnit : Java dili için yazılmış bir java kütüphanesidir. Java kodlarının beklendiği gibi çalışıp
        çalışmadığını kontrol eder ve kod kalitesini artırmamızı sağlar

DropDown : Dropdown menüler, listeden seçim yapmayı sağlamak amacıyla kullanılan bir açılır menüdür.
           Select objesi oluşturularak elde ettiğimiz methodlar ile dropdown içerisinden istediğimiz seçimi yapabiliriz.
           Bu methodlar : selectByIndex(), selectByValue() ve selectByVisibleText()'dir. Aktif olarak kullanımı
           en makul ve kullanıslı olan method ise selectByVisibleText()'dir.

    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

* * EXCEPTION * *

Interview Questions

-Tell me 5 exception that you get.-5 adet selenium da aldigin exceptions dan bahset.
-What type of exceptions do you get in selenium? - Seleniumda ki align exceptions tiplerinden bahset
-What is your solution?-Cozum ne?
-What type of waits do you use?- Hangi çesit wait kullanirsin?
-Which wait do you prefer?- Hangi wait tercih edersin?
-Why do you prefer that wait?- Neden onu tercih edersin?
-How to you resolve synronization issue?-Senkronizasyon problemini nasil cozersin?

>> NoSuchElementException

-NoSuchElementException
-Yanlis locator
-Popup, yeni pencere, iframe…
-Sayfa dolmada problemler ve yavaşlamalar
-Sakli olan elementler

Cözüm:
-Locatorin dogrulugunu tekrar kontrol et
-Manual test ile iframe, yeni pencere, alert…. gibi elementlerin varliğini kontrol et
-Bekleme problemi olabilir. İmplicit wait bekleme suresini cozmuyor. Bu durumda explicit wait ya da fluent wait kullaniriz

>> TimeOutException

-Explicit wait kullanildiginda, ve element bulunamadiginda alinir.
-Explicit wait & yanlis locator-> timeout
-Explicit wait & doğru locator & sure yeterli degil -> timeout
-Explicit wait & dogru locator & sure yeterli & iframe var ->  time out

Solution:
-Sureyi arttirmak
-Farkli explicit kullanmak: wait visibilityOfElementLocated YERINE presenceOfElementLocated.
 Yada javascript executor da ki waiter sayfa geçişlerini beklemek icin kullanabilirim
-Locatori tekrar kontrol etmek
-Frameworkunde hazir reusable method lar var Bu durumda timeoutexception aldigimda hızlıca o metotlar yardımıyla problemi cozebiliyoruz

>> NullPointerException

-Degiskenleri oluşturup instantiate etmediğimizde alırız(new kelimesini kullanmadigimizda)
-Ornegin WebDriver driver; deyip = new ChromeDriver() demezisek null pointer exception aliriz

Solution:
-Degiskeni instantiate et

>> StaleElementReferenceException

Stale Element = eski, kullanılamaz durumda, kullanım artık elverişli degil
-Sayfayi yenilediğinizde (refresh())
-Sayfada ileri geri gittimizde

COZUM:
-Elementi tekrar bulmak

>> WebDriverException

-Driver versiyonları ve browser versiyonları ayni veya yakin olmadiginda alinir
-Driver(Browser) kapattikdan sonra tekrar kullanmak istediğiniz durumlarda alınabilir.

Solution
-Framework designinin guzel kurulmuş olması gerekir, ornegin Driver sinifinda birden farza driver.quit() olmamali

Others :

InvalidSelectorException
InvalidElementStateException
ElementNotInteractableException
ElementClickInterceptedException
InvalidArgumentException
JavascriptException
RemoteDriverServerException

Seleniumda aldigin 5 exception vardır
Null pointer, no such element, time out, slale element reference, web driver

Genel olarak exception aldiginda bozum yolun nedir?
Hata mesajini oku
Genel olarak zamanlama, yanlis locator, iframe hataları olabiliyor
Hata mesajina gore exception I cozdukden sonra tekrar kodumu calistirim
Selniumda kullandigin waitler nelerdir>
Implicit yada explicit yada fluent

Hangi waiti tercih edersin?
Test Base (Driver sinifinda) implicit wait kullanıyorum.
Cogu problemi bozuyor Cozemedigi durumlarda explicit wait kullanıyorum.

Neden Explicit wait?
Explicit wait element e ouzel yazilabilir. Yerel cozum gerektiğinde explicit wait I kullanmak zorundayiz.

Senkronize(bekleme) problemlerini nasıl çözersin?
Selenium waitlerini kullanarak. Implicit wait driver im da var, ama yetmedigi durumlarda explicit wait kullanirim.
Bu yüzden ReusableMethod sinifimda tekrar tekrar kullanabileceğimiz explicit wait method lari var.
Kolaylıkla explicit wait ile bekleme problemlerini cozebuliyoruz.

    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -


 */











}
