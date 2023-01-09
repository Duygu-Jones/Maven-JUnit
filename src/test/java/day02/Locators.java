package day02;

public class Locators {

 /*

    Relative Xpath();

    Genelde 3 bilesen de kullanilir, Ancak bazen daha az bilesen yazmak da yeterli olabilir.

    Sadece tag name kullanarak xpath yazmak icin
    driver.findElement(By.xpath(“//input” ));

    Tag name farketmeksizin attribute ismi ve attribute value kullanarak xpath yazmak icin
    driver.findElement(By.xpath(“// * [@type=‘text’]” ));

    Attribute name farketmeksizin tag name ve attribute value kullanarak xpath yazmak icin
    driver.findElement(By.xpath(“//input[@ *=‘text’]” ));

    Attribute value farketmeksizin tag name ve attribute ismi kullanarak xpath yazmak icin
    driver.findElement(By.xpath(“//input[@type]” ));

    -   -    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

    By.cssSelector( );

    Css selector xpath'e benzer. Üç ana tip kullanılır

    1) css = tagName[attribute name= 'value’ ];
    driver.findElement(By.cssSelector("input[name='session[password]']"));

    2 ) css="tagName#idValue" veya sadece css="#idValue" => Yalnızca id value ile çalışır
    driver.findElement(By.cssSelector("input#session_password"));

    3 ) css="tagName.classValue" veya sadece css=".classValue"=> Yalnızca class value ile çalışır
    driver.findElement(By.cssSelector(".form-control"));

*/

}
