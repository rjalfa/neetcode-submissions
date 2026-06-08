class Solution {
    static class FrequencyUnit implements Comparable<FrequencyUnit> {
        int freq;
        int val;
        
        public FrequencyUnit(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        public void increment() { this.freq ++; }

        public int getVal() { return this.val; }
        public int compareTo(FrequencyUnit other) {
            if (this.freq != other.freq) return this.freq - other.freq;
            return this.val - other.val;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hist = new HashMap<>();
        for (int n : nums) {
            hist.put(n, hist.getOrDefault(n, 0) + 1);
        }
        ArrayList<FrequencyUnit> all = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hist.entrySet()) {
            all.add(new FrequencyUnit(entry.getKey(), entry.getValue()));
        }
        Collections.sort(all, Collections.reverseOrder());
        int[] ans = new int[k];
        for (int i = 0; i < k; i ++) {
            ans[i] = all.get(i).getVal();
        }
        return ans;
    }
}
