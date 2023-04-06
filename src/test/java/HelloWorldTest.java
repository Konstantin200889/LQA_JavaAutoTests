import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;


public class HelloWorldTest {

    private final static String testUrl = "https://playground.learnqa.ru/api";

    /*@Test
    public void test1() {
                JsonPath response =  RestAssured
                .get(testUrl + "/get_json_homework")
                        .jsonPath();
                response.prettyPrint();

        ArrayList allMessages = response.get("messages");
        HashMap SecondMessage = (HashMap) allMessages.get(1);
        String secondMessageText = response.get("messages[1].message");
        Assertions.assertEquals(secondMessageText, "And this is a second message");
        System.out.println(secondMessageText);
    }*/



    /*@Test
    public void test2() {
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get(testUrl + "/long_redirect")
                .andReturn();
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Headers respHeaders = response.getHeaders();
        System.out.println(respHeaders.getValue("Location").toString());
    }
    */




    /*@Test
    public void test3() {
        int i = 0;
        String url = testUrl + "/long_redirect";
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
            if (statusCode == 200) {
                break;
            }
            url = respHeaders.getValue("Location").toString();
            i++;
            *//*System.out.println(url);
            System.out.println(statusCode);*//*
        } while (true);
        System.out.println(i);
        System.out.println(url);
    }*/




    /*@Test
    public void test4() throws InterruptedException {
        JsonPath response1 = RestAssured
                .get(testUrl+ "/longtime_job")
                .jsonPath();
        String getToken = response1.get("token");
        Integer getTime = response1.get("seconds");
        HashMap<String, String> mapToken = new HashMap<>();
        mapToken.put("token", getToken);
        System.out.println(mapToken);
        JsonPath response2 = RestAssured
                .given()
                .queryParams(mapToken)
                .get(testUrl+ "/longtime_job")
                .jsonPath();
                String fieldStatus = response2.get("status");
                if (!Objects.equals(fieldStatus, "Job is NOT ready")) {
                    System.out.println("wrong status");
                }
                else {
                    System.out.println(fieldStatus);
                }
                Thread.sleep(getTime * 1000);
                JsonPath response3 = RestAssured
                        .given()
                        .queryParams(mapToken)
                        .get(testUrl+ "/longtime_job")
                        .jsonPath();
                String newFieldStatus = response3.get("status");
                String fieldResult = response3.get("result");
                Assertions.assertEquals(newFieldStatus, "Job is ready");
                Assertions.assertNotNull(fieldResult, "field result is empty");
                System.out.println(newFieldStatus);
                System.out.println(fieldResult);

    }*/





}


















