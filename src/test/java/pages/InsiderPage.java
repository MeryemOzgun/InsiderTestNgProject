package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class InsiderPage {
    public InsiderPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="(//a[@class='nav-link dropdown-toggle'])[last()]")
    public WebElement company;
    @FindBy(css="a[href='https://useinsider.com/careers/']")
    public WebElement careers;

    @FindBy(css=".col-12.col-md-6")
     public WebElement locations;

    @FindBy(linkText="See all teams")
     public WebElement teams;
     @FindBy(xpath="(//*[@class='elementor-heading-title elementor-size-default'])[5]")
     public WebElement lifeAtInsider;





}

