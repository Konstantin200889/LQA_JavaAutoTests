import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ExampleTests {

    private final static String testUrl = "https://playground.learnqa.ru/api";


    /*@Test
    public void testStatusCodeCheck() {
        Response response = RestAssured
                .get(testUrl + "/map1")
                .andReturn();
        assertEquals(200, response.statusCode(), "unexpected code"); // проверяем соответствие статус кода ожиданиям
        //для сравнения результата сначала передаем ожидаемое значение, а затем действительное
    }*/



    /*@Test
      public void testGetSecondMessageFromJson() {

                JsonPath response =  RestAssured
                .get(testUrl + "/get_json_homework")
                        .jsonPath();
                response.prettyPrint();
        ArrayList allMessages = response.get("messages");
        HashMap SecondMessage = (HashMap) allMessages.get(1);
        String SecondMessageText = (String) SecondMessage.get("message"); //вытаскиваем из массива в JSON второе сообщение и печатаем
        System.out.println(SecondMessageText);
    }*/



    /*@Test
    public void testCheckUserName() {
        Map<String, String> params = new HashMap<>(); // создали коллекцию Map для хранения нужных данных
        params.put("name", "john");
        JsonPath response = RestAssured // JsonPath - класс для парсинга Json (десериализует полученный Json в объект и достает нужные данные)
                .given()
                .queryParams(params)
                .get("testUrl + "/hello") // некоторые параметры передаются в теле get-запроса после вопр.знака
                 // в RestAssured такие параметры обычно передают массивом отдельно от самого тела запроса и заголовков
                .jsonPath();
        String name = response.get("answer");
        // ищем в ответе поле "answer", если оно есть там - сохраняем в String name,
        // если нет (==null) - выводим "the key 'answer2' is absent"
        if (name == null) {
            System.out.println("the key 'answer2' is absent");
        }
        else {
            System.out.println(name);
        }
    }*/



    /*@Test
    public void testCheckStatusCodeAndHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("myHeader1", "myValue1");
        headers.put("myHeader2", "myValue2");

        Response response = RestAssured
                .given()
                .headers(headers) // отправили мапу headers с заголовками в теле запроса
                .when()
                .get("https://playground.learnqa.ru/api/show_all_headers")
                .andReturn();
        int statusCode = response.getStatusCode(); //извлекаем и печатаем статус код
        response.prettyPrint();

        Headers responseHeaders = response.getHeaders(); //извлекаем и печатаем заголовки, кот.сервер отправил в ответ
        System.out.println(responseHeaders);
    }*/



    /*@Test
    public void testCheckHeadersAndCookie() {
    Map<String, String>data = new HashMap<>();
    data.put("login", "secret_login");
    data.put("password", "secret_pass");

    Response response = RestAssured
            .given()
            .body(data) // передаем мапу data c логином и паролем
            .when()
            .post(testUrl + "/get_auth_cookie")
            .andReturn();

        System.out.println("\nStatusCode:");
        System.out.println(response.getStatusCode()); // проверяем статус код

        System.out.println("\nHeaders:");
        Headers responseHeaders = response.getHeaders(); // распечатываем заголовки
        System.out.println(responseHeaders);

        System.out.println("\nCookies:");
        Map<String, String> responseCookies = response.getCookies(); // распечатываем cookie
        System.out.println(responseCookies);
    }*/



    // Тест, который будет запускаться в цикле до тех пор, пока не прекратятся редиректы, и не придет статус код 200
            /*@Test
            public void testLongRedirect() {
                int i = 0;
                String url = testUrl + "/long_redirect";
                // при переходе по данной ссылке автоматически происходит редирект, который необходимо обработать
                do {
                    Response response = RestAssured
                            .given()
                            .redirects()
                            .follow(false)
                            .when()
                            .get(url)
                            .andReturn();
                    int statusCode = response.getStatusCode();
                    Headers respHeaders = response.getHeaders();
                    if (statusCode == 200) { // если придет код 200, цикл остановится
                        break;
                    }
                    url = respHeaders.getValue("Location").toString();
                    // после каждого нового перехода значение адреса будет перезаписываться в переменную url
                    i++;
                    *//*System.out.println(url);
                    System.out.println(statusCode);*//*
                } while (true);
                System.out.println(i); // после окончания цикла выводится итоговый адрес и кол-во выполненных редиректов(i)
                System.out.println(url);
            }*/



            /*@Test
            public void testGetTokenAndThenAuth() throws InterruptedException {
                JsonPath response1 = RestAssured
                        .get(testUrl+ "/longtime_job")
                        .jsonPath();
                String getToken = response1.get("token"); // извлекаем токен авторизации
                Integer getTime = response1.get("seconds"); // извлекаем значение оставшегося кол-ва секунд до обработки запроса
                HashMap<String, String> mapToken = new HashMap<>();
                mapToken.put("token", getToken);
                System.out.println(mapToken);
                JsonPath response2 = RestAssured
                        .given()
                        .queryParams(mapToken) // передаем токен
                        .get(testUrl+ "/longtime_job")
                        .jsonPath();
                        String fieldStatus = response2.get("status");
                        if (!Objects.equals(fieldStatus, "Job is NOT ready")) {
                        // ожидаемый результат - сообщение "Job is NOT ready"
                            System.out.println("wrong status");
                        }
                        else {
                            System.out.println(fieldStatus);
                        }
                        Thread.sleep(getTime * 1000);
                        // задаем интервал для ожидания обработки запроса (берем значение переменной getTime (кол-во секунд) и умножаем на 1000)
                        JsonPath response3 = RestAssured
                                .given()
                                .queryParams(mapToken)
                                .get(testUrl+ "/longtime_job")
                                .jsonPath(); // получили ответ в json, далее проверяем необходимые условия при помощи Assertions
                        String newFieldStatus = response3.get("status");
                        String fieldResult = response3.get("result");
                        Assertions.assertEquals(newFieldStatus, "Job is ready");
                        Assertions.assertNotNull(fieldResult, "field result is empty");
                        System.out.println(newFieldStatus);
                        System.out.println(fieldResult);
            }*/



    // в @ParameterizedTest мы передаем набор параметров, тест будет запускаться столько раз, сколько параметров передано

    /*@ParameterizedTest
    @ValueSource(strings = {"", "John", "Pete"}) // в этом теге передаем набор параметров
    // мы передали 3 параметра в тест, теперь тест будет запущен 3 раза, каждый раз подставляя очередной параметр

    public void checkUserNameParameterizedTest(String name) { // в String name будут по очереди передаваться значения из (strings = {"", "John", "Pete"})
        Map <String, String> queryParams = new HashMap<>();

        if (name.length() > 0) { // обрабатываем ситуацию, когда имя - пустое
            queryParams.put("name", name); // добавляем имя в качестве параметра в созданную мапу queryParams
        }

        JsonPath response = RestAssured
                .given()
                .queryParams(queryParams) // поместили мапу queryParams в тело запроса
                .get(testUrl + "/hello")
                .jsonPath();
        String answer = response.getString("answer");
        String expectedName = (name.length() > 0) ? name : "someone"; // конструкция тернарного оператора: переменная= (условие) ? результат_если_true : результат_если_false
        //если длина значения переменной name больше нуля, то она сохранится в новую переменную expectedName
        assertEquals("Hello, " + expectedName, answer, "wrong response"); // извлекаем поле со значением имени и сравниваем с ожидаемым результатом
        response.prettyPrint();
    }*/


}


















