import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateAndPrintHM {
    public static void main(String[] args) {
        List<Integer> idArrayList = new ArrayList<>();
        idArrayList.add(5);
        idArrayList.add(9);

        Map<String, Object> batterHashMap2= new HashMap<>();
        batterHashMap2.put("id", idArrayList);
        batterHashMap2.put("type", "Chocolate");

        System.out.println("batterHashMap2:");
        for (Map.Entry<String,Object> mapElement : batterHashMap2.entrySet()) {
            String key = mapElement.getKey();

            // Adding some bonus marks to all the students
            Object value = (mapElement.getValue());

            // Printing above marks corresponding to
            // students names
            System.out.println(key + " : " + value);
        }
    }
}
