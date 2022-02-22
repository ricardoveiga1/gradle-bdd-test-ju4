package gradle.bdd.test.ju4.support.api;

import gradle.bdd.test.ju4.support.domain.Pet;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PetApi {

    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "v3/pet/findByStatus?status={status}";
    private static final String PET_ENDPOINT = "v3/pet/{id}";

    public List<Pet> getPetsByStatus(String status) {
        return given().
                pathParam("status", status). //status da url
        when().
                get(FIND_PETS_BY_STATUS_ENDPOINT).
        then().
                extract().body().jsonPath().getList("", Pet.class); //por ser uma lista, preciso extrair o caminho do json, e está na RAIZ, por isso o path é "", se não teria q passar path correto
    }

    //Menos legível, porém tem mais flexibilidade do JAVA
    public List<Pet> getPetByStatus2(String status){
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.pathParam("status", status);
        Response response = httpRequest.get(FIND_PETS_BY_STATUS_ENDPOINT);
        JsonPath jsonPath = response.body().jsonPath();
        return jsonPath.getList("", Pet.class);
        //return  response.body().jsonPath().getList("", Pet.class);
    }

    //Get em todos pets available
    public Response getPetsResponseByStatus(String status){
        return given().
           pathParam("status", status). //status da url
        when().
           get(FIND_PETS_BY_STATUS_ENDPOINT);
    }


}
