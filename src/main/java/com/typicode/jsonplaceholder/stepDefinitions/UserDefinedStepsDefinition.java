package com.typicode.jsonplaceholder.stepDefinitions;

import com.typicode.jsonplaceholder.qaUtils.ConfigFileReader;
import com.typicode.jsonplaceholder.qaUtils.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static io.restassured.RestAssured.given;

public class UserDefinedStepsDefinition {
    private ConfigFileReader configReader = new ConfigFileReader();
    private RequestSpecification requestSpec = given().baseUri(configReader.property("uri"));
    private Response response;
    private String requestBody;
    private ArrayList<Object> list = new ArrayList();
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

    @Then("I verify in response {string} with jpath {string}")
    public void i_verify_in_response_with_jpath(String expValue, String jpathExp) {
        JsonPath jPath = new JsonPath(this.response.asPrettyString());
        list = jPath.get(jpathExp);
        String stringActualValue = list.toString();
        log.info("****************************************************************************");
        log.info("************* Actual extracted value from JPath " + list + "  *************");
        log.info("****************************************************************************");
        Assert.assertTrue(stringActualValue.contains(expValue), "This is a failure");
    }

    @Given("search for the username {string} with url {string} for {string} queryParams")
    public void search_for_the_username_with_url_for_query_params(String string, String resourceUrl, String queryParamKey) {
//        Utils.createMap("", "");

        this.response = requestSpec.contentType(ContentType.JSON).queryParams(queryParamKey, list)
                .body(this.requestBody).get(resourceUrl);
        log.info("****************************************************************************");
        log.info("***Response " + this.response.asPrettyString() + "***");
        log.info("****************************************************************************");
    }

    @Then("I verify the email format with regular exp {string}")
    public void i_verify_the_email_format_with_regular_exp(String regEx) {
        list.add("user@domaincom");
        list.add("user#domain.com");
        for (Object obj : list) {
            log.info("****************************************************************************");
            log.info("******* is " + obj.toString() + " a valid email? == " + Utils.validEmail(regEx, obj.toString()));
            log.info("****************************************************************************");
            Assert.assertTrue(Utils.validEmail(regEx, obj.toString()), " This is not a valid email");
        }
    }

}


