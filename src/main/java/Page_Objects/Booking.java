package Page_Objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Booking
{

    WebDriver driver;
    public Booking(WebDriver driver)
    {
       this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@id='txt-username']")
    public static  WebElement Username;

    @FindBy(xpath="//input[@id='txt-password']")
    public static  WebElement Password;

    @FindBy(xpath="//*[@id=\"btn-login\"]")
    public static  WebElement Login;

    @FindBy(xpath="//*[@id=\"combo_facility\"]")
    public static  WebElement Facility;

    @FindBy(xpath="//*[@id=\"chk_hospotal_readmission\"]")
    public static  WebElement Readmission;

    @FindBy(xpath="//*[@id=\"radio_program_none\"]")
    public static  WebElement Program;

    @FindBy(xpath="//*[@id=\"txt_visit_date\"]")
    public static  WebElement Date;

    @FindBy(xpath="//*[@id=\"txt_comment\"]")
    public static  WebElement Comment;

    @FindBy(xpath="//*[@id=\"btn-book-appointment\"]")
    public static  WebElement Book;

    @FindBy(xpath="//*[@id=\"facility\"]")
    public static  WebElement Facility_Name;


}
