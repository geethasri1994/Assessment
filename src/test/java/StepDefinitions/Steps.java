package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import Page_Objects.Booking;
import org.openqa.selenium.support.ui.Select;
import static Page_Objects.Booking.*;

public class Steps
{
    WebDriver driver;
    Booking Booking;
    String url;

    @Given("^Launch chrome$")
    public void Launch()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        Booking=new Booking(driver);
    }

    @And("^navigate to Booking Website$")
    public void navigate()
    {

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/profile.php#login");

    }

    @Then("^Login with correct credentials$")
    public void Login() throws InterruptedException
    {
        Username.sendKeys("John Doe");
        Password.sendKeys("ThisIsNotAPassword");
        Login.click();
        Thread.sleep(2000);

    }

    @Then("^fill in with mandatory details$")
    public void Details()
    {
      Select Facility=new Select(Page_Objects.Booking.Facility);
      Facility.selectByVisibleText("Hongkong CURA Healthcare Center");
      Readmission.click();
      Program.click();
      Date.sendKeys("17/05/2022"+ Keys.RETURN);

    }

    @Then("^book appointment$")
    public void Book() throws InterruptedException
    {
      Comment.sendKeys("Testing");
      Book.click();
      Thread.sleep(2000);
    }

    @Then("^return facility name$")
    public void Facility()
    {
       String Facility_Name= Page_Objects.Booking.Facility_Name.getText();
       System.out.println("Facility Name:"+Facility_Name);
    }

}