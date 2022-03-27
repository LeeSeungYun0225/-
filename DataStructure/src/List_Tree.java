 
public class List_Tree {

	List_Tree()
	{}

	
	public Object getData(TreeNode node) // ������ ��ȯ 
	{
		return node.data;
	}
	
	public int getKey(TreeNode node) // Ű ��ȯ 
	{
		return node.key;
	}
	
	public void setData(TreeNode node, char in) // ������ ����
	{
		node.data = in;
	}
	
	public TreeNode getLeftSubTree(TreeNode node) // ���� ����Ʈ�� ��ȯ
	{
		return node.prev;
	}
	
	public TreeNode getRightSubTree(TreeNode node) // ������ ����Ʈ�� ��ȯ
	{
		return node.next;
	}
	
	
	
	
	public void chainLeftSubTree(TreeNode node,TreeNode subnode) // ���� ����Ʈ�� ���� 
	{
		node.prev = subnode;
	}
	
	public void chainRightSubTree(TreeNode node,TreeNode subnode) // ������ ����Ʈ�� ���� 
	{
		node.next = subnode;
	}
	
	
	public void InorderTraverse(TreeNode node)  // ������ȸ ,
	{
		
		if(getLeftSubTree(node) != null)
		{
			InorderTraverse(getLeftSubTree(node));
		}
		
		System.out.print(node.data + "");
		if(getRightSubTree(node) != null)
		{
			InorderTraverse(getLeftSubTree(node));
		}
		
	}
	
	public void PreorderTraverse(TreeNode node) // ���� ��ȸ,
	{
		System.out.print(node.data + "");
		if(getLeftSubTree(node) != null)
		{
			PreorderTraverse(getLeftSubTree(node));
		}
		if(getRightSubTree(node) != null)
		{
			PreorderTraverse(getLeftSubTree(node));
		}
	}
	
	public void PostorderTraverse(TreeNode node) // ������ȸ 
	{
		if(getLeftSubTree(node) != null)
		{
			PostorderTraverse(getLeftSubTree(node));
		}
		if(getRightSubTree(node) != null)
		{
			PostorderTraverse(getLeftSubTree(node));
		}
		System.out.print(node.data 	+ "");
	}

}


/*List_Tree<String> root = new List_Tree<String>();
		List_Tree<String> t1 = new List_Tree<String>();
		
		
		List_Tree<String> t2 = new List_Tree<String>();
		List_Tree<String> t3 = new List_Tree<String>();
		List_Tree<String> t4 = new List_Tree<String>();
		List_Tree<String> t5 = new List_Tree<String>();
		List_Tree<String> t6 = new List_Tree<String>();
		
		root.chainLeftSubTree(t1);
		
		root.chainRightSubTree(t2);
		t1.chainLeftSubTree(t3);
		t1.chainRightSubTree(t4);
		t4.chainLeftSubTree(t5);
		t4.chainRightSubTree(t6);
		
		root.setData("-");
		t1.setData("+");
		t2.setData("1");
		
		t3.setData("7");
		t4.setData("*");
		
		t5.setData("4");
		t6.setData("2");
		
		
		//System.out.println("" + root.getLeftSubTree().getLeftSubTree().getData());
		root.InorderTraverse();
		*/
