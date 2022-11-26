import org.testng.annotations.Test;

public class EchoFileReqTest extends BaseTest{
    String baseURI = "https://postman-echo.com";
    String path = "/post";
    String attributes = "{\"name\":\"file.txt\",\"parent\":{\"id\":\"123456\"}}";
    String filePath = "src/test/java/file.txt";

    @Test
    public void postFileEchoReq() {
        postFileReq(baseURI, path, filePath, attributes);
    }
}
