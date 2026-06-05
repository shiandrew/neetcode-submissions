class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = [[False for _ in range(len(grid[0]))] for _ in range(len(grid))]
        count = 0
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def dfs(r, c):
            if not 0 <= r < len(grid) or not 0 <= c < len(grid[0]) or visited[r][c]:
                return
            if grid[r][c] == "1":
                visited[r][c] = True
                for dr, dc in directions:
                    dfs(r + dr, c + dc)

        for r in range(len(grid)):        
            for c in range(len(grid[0])):
                if grid[r][c] == "1" and not visited[r][c]:
                    dfs(r, c)
                    count += 1
        return count
