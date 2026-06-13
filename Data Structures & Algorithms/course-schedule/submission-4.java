class Solution {
    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> prereq = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for (int i = 0; i < prerequisites.length; i++) {
            prereq.putIfAbsent(prerequisites[i][0], new ArrayList<>());
            prereq.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) {
            return false;
        }
        
        if (!prereq.containsKey(course)) {
            return true;
        }

        visited.add(course);
        for (int i = 0; i < prereq.get(course).size(); i++) {
            if (!dfs(prereq.get(course).get(i))) {
                return false;
            }
        }
        visited.remove(course);
        prereq.remove(course);
        return true;
        
    }
}
