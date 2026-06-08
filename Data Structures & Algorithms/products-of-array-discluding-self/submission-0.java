class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixMul = new int[n];
        int[] suffixMul = new int[n];
        int[] ansMul = new int[n];

        prefixMul[0] = nums[0];
        for (int i = 1; i < n; i ++) {
            prefixMul[i] = nums[i] * prefixMul[i - 1];
        }

        suffixMul[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i --) {
            suffixMul[i] = nums[i] * suffixMul[i + 1];
        }

        ansMul[0] = suffixMul[1];
        ansMul[n - 1] = prefixMul[n - 2];
        for (int i = 1; i + 1 < n; i ++) {
            ansMul[i] = prefixMul[i-1] * suffixMul[i+1];
        }
        return ansMul;
    }
}  
