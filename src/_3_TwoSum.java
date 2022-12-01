import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _3_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int complement = target - nums[i];

            if (complementMap.containsKey(nums[i]))
                return new int[] {complementMap.get(nums[i]), i};

            complementMap.put(complement, i);
        }

        return null;
    }

    // two pointer solution - O(NlogN), O(1) space
    public static int[] twoSumV2(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int leftRightSum = nums[left] + nums[right];

            if (target == leftRightSum) {
                return new int[] {nums[left], nums[right]};
            }
            else if (leftRightSum > target)
                right--;
            else
                left++;
        }

        return null;
    }
}

/*
Constraints:
    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
 */