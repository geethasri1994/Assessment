package Page_Objects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Shopping_Cart
{
    WebDriver driver;
    public Shopping_Cart(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id=\"user-name\"]")
    public static  WebElement Username;

    @FindBy(xpath="//*[@id=\"password\"]")
    public static  WebElement Password;

    @FindBy(xpath="//*[@id=\"login-button\"]")
    public static  WebElement Login_Button;

    @FindBy(xpath="//*[@id=\"remove-sauce-labs-backpack\"]")
    public static  WebElement Item1_Cart_Remove;

    @FindBy(xpath="//*[@id=\"remove-sauce-labs-bike-light\"]")
    public static  WebElement Item2_Cart_Remove;

    @FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    public static  WebElement Item1_Cart;

    @FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    public static  WebElement Item2_Cart;

    @FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a/span")
    public static  WebElement Shopping_Cart_Icon;

    @FindBy(xpath="//*[@id=\"checkout\"]")
    public static  WebElement Checkout;

    @FindBy(xpath="//*[@id=\"first-name\"]")
    public static  WebElement First_Name;

    @FindBy(xpath="//*[@id=\"last-name\"]")
    public static  WebElement Last_Name;

    @FindBy(xpath="//*[@id=\"postal-code\"]")
    public static  WebElement Postal_Code;

    @FindBy(xpath="//*[@id=\"continue\"]")
    public static  WebElement Continue;

    @FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    public static  WebElement Item1_Amount;

    @FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")
    public static  WebElement Item2_Amount;

    @FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]")
    public static  WebElement Total_Amount;

    @FindBy(xpath="//*[@id=\"finish\"]")
    public static  WebElement Finish;

    @FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
    public static  WebElement Checkout_Complete;

}
