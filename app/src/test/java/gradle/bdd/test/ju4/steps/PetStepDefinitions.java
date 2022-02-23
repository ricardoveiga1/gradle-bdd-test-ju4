package gradle.bdd.test.ju4.steps;

import com.fasterxml.jackson.core.JsonProcessingException; //para poder imprimir o objsto como json
import com.fasterxml.jackson.databind.ObjectMapper;
import gradle.bdd.test.ju4.support.api.PetApi;
import gradle.bdd.test.ju4.support.domain.Pet;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

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

    @Dado("que eu possua animais {word}")
    public void queEuPossuaAnimaisDispiníveis(String status) throws JsonProcessingException {
//        Pet pet = Pet.builder().build();
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(pet);
//        System.out.println(json);
//        System.out.println("test debug");
    }

    @Quando("eu pesquiso por todos os animais {word}")// transformamos a palavra available em uma variável {word}
    public void euPesquisoPorTodosOsAnimaisAvailable(String status) {
        actualPets = petApi.getPetsByStatus(status); //recebo uma lista de Pets
        //System.out.println("Teste debug");

    }

    @Então("eu recebo a lista de animais available")
    public void euReceboAListaDeAnimaisAvailable() {
        assertThat(actualPets, is(not(empty())));
    }

    @E("eu recebo uma outra lista de animais {word}")
    public void euReceoUmaOutraListaDeAnimaisAvailable(String status) {
        //jogando o GET em uma variável
        Response actualAvailablePetsResponse = petApi.getPetsResponseByStatus(status);

        //pegando lista dinamica, caso mude a quantidade de itens, estarei atualizando a lista de itens, fica mais inteligente
        //desserialização
        actualPets = actualAvailablePetsResponse.body().jsonPath().getList("", Pet.class);

        actualAvailablePetsResponse.
                then().
                statusCode(HttpStatus.SC_OK).
                //groove collection
                body(
                       // "size", is(7),
                     "size", is(actualPets.size()),
                     //como se for um for it, percorre todos otens, mas poderia por apenas available
                     "findAll { it.status == '"+status+"'}.size()", is (actualPets.size())
                );

    }

    @Então("eu recebo a lista com {} animal/animais")
    public void euReceboAListaDeAnimaisPending(int petsQuantity) {
        assertThat(actualPets.size(), is(petsQuantity));
    }

    @Dado("que eu não possua animais {word}")
    public void queEuNãoPossuaAnimaisSold(String status) {
        petApi.deletePetsByStatus(status);
    }
}
