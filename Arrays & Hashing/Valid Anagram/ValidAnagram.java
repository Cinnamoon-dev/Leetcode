import java.util.HashMap;

public class ValidAnagram {
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
