package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CareersQualityAssurancePage {
    public CareersQualityAssurancePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css=".btn.btn-outline-secondary.rounded.text-medium.mt-2.py-3.px-lg-5.w-100.w-md-50")
    public WebElement seeAllQaJobs;
    @FindBy(css="#wt-cli-reject-btn")
    public WebElement cerez;
 @FindBy(css= "[id='filter-by-location']")
    public WebElement locationFilter;



     @FindBy(css = ".job-team.qualityassurance")
    public WebElement departmentFilter;

 @FindBy(css= ".currentResult")
    public WebElement ilanlar;


@FindBy(css = "[class=\"btn btn-navy rounded pt-2 pr-5 pb-2 pl-5\"]")
    public WebElement viewRoleButon;

@FindBy(css = ".postings-btn.template-btn-submit.shamrock")
    public WebElement applyForThisJob;


@FindBy(xpath = "//h4[text()='Submit your application']")
    public WebElement basvuruFormu;






}
