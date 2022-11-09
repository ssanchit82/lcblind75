import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _5_TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            if (frequencyMap.containsKey(num))
                frequencyMap.put(num, frequencyMap.get(num)+1);
            else
                frequencyMap.put(num, 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (m1,m2) -> (m1.getValue()-m2.getValue())
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.add(entry);

            if (minHeap.size() > k)
                minHeap.poll();
        }

        int[] result = new int[k];
        int index=0;

        while (!minHeap.isEmpty())
            result[index++] = minHeap.poll().getKey();

        return result;
    }
}

/*
Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.
 */
