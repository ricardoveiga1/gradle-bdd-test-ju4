package gradle.bdd.test.ju4.steps;

import gradle.bdd.test.ju4.support.domain.Store;
import gradle.bdd.test.ju4.support.domain.builders.StoreBuilder;
import io.cucumber.java.pt.Dado;

public class StoreStepDefinitions {
    @Dado("alguma coisa")
    public void algumaCoisa() {

        Store store1 = new StoreBuilder().build();

        Store store2 = new StoreBuilder()
                .withId(9)
                .withPetId(99)
                .withQuantity(100)
                .withStatus("complete")
                .withShipDate("24/02/2022")
                .build();

        Store store3 = new StoreBuilder()
                .withPetId(88)
                .withQuantity(50)
                .withStatus("incomplete")
                .build();

        Store store4 = new StoreBuilder().build();

        System.out.println("asdasd");
    }
}
