import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3 ,4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] before = new int[nums.length];
        int[] after = new int[nums.length];
        int[] answer = new int[nums.length];
            
        for (int i = 0; i < nums.length; i++) {
            before[i] = 1;
            after[i] = 1;
            answer[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            before[i] = before[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i > -1; i--) {
            after[i] = after[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = before[i] * after[i];
        }

        return answer;
    }    
}
