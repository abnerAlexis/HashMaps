import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import java.io.File;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class BaseTest extends ApiKeySt{
    protected static final String BASE_URI = "https://101d9111-dd5a-4f1b-b26c-69d993af6f6c.mock.pstmn.io";

    public Response getRequest(String path){
        return given()
            .baseUri(BASE_URI)
            .header("x-api-key", API_KEY)
            .log().all()
            .get(path)
            .then()
            .log().all()
            .extract().response();
    }

    public Response postRequest(String path, Map body) {
        return given()
            .body(body)
            .baseUri(BASE_URI)
            .header("x-api-key", API_KEY)
            .log().all()
            .post(path)
            .then()
            .log().all()
            .extract().response();
    }

    public Response putRequest(String path) {
        return given()
            .baseUri(BASE_URI)
            .header("x-api-key", API_KEY)
            .log().all()
            .put(path)
            .then()
            .log().all()
            .extract().response();
    }

    public void postFileReq(String baseURI, String path, String filePath, String attributes) {
        given()
            .baseUri(baseURI)
            .multiPart("file", new File(filePath))
            .multiPart("attributes", attributes, "application/json")
            .log().all()
            .when()
            .post(path)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_OK);
    }

    public Response patchRequest(String path) {
        return given()
            .baseUri(path)
            .header("x-api-key", API_KEY)
            .log().all()
            .patch(path)
            .then()
            .log().all()
            .extract().response();
    }

    public Response deleteRequest(String path)  {
        return given()
            .baseUri(BASE_URI)
            .header("x-api-key", API_KEY)
            .log().all()
            .delete()
            .then()
            .log().all()
            .extract().response();
    }

    public void printResponseBody(Object body, String path) {
        given()
            .body(body)
            .log().all()
            .post(path)
            .then();
    }
}
