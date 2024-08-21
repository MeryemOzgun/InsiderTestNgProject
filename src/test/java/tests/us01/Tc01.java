package tests.us01;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.InsiderPage;
import utilities.*;

@Listeners(TestListener.class)
public class Tc01 extends ExtentReport {
    SoftAssert softAssert=new SoftAssert();
    InsiderPage page=new InsiderPage();
    @Test
    public void test01() {
        extentTest =extentReports.createTest("TC01","InsiderVisit");
        // kullanici siteye gider
        Driver.getDriver().get(ConfigReader.getProperty("insiderUrl"));
        extentTest.info("SITEYE GIDILDI");
        // anasayfanin acildigini dogrular
        String expectedUrl = ConfigReader.getProperty("insiderUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "Anasayfaya gidilmedi!");
        extentTest.info("ANASAYFANIN ACILDIGI DOGRULANDI");
        // "Company" ddm menüsüne tikla
        page.company.click();
        extentTest.info("COMPANY SECIMINE TIKLANDI");
        // "Careers" secenegine tikla
        page.careers.click();
        extentTest.info("CAREERS SECIMINE TIKLANDI");
        // "Careers" sayfasının açılıp açılmadığını dogrula
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("careers"));
        extentTest.info("CAREERS SECENEGININ ACILDIGI DOGRULANDI");
        // "Teams" blogunun acildigini dogrula
        ReusableMethods.scroll(page.teams);
        softAssert.assertTrue(page.teams.isDisplayed(),"Teams blogu görülmedi");
        extentTest.info("TEAMS BLOGUNUN ACILDIGI DOGRULANDI");
        ReusableMethods.bekle(2);
        // "Locations" blogunun acildigini dogrula
        ReusableMethods.scroll(page.locations);
        softAssert.assertTrue(page.locations.isDisplayed(),"Locations blogu görülmedi");
        extentTest.info("LOCATİONS BLOGUNUN ACILDIGI DOGRULANDI");
        ReusableMethods.bekle(2);
        // "Life at Insider"  blogunun acildigini dogrula
        ReusableMethods.scroll(page.lifeAtInsider);
        softAssert.assertTrue(page.lifeAtInsider.isDisplayed(),"Life at Insider blogu görülmedi");
        extentTest.info("LIFE AT INSIDER BLOGUNUN ACILDIGI DOGRULANDI");
        softAssert.assertAll();


    }
}
