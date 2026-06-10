func numIdenticalPairs(nums []int) int {
    m := make(map[int]int);
    for _, num := range nums {
        oldVal, exists := m[num]
        if !exists {
            m[num] = 1
        } else {
            m[num] = oldVal + 1
        }
    }
    ans := 0;
    for _, freq := range m {
        ans += (freq * (freq - 1)) / 2 
    }
    return ans;
}