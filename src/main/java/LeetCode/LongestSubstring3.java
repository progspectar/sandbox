package LeetCode;

import java.util.HashMap;

class LongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubstring3 str = new LongestSubstring3();
        System.out.println(str.lengthOfLongestSubstring("pwwkew"));
    }
}