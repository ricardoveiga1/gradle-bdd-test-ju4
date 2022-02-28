package gradle.bdd.test.ju4.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void restAssuredSetup(){

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();  // deixando verboso os erros
        RestAssured.baseURI = "http://localhost:12345";
        RestAssured.basePath = "/api";

        //trabahando apenas com json
        RestAssured.requestSpecification = new RequestSpecBuilder().
                addHeader("Authorization", getToken()).  //apenas para uso didático setAuth() do restassured
                        setContentType(ContentType.JSON).
                build();
    }

    private static String getToken(){

        return "grant acess";
    }
}
