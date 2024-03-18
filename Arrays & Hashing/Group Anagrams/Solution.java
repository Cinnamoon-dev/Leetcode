import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Possible Solution
// 1. group strings in lists by length
// 2. use the method is valid anagram
// 3. group anagrams together in the same list

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<List<String>>();
        HashMap<Integer, List<String>> groupedWords = new HashMap<Integer, List<String>>();

        // Strings grouped by size
        for (int i = 0; i < strs.length; i++) {
            if(groupedWords.get(strs[i].length()) == null) {
                ArrayList<String> words = new ArrayList<String>();
                words.add(strs[i]);
                groupedWords.put(strs[i].length(), words);
                continue;
            }
            
            groupedWords.get(strs[i].length()).add(strs[i]);
        }
        
        // Getting each List of strings and creating a list of lists of grouped anagrams
        // or adding them in the groupedAnagrams variable
        for(Integer length : groupedWords.keySet()) {
            List<String> sameSizeWords = groupedWords.get(length);

            for (int i = 0; i < sameSizeWords.size(); i++) {
                
            }
        }
        
        return groupedAnagrams;
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> characters = new HashMap<Character, Integer>();

        for(char i : s.toCharArray()) {
            if(!characters.containsKey(i)) {
                characters.put(i, 1);
                continue;
            }

            characters.put(i, characters.get(i) + 1);
        }

        for(char i : t.toCharArray()) {
            if(!characters.containsKey(i)) {
                return false;
            }

            characters.put(i, characters.get(i) - 1);
        }

        if(characters.values().stream().anyMatch((e) -> e > 0 || e < 0)) {
            return false;
        }

        return true;
    }
}
