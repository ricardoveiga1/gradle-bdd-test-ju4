package gradle.bdd.test.ju4.steps;

import com.fasterxml.jackson.core.JsonProcessingException; //para poder imprimir o objsto como json
import com.fasterxml.jackson.databind.ObjectMapper;
import gradle.bdd.test.ju4.support.api.PetApi;
import gradle.bdd.test.ju4.support.domain.Pet;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PetStepDefinitions {

    private PetApi petApi;
    private List<Pet> actualPets;

    //para utilizar o metodos do petApi preciso inicializar dentro do construtor
    public PetStepDefinitions(){
        petApi = new PetApi();
    }

    @Dado("que eu possua animais available")
    public void queEuPossuaAnimaisDispiníveis() throws JsonProcessingException {
        Pet pet = Pet.builder().build();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pet);
        System.out.println(json);
        //System.out.println("test debug");
    }

    @Quando("eu pesquiso por todos os animais {word}")// transformamos a palavra available em uma variável {word}
    public void euPesquisoPorTodosOsAnimaisAvailable(String status) {
        actualPets = petApi.getPetsByStatus(status); //recebo uma lista de Pets
        System.out.println("Teste debug");

    }

    @Então("eu recebo a lista de animais available")
    public void euReceboAListaDeAnimaisAvailable() {
        assertThat(actualPets, is(not(empty())));
    }
}
