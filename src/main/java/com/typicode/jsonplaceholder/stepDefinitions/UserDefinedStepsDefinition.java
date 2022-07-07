package com.typicode.jsonplaceholder.stepDefinitions;

import com.typicode.jsonplaceholder.qaUtils.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserDefinedStepsDefinition {
    private ConfigFileReader configReader = new ConfigFileReader();
    private RequestSpecification requestSpec = given().baseUri(configReader.property("uri"));
    private Response response;
    private String requestBody;
    private ArrayList<Response> responseMapList = new ArrayList<Response>();
    private ArrayList<HashMap<Object, Object>> requestMapList = new ArrayList<HashMap<Object, Object>>();
    private Logger log = LogManager.getLogger();



    @Given("search for the username {string} with url {string} for {string} queryParam")
    public void search_for_the_username_with_url_for_query_param(String username, String resourceUrl, String queryParamKey) {
        this.requestBody = "";
        this.response = requestSpec.contentType(ContentType.JSON).queryParam(queryParamKey, username)
                .body(this.requestBody).get(resourceUrl);
        log.info("****************************************************************************");
        log.info("***Response " + this.response.asPrettyString() + "***");
        log.info("****************************************************************************");
    }

    @Then("I verify response with status code {int}")
    public void i_verify_response_with_status_code(Integer statuCode) {
        Assert.assertTrue(this.response.getStatusCode() == statuCode, "Expected status code: " + statuCode + " Actual: " + this.response.getStatusCode());
    }

}
