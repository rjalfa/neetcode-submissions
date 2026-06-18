class Solution {
    public int maxProductDifference(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        return a[n - 1] * a[n - 2] - a[1] * a[0];
    }
}