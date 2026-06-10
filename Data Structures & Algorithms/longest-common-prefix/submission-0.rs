impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        if strs.len() < 1 {
            return String::new();
        }
        for (i, &ch) in (&strs[0]).as_bytes().iter().enumerate() {
            for s in &strs[1..] {
                if i >= s.len() || s.as_bytes()[i] != ch {
                    return String::from(&strs[0][0..i]);
                }
            }
        }
        return String::from(&strs[0]);
    }
}
