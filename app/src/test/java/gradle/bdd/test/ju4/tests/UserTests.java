package gradle.bdd.test.ju4.tests;

import gradle.bdd.test.ju4.support.api.UserApi;
import gradle.bdd.test.ju4.support.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Testes da funcionalidade de usuário")
public class UserTests extends BaseTest {

    UserApi userApi = new UserApi();
    User expectedUser;

    @Test
    @DisplayName("Usuário deve ser registrado do sistema")
    void shouldBeCreateNewUser() {

        expectedUser = User.builder().build();
        userApi.createUser(expectedUser);

        String actualUserName = userApi.getUsername(expectedUser);
        //System.out.println(actualUserName);
        assertThat(actualUserName, is(expectedUser.getUsername()));
    }

    @AfterEach
    void deleteNewUser() {
        userApi.deleteUser(expectedUser);
    }
}
