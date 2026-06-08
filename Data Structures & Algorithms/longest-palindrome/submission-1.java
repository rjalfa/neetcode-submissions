class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[26];
        int[] ucnt = new int[26];
        
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') cnt[ch - 'a'] ++;
            else ucnt[ch - 'A'] ++;
            
        }
        int ans = 0;
        boolean has_extra = false;
        for (int i = 0; i < 26; i ++) {
            if (cnt[i] % 2 == 0) ans += cnt[i];
            else {
                ans += cnt[i] - 1;
                has_extra = true;
            }
            if (ucnt[i] % 2 == 0) ans += ucnt[i];
            else {
                ans += ucnt[i] - 1;
                has_extra = true;
            }

        }
        return ans + (has_extra ? 1 : 0);
    }
}