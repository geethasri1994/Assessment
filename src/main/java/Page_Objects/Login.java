package Page_Objects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login
{

    WebDriver driver;
    public Login(WebDriver driver)
    {
       this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id=\"ui-id-5\"]/span[2]")
    public static WebElement Men;

    @FindBy(xpath="//*[@id=\"maincontent\"]/div[4]/div[2]/div[2]/div/ul[1]/li[2]/a")
    public static WebElement Jacket;

    @FindBy(xpath="//*[@id=\"search\"]")
    public static WebElement Search;

    @FindBy(xpath="/html/body/div[2]/main/div[3]/div[1]/div[2]/div[2]/ol/li[2]/div/div/div[3]/div[1]/div/div[3]")
    public static WebElement Size_M;

    @FindBy(xpath="/html/body/div[2]/main/div[3]/div[1]/div[2]/div[2]/ol/li[2]/div/div/div[3]/div[2]/div/div[3]")
    public static WebElement Color_Red;

    @FindBy(xpath="//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[2]/div/div/div[4]/div/div[1]/form/button/span")
    public static WebElement Add_To_Cart;

    @FindBy(xpath="//input[@name='LastName']")
    public static WebElement LastNAme;



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

    @FindBy(xpath="/html/body/app-root/app-home/div/div[1]/div/div[1]/div[2]/a[2]/span[1]")
    public static WebElement Login;

    @FindBy(xpath="//*[@id=\"mat-input-2\"]")
    public static WebElement Username;

    @FindBy(xpath="//*[@id=\"mat-input-3\"]")
    public static WebElement Password;

    @FindBy(xpath="//*[@id=\"mat-dialog-0\"]/app-login-dialog/mat-dialog-content/div[1]/div/form/div[2]/div[1]/button")
    public static WebElement Login_Button;

}
