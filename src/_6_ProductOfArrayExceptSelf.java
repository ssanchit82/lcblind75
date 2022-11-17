public class _6_ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            if (i==0)
                leftProduct[i] = 1;
            else
                leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }

        for (int i=nums.length-1; i>=0; i--) {
            if (i==nums.length-1)
                rightProduct[i] = 1;
            else
                rightProduct[i] = rightProduct[i+1] * nums[i+1];
        }

        int[] result = new int[nums.length];
        for (int i=0; i<nums.length; i++)
            result[i] = leftProduct[i] * rightProduct[i];

        return result;
    }
}

/*
Constraints:
    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */