package API.HelperAPI;

import API.dataProviders.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class HelperAPI {

    public static RequestSpecification requestSetup() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri(ConfigReader.getProperty("baseUri"))
                .contentType(ContentType.JSON).accept(ContentType.JSON);
        return requestSpecification;
    }

    public static Response request(String endPoint, Method method) {
        return requestSetup()
                .when()
                .request(method, endPoint);
    }

    public static Response requestWithBody(String endPoint, Method method, String body) {
        return requestSetup()
                .body(body)
                .when()
                .request(method, endPoint);
    }

    public static Response requestWithQueryParams(String endPoint, Method method, Map<String, String> queryParams) {
        return requestSetup()
                .queryParams(queryParams)
                .when()
                .request(method, endPoint);
    }
}
