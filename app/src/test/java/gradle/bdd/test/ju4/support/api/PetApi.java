package gradle.bdd.test.ju4.support.api;

import gradle.bdd.test.ju4.support.domain.Pet;

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


}
