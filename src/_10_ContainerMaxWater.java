public class _10_ContainerMaxWater {
    public static int maxArea(int[] height) {
        int left=0, right= height.length-1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, (right-left) * Math.min(height[left], height[right]));

            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return maxArea;
    }
}

/*
Constraints:
    n == height.length
    2 <= n <= 105
    0 <= height[i] <= 104
 */