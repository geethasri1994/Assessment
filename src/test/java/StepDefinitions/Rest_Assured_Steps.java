package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;
import java.util.List;
import java.util.Map;

import io.restassured.response.ResponseBody;
import org.junit.Assert;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Rest_Assured_Steps
{
    @Given("^Retreive List of all dog breeds$")
    public void Retrieve_List_of_all_Dog_Breeds()
    {
        //Retreive List of all dog breeds
        RestAssured.baseURI = "https://dog.ceo/api/breeds/list";
        Response Response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/all")
                .then()
                .extract().response();

        ResponseBody body = Response.getBody();
        System.out.println("Response: "+ body.asString());
        Assertions.assertEquals(200, Response.statusCode());

    }
    @Then("^Verify whether Retreiver breed is within the list$")
    public void Retriever_breed_is_within_the_list()
    {
        RestAssured.baseURI = "https://dog.ceo/api/breeds/list";
        Response Response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/all")
                .then()
                .extract().response();

        ResponseBody body = Response.getBody();
        Assertions.assertEquals(true, body.asString().contains("retriever"));
    }
    @Then("^Retreive list of sub breeds for Retreiver$")
    public void Retrive_list_of_sub_breeds_for_retreiver()
    {
        RestAssured.baseURI = "https://dog.ceo/api/breed/retriever";
        Response Response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/list")
                .then()
                .extract().response();

        ResponseBody body = Response.getBody();
        System.out.println("Retriever List: "+ body.asString());
        Assertions.assertEquals(200, Response.statusCode());
    }

    @Then("^Retrieve random image/link for sub-breed “golden”$")
    public void Retrive_Random_image()
    {
        RestAssured.baseURI = "https://dog.ceo/api/breed/retriever/golden/images";
        Response Response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/random")
                .then()
                .extract().response();

        ResponseBody body = Response.getBody();
        System.out.println("Retriever Golden Sub Breed List Image: "+ body.asString());
        Assertions.assertEquals(200, Response.statusCode());
    }
}
