package day15;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReports2 {

    //    HATIRLAMAMIZ GEREKEN 3 CLASS
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;



    @BeforeClass
    public static void extendReportsSetUp() {


//      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";
//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();

//       ******************* RAPORU CUSTOMIZE EDEBILIRIZ ***********************

        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechPro Education");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Takim","Eagles");
        extentReports.setSystemInfo("Epic","Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint Numarasi","Sprint-145");
        extentReports.setSystemInfo("QA","Ahmet");

//        ********************** EXTRA RAPOR ISMI VE DOCUMAN ISMI EKLEYEBILIRIZ *******************

        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Reports");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");

//        *************************** RAPOR AYARLARI BITTI ****************************

//        Raporu projeme ekliyorum
        extentReports.attachReporter(extentHtmlReporter);
        extentTest = extentReports.createTest("Extent Report Login Test", "Smoke Test Report");

    }

    @Test
    public void extentReportsTest() {

        extentTest.pass("PASS");
        extentTest.info("Bilgilendirme Notu");
        extentTest.fail("FAILED");
        extentTest.warning("Uyarı Mesajı");
        extentTest.skip("Atlama Mesajı");
        extentTest.fatal("Sistem Çöküş Hatası");
    }

    @AfterClass
    public static void afterClass()  {
        extentReports.flush();

    }
}
