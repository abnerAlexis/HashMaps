import org.testng.annotations.Test;

public class NIkeReturnEchoFileReqTest extends BaseTest{
    String baseURI = "https://postman-echo.com";
    String path = "/post";
    String attributes = "{\"name\":\"NikeReturn.txt\",\"parent\":{\"id\":\"1234560\"}}";
    String filePath = "src/test/java/NikeReturn.txt";

    @Test
    public void postFileEchoReq() {
        postFileReq(baseURI, path, filePath, attributes);
    }
}
