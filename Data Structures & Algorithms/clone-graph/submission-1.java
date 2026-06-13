/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> nodeToClone = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (nodeToClone.containsKey(node)) {
            return nodeToClone.get(node);
        }
        if (node == null) {
            return null;
        }
        
        Node clone = new Node(node.val);
        nodeToClone.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        nodeToClone.put(node, clone);
        return clone;
    }
}