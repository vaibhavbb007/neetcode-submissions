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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if(root != null){
            queue.add(root);
        }
        List<List<Integer>> listOut = new ArrayList<>();
        if(root == null){
            return listOut;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        listOut.add(temp);
        while(!queue.isEmpty()){
            List<Integer> listIn = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.removeFirst();
                if(node.left!=null){
                    queue.add(node.left);
                    listIn.add(node.left.val);
                }
                if(node.right!=null){
                    queue.add(node.right);
                    listIn.add(node.right.val);
                }
            }
            if(!listIn.isEmpty()){
                listOut.add(listIn);
            }
        }
        return listOut;       
    }
}
