package gradle.bdd.test.ju4.steps;

import gradle.bdd.test.ju4.support.api.PetApi;
import gradle.bdd.test.ju4.support.domain.Pet;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class LojaStepDefinitions {

    PetApi petApi;
    Pet expectedPet;

    public LojaStepDefinitions(){
        petApi = new PetApi();
    }

    @Dado("que eu possua animal {word}")
    public void queEuPossuaAnimalAvailable(String status) {
        Pet pet = Pet.builder()
                .id(77)
                .status(status)
                .build();

        expectedPet = petApi.createPet(pet);
    }
}
