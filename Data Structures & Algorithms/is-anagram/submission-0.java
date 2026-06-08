class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            a[ch - 'a'] ++;
        }
        for (int i = 0; i < t.length(); i ++) {
            char ch = t.charAt(i);
            b[ch - 'a'] ++;
        }
        for (int i = 0; i < 26; i ++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
