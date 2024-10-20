package Utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiFactory {

    public static Response getMethod(String url, String basePath) {
        Response res = given()
                .contentType("application/json")
                .when()
                .get(url + basePath);
        return res;
    }
}
