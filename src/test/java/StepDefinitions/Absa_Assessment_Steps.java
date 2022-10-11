package StepDefinitions;

import Page_Objects.Shopping_Cart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import Page_Objects.Shopping_Cart;
import org.openqa.selenium.support.ui.Select;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLongHexNumber;

import java.util.concurrent.TimeUnit;

public class Absa_Assessment_Steps
{
    WebDriver driver;
    Shopping_Cart Shopping_Cart;
    String url;

    @Given("^Launch chrome and navigate to shopping cart Website$")
    public void Launch() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        Shopping_Cart=new Shopping_Cart(driver);

      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Navigate to Shopping Cart Website
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Then("^Add 2 products to shopping cart$")
    public void navigate() throws InterruptedException
    {
        Page_Objects.Shopping_Cart.Username.sendKeys("standard_user");
        Page_Objects.Shopping_Cart.Password.sendKeys("secret_sauce");
        Page_Objects.Shopping_Cart.Login_Button.click();
        Thread.sleep(2000);

        //Adding Item cart 1
        try
        {
            if (Page_Objects.Shopping_Cart.Item1_Cart_Remove.isDisplayed())
            {
                Page_Objects.Shopping_Cart.Item1_Cart_Remove.click();
            }
        }
        catch(Exception e)
        {
        System.out.println("Exception: "+e);
        }

            Page_Objects.Shopping_Cart.Item1_Cart.click();

        //Adding Item cart 2
        try
        {
            if (Page_Objects.Shopping_Cart.Item2_Cart_Remove.isDisplayed())
            {
                Page_Objects.Shopping_Cart.Item2_Cart_Remove.click();
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
        }

        Page_Objects.Shopping_Cart.Item2_Cart.click();
    }

    @Then("^Add Information for first name,last name, postal code$")
    public void Add_Products() throws InterruptedException
    {
        Page_Objects.Shopping_Cart.Shopping_Cart_Icon.click();
        Page_Objects.Shopping_Cart.Checkout.click();
        Thread.sleep(2000);
        Page_Objects.Shopping_Cart.First_Name.sendKeys("Shravani");
        Page_Objects.Shopping_Cart.Last_Name.sendKeys("Absa");
        Page_Objects.Shopping_Cart.Postal_Code.sendKeys("1686");
        Page_Objects.Shopping_Cart.Continue.click();
    }

    @Then("^confirm that the total price is correct which is the sum of the two products$")
    public void Amount_Confirmation() throws InterruptedException
    {
        String Item1_Amount = Page_Objects.Shopping_Cart.Item1_Amount.getText();
        Item1_Amount = Item1_Amount.substring(1);
        //  System.out.println("Item 1 Amount: "+Item1_Amount);
        String Item2_Amount = Page_Objects.Shopping_Cart.Item2_Amount.getText();
        Item2_Amount = Item2_Amount.substring(1);
        //  System.out.println("Item 2 Amount: "+Item2_Amount);
        float b = Float.parseFloat(Item1_Amount);
        float c = Float.parseFloat(Item2_Amount);
        float Expected_Total_Amount = b + c;
        // System.out.println("Item1_Price: "+b);
        System.out.println("Expected Total_Amount: " + Expected_Total_Amount);
        String Total_Amount = Page_Objects.Shopping_Cart.Total_Amount.getText();
        String Actual_Total_Amount = Total_Amount.substring(13);
        System.out.println("Actual Total Amount: " + Actual_Total_Amount);
        float Act_Total_Amount = Float.parseFloat(Actual_Total_Amount);

        //confirm that the total price is correct which is the sum of the two products
        Assert.assertEquals(Expected_Total_Amount, Act_Total_Amount, 0);
    }
        @Then("^Finish the order and Confirm that the order confirmation screen is displayed$")
        public void Order_Confirmation() throws InterruptedException
        {
            Page_Objects.Shopping_Cart.Finish.click();
            Thread.sleep(2000);
            String Order_Confirmation=Page_Objects.Shopping_Cart.Checkout_Complete.getText();
            System.out.println("Order_Confirmation: " +Order_Confirmation);
            Assert.assertEquals(Order_Confirmation, "CHECKOUT: COMPLETE!");
        }
}
