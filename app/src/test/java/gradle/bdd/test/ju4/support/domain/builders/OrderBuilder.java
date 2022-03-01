package gradle.bdd.test.ju4.support.domain.builders;

import gradle.bdd.test.ju4.support.domain.Order;
//jeito antigo de criar builder, sem lombok
public class OrderBuilder {

    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public OrderBuilder() {

        reset();
    }

    public OrderBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public OrderBuilder withPetId(int petId) {
        this.petId = petId;
        return this;
    }

    public OrderBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderBuilder withShipDate(String shipDate) {
        this.shipDate = shipDate;
        return this;
    }

    public OrderBuilder withStatus(String status) {
        this.status = status;
        return this;
    }

    public OrderBuilder withComplete(Boolean complete) {
        this.complete = complete;
        return this;
    }

    public Order build() {
        return new Order(
                id,
                petId,
                quantity,
                shipDate,
                status,
                complete
        );
    }

    public void reset() {
        id = 5;
        petId = 22;
        quantity = 10;
        shipDate = "2022-03-01T01:31:31.229Z";
        status = "approved";
        complete = true;
    }
}
