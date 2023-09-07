package StepDefinitions;

import Page_Objects.Booking;
import Utils.ExcelUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import Utils.CommonUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Web
{
    WebDriver driver;
  //  Shopping_Cart Shopping_Cart;
    String url;
    public ExtentTest test;
    public ExtentReports report;
    public Booking Booking;
    ExcelUtils ExcelUtils;
    CommonUtil CommonUtil;
    String [][] Excel_Values;
    public String Username1;
     public String Username2;

    @Given("^Launch Edge Browser$")
    public void Launch() throws InterruptedException, IOException
    {
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
         driver = new EdgeDriver();
           driver.manage().window().maximize();
       //  Shopping_Cart=new Shopping_Cart(driver);
         CommonUtil=new CommonUtil(driver);
         ExcelUtils = new ExcelUtils();
        String timestamp = new SimpleDateFormat("YYY.MM.dd.hh.mm.ss").format(new Date());
        report = new ExtentReports("Reports/Assessment1_" + timestamp + ".html", false);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Excel_Values = ExcelUtils.readExcelDataFileToArray("src/test/resources/TestData/Assessment2.xlsx", "Sheet1");

        driver.navigate().to("https://www.way2automation.com/angularjs-protractor/webtables/");
        Thread.sleep(3000);
        test=report.startTest("Assessment_1");
        test.log(LogStatus.PASS,"List of All Users",test.addBase64ScreenShot(CommonUtil.captureScreenshot("TestCase1")));
    }

    @Then("^click Add User$")
    public void Add_User() throws InterruptedException {
        //Thread.sleep(2000);
        //driver.findElement(Booking.Add_USer);
        //l.sendKeys("abc@gmail.com");
        Booking=new Booking(driver);
        Booking.Add_USer.click();

    }
    @Then("^Add Users with details$")
    public void Add_Products() throws InterruptedException, IOException {
        // Adding User1
        Page_Objects.Booking.FirstName.sendKeys(Excel_Values[1][0]);
        Page_Objects.Booking.LastNAme.sendKeys(Excel_Values[1][1]);
        Username1 = RandomStringUtils.randomAlphabetic(8);
        Page_Objects.Booking.UserName.sendKeys(Username1);
        System.out.println("Username1:"+Username1);
        Page_Objects.Booking.Password.sendKeys(Excel_Values[1][2]);
        Page_Objects.Booking.Radio.click();
        Select Role = new Select( Page_Objects.Booking.Role);
        Role.selectByVisibleText(Excel_Values[1][3]);
        Page_Objects.Booking.Email.sendKeys(Excel_Values[1][4]);
        Page_Objects.Booking.Mobilephone.sendKeys(Excel_Values[1][5]);
        //test2=report.startTest("Assessment_1");
        test.log(LogStatus.PASS,"1st User Details",test.addBase64ScreenShot(CommonUtil.captureScreenshot("TestCase1")));
        Page_Objects.Booking.Save.click();

        // Adding User2
        Booking.Add_USer.click();
        Page_Objects.Booking.FirstName.clear();
        Page_Objects.Booking.FirstName.sendKeys(Excel_Values[2][0]);
        Page_Objects.Booking.LastNAme.clear();
        Page_Objects.Booking.LastNAme.sendKeys(Excel_Values[2][1]);
         Username2 = RandomStringUtils.randomAlphabetic(8);
        Page_Objects.Booking.UserName.sendKeys(Username2);
        System.out.println("Username2:"+Username2);
        Page_Objects.Booking.Password.clear();
        Page_Objects.Booking.Password.sendKeys(Excel_Values[2][2]);
        Page_Objects.Booking.Radio2.click();
         Role = new Select( Page_Objects.Booking.Role);
        Role.selectByVisibleText(Excel_Values[2][3]);
        Page_Objects.Booking.Email.clear();
        Page_Objects.Booking.Email.sendKeys(Excel_Values[2][4]);
        Page_Objects.Booking.Mobilephone.clear();
        Page_Objects.Booking.Mobilephone.sendKeys(Excel_Values[2][5]);
        test.log(LogStatus.PASS,"2nd User Details",test.addBase64ScreenShot(CommonUtil.captureScreenshot("TestCase1")));
        Page_Objects.Booking.Save.click();

    }

    @Then("^Verify whether users are added to the list$")
    public void Amount_Confirmation() throws InterruptedException, IOException {
        //Comparing values between webtable and excel values for 1st user
        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]")).getText(), Excel_Values[2][0]);
        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[2]")).getText(), Excel_Values[2][1]);
        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[6]")).getText(), Excel_Values[2][3]);
        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[7]")).getText(), Excel_Values[2][4]);
        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[8]")).getText(), Excel_Values[2][5]);


        //Comparing values between webtable and excel values for 2nd user
        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[1]")).getText(), Excel_Values[1][0]);
        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]")).getText(), Excel_Values[1][1]);
        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[6]")).getText(), Excel_Values[1][3]);
        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[7]")).getText(), Excel_Values[1][4]);
        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[8]")).getText(), Excel_Values[1][5]);
        test.log(LogStatus.PASS,"Updated User List",test.addBase64ScreenShot(CommonUtil.captureScreenshot("TestCase1")));
        report.endTest(test);
        report.flush();
    }

}
