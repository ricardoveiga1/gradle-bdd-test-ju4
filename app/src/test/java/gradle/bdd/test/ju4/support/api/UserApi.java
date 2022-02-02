    package gradle.bdd.test.ju4.support.api;

    import gradle.bdd.test.ju4.support.domain.User;
    import io.restassured.http.ContentType;
    import org.apache.http.HttpStatus;

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
                    statusCode(HttpStatus.SC_OK);
        }

        public String getUsername(User user) {
            return given().
                    pathParam("username", user.getUsername()). //variável aicionada no início da classe private static na url {}
                    when().
                    get(USER_ENDPOINT).
                    thenReturn().
                    path("username");
        }
    }
