package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.lang.module.Configuration;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

public class Rest_Assured_Steps
{
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
//    private static String token;
//    private static Response response;
//    private static String jsonString;
//    private static String bookId;


    @Given("^Retrieve the price of GBP Rate$")
    public void Retrieve()
    {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        Response response = request.get();
       // System.out.println("Response: " + response);
       // Configuration conf = Configuration.defaultConfiguration();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String Street = jsonPathEvaluator.get("address[2].geo.lat");
        System.out.println("Street: " + Street);

    }
}
