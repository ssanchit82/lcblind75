import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _7_LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length==0 || nums.length==1)
            return nums.length;

        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        List<Integer> sequences = new ArrayList<>();
        for (int num : nums) {
            if (!set.contains(num-1))
                sequences.add(num);
        }

        int maxStreak = 1;
        for (int sequence : sequences) {
            int currentStreak = 1;
            int currentNum = sequence;

            while (set.contains(currentNum+1)) {
                currentStreak++;
                currentNum++;
            }

            if (currentStreak > maxStreak)
                maxStreak = currentStreak;
        }

        return maxStreak;
    }
}

/*
Constraints:
    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
 */