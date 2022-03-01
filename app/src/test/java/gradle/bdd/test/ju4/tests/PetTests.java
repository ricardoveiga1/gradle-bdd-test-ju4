package gradle.bdd.test.ju4.tests;

import gradle.bdd.test.ju4.support.api.PetApi;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.Matchers.is;

public class PetTests extends  BaseTest{

    @Nested
    @DisplayName("Lista Pets")
    class ListPets {
        PetApi petApi = new PetApi();

        @DisplayName("Lista todos pets pelo status, mas o status sold(vendido) não está presente")
        @ParameterizedTest
        @CsvSource({
                "available, 7",
                "pending,   2",
                "sold,      0"
        })
        void listAllPetsExceptOnSoldState(String status, int quantity) {//declarando assim, já transforma o quantity em um inteiro direto
            petApi.deletePetsByStatus("sold");

            Response actualPetsResponse = petApi.getPetsResponseByStatus(status);

            actualPetsResponse.
                    then().
                    statusCode(HttpStatus.SC_OK).
                    body(
                            "size()", is(quantity),
                            "findAll { it.status == '"+status+"' }.size()", is(quantity)
                    );
        }

    }
}
