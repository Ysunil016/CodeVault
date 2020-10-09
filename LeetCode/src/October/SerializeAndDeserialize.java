package October;

import java.util.HashMap;

public class SerializeAndDeserialize {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(100);
        r.left = new TreeNode(50);
        r.right = new TreeNode(200);

        System.out.println(serialize(r));
    }

    // Encodes a tree to a single string.
    static StringBuilder sb = new StringBuilder();
    public static HashMap<String,TreeNode> map = new HashMap<>();

    private static void inorder(TreeNode root)
    {
        if(root==null) return;
        sb.append(String.valueOf(root.val));
        sb.append(" ");
        inorder(root.left);
        inorder(root.right);
    }


    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        inorder(root);
        map.put(sb.toString().trim(),root);
        return sb.toString().trim();
    }

    public TreeNode deserialize(String data) {
        return map.get(data);
    }
}
