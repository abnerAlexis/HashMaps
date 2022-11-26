import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class isbnDataHMJSON extends BaseTest{
    private static final String path = BASE_URI + "/isbnData";

    @Test
    protected void createRunHMJSON() {
        Map<String, Object> body = new HashMap<>() {{
            put("isbn", "123-456-222");
            put("author", new HashMap(){{
                put("lastname", "Doe");
                put("firstname", "Jane");
            }});
            put("editor", new HashMap() {{
                put("lastname", "Smith");
                put("firstname", "Jane");
            }});
            put("title","The Ultimate Database Study Guide");
            put("category", Arrays.asList("Non-Fiction", "Technology"));
        }};

        postRequest(path, body);
    }

    @Test
    public void deleteMapBody() {
        deleteRequest(path);
    }
}
/*
{"isbn": "123-456-222",
 "author":
    {
      "lastname": "Doe",
      "firstname": "Jane"
    },
"editor":
    {
      "lastname": "Smith",
      "firstname": "Jane"
    },
  "title": "The Ultimate Database Study Guide",
  "category": ["Non-Fiction", "Technology"]
 }
 */