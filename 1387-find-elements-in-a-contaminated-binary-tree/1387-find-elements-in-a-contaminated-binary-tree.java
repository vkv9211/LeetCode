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

 /**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
class FindElements {

    //TreeNode treeNode;
    HashSet<Integer> set = new HashSet<>();


    public FindElements(TreeNode root) {
        findElementUtil(root, 0);
    
       // printTreeNode(treeNode);
    }

    private void findElementUtil(TreeNode root , int value){
        if(null == root ){
            return ;
        }
        root.val = value;
        set.add(value);
        findElementUtil(root.left, 2*value+1);
        findElementUtil(root.right, 2*value+2);
    }

    private void printTreeNode(TreeNode node){
        if(node == null){
            System.out.print(" null ");
            return ;
        }
        System.out.print(node.val+" ");
        printTreeNode(node.left);
        printTreeNode(node.right);
    }
    
    public boolean find(int target) {
       
        return set.contains(target);
      
    }

    

   
}

