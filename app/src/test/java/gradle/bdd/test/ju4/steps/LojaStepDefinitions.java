package gradle.bdd.test.ju4.steps;

import gradle.bdd.test.ju4.support.api.PetApi;
import gradle.bdd.test.ju4.support.api.StoreApi;
import gradle.bdd.test.ju4.support.domain.Order;
import gradle.bdd.test.ju4.support.domain.Pet;
import gradle.bdd.test.ju4.support.domain.builders.OrderBuilder;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.is;

public class LojaStepDefinitions {

    PetApi petApi;
    StoreApi storeApi;

    Pet expectedPet;
    Order expectedOrder;

    public LojaStepDefinitions(){//necessita instanciar no construtor para podermos usar os métodos

        petApi = new PetApi();
        storeApi = new StoreApi();
    }

    @Dado("que eu possua animal {word}")
    public void queEuPossuaAnimalAvailable(String status) {
        Pet pet = Pet.builder()
                .id(333)
                .status(status)
                .build();

        expectedPet = petApi.createPet(pet);
    }

    @Quando("faço o pedido desse animal")
    public void façoOPedidoDesseAnimal() {
        Order order = new OrderBuilder()
                .withId(888)
                .withPetId(expectedPet.getId())
                .build();

        expectedOrder = storeApi.createOrder(order);

    }

    @Então("o pedido é aprovado")
    public void oPedidoÉAprovado() {

        Response actualOrderResponse = storeApi.getOrder(expectedOrder.getId());

        actualOrderResponse.
                then().
                body(
                        "id",is(expectedOrder.getId()),
                        "petId", is(expectedPet.getId()),
                        "quantity", is(expectedOrder.getQuantity()),
                        "status", is("approved")
                );
    }
}
