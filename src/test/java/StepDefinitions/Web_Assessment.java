package StepDefinitions;

import Page_Objects.Login;
import Utils.CommonUtil;
import Utils.ExcelUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Web_Assessment
{
    WebDriver driver;
  //  Shopping_Cart Shopping_Cart;
    String url;
    public ExtentTest test;
    public ExtentReports report;
    public Login Login;
    ExcelUtils ExcelUtils;
    CommonUtil CommonUtil;
    String [][] Excel_Values;
    public String Username1;
     public String Username2;

    @Given("^Launch Edge Browser for Assessment$")
    public void Launch() throws InterruptedException, IOException
    {
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
         driver = new EdgeDriver();
           driver.manage().window().maximize();
       //  Shopping_Cart=new Shopping_Cart(driver);
         CommonUtil=new CommonUtil(driver);
         ExcelUtils = new ExcelUtils();
         Login=new Login(driver);
        String timestamp = new SimpleDateFormat("YYY.MM.dd.hh.mm.ss").format(new Date());
        report = new ExtentReports("screenshots/Assessment1_" + timestamp + ".html", false);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Excel_Values = ExcelUtils.readExcelDataFileToArray("src/test/resources/TestData/Assessment2.xlsx", "Sheet1");

        driver.navigate().to("https://etalente.co.za/");

        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        test=report.startTest("Assessment_1");
        test.log(LogStatus.PASS,"Home Page",test.addBase64ScreenShot(CommonUtil.addScreenshots()));

        Page_Objects.Login.Login.click();
        Thread.sleep(2000);
        Page_Objects.Login.Username.sendKeys("Test_Assessment");
        Page_Objects.Login.Password.sendKeys("Test_Password");
        Page_Objects.Login.Login_Button.click();
        Thread.sleep(2000);
        test.log(LogStatus.PASS,"Login Failed",test.addBase64ScreenShot(CommonUtil.addScreenshots()));
        report.endTest(test);
         report.flush();
    }
}
