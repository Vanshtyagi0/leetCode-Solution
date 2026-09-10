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
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);

        return count;
    }
    private int[] helper(TreeNode node){
        if(node == null){
            return new int[]{0, 0};
        }

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        
        int total = left[1] + right[1] + node.val;
        int n = left[0] + right[0] + 1;

        if(n != 0 && total / n == node.val) count++;

        return new int[]{n, total};
    } 
}