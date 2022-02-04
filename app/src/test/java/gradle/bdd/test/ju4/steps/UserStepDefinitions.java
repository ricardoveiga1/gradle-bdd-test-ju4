package gradle.bdd.test.ju4.steps;

import gradle.bdd.test.ju4.support.api.UserApi;
import gradle.bdd.test.ju4.support.domain.User;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.MatcherAssert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserStepDefinitions {

    private static final String CREATE_USER_ENDPOINT = "/v3/user";
    private static final String USER_ENDPOINT = "/v3/user/{username}";

    private User expectedUser;
    private UserApi userApi;

    public UserStepDefinitions(){ //construtor criado para inicializar o que preciso
        userApi = new UserApi();
    }

    @Quando("crio um user")
    public void crioUmUser() {
        expectedUser = User.builder().build();
        //expectedUser = User.builder().username("Ana Maria").build();
        userApi.createUser(expectedUser);

//        given().
//                body(expectedUser).
//                when().
//                post(CREATE_USER_ENDPOINT).
//                then().
//                statusCode(HttpStatus.SC_OK);
    }

    @Então("user é salvo no sistema")
    public void userÉSalvoNoSistema() {  // retorna uma string
       String actualUserName = userApi.getUsername();
        System.out.println(actualUserName);

       assertThat(actualUserName, is(expectedUser.getUsername()));
    }


}
