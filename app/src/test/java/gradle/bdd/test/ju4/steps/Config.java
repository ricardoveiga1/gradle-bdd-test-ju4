package gradle.bdd.test.ju4.steps;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;


public class Config {

    @Before  //before do cucumber, se for do junit daria problema, pois teria que extender classes
    public void Setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();  // deixando verboso os erros
        RestAssured.baseURI = "http://localhost:12345";
        RestAssured.basePath = "/api";

        //trabahando apenas com json
        RestAssured.requestSpecification = new RequestSpecBuilder().
                addHeader("Authorization", getToken()).  //apenas para uso didático setAuth() do restassured
                setContentType(ContentType.JSON).
                build();

        RestAssured.responseSpecification = new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                build();
    }

    private String getToken(){
        return "grant acess";
    }
}
