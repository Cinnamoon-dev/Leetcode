import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Possible Solution
// 1. group strings in lists by length
// 2. use the method is valid anagram
// 3. group anagrams together in the same list

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lista = new Solution().groupAnagrams(strs);

        for (List<String> list : lista) {
            System.out.println("-----------------------------------------------------");
            for (String string: list) {
               System.out.println(string);
            }
            System.out.println("-----------------------------------------------------");
        }
    }

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

            // Testing each word and checking for anagrams in the entire array
            while(sameSizeWords.size() > 0) {
                String word = sameSizeWords.remove(0);

                List<String> currentArrayAnagrams = new ArrayList<>();
                currentArrayAnagrams.add(word);

                for (int j = 0; j < sameSizeWords.size(); ) {
                    if(isAnagram(word, sameSizeWords.get(j))) {
                        currentArrayAnagrams.add(sameSizeWords.get(j));
                        sameSizeWords.remove(j);
                        continue;
                    }
                    j++;
                }

                groupedAnagrams.add(currentArrayAnagrams);
            }
        }
        
        return groupedAnagrams;
    }

    public boolean isAnagram(String s, String t) {
        char[] word = s.toCharArray();
        char[] possibleAnagram = t.toCharArray();

        if(word.length != possibleAnagram.length) {
            return false;
        }

        Arrays.sort(word);
        Arrays.sort(possibleAnagram);
        return Arrays.equals(word, possibleAnagram);
    }
}
