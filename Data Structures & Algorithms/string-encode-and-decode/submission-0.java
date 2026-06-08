class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int sz = s.length();
            // encode size
            char[] encodedSz = new char[4];
            // Big endian order
            encodedSz[0] = (char)(sz & 0xff000000);
            encodedSz[1] = (char)(sz & 0x00ff0000);
            encodedSz[2] = (char)(sz & 0x0000ff00);
            encodedSz[3] = (char)(sz & 0x000000ff);
            sb.append(new String(encodedSz));
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int k = 0;
        List<String> ans = new ArrayList<>();
        while (k < str.length()) {
            // Read 4 bytes
            int sz = (str.charAt(k) << 24) + (str.charAt(k + 1) << 16) + (str.charAt(k + 2) << 8) + str.charAt(k + 3);
            k += 4;
            // Read sz bytes from data;
            ans.add(str.substring(k, k + sz));
            k += sz;
        }
        return ans;
    }
}
