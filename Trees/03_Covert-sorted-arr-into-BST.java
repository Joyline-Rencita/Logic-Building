class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor
    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    // Helper method using recursion (like the lambda in C++)
    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;
        TreeNode left = dfs(nums, l, mid - 1);
        TreeNode right = dfs(nums, mid + 1, r);
        return new TreeNode(nums[mid], left, right);
    }

    // Optional: in-order traversal to test the tree
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    // Main method to run
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode bstRoot = solution.sortedArrayToBST(nums);

        System.out.println("In-order traversal of constructed BST:");
        solution.inOrder(bstRoot);
    }
}
