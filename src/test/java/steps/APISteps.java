package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.APIConstants;
import utils.APIPayloads;

import static io.restassured.RestAssured.given;
import static steps.tokenReader.token;

public class APISteps {
    //String token;
    RequestSpecification request;
    Response response;
    String employee_id;

 /*   @Given("a JWT is generated")
    public void a_jwt_is_generated() {
        RequestSpecification request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.CONTENT_TYPE_VALUE).
                body(APIPayloads.generateTokenPayload());

        Response response = request.when().post(APIConstants.GENERATE_TOKEN_URI);
        //storing the token after generating it
        token = "Bearer "+ response.jsonPath().getString("token");
        System.out.println(token);
    }*/

    @Given("a request is prepared to create an Employee")
    public void a_request_is_prepared_to_create_an_employee() {

        request = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY, token)
                .body(APIPayloads.createEmployeePayload());

    }
    @When("a POST call is made to the endpoint")
    public void a_post_call_is_made_to_the_endpoint() {
        response =  request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
        //to print the response in console
        response.prettyPrint();
    }
    @Then("the status code is {int}")
    public void the_status_code_is(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);

    }
    @Then("the employee id {string} is stored as a global variable")
    public void the_employee_id_is_stored_as_a_global_variable(String empId) {
        employee_id=response.jsonPath().getString(empId);
        System.out.println(employee_id);
    }
    @Then("we verify that the value for key {string} is {string}")
    public void we_verify_that_the_value_for_key_is(String key, String message) {
        String actualValue=response.jsonPath().get(key);
        Assert.assertEquals(actualValue,message);
    }

}
