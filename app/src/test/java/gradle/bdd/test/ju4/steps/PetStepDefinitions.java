package gradle.bdd.test.ju4.steps;

import com.fasterxml.jackson.core.JsonProcessingException; //para poder imprimir o objsto como json
import com.fasterxml.jackson.databind.ObjectMapper;
import gradle.bdd.test.ju4.support.domain.Pet;
import io.cucumber.java.pt.Dado;

public class PetStepDefinitions {
    @Dado("que eu possua animais dispiníveis")
    public void queEuPossuaAnimaisDispiníveis() throws JsonProcessingException {
        Pet pet = Pet.builder().build();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pet);
        System.out.println(json);
        //System.out.println("test debug");
    }
}
