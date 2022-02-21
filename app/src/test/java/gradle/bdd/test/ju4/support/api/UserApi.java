    package gradle.bdd.test.ju4.support.api;

    import gradle.bdd.test.ju4.support.domain.User;
    import io.restassured.http.ContentType;
    import org.apache.http.HttpStatus;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;

    import static io.restassured.RestAssured.given;
    import static org.hamcrest.CoreMatchers.is;

    public class UserApi {

        private static final String CREATE_USER_ENDPOINT = "/v3/user";
        private static final String USER_ENDPOINT = "/v3/user/{username}";

        public void createUser(User user){
            given().
                    body(user).
                    when().
                    post(CREATE_USER_ENDPOINT).
                    then().
                    statusCode(HttpStatus.SC_ACCEPTED);
        }

        public String getUsername(User user) {
            return given().
                    pathParam("username", user.getUsername()). //variável aicionada no início da classe private static na url {}
                    when().
                    get(USER_ENDPOINT).
                    thenReturn().
                    path("username");
        }

        //fazendo uma lista de usuários para deletar
        public void deleteAllUsers(){
            //List<String> usersList = Arrays.asList("ricardoVeiga", "outroConteudo);
            List<String> usersList = Arrays.asList("ricardoVeiga", "Ana Maria"); //deletando use de teste

            for( String user: usersList) {  //cada varredura vou ter um usuario da lista que vai estar dentro do user
                given().
                pathParam("username", user). //variável aicionada no início da classe private static na url {}
                        when().
                        delete(USER_ENDPOINT).
                        then().
                        statusCode(HttpStatus.SC_OK);
            }
        }


    }
