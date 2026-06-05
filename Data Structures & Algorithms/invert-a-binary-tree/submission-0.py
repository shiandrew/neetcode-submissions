# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(node, visited = None):
            if not visited:
                visited = set()

            if not node:
                return

            visited.add(node)

            temp = node.left
            node.left = node.right
            node.right = temp

            if node.left not in visited:
                dfs(node.left, visited)
            if node.right not in visited:
                dfs(node.right, visited)
        
        dfs(root)
        return root