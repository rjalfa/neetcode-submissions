class Solution {
    public int maxProfit(int[] prices) {
        int[] prefixMin = new int[prices.length];
        prefixMin[0] = prices[0];
        for (int i = 1; i < prices.length; i ++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], prices[i]);
        }
        int best = 0;
        for (int i = 1; i < prices.length; i ++) {
            best = Math.max(best, prices[i] - prefixMin[i - 1]);
        }
        return best;
    }
}
