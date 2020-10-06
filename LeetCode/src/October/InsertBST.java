package October;

public class InsertBST {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);

        insert(null,root,val);

        return root;
    }

    public void insert(TreeNode parent, TreeNode root,int val){
        if(root==null){
            if(parent.left == null && parent.right == null){
                if(val > parent.val){
                    parent.right = new TreeNode(val);
                }else{
                    parent.left = new TreeNode(val);
                }
            }else if(parent.left == null){
                parent.left = new TreeNode(val);
            }else{
                parent.right = new TreeNode(val);
            }
        }else{
            if(val < root.val ){
                insert(root,root.left,val);
            }else{
                insert(root,root.right,val);
            }
        }
    }
}
