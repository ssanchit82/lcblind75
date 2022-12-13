import java.util.HashSet;
import java.util.Set;

public class _12_LongestSubStringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0 || s.length()==1)
            return s.length();

        int longestSubstring = 1;
        Set<Character> set = new HashSet<>();
        int left=0, right=1;
        set.add(s.charAt(left));

        while (right < s.length()) {
            char c = s.charAt(right);

            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);

            if (set.size() > longestSubstring)
                longestSubstring = set.size();

            right++;
        }

        return longestSubstring;
    }
}

/*
Constraints:
    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
 */