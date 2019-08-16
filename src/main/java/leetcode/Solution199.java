package leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * @author zhaojianyin
 * @create 2019-08-15 下午9:03
 */
public class Solution199 {

	//case:[1,2,3,null,5,null,4]

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<Integer> rightSideView(TreeNode root) {
		ArrayList<Integer> list = Lists.newArrayList();
		//
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			while(size-->0){
				TreeNode treeNode = queue.poll();
				if (treeNode.left != null){
					queue.offer(treeNode.left);
				}
				if (treeNode.right != null){
					queue.offer(treeNode.right);
				}
				if (size==0){
					list.add(treeNode.val);
				}

			}
		}
		return list;
	}


	private static TreeNode treeNode(){
		TreeNode root = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		root.left = r2;
		return root;
	}
	public static void main(String[] args) {
		rightSideView(treeNode());
	}
}
