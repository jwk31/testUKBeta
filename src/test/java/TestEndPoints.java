import API.HelperAPI.HelperAPI;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestEndPoints extends A_BaseTest {

    @Test(description = "Check first endpoint", dataProvider = "dataForFirstEndpoint")
    public void testFirstEndpointToken(String token, String layer, Method method, String msg,
                                       String queryParams1, String queryParams2,
                                       String description) {
        Map<String, String> qp = new HashMap<>();
        qp.put("bbox", queryParams1);

        if (layer.equals(layer3)) {
            qp.put("type_map", queryParams2);
        }

        String bearer = "";
        if (!token.equals("")) {
            bearer = "Bearer ";
        }

        Response response = HelperAPI.requestSetup()
                .header("Authorization", bearer + token)
                .queryParams(qp)
                .when()
                .request(method, "layers/" + layer);

        System.out.println(description);
        Assert.assertTrue(response.body().asPrettyString().contains(msg), msg + " нет в ответе запроса");

    }

    @Test(description = "Check second endpoint", dataProvider = "dataForSecondEndpoint")
    public void testSecondEndpoint(String token, String layer, String fid, Method method, String msg,
                                   String description) {

        String bearer = "";
        if (!token.equals("")) {
            bearer = "Bearer ";
        }

        Response response = HelperAPI.requestSetup()
                .header("Authorization", bearer + token)
                .when()
                .request(method, "layers/" + layer + "/" + fid);

        System.out.println(description);
        Assert.assertTrue(response.body().asPrettyString().contains(msg), msg + " нет в ответе запроса");
    }

    @Test(description = "Check third endpoint", dataProvider = "dataForThirdEndpoint")
    public void testThirdEndpointToken(String token, String parcel, Method method, String msg,
                                       String queryParams1, String queryParams2, String queryParams3,
                                       String description) {
        Map<String, String> qp = new HashMap<>();
        qp.put("x", queryParams1);
        qp.put("y", queryParams2);
        qp.put("parcel_type", queryParams3);

        String bearer = "";
        if (!token.equals("")) {
            bearer = "Bearer ";
        }

        Response response = HelperAPI.requestSetup()
                .header("Authorization", bearer + token)
                .queryParams(qp)
                .when()
                .request(method, parcel);

        System.out.println("Время ответа: " + response.time());
        System.out.println(description);
        Assert.assertTrue(response.body().asPrettyString().contains(msg), msg + " нет в ответе запроса");
    }
}
