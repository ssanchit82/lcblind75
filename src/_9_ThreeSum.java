import java.util.*;

public class _9_ThreeSum {
    private static List<List<Integer>> result;
    private static Set<List<Integer>> triplet;
    private static int[] array;

    public static List<List<Integer>> threeSum(int[] nums) {
        result = new ArrayList<>();
        triplet = new HashSet<>();

        array = nums;

        for (int i=0; i<nums.length; i++) {
            int target = -nums[i];

            if (i+1 < nums.length-1)
                twoSum(target, i+1);
        }

        result.addAll(triplet);
        return result;
    }

    private static void twoSum (int target, int start) {
        Map<Integer, Integer> complementMap = new HashMap<>();

        for (int i=start; i<array.length; i++) {
            int complement = target - array[i];

            if (complementMap.containsKey(array[i]))
            {
                List<Integer> list = Arrays.asList(-target, complementMap.get(array[i]), array[i]);
                Collections.sort(list);
                triplet.add(list);
            }
            else
                complementMap.put(complement, array[i]);
        }
    }

    //two pointer solution - O(N2), O(K)
    public static List<List<Integer>> threeSumV2(int[] nums) {
        result = new ArrayList<>();
        triplet = new HashSet<>();

        Arrays.sort(nums);

        for (int i=0; i<nums.length-2; i++) {
            if (i==0 || (i>0 && nums[i]!=nums[i-1])) {
                int left = i+1;
                int right = nums.length-1;
                int target = -nums[i];

                while (left < right) {
                    int leftRightSum = nums[left] + nums[right];

                    if (leftRightSum == target) {
                        triplet.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++; right--;
                    }
                    else if (leftRightSum > target)
                        right--;
                    else
                        left++;
                }
            }
        }

        result.addAll(triplet);
        return result;
    }
}

/*
Constraints:
    3 <= nums.length <= 3000
    -105 <= nums[i] <= 105
 */
