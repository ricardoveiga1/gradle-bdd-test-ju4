package gradle.bdd.test.ju4.steps;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;


public class UserStepDefinitions {

    private Map<String, String> expectedUser = new HashMap<>();

    @Quando("faço um POST para {word} com os seguintes valores:")
    public void façoUmPOSTParaVUserComOsSeguintesValores(String endpoint, Map<String, String> user) {
        expectedUser = user;
        given().
            contentType(ContentType.JSON).
            body(user).
        when().
            post("http://localhost:12345/api" + endpoint).
        then().
            contentType(ContentType.JSON).
            statusCode(HttpStatus.SC_OK);
    }

    @Então("quando faço um GET para {word}, o usuário criado é retornado")
    public void quandoFaçoUmGETParaVUserRicardoVeigaOUsuárioCriadoÉRetornado(String  endpoint) {
        when().
                get("http://localhost:12345/api" + endpoint).
                then().
                contentType(ContentType.JSON).
                statusCode(HttpStatus.SC_OK).
                body("username", is(expectedUser.get("username"))); //username da tabela do cenario
    }



}
