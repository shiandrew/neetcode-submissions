"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node == None:
            return None
        clonedMap = {}
        def clone(n: Optional['Node']):
            if n in clonedMap:
                return
            
            cloned = Node(n.val, [])
            clonedMap[n] = cloned
            for nbr in n.neighbors:
                clone(nbr)

        def convertNeighbor(n: Optional['Node']):
            if clonedMap[n].neighbors != []:
                return
            for nbr in n.neighbors:
                clonedMap[n].neighbors.append(clonedMap[nbr])
                convertNeighbor(nbr)

        clone(node)
        convertNeighbor(node)
        return clonedMap[node]

        
