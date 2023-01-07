package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    // Masaüstünde bir dosyanın varlığını test et
    
    @Test
    public void isExistTest() {

//        WebElement uploadFile = driver.findElement(By.xpath("//input[@name='upload_file']"));
//        uploadFile.sendKeys("C:\\Users\\bacan\\OneDrive\\Masaüstü\\SeleniumLMS.pdf");
        
        String userDIR = System.getProperty("user.dir");
        System.out.println("userDIR = " + userDIR);
        
        String userHome = System.getProperty("user.home");
        System.out.println("userHome = " + userHome);

        //Logo masaüstünde : C:\Users\bacan

        String dosyaYolu = userHome+"\\OneDrive\\Masaüstü\\logo.jpeg";
        System.out.println("dosyaYolu = " + dosyaYolu);

        boolean isExist = Files.exists(Paths.get(dosyaYolu));//Dosya varsa T yoksa F return eder
        Assert.assertTrue(isExist);

    }
}
