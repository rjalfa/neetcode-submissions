class Solution {
public:
    int appendCharacters(string s, string t) {
        int m = 0;
        int n = 0;
        while (m < s.size() && n < t.size()) {
            if (s[m] == t[n]) {
                n ++;
            }
            m ++;
        }
        if (n == t.size()) {
            return 0;
        } else return (t.size() - n);
    }
};