Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 
Constraints:

1 <= preorder.length <= 3000   inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values. Each value of inorder also appears in preorder. preorder is guaranteed to be the preorder traversal of the tree. inorder is guaranteed to be the inorder traversal of the tree.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int[] preorder;
    private Map<Integer, Integer> d = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        this.preorder = preorder;
        for (int i = 0; i < n; ++i) {
            d.put(inorder[i], i);
        }
        return dfs(0, 0, n);
    }

    private TreeNode dfs(int i, int j, int n) {
        if (n <= 0) {
            return null;
        }
        int v = preorder[i];
        int k = d.get(v);
        TreeNode l = dfs(i + 1, j, k - j);
        TreeNode r = dfs(i + 1 + k - j, k + 1, n - 1 - (k - j));
        return new TreeNode(v, l, r);
    }
}

********************************************************************************************************************

class Solution {
    private List<Integer> preorder;
    private Map<Integer, List<Integer>> d = new HashMap<>();

    public List<TreeNode> getBinaryTrees(List<Integer> preOrder, List<Integer> inOrder) {
        int n = preOrder.size();
        this.preorder = preOrder;
        for (int i = 0; i < n; ++i) {
            d.computeIfAbsent(inOrder.get(i), k -> new ArrayList<>()).add(i);
        }
        return dfs(0, 0, n);
    }

    private List<TreeNode> dfs(int i, int j, int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n <= 0) {
            ans.add(null);
            return ans;
        }
        int v = preorder.get(i);
        for (int k : d.get(v)) {
            if (k >= j && k < j + n) {
                for (TreeNode l : dfs(i + 1, j, k - j)) {
                    for (TreeNode r : dfs(i + 1 + k - j, k + 1, n - 1 - (k - j))) {
                        ans.add(new TreeNode(v, l, r));
                    }
                }
            }
        }
        return ans;
    }
}
