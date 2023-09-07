package Page_Objects;

import org.openqa.selenium.*;
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

    @FindBy(xpath="//button[@type='add']")
    public static WebElement Add_USer;

    @FindBy(xpath="//input[@name='FirstName']")
    public static WebElement FirstName;

    @FindBy(xpath="//input[@name='LastName']")
    public static WebElement LastNAme;

    @FindBy(xpath="//input[@name='UserName']")
    public static WebElement UserName;

    @FindBy(xpath="//input[@name='Password']")
    public static WebElement Password;

    @FindBy(xpath="//input[@name='optionsRadios']")
    public static WebElement Radio;

    @FindBy(xpath="/html/body/div[2]/div[2]/form/table/tbody/tr[5]/td[2]/label[2]/input")
    public static WebElement Radio2;

    @FindBy(xpath="//select[@name='RoleId']")
    public static WebElement Role;

    @FindBy(xpath="//input[@name='Email']")
    public static WebElement Email;

    @FindBy(xpath="//input[@name='Mobilephone']")
    public static WebElement Mobilephone;

    @FindBy(xpath="//button[text()='Save']")
    public static WebElement Save;

}
