package gradle.bdd.test.ju4.steps;

import gradle.bdd.test.ju4.support.domain.Order;
import gradle.bdd.test.ju4.support.domain.builders.OrderBuilder;
import io.cucumber.java.pt.Dado;

public class StoreStepDefinitions {
    @Dado("alguma coisa")
    public void algumaCoisa() {

        Order order1 = new OrderBuilder().build();

        Order order2 = new OrderBuilder()
                .withId(9)
                .withPetId(99)
                .withQuantity(100)
                .withStatus("complete")
                .withShipDate("24/02/2022")
                .build();

        Order order3 = new OrderBuilder()
                .withPetId(88)
                .withQuantity(50)
                .withStatus("incomplete")
                .build();

        Order order4 = new OrderBuilder().build();

        System.out.println("asdasd");//para por breakpoint e debugar, didático
    }
}
