import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] sd = {2222222, 2222222};
        System.out.println(twoSum(sd, 4444444));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] response = new int[2];
        HashMap<Integer, Integer> aux = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(aux.get(target - nums[i]) != null) {
                response[0] = i;
                response[1] = aux.get(target - nums[i]);

                return response;
            }

            aux.put(nums[i], i);
        }

        return response;
    } 
}
