package LeetCode;

public class MaximumAverageSubarray643 {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        int next = maxSum;
        for (int i = k; i < nums.length; i++) {
            maxSum += nums[i] - nums[i - k];
            next = Math.max(maxSum, next);
        }
        return (double ) next / k;
    }

    public static void main(String[] args) {
        int[] arr = {1, 12, -5, -6, 50, 3};
        MaximumAverageSubarray643 subar = new MaximumAverageSubarray643();
        double res = subar.findMaxAverage(arr, 4);
        System.out.println(res);
        //12.75

    }
}
