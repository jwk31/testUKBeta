import io.restassured.http.Method;
import org.testng.annotations.DataProvider;

public class DataGenerator {

    protected String correctToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJmcmVzaCI6ZmFsc2UsImlhdCI6MTY2Mjk3MjYxMCwianRpIjoiMGI2ZmIwNWEtMzZmYy00YmNhLWE3OGMtNWE5ZmNkMmEwMDE0IiwidHlwZSI6ImFjY2VzcyIsInN1YiI6InZvbG9zaG9rYXNAc2lnbWEtZC5ydSIsIm5iZiI6MTY2Mjk3MjYxMCwiZXhwIjo1MzkxNzY5MjYxMH0.tU1hETYui1F_IC0d7k08Tu-7LUc9jGna__Nxct6dzI4";
    protected String wrongToken = "aAabBbcCc111222333";

    protected String layer1 = "egrn_nerazm";
    protected String layer2 = "yandex.v_azs";
    protected String layer3 = "railroads";
    protected String wrongLayer = "test_layer";
    protected String empty = "";

    protected String fid = "1011402845";
    protected String negativeFid = "-1";

    protected String parcel = "get_pkk_parcel";
    protected String wrongParcel = "test_parcel";

    protected String bbox = "30.152458190917972,59.89319751446438,30.48074340820313,60.00680269772907";
    protected String wrongBbox = "A,A,A,A";

    protected String type_map = "1,2,3,4,5,6";
    protected String wrongType_map = "A,A,A";

    protected String x = "55.73895203895719";
    protected String wrongX = "XXX";

    protected String y = "37.512983938007515";
    protected String wrongY = "YYY";

    protected String parcel_type = "1";
    protected String wrongParcel_type = "A";

    protected Method get = Method.GET;
    protected Method post = Method.POST;
    protected Method put = Method.PUT;
    protected Method patch = Method.PATCH;

    protected String msgNotAllowedMethod = "Method Not Allowed";
    protected String msgMissingToken = "Missing Authorization Header";

    protected String msgInvalidLayer = "Invalid layer";
    protected String msgInvalidQueryParameter = "Not Found";

    protected String msgFid = "fid";
    protected String msgFeature = "features";


    @DataProvider
    public Object[][] dataForFirstEndpoint() {
        return new Object[][]{
                {correctToken, layer1, get, msgFeature, bbox, type_map, "Правильный токен: " + correctToken},
                {wrongToken, layer1, get, msgMissingToken, bbox, type_map, "Неправильный токен: " + wrongToken},
                {empty, layer1, get, msgMissingToken, bbox, type_map, "Отсутствие токена"},

                {correctToken, layer1, get, msgFeature, bbox, type_map, "Параметр layer: " + layer1},
                {correctToken, layer2, get, msgFeature, bbox, type_map, "Параметр layer: " + layer2},
                {correctToken, layer3, get, msgFeature, bbox, type_map, "Параметр layer: " + layer3},

                {correctToken, layer1, get, msgFeature, bbox, type_map, get + " метод"},
                {correctToken, layer1, post, msgNotAllowedMethod, bbox, type_map, post + " метод"},
                {correctToken, layer1, put, msgNotAllowedMethod, bbox, type_map, put + " метод"},
                {correctToken, layer1, patch, msgNotAllowedMethod, bbox, type_map, post + " метод"},

                {correctToken, layer1, get, msgFeature, bbox, type_map, "Правильный параметр layer: " + layer1},
                {correctToken, wrongLayer, get, msgInvalidLayer, bbox, type_map, "Неправильный параметр layer: " + wrongLayer},
                {correctToken, empty, get, msgInvalidLayer, bbox, type_map, "Пустой параметр layer"},

                {correctToken, layer1, get, msgFeature, bbox, type_map, "Правильный query-параметр bbox: " + bbox},
                {correctToken, layer1, get, msgInvalidQueryParameter, wrongBbox, type_map, "Неправильный query-параметр bbox: " + wrongBbox},
                {correctToken, layer1, get, msgInvalidQueryParameter, empty, type_map, "Пустой query-параметр bbox"},

                {correctToken, layer3, get, msgFeature, bbox, type_map, "Правильный query-параметр type_map: " + type_map},
                {correctToken, layer3, get, msgInvalidQueryParameter, bbox, wrongType_map, "Неправильный query-параметр wrongType_map: " + wrongType_map},
                {correctToken, layer3, get, msgInvalidQueryParameter, bbox, empty, "Пустой query-параметр withOutType_map"},
        };
    }

