impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {
        let mut charCount = Vec::<i32>::new();
        for i in 0..26 {
            charCount.push(0);
        }

        for ch in s.chars() {
            let chi = ch as usize;
            charCount[chi - 97] += 1;
        }

        for ch in t.chars() {
            let chi = ch as usize;
            charCount[chi - 97] -= 1;
        }
        for i in 0..26 {
            if charCount[i] != 0 {
                return false;
            }
        }

        return true;
    }
}
