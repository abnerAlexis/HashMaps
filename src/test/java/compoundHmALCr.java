import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class compoundHmALCr extends BaseTest{
    private static final String path = BASE_URI + "/isbnData";
    @Test
    public void createMap() {
        Map<String, Object> body = new HashMap<>() {{
            put("accounting", Arrays.asList(getPersonMap("John", "Doe", 23), getPersonMap("Mary", "Smith", 32)));
            put("sales", Arrays.asList(getPersonMap("Sally", "Green", 27), getPersonMap("Jim", "Galley", 41)));
        }};

//        printResponseBody(body, path); prints the HashMap body
        postRequest(path, body);
    }

    private Map getPersonMap(String firstname, String lastname, int age) {
        return new HashMap<>() {{
            put("firstName", firstname);
            put("lastName", lastname);
            put("age", age);
        }};
    }
}
/*
{
  "accounting" : [
                     { "firstName" : "John",
                       "lastName"  : "Doe",
                       "age"       : 23 },

                     { "firstName" : "Mary",
                       "lastName"  : "Smith",
                        "age"      : 32 }
                 ],
  "sales"      : [
                     { "firstName" : "Sally",
                       "lastName"  : "Green",
                        "age"      : 27 },

                     { "firstName" : "Jim",
                       "lastName"  : "Galley",
                       "age"       : 41 }
                 ]
}
 */
