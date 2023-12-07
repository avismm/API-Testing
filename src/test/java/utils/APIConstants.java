package utils;

import io.restassured.RestAssured;

public class APIConstants {
    public static final String BaseURI = RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    public static final String GENERATE_TOKEN_URI = BaseURI +"/generateToken.php";
    public static final String CREATE_EMPLOYEE_URI = BaseURI +"/createEmployee.php";
    public static final String GET_ONE_EMPLOYEE_URI = BaseURI +"/getOneEmployee.php";
    public static final String UPDATE_EMPLOYEE_URI = BaseURI +"/updateEmployee.php";
    public static final String GET_ALL_JOB_TITLES = BaseURI +"/jobTitle.php";
    public static final String GET_ALL_EMPLOYEE_URI = BaseURI +"/getAllEmployee.php";
    public static final String PARTIALLY_UPDATE_EMPLOYEE_URI = BaseURI +"/updatePartialEmployeesDetails.php";
    public static final String HEADER_CONTENT_TYPE_KEY ="Content-Type";
    public static final String CONTENT_TYPE_VALUE ="application/json";
    public static final String HEADER_AUTHORIZATION_KEY = "Authorization";
}
