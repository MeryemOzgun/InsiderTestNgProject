package tests.us01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CareersQualityAssurancePage;
import pages.InsiderPage;
import utilities.*;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.ResourceBundle;



@Listeners(TestListener.class)
public class Tc02 extends ExtentReport {

   CareersQualityAssurancePage page = new CareersQualityAssurancePage();

   @Test
   public void test01() {
      extentTest = extentReports.createTest("TC02","CareersQualityAssurance");

      //kullanici url e gider
      Driver.getDriver().get(ConfigReader.getProperty("CareersQualityAsuranceUrl"));
      extentTest.info("SITEYE GIDILDI");

      // "See all QA jobs" (Tüm QA işlerini gör) butonuna tıklar
      page.cerez.click();
      page.seeAllQaJobs.click();
      ReusableMethods.bekle(3);
      extentTest.info("SEE ALL QA JOBS BUTNUNA TIKLANDI");


      // Açılan sayfada "Location" (Lokasyon) olarak "Istanbul, Turkey" secimini yapar
      Select select = new Select (Driver.getDriver().findElement(By.cssSelector("[id='filter-by-location']")));
       WebElement optionTagı = Driver.getDriver().findElement(By.xpath("//select[@id='filter-by-location']/option"));
       WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));
       wait.until(ExpectedConditions.visibilityOf(optionTagı));
      select.selectByVisibleText("Istanbul, Turkey");
      extentTest.info("LOKASYON OLARAK 'ISTANBUL TURKEY'SECIMI YAPILDI");


      //"Department" (Departman) olarak "Quality Assurance" secili oldugunu dogrula
       ReusableMethods.bekle(2);
      Assert.assertTrue(page.departmentFilter.isSelected());
      extentTest.info("DEPARTMAN OLARAK QUALİTY ASSURANCE SECILI OLDUGU DOGDULANDI");


       // Filtreleme işlemi sonrasında iş ilanlarının listelenip listelenmediğini kontrol eder
     ReusableMethods.bekle(3);
       ReusableMethods.scroll(page.ilanlar);
      Assert.assertTrue(page.ilanlar.isDisplayed());
     extentTest.info("IS ILANLARININ LISTELENDIGI DOGRULANDI");


       // Tüm iş ilanlarının "Position" (Pozisyon) kısmında "Quality Assurance" ifadesi geçtiğini dogrular
       List<WebElement>positionElements = Driver.getDriver().findElements(By.cssSelector("[class='position-title font-weight-bold']"));
       ReusableMethods.bekle(2);
       for (WebElement positionElement : positionElements) {
           String positionText = positionElement.getText();
          Assert.assertTrue(positionText.contains("Quality Assurance"));
       extentTest.info("POZISYONLARIN 'QUALITY ASSURANCE' ICERDIGI DOGRULANDI");

      // "Department" (Departman) kısmında "Quality Assurance" ibaresinin yer aldığını doğrular
      List<WebElement> depertmanElements = Driver.getDriver().findElements(By.cssSelector(".position-department.text-large.font-weight-600.text-primary"));
      for (WebElement w : depertmanElements) {
         if (w.getText().contains("Quality Assurance")) {
         System.out.println("departmanlar 'Quality Assurance' iceriyor :" + w.getText());
         } else {
         System.out.println("tüm departmanlar 'Quality Assurance' icermiyor :" + w.getText());
         }}
       extentTest.info("DEPARTMANLARIN 'QUALITY ASSURANCE' ICERDIGI DOGRULANDI");


      //"Location" (Lokasyon) kısmında "Istanbul, Turkey" yazdığını dogrular
      List <WebElement> locationElements = Driver.getDriver().findElements(By.cssSelector(".position-location.text-large"));
      for (WebElement w : locationElements) {

         if (w.getText().contains("Istanbul, Turkey")) {
         System.out.println("lokasyonlar 'Istanbul, Turkey' iceriyor: " + w.getText());
         }else {
         System.out.println("tüm departmanlar 'Istanbul, Turkey' icermiyor: " + w.getText());
         }}
       extentTest.info("LOKASYONLARIN 'ISTANBUL TURKEY' ICERDIGI DOGRULANDI");



       // "View Role" (Pozisyonu Gör) butonuna tıklar
       JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
       js.executeScript("window.scrollBy(0, -200);"); // Sayfayı 500 piksel yukarı kaydırma (eksi değer yukarı kaydırır)
       Actions actions = new Actions(Driver.getDriver());


       // Hedef elementin üzerine gelmeden önceki ve tıklanacak olan elementi locate et
       WebElement uzerineGelinecekElement = Driver.getDriver().findElement(By.cssSelector("[class='position-list-item-wrapper bg-light']"));
       WebElement tiklanacakElement = page.viewRoleButon;
       actions.moveToElement(uzerineGelinecekElement).perform();
       tiklanacakElement.click();
       extentTest.info("'VIEW ROLE'BUTONUNA TIKLANDI");

       // Lever başvuru formu sayfasına yönlendirdiğini dogrular(yeni sekmede acılır)
       ReusableMethods.switchToWindow(1);
       Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("lever"));
       extentTest.info("LEVER SAYFASINA YONLENDIRILDIGI DOGRULANDI");

       // "Apply for this job" butonuna tıklar
       page.applyForThisJob.click();
       extentTest.info("'APPLY FOR THIS JOB'BUTONUNA TIKLANDI");

       // basvuru formunun ciktigini dogrular
       Assert.assertTrue(page.basvuruFormu.isDisplayed());
       extentTest.info("BASVURU FORMUNUN CIKTIGI DOGRULANDI");


   }
   }
}
