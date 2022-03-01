package gradle.bdd.test.ju4.tests;

import gradle.bdd.test.ju4.support.api.PetApi;
import gradle.bdd.test.ju4.support.api.StoreApi;
import gradle.bdd.test.ju4.support.domain.Order;
import gradle.bdd.test.ju4.support.domain.Pet;
import gradle.bdd.test.ju4.support.domain.builders.OrderBuilder;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.is;

public class StoreTest extends BaseTest{

    @Nested //ANINHADo - Ajuda no encadeamento, colocando uma classe dentro da outra para se utilizar dos HOOKS melhor
    @DisplayName("Usuário cria novo pedido")
    class CreateNewOrder {

        Pet expectedPet;
        Order expectedOrder;

        PetApi petApi = new PetApi();
        StoreApi storeApi = new StoreApi();

        @BeforeEach
        void setup() {
            Pet pet = Pet.builder()
                    .id(333)
                    .status("available")
                    .build();
            expectedPet = petApi.createPet(pet); //crio um pet antes do teste

            Order order = new OrderBuilder()
                    .withId(888)
                    .withPetId(expectedPet.getId())
                    .build();

            expectedOrder = storeApi.createOrder(order); //crio um pedido
        }

        @Test
        @DisplayName("Usuário deve ser possível criar um pedido com pet disponivel")
        void userMustBeAbleToOrderAvailablePet() {
            Response actualOrderResponse = storeApi.getOrder(expectedOrder.getId());

            actualOrderResponse.
                    then().log().all().
                    body(
                            "id",is(expectedOrder.getId()),
                            "petId", is(expectedPet.getId()),
                            "quantity", is(expectedOrder.getQuantity()),
                            "status", is("approved")
                    );

        }

        @AfterEach
        void deletePetsAvailableCreated() {

            petApi.deleteExtraPets("available");
        }

    }
}
