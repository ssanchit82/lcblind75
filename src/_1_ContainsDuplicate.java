import java.util.HashSet;
import java.util.Set;

public class _1_ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> dups = new HashSet<>();

        for (int num : nums) {
            if (dups.contains(num))
                return true;
            dups.add(num);
        }

        return false;
    }
}

/*
Constraints:
    1 <= nums.length <= 105
    -10^9 <= nums[i] <= 10^9
 */