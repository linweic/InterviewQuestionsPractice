public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preorderHelper(list, root);
        return list;
    }
    private void preorderHelper(List<Integer> list, TreeNode root){
        if(root == null) return;
        list.add(root.val);
        preorderHelper(list,root.left);
        preorderHelper(list, root.right);
        return;
    }
}