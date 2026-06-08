class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) sb.append(ch);
            else if (ch >= 'A' && ch <= 'Z') sb.append((char)(ch - 'A' + 'a'));
        }
        s = sb.toString();

        for (int i = 0; i < s.length() / 2; i ++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}
