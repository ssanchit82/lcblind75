public class _13_LongestSubStringCharReplacement {
    private static int[] alphabetFrequency = new int[26];

    public static int characterReplacement(String s, int k) {
        if (s.length()==1)
            return 1;

        int left=0, right=0;
        char c = s.charAt(right);
        alphabetFrequency[c-65] = 0;
        int result = 1;

        while (right < s.length()) {
            c = s.charAt(right);
            alphabetFrequency[c-65]++;

            int lengthOfWindow = right-left+1;

            if (lengthOfWindow - maxFrequency() <= k) {
                right++;
                result = Math.max(result, lengthOfWindow);
            }
            else {
                alphabetFrequency[s.charAt(left)-65]--;
                left++;
                right++;
            }
        }

        return result;
    }

    private static int maxFrequency () {
        int max=0;

        for (int i=0; i<alphabetFrequency.length; i++) {
            max = Math.max(max, alphabetFrequency[i]);
        }

        return max;
    }
}

/*
Constraints:
    1 <= s.length <= 105
    s consists of only uppercase English letters.
    0 <= k <= s.length
 */
