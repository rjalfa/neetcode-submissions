impl Solution {
    pub fn replace_elements(arr: Vec<i32>) -> Vec<i32> {
        let mut ans = arr.clone();
        ans[arr.len() - 1] = -1;
        let mut rmax = arr[arr.len() - 1];
        for i in (0..(ans.len()-1)).rev() {
            rmax = max(arr[i+1], rmax);
            ans[i] = rmax;
        }
        return ans;
    }
}
