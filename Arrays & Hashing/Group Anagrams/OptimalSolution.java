import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

public class OptimalSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groupedCharArrays = new HashMap<String, List<String>>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String orderedWord = new String(chars);

            if(!groupedCharArrays.containsKey(orderedWord)) {
                groupedCharArrays.put(orderedWord, new ArrayList<String>());
            }

            groupedCharArrays.get(orderedWord).add(word);
        }

        return new ArrayList<>(groupedCharArrays.values());
    }
}
