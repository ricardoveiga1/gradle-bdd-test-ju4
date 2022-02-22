package gradle.bdd.test.ju4.support.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
@NoArgsConstructor //constutor padrão
@AllArgsConstructor //constutor com todos argumentos do jackson
@JsonIgnoreProperties(ignoreUnknown = true)// ignorando atributos desconheicdos do JSON, no caso TAGS
public class Pet {
    @Builder.Default
    private int id = 2;
    @Builder.Default
    private String name = "TunderCat";
    @Builder.Default
    private PetCategory category = new PetCategory();
    @Builder.Default
    private List<String> photoUrls = Arrays.asList("url1", "url2");
    @Builder.Default
    private String status = "available";

}
