import groovy.util.MapEntry;
import javax.swing.text.html.ObjectView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HMFromJSON extends BaseTest{
    public static void main(String[] args) {
        Map<String, Object> body = new HashMap<>() {{
           put("colors", Arrays.asList(
               new HashMap() {{
                   put("color", "black");
                   put("category", "hue");
                   put("type", "primary");
                   put("code", new HashMap<>() {{
                       put("rgba", Arrays.asList(255, 255, 255, 1));
                       put("hex", "#000");
                   }});
               }},

               new HashMap() {{
                   put("color", "white");
                   put("category", "value");
                   put("code", new HashMap<>() {{
                       put("rgba", Arrays.asList(0, 0, 0, 1));
                       put("hex", "#FFF");
                   }});
               }}
           ));
        }};
        String key;
        Object value;
        for (Map.Entry<String, Object> mapItem : body.entrySet()) {
           key = mapItem.getKey();
           value = mapItem.getValue();
           System.out.println("Key : " + key + "\nValue : " + value);
        }
    }
}
