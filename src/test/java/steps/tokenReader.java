package steps;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIPayloads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class tokenReader {
public static String token;
    @Given("a JWT is generated")
    public void a_jwt_is_generated() throws IOException {
            //checking if the previous token is still valid or not
        if(!isTokenValid()){
            //generate token
            RequestSpecification request = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.CONTENT_TYPE_VALUE)
                    .body(APIPayloads.generateTokenPayload());
            Response response = request.when().post(APIConstants.GENERATE_TOKEN_URI);
            String rawToken=response.jsonPath().getString("token");
            token="Bearer" +rawToken;
            //get expiration time
            LocalDateTime expirationTime=getTheExpirationTime(rawToken);
            //write the token and expiration time to file
            saveTokenToFile(token,expirationTime);

        }
        else{

        token=readTokenFromFile();

        }
    }

    //return true if token is valid
    //false if token is expired
    public static boolean isTokenValid() throws IOException {
        //read the file and save it in "content"
        String content=new String(Files.readAllBytes((Paths.get("token.txt"))));

        //the file is empty
        if(content.isEmpty()){
            return false;
        }
        //splitting the string content into an array of strings using the newline character (\n) as the delimiter
        String[] parts=content.split("\n");

        //using the LocalDateTime.parse method in Java to parse a string representation of a date and time,
        // which is stored in the parts[1] array element.
        //get the time out of the string array
        LocalDateTime expirationTime= LocalDateTime.parse(parts[1]);

        //compare the time now and expiration time
        LocalDateTime currentDateTime=LocalDateTime.now();

        //return true if local time is before expirationTime, else return false
        return currentDateTime.isBefore(expirationTime);
    }


    //decode a JWT token, retrieve its expiration date, and convert it to a LocalDateTime object
    public static LocalDateTime getTheExpirationTime(String token){
        //decode the jwt token
        DecodedJWT jwt=JWT.decode(token);
        //retrieve the expiration of the token
        Date exp=jwt.getExpiresAt();
        return exp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public void saveTokenToFile(String token, LocalDateTime exptime) throws IOException {
        String content=token +"\n"+exptime;
        //writing the string content in the file token.txt
        //after converting it in the form of bytes (content.getBytes)
        Files.write(Paths.get("token.txt"),content.getBytes());

    }

    public static String readTokenFromFile() throws IOException {
      String content=new String(Files.readAllBytes(Paths.get("token.txt")));
      //extract the token from the content
        return content.split("\n")[0];
    }
}
