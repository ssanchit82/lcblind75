import java.util.*;

public class _4_GroupAnagrams {
    private static Map<String, List<String>> anagramsMap;

    public static List<List<String>> groupAnagrams(String[] strs) {
        anagramsMap = new HashMap<>();

        for (String str : strs) {
            String wordKey = getWordKey(str);

            if (anagramsMap.containsKey(wordKey)) {
                List<String> list = anagramsMap.get(wordKey);
                list.add(str);
                anagramsMap.put(wordKey, list);
            }
            else {
                anagramsMap.put(wordKey, new ArrayList<>(Arrays.asList(str)));
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : anagramsMap.keySet())
            result.add(anagramsMap.get(key));

        return result;
    }

    private static String getWordKey (String str) {
        StringBuilder sb = new StringBuilder();

        int[] letterFrequency = new int[26];
        Arrays.fill(letterFrequency, 0);

        for (char c : str.toCharArray())
            letterFrequency[c-'a']++;

        for (int frequency : letterFrequency)
            sb.append(frequency).append("#");

        return sb.toString();
    }
}

/*
Constraints:
    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.
 */