import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.http.Headers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserAuthTest {


// сначала выполняем авторизацию пользователя, затем проверяем, что пользователь авторизовался успешно

    /*@Test
    public void AuthUserPositiveTest() {
    Map<String, String> authData = new HashMap<>();
    authData.put("email", "vinkotov@example.com");
    authData.put("password", "1234");

    Response responseGetAuth = RestAssured
            .given()
            .body(authData)
            .post("https://playground.learnqa.ru/api/user/login")
            .andReturn();

            Map<String, String> cookies = responseGetAuth.getCookies(); // в случае успешной авторизации возвращаются cookies, заголовки и user_id
            Headers headers = (Headers) responseGetAuth.getHeaders();
            int userIdOnAuth = responseGetAuth.jsonPath().getInt("user_id");

            assertEquals(200, responseGetAuth.statusCode(), "wrong status code");
            assertTrue(cookies.containsKey("auth_sid"), "Response doesn't have 'auth_sid' cookie"); // проверяем код ответа и полученные cookies, заголовки и user_id
            assertTrue(headers.hasHeaderWithName("x-csrf-token"), "Response doesn't have 'x-csrf-token' header");
            assertTrue(responseGetAuth.jsonPath().getInt("user_id") > 0, "'user_id should be greater then 0'");

            JsonPath responseCheckAuth = (JsonPath) RestAssured
            .given()
            .header("x-csrf-token", responseGetAuth.getHeader("x-csrf-token")) // передаем полученные и проверенные cookies и заголовки для проверки успешно сти авторизации
            .cookie("auth_sid", responseGetAuth.getCookie("auth_sid"))
                    .get("https://playground.learnqa.ru/api/user/auth")
                    .jsonPath();
            int userIdOnCheck = responseCheckAuth.getInt("user_id");
            assertTrue(userIdOnCheck > 0, "Unexpected user id" + userIdOnCheck);
            assertEquals(userIdOnAuth, userIdOnCheck, "'userIdOnAuth' is not equals 'userIdOnCheck'");
            // в случае успешной авторизации сервер вернет тот же user_id, что и в первом запросе, здесь мы их сравниваем (userIdOnAuth == userIdOnCheck)
            if (userIdOnAuth == userIdOnCheck) {
                System.out.println("User auth was completed successfully");
            }
            else if (userIdOnAuth != userIdOnCheck){
                System.out.println("userIdOnAuth doesn't match userIdOnCheck. User auth error");
            }


    }*/


}
