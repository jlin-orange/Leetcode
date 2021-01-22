package Java;

public class postOrderTraversal {
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    // Postorder = Left, Right, ME
    // Recursive solution
    public List<Integer> postorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        pot(root, answer);
        return answer;
    }
    
    public void pot(Node n, List<Integer> ans) {
        if (n == null) return;
        if (n.children.size() == 0) {
            ans.add(n.val);
            return;
        }
        
        for (Node node : n.children) {
            pot(node, ans);
        }
        ans.add(n.val);
    }
}
