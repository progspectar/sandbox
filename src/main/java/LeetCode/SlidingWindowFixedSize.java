package LeetCode;

import java.util.HashSet;

public class SlidingWindowFixedSize {

    // Check if array contains a pair of duplicate values,
    // where the two duplicates are no farther than k positions from 
    // eachother (i.e. arr[i] == arr[j] and abs(i - j) + 1 <= k).
    // O(n * k)
    public static boolean closeDuplicatesBruteForce(int[] nums, int k) {
        for (int L = 0; L < nums.length; L++) {
            for (int R = L + 1; R < Math.min(nums.length, L + k); R++) {
                if (nums[L] == nums[R]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Same problem using sliding window.
    // O(n)
    public static boolean closeDuplicates(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();
        int L = 0;
        for (int R = 0; R < nums.length; R++) {
            if (R - L + 1 > k) {
                window.remove(nums[L]);
                L++;
            }
            if (window.contains(nums[R])) {
                return true;
            }
            window.add(nums[R]);
        }
        return false;
    }

    public static boolean isPalindrome(String word) {
        word = word.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int L = 0, R = word.length() - 1;
        char[] charArray = word.toCharArray();
        while (L < R) {
            if (charArray[L] != charArray[R]) {
                return false;
            }
            L++;
            R--;
        }
        return true;
    }

    static int maxArea(int[] height) {
        int left, currMax, currIdx = currMax = left = 0;
        int leftMax = 0, rightMax = 0, maxArea = 0;
        int right = height.length - 1;
        while (left < right) {
            currMax = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(currMax, maxArea);
            if (height[left] < height[right]) {
                currIdx = left;
                while (left < right && height[currIdx] >= height[left]) {
                    left++;
                }
            } else {
                currIdx = right;
                while (left < right && height[currIdx] >= height[right]) {
                    right--;
                }
            }
        }
        return maxArea;
    }

    public static int trap(int[] height) {
        int leftMax, rightMax, left, res = left = rightMax = leftMax = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) { // Can contain water
                    res += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else { // height[right] >= height[left]

                if (height[right] < rightMax) { // Can contain water
                    res += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return res;
    }

    static String mergeStrings(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        byte len1 = (byte) word1.length();
        byte len2 = (byte) word2.length();
        byte min = (byte) Math.min(len1, len2);
        for (byte i = 0; i < min; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (len1 > min) {
            sb.append(word1, min, len1);
        }
        if (len2 > min) {
            sb.append(word2, min, len2);
        }
        return sb.toString();
    }

    static public boolean isEven(int num) {
        int counter = 0;
        while (num != 0) {
            int digit = num % 10;
            num = num / 10;
            counter++;
        }
        return (counter & 1) == 0;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        // int[] nums = {1, 1, 0, 1, 1, 1,1,0,0,1,1,1,};
        //int[] nums = {0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0};
        int[] nums = {0, 0};
        System.out.println(findMaxConsecutiveOnes(nums));

//        int k = 3;
//        boolean res = closeDuplicates(nums, k);
//        System.out.println(res);
//        String s = "A man, a plan, a canal: Panama";
//        res = isPalindrome(s);
//        //int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        System.out.println(trap(height));
//        String word1 = "abcd", word2 = "pq";
//
//        System.out.println(mergeStrings(word1, word2));
    }
}