impl Solution {
    pub fn has_duplicate(nums: Vec<i32>) -> bool {
        let mut allNums = std::collections::HashSet::<i32>::new();
        for &num in &nums {
            if allNums.contains(&num) {
                return true;
            }
            allNums.insert(num);
        }
        return false;
    }
}
