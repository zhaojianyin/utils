package leetcode;

/**
 * @author zhaojianyin
 * @create 2019-08-22 下午9:34
 */
public class Solution617 {


	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		TreeNode treeNode;
		if (t1 == null && t2 == null){
			return null;
		}else if (t1 == null){
			treeNode = new TreeNode(t2.val);
		}else if (t2 == null){
			treeNode = new TreeNode(t1.val);
		}else{
			treeNode = new TreeNode(t1.val + t2.val);
		}
		treeNode.left = mergeTrees(t1 == null ? null : t1.left,t2 == null ? null:t2.left);
		treeNode.right = mergeTrees(t1 == null ? null : t1.right,t2 == null ? null:t2.right);
		return treeNode;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
