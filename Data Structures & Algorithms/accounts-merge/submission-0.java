class Solution {

    void dfs(int root, HashMap<Integer, Set<Integer>> adj, Set<Integer> currentEmailSet, List<Boolean> visited) {
        visited.set(root, true);
        currentEmailSet.add(root);
        if (!adj.containsKey(root)) return;
        for (int neighbor : adj.get(root)) {
            if (!visited.get(neighbor)) {
                dfs(neighbor, adj, currentEmailSet, visited);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Find all unique emails and assign them a number.
        HashMap<String, Integer> emailIndex = new HashMap<>();
        HashMap<Integer, String> revEmailIndex = new HashMap<>();
        HashMap<String, String> emailName = new HashMap<>();
        int nextIdx = 0;
        for (var accountRow : accounts) {
            for (int i = 1; i < accountRow.size(); i ++) {
                String email = accountRow.get(i);
                if (!emailIndex.containsKey(email)) {
                    emailIndex.put(email, nextIdx ++);
                }
                emailName.put(email, accountRow.get(0));
            }
        }
        for (var email : emailIndex.keySet()) {
            revEmailIndex.put(emailIndex.get(email), email);
        }
        int totalEmails = nextIdx; // Total nodes in the graph
        // Create edges now
        HashMap<Integer, Set<Integer>> adj = new HashMap<>();
        for (var accountRow : accounts) {
            for (int i = 1; i < accountRow.size(); i ++) {
                String firstEmail = accountRow.get(i);
                int firstEmailIndex = emailIndex.get(firstEmail);
                for (int j = i + 1; j < accountRow.size(); j ++) {
                    String secondEmail = accountRow.get(j);
                    int secondEmailIndex = emailIndex.get(secondEmail);
                if (!adj.containsKey(firstEmailIndex)) {
                    adj.put(firstEmailIndex, new HashSet<Integer>());
                }
                if (!adj.containsKey(secondEmailIndex)) {
                    adj.put(secondEmailIndex, new HashSet<Integer>());
                }
                adj.get(firstEmailIndex).add(secondEmailIndex);
                adj.get(secondEmailIndex).add(firstEmailIndex);
                }
            }
        }
    List<Set<Integer>> emailSets = new ArrayList<>();
    List<Boolean> visited = new ArrayList<Boolean>(totalEmails);
    for (int i = 0; i < totalEmails; i ++) visited.add(false);
    for (int i = 0; i < totalEmails; i ++) {
        if (!visited.get(i)) {
            Set<Integer> currentEmailSet = new HashSet<Integer>();
            dfs(i, adj, currentEmailSet, visited);
            emailSets.add(currentEmailSet);
        }
    }

    // emailSets now contain set of emails that have the same email
    List<List<String>> ans = new ArrayList<>();
    for (var emailSet : emailSets) {
        TreeSet<String> emailAddrs = new TreeSet<>();
        for (int idx : emailSet) emailAddrs.add(revEmailIndex.get(idx));
        List<String> emails = new ArrayList<>(emailAddrs);
        emails.add(0, emailName.get(emails.get(0)));
        ans.add(emails);
    }

    return ans;
    }
}