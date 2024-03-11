import java.util.HashMap;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> duplicates = new HashMap<>();

        for(Integer i : nums) {
            if(duplicates.get(i) != null) {
                return true;
            }

            duplicates.put(i, 1);
        }

        return false;
    }
}