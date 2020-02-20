package designmode.structure.composite;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Vector;

/**
 * 组合模式测试
 * 
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		Tree tree = new Tree("A");
		TreeNode nodeB1 = new TreeNode("B1");
		TreeNode nodeB2 = new TreeNode("B2");
		TreeNode nodeC = new TreeNode("C");
		// B1节点放子节点
		nodeB1.add(nodeC);
		// 给根节点放两个子节点
		tree.getRoot().add(nodeB1);
		tree.getRoot().add(nodeB2);
		System.out.println("build the tree finished!");
		
        TreeNode contanier = null;
		// 遍历子节点
		findChildrenByName(contanier, "C",tree.getRoot());
		System.out.println(contanier);
		if (contanier != null) {
			System.out.println(contanier.getName());
		}

//		TreeNode node = tree.getRoot().getChildren().nextElement().getChildren().nextElement();
//		System.out.println(node.getName());
	}
	
	/**
	 * 根据节点名称来检索整个树
	 * @param name 节点名称
	 * @param parent 检索的父节点
	 * @return
	 */
	public static void findChildrenByName(TreeNode contanier, String name, TreeNode parent) {
		if (name == null || parent == null) {
			return;
		}
		// 获取所有的子节集
		Enumeration<TreeNode> children = parent.getChildren();
		// 遍历子节点
		while(children.hasMoreElements()){
//			if (contanier != null) {
//				return;
//			}
			// 获取下一个子节点
			TreeNode node = children.nextElement();
			if (name.equals(node.getName())) {
				// 递归无法强制退出
				contanier = node;
			} else {
				findChildrenByName(contanier, name, node);
			}
		}
		
	}
}
