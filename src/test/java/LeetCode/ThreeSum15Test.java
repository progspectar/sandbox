package LeetCode;

import java.util.List;

class ThreeSum15Test {
    public static void main(String[] args) {
        int[] inp = {-1,0,1,2,-1,-4};
        int[] inp1 = {-3,1,2};
        int[][] out = {{-1,-1,2},{-1,0,1}};
        List<List<Integer>> out1 = ThreeSum15.threeSum(inp1);
        System.out.println(out1);
    }
}