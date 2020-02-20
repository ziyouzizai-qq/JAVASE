package designmode.structure.composite;

/**
 * 树
 * @author 王浩
 *
 */
public class Tree {

	// 根节点
	private TreeNode root = null;
	
	/**
	 * 构造器
	 * @param name 根节点名称
	 */
	public Tree(String name) {  
        root = new TreeNode(name);  
    }

	public TreeNode getRoot() {
		return root;
	}
	
	
}
