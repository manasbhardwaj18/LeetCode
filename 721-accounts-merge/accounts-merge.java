class Solution {
    private int[] idMap;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        idMap = new int[n];
        for (int i = 0; i < n; i++) {
            idMap[i] = i;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                Integer id = map.putIfAbsent(account.get(j), i);
                if (id != null) {
                    idMap[getRootParent(i)] = getRootParent(id);
                }
            }
        }
        Map<Integer, List<String>> mergedMap = new HashMap<>(map.size(), 1.0f);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int id = getRootParent(entry.getValue());
            mergedMap.computeIfAbsent(id, (i) -> new ArrayList<>()).add(entry.getKey());
        }
        List<List<String>> mergedAccounts = new ArrayList<>(mergedMap.size());
        for (Map.Entry<Integer, List<String>> entry : mergedMap.entrySet()) {
            String user = accounts.get(entry.getKey()).get(0);
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            emails.add(0, user);
            mergedAccounts.add(emails);
        }
        return mergedAccounts;
    }

    private int getRootParent(int x) {
        if (idMap[x] != x) {
            idMap[x] = getRootParent(idMap[x]);
        }
        return idMap[x];
    }
}