package gradle.bdd.test.ju4.steps;

import io.cucumber.docstring.DocString;
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
            //contentType(ContentType.JSON).
            body(user).
        when().
            post(endpoint).
        then().
            contentType(ContentType.JSON).
            statusCode(HttpStatus.SC_OK);
    }

    @Então("quando faço um GET para {word}, o usuário criado é retornado")
    public void quandoFaçoUmGETParaVUserRicardoVeigaOUsuárioCriadoÉRetornado(String  endpoint) {
        when().
                get(endpoint).
                then().
                contentType(ContentType.JSON).
                statusCode(HttpStatus.SC_OK).
                body("username", is(expectedUser.get("username"))); //username da tabela do cenario
    }


    @Quando("faço um POST para {word} com a seguinte docString:")
    public void façoUmPOSTParaVUserComASeguinteDocString(String endpoint, DocString docString) {
        expectedUser.put("username", "theUser"); // está errado, pois estamos marretando

        given().
                //contentType(ContentType.JSON).
                body(docString.getContent()). //passando conteúdo completo do json
                when().
                post(endpoint).
                then().
                contentType(ContentType.JSON).//perdeu necessidade pois foi config
                statusCode(HttpStatus.SC_OK);

    }
}
