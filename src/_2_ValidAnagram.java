import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _2_ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())
            return false;

        char[] sCArray = s.toCharArray();
        char[] tCArray = t.toCharArray();

        Arrays.sort(sCArray);
        Arrays.sort(tCArray);

        return Arrays.equals(sCArray, tCArray);
    }

    // no sorting
    public static boolean isAnagramV2 (String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> sourceMap = new HashMap<>();
        buildMap (s, sourceMap);

        Map<Character, Integer> targetMap = new HashMap<>();
        buildMap(t, targetMap);

        for (char c : targetMap.keySet()) {
            if (!sourceMap.containsKey(c) || ((int) sourceMap.get(c) != (int) targetMap.get(c)))
                return false;
        }

        return true;
    }

    private static void buildMap (String s, Map<Character, Integer> map) {
        for (char c : s.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }
    }
}

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
Constraints:
    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.
 */
