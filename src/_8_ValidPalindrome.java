public class _8_ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if (s.length()==1)
            return true;

        int left=0, right=s.length()-1;

        while (left < right) {
            if (isAscii(s.charAt(left)) && isAscii(s.charAt(right))) {
                if (!isEquivalent(s.charAt(left), s.charAt(right)))
                    return false;

                left++;
                right--;
            }
            else {
                if (!isAscii(s.charAt(left))) {
                    left++;
                }

                if (!isAscii(s.charAt(right))) {
                    right--;
                }
            }
        }

        return true;
    }

    private static boolean isEquivalent (char first, char second) {
        if (isUpperCase(first))
            first = (char) (first+32);

        if (isUpperCase(second))
            second = (char) (second+32);

        return first==second;
    }

    private static boolean isUpperCase (char c) {
        return (c>='A' && c<='Z');
    }

    private static boolean isAscii (char c) {
        return ((c>='0' && c<='9') || (c>='A' && c<='Z') || (c>='a' && c<='z'));
    }
}

/*
Constraints:
    1 <= s.length <= 2 * 105
    s consists only of printable ASCII characters.
 */