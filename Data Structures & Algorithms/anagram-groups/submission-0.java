class Solution {
    String sortedString(String a) {
        char[] ch = a.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> all = new HashMap<>();
        for (String s : strs) {
            String sortedS = sortedString(s);
            if (all.containsKey(sortedS)) {
                all.get(sortedS).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                all.put(sortedS, newList);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : all.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