    @DataProvider
    public Object[][] dataForSecondEndpoint() {
        return new Object[][]{
                {correctToken, layer2, fid, get, msgFid, "Правильный токен: " + correctToken},
                {wrongToken, layer2, fid, get, msgMissingToken, "Неправильный токен: " + wrongToken},
                {empty, layer2, fid, get, msgMissingToken, "Отсутствие токена"},

                {correctToken, layer1, fid, get, msgFid, "Параметр layer: " + layer1},
                {correctToken, layer2, fid, get, msgFid, "Параметр layer: " + layer2},
                {correctToken, layer3, fid, get, msgFid, "Параметр layer: " + layer3},

                {correctToken, layer2, fid, get, msgFid, get + " метод"},
                {correctToken, layer2, fid, post, msgNotAllowedMethod, post + " метод"},
                {correctToken, layer2, fid, put, msgNotAllowedMethod, put + " метод"},
                {correctToken, layer2, fid, patch, msgNotAllowedMethod, post + " метод"},

                {correctToken, layer2, fid, get, msgFid, "Правильный параметр layer: " + layer2},
                {correctToken, wrongLayer, fid, get, msgInvalidLayer, "Неправильный параметр layer: " + wrongLayer},
                {correctToken, empty, fid, get, msgInvalidLayer, "Пустой параметр layer"},

                {correctToken, layer2, fid, get, msgFid, "Правильный параметр fid: " + fid},
                {correctToken, layer2, negativeFid, get, msgInvalidLayer, "Негативный параметр fid: " + negativeFid},
                {correctToken, layer2, empty, get, msgInvalidLayer, "Пустой параметр fid"},
        };
    }

    @DataProvider
    public Object[][] dataForThirdEndpoint() {
        return new Object[][]{
                {correctToken, parcel, get, msgFeature, x, y, parcel_type, "Правильный токен: " + correctToken},
                {wrongToken, parcel, get, msgMissingToken, x, y, parcel_type, "Неправильный токен: " + wrongToken},
                {empty, parcel, get, msgMissingToken, x, y, parcel_type, "Отсутствие токена"},

                {correctToken, parcel, get, msgFeature, x, y, parcel_type, get + " метод"},
                {correctToken, parcel, post, msgNotAllowedMethod, x, y, parcel_type, post + " метод"},
                {correctToken, parcel, put, msgNotAllowedMethod, x, y, parcel_type, put + " метод"},
                {correctToken, parcel, patch, msgNotAllowedMethod, x, y, parcel_type, post + " метод"},

                {correctToken, parcel, get, msgFeature, x, y, parcel_type, "Правильный параметр parcel: " + parcel},
                {correctToken, wrongParcel, get, msgInvalidLayer, x, y, parcel_type, "Неправильный параметр parcel: " + wrongParcel},
                {correctToken, empty, get, msgInvalidLayer, x, y, parcel_type, "Пустой параметр parcel"},

                {correctToken, parcel, get, msgFeature, x, y, parcel_type, "Правильный query-параметр x: " + x},
                {correctToken, parcel, get, msgInvalidQueryParameter, wrongX, y, parcel_type, "Неправильный query-параметр x: " + wrongX},
                {correctToken, parcel, get, msgInvalidQueryParameter, empty, y, parcel_type, "Пустой query-параметр x"},

                {correctToken, parcel, get, msgFeature, x, y, parcel_type, "Правильный query-параметр y: " + y},
                {correctToken, parcel, get, msgInvalidQueryParameter, x, wrongY, parcel_type, "Неправильный query-параметр y: " + wrongY},
                {correctToken, parcel, get, msgInvalidQueryParameter, x, empty, parcel_type, "Пустой query-параметр Y"},

                {correctToken, parcel, get, msgFeature, x, y, parcel_type, "Правильный query-параметр parcel_type: " + parcel_type},
                {correctToken, parcel, get, msgInvalidQueryParameter, x, y, wrongParcel_type, "Неправильный query-параметр parcel_type: " + wrongParcel_type},
                {correctToken, parcel, get, msgInvalidQueryParameter, x, y, empty, "Пустой query-параметр parcel_type"},
        };
    }
}
