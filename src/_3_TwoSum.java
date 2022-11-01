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
}

/*
Constraints:
    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
 */