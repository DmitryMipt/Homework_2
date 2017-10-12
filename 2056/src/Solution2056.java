import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution2056 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Scanner txt = new Scanner(System.in);
        String text = "";
        while (txt.hasNext()) {
            text += txt.nextLine() + " ";
        }
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            if (map.containsKey(words[i]))
                map.put(words[i], map.get(words[i]) + 1);
            else map.put(words[i], 1);
        }
        Map<String, Integer> mapSort = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
        mapSort.putAll(map);
        int maxValue = 0;
        for (String key : mapSort.keySet()) {
            if (mapSort.get(key) > maxValue) {
                maxValue = mapSort.get(key);
            }
        }
        for (String key : mapSort.keySet()) {
            if (mapSort.get(key) == maxValue) {
                System.out.println(key);
            }
        }
    }
}
