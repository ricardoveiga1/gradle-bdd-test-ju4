package gradle.bdd.test.ju4.steps;

import gradle.bdd.test.ju4.support.api.UserApi;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;


public class Config {

    private final UserApi userApi;

    public Config() {
        userApi = new UserApi();
    }

    @Before  //before do cucumber, se for do junit daria problema, pois teria que extender classes
    public void Setup(){
        System.out.println("Setup");
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();  // deixando verboso os erros
        RestAssured.baseURI = "http://localhost:12345";
        RestAssured.basePath = "/api";

        //trabahando apenas com json
        RestAssured.requestSpecification = new RequestSpecBuilder().
                addHeader("Authorization", getToken()).  //apenas para uso didático setAuth() do restassured
                setContentType(ContentType.JSON).
                build();

        //Retirado porque o delete user nao retorna JSON
//        RestAssured.responseSpecification = new ResponseSpecBuilder().
//                expectContentType(ContentType.JSON).
//                build();
    }

    private String getToken(){

        return "grant acess";
    }
//se adicionarmos mesmo order 1 na config, será executado na ordem do arquivo
//    @Before(order = 1)
//    public  void doSomething(){
//        System.out.println("hook before");
//    }
//    @Before(value = "@primeira", order = 3)
//    public  void doFirst(){
//        System.out.println("before primeiro");
//    }
//    @Before(value = "@segunda", order = 2)
//    public  void doSecond(){
//        System.out.println("before segundo");
//    }
//    @Before(value = "@terceira", order = 1)
//    public  void doThird(){
//        System.out.println("before terceiro");
//    }

    //After é decremental, inicia de tras para frente
    @After("@deleteAllUsers")
    public  void deleteAllUsers(){
        System.out.println("delete users");
        userApi.deleteAllUsers();
    }
//    @After(value = "@segunda", order = 2)
//    public  void doLast2(){
//        System.out.println("before segundo");
//    }
//    @After(value = "@terceira", order = 3)
//    public  void doLast3(){
//        System.out.println("before terceiro");
//    }
}
