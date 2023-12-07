import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class APIExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDE5MDk3MDQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcwMTk1MjkwNCwidXNlcklkIjoiNjA4NCJ9.e6K13869FHCrledTW6-bkdEtl-_aQGGc6orYFdiGZdk";
@Test
    public void createEmployee(){
RequestSpecification request =given().header("Content-Type","application/json").header("Authorization",token)
        .body("{\n" +
                "  \"emp_firstname\": \"Alexix\",\n" +
                "  \"emp_lastname\": \"Jovan\",\n" +
                "  \"emp_middle_name\": \"MPA\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2023-11-26\",\n" +
                "  \"emp_status\": \"Confirmed\",\n" +
                "  \"emp_job_title\": \"SBA\"\n" +
                "}");

    //send the request to the endpoint
    Response response=request.when().post("/createEmployee.php");

    //return response as a string
    String resp=response.then().extract().body().asString();
    System.out.println(resp);

    //GSON library helps to convert a string to a JSONOBject
    //string to JSON object is deserialization
    //JSON to string JSONObject is serialization

    //extract the value of the key message
    String message=response.jsonPath().getString("Message");

    //assertion that employee was created. We will use the value of the message key
    Assert.assertEquals(message,"Employee Created");


    //extract the value of the key emp_firstname
    String firstname=response.jsonPath().getString("Employee.emp_firstname");

    //assertion employee's first name
    Assert.assertEquals(firstname,"Alexix");
}



}
