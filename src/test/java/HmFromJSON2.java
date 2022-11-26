import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class HmFromJSON2 extends BaseTest{
    String path = "https://81aae278-1332-4ec8-a7d7-ca51a75f656f.mock.pstmn.io/post";
    @Test
    public void postReqJSON() {
        Map<String, Object> body = new HashMap<>() {{
            put("data", Arrays.asList(new HashMap<>(){{
                put("type", "articles");
                put("id", "1");
                put("attributes", new HashMap<>() {{
                    put("title", "JSON:API paints my bikeshed!");
                    put("body", "The shortest article. Ever.");
                    put("created", "2015-05-22T14:56:29.000Z");
                    put("updated", "2015-05-22T14:56:28.000Z");
                }});
                put("relationships", new HashMap<>() {{
                    put("author", new HashMap<>() {{
                        put("data", new HashMap<>() {{
                            put("id", "42");
                            put("type", "people");
                        }});
                    }});
                }});
            }}));
            put("included", Arrays.asList(new HashMap<>() {{
                put("type", "people");
                put("id", "42");
                put("attributes", new HashMap<>() {{
                    put("name", "John");
                    put("age", "80");
                    put("gender", "male");

                }});
            }}));
        }};
        postRequest(path, body);
    }
    /*
    {
  "data": [{
    "type": "articles",
    "id": "1",
    "attributes": {
      "title": "JSON:API paints my bikeshed!",
      "body": "The shortest article. Ever.",
      "created": "2015-05-22T14:56:29.000Z",
      "updated": "2015-05-22T14:56:28.000Z"
    },
    "relationships": {
      "author": {
        "data": {"id": "42", "type": "people"}
      }
    }
  }],
  "included": [{
      "type": "people",
      "id": "42",
      "attributes": {
        "name": "John",
        "age": 80,
        "gender": "male"
      }
    }
  ]
}
     */
}
