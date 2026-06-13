class Solution {
    Set<Integer> visit = new HashSet<>();
    List<List<Integer>> adj = new ArrayList<>();

    public int countComponents(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visit.contains(i)) {
                count++;
                dfs(i);
            }
        }
        return count;
    }

    private void dfs(int node) {
        if (visit.contains(node)) {
            return;
        }
        visit.add(node);
        for (int neighbor : adj.get(node)) {
            dfs(neighbor);
        }
    }
}
