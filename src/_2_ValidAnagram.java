import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _2_ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        char[] sCArray = s.toCharArray();
        char[] tCArray = t.toCharArray();

        Arrays.sort(sCArray);
        Arrays.sort(tCArray);

        return Arrays.equals(sCArray, tCArray);
    }

    // no sorting
    public static boolean isAnagramV2 (String s, String t) {
        Map<Character, Integer> anagramMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (anagramMap.containsKey(c))
                anagramMap.put(c, anagramMap.get(c)+1);
            else
                anagramMap.put(c, 1);
        }

        for (char c : t.toCharArray()) {

        }

        return true;
    }
}

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
Constraints:
    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.
 */
