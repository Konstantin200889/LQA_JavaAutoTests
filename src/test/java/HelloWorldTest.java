import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HelloWorldTest {

    private final static String testUrl = "https://playground.learnqa.ru/api";


    /*@Test
    public void testRestAssured1() {
        Response response = RestAssured
                .get(testUrl + "/map")
                .andReturn();
                assertTrue(response.statusCode() == 200, "unexpected code");
               //функция assertTrue приводит выражение в скобках к типу boolean
    }*/

    /*@Test
    public void testRestAssured2() {
        Response response = RestAssured
                .get(testUrl + "/map1")
                .andReturn();
        assertEquals(200, response.statusCode(), "unexpected code");
        //для сравнения результата сначала передаем ожидаемое значение, а затем действительное
    }*/


    /*@Test
    public void testRestAssured3() {
        JsonPath response = RestAssured
                .get(testUrl + "/hello")
                .jsonPath();
        String answer = response.getString("answer");
        assertEquals("Hello, someone", answer, "wrong response");
        //делаем запрос без параметров
        response.prettyPrint();
    }*/


    /*@Test
    public void testRestAssured4() {
        String name = "Username";
        //передаем в качестве параметра name = "Username" в теле теста
        JsonPath response = RestAssured
                .given()
                .queryParams("name", name)
                .get(testUrl + "/hello")
                .jsonPath();
        String answer = response.getString("answer");
        assertEquals("Hello, " + name, answer, "wrong response");
        response.prettyPrint();
    }*/



    @ParameterizedTest // в @ParameterizedTest мы передаем набор параметров, тест будет запускаться столько раз, сколько параметров передано
    @ValueSource(strings = {"", "John", "Pete"})// в этом теге передаем набор параметров
    // мы передали 3 параметра в тест, теперь тест будет запущен 3 раза, каждый раз подставляя очередной параметр
    public void testRestAssured5(String name) { // в String name будут по очереди передаваться значения из (strings = {"", "John", "Pete"})
        Map <String, String> queryParams = new HashMap<>();

        if(name.length() > 0) { // обрабатываем ситуацию, когда имя - пустое
            queryParams.put("name", name); // добавляем имя в качестве параметра в созданную мапу queryParams
        }

       //чтобы автоматически передавать параметры в тест, мы добавили аннотацию @parametrizedTest + @ValueSource
        JsonPath response = RestAssured
                .given()
                .queryParams(queryParams) // поместили мапу queryParams в тело запроса
                .get(testUrl + "/hello")
                .jsonPath();
        String answer = response.getString("answer");
        String expectedName = (name.length() > 0) ? name : "someone"; // конструкция тернарного оператора: переменная= (условие) ? результат_если_true : результат_если_false
        //если длина значения переменной name больше нуля, то она сохранится в новую переменную expectedName
        assertEquals("Hello, " + expectedName, answer, "wrong response");
        response.prettyPrint();

    }





















}


















