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

    TreeNode treeNode;


    public FindElements(TreeNode root) {
        if(root == null){
            treeNode= new TreeNode(0);
            return ;
        }

        FindElementsUtil(root , root.left);
        FindElementsUtil(root , root.right);
        treeNode = root;
       // printTreeNode(treeNode);
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
        return findUtil(this.treeNode, target);

       //return false;
    }

    private boolean findUtil(TreeNode root, int target){
        if(root == null){
            return false;
        }
        if(root.val == target){
            return true;
        }

        return findUtil(root.left,target) || findUtil(root.right,target);

    }

    private void FindElementsUtil(TreeNode parent, TreeNode child){
        if(child == null){
            return ;
        }
        if(parent.val ==-1){
            parent.val = 0;
        }
        if(child == parent.left){
            child.val = 2*parent.val + 1;
        }
        if(child == parent.right){
            child.val = 2*parent.val + 2;
        }
        FindElementsUtil(child, child.left);
        FindElementsUtil(child, child.right);
    }
}

