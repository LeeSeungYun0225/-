
public class BinarySearchTree extends List_Tree { // ���� Ž�� Ʈ��, ���� Ʈ��(���Ḯ��Ʈ��)�� ��ӹ޴´�. 	
	 // ���� Ž�� Ʈ���� �������� ���� ���� �ſ� ȿ�������� �����͸� Ž���� �� �ִٴ� ������ ���´�. 
	
	TreeNode root = new TreeNode();
	
	public BinarySearchTree()
	{
		root =null;
	}
	

	public void BSTInsert(int key,Object data) // BST�� �� ��� �߰�, ������ ���� , ��� ���������� ���Ե� 
	{
		
		TreeNode newnode = new TreeNode(key,data);
		
		if(root==null)
		{
			root = newnode;
			return;
		}
		
		TreeNode parent = null;
		TreeNode current = root;
		
	
		// �� ����� ������ ��ġ ã�� ���� while��, while�� Ż�� ��, ���ԵǴ� ���� parent�� �����Ų��. 
		while(current != null)
		{ 
			if(key == current.getKey()) // �ߺ��� Ű��� ������ �ߴ��Ѵ�. (Ű�� ���ϼ� ����)
			{
				return;
			}
			
			
			parent = current;
			
			if(current.getKey() > key) // ���� ��庸�� ���� Ű�� ��쿡 
			{
				
				current = current.getLeftSubTree();

			}
			else // ���� ��庸�� ū Ű�� ��쿡,
			{
				current = current.getRightSubTree();

			}
		}
		
	
		if(parent.key > key) 
		{
			parent.chainLeftSubTree(newnode);
		}
		else
		{
			parent.chainRightSubTree(newnode);
		}
	}


		
	
	
	
	public boolean BSTSearch(int targetKey) // BST���� Ÿ�� Ű�� Ž���ϴ� �޼ҵ� 
	{
		TreeNode current = root;
		
		while(current !=null) // current�� null�� �Ǿ� Ż���ϴ� ��� >> �ش� Ű�� �������� ������ �ǹ� 
		{
			if(targetKey == current.key) // Ű�� ã���� 
			{
				return true; // �ش� ��� ��ȯ 
			}
			else if(targetKey < current.key) // ã�� Ű�� ���ݳ���� Ű���� ������ 
			{
				current = current.getLeftSubTree();// ���� ���� 
			}
			else
			{
				current = current.getRightSubTree(); // ���� ���� 
			}
		}
		
		return false; // �ش� Ű�� ����Ǿ� ���� �ʴ�.  
	}
	
	
	
	
	public TreeNode BSTRemove(int targetKey)
	{

		TreeNode parent = null;
		TreeNode current = root;
		TreeNode deleteTarget;
		
		while(current !=null && current.getKey() != targetKey) // Ÿ���� ã�� ���� 
		{
			parent = current;
			
			if(targetKey < current.getKey()) // Ÿ���� ���� Ű���� ���� ��� 
			{
				current= current.getLeftSubTree(); // �������� �̵� 
			}
			else // Ÿ���� ���� Ű���� Ŭ ��� 
			{
				current = current.getRightSubTree(); // ���������� �̵� 
			}
		}
		
		
		if(current == null) // Ž�� ���� 
		{
			return null;
		}
		
		// ���� Ž�� ���� ���� // 
		deleteTarget = current;
		
		//// ���� ����� �ܸ� ����� �� ////
		if(deleteTarget.getLeftSubTree() == null && deleteTarget.getRightSubTree() == null)
		{
			if(parent.getLeftSubTree() == deleteTarget) // �θ��� ���� ����Ʈ���� ���� ����� �� 
			{
				parent.prev= null;
			}
			else // �θ��� ���� ����Ʈ���� ���� ����� �� 
			{
				parent.next = null;
			}
		}
		/// ��������� �ϳ��� �ڽ� ��带 ���� �� /// 
		else if(deleteTarget.getLeftSubTree() == null || deleteTarget.getRightSubTree() == null)
		{
			TreeNode subTarget; // ���� ����� �ڽ��� ����ų Ʈ�� ��� 
			
			if(deleteTarget.getLeftSubTree() == null) // ���� ����� ������ ����Ʈ���� ���� ��, 
			{
				subTarget = deleteTarget.getRightSubTree(); // subTarget ������ ������ ����Ʈ�� ���� 
			}
			else
			{
				subTarget = deleteTarget.getLeftSubTree();
			}
			
			if(parent.getLeftSubTree() == deleteTarget) // ���� ����� �θ� ����� ���� ����Ʈ����, 
			{
				parent.prev = subTarget;
			
			}
			else
			{
				parent.next = subTarget;
			}
		}
		
		/// ���� ����� �ΰ��� �ڽ� ��带 ���� �� ///
		else
		{
		
			TreeNode tempNode = deleteTarget.getRightSubTree();
			TreeNode temp2Node = deleteTarget;
			Object deleteData = deleteTarget.data;
			
			while(tempNode.getLeftSubTree() != null) // ������� Ű�� �ִ� ��� ��� ���� �� ��带 Ž���Ѵ� . 
			{
				temp2Node = tempNode;
				tempNode = tempNode.getLeftSubTree();
				
			}
			
			deleteTarget.setData(tempNode.getData()); // �� �ϴ� ��(���� Ű�� ��ü�ϱ� ���� ��)�� ������ �����Ѵ�.
			deleteTarget.setKey(tempNode.getKey());
			
			if(temp2Node.getLeftSubTree() == tempNode) // ��ü�Ǿ� ��� ���� �ʴ� ���� ��带 ������, ������ ��忡 ���� ����Ʈ���� �� �θ���� �����ϴ� ���� 
			{
				temp2Node.prev = tempNode.next;
			}
			else
			{
				temp2Node.next = tempNode.next;
			
			}
			
			deleteTarget = tempNode;
			deleteTarget.setData(deleteData);
			deleteTarget.setKey(targetKey);
			
			
		}
		
	
		
		return deleteTarget;
	}
	
	public void BSTShowAll()
	{
		InorderTraverse(root);
	}
	

}



/* ����Ŭ���� �׽�Ʈ�� ���� 
 * BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode();
		bst.BSTMakeAndInit(root);
		
		bst.BSTInsert(root, 9, "9");
		bst.BSTInsert(root, 1, "1");
		bst.BSTInsert(root, 6, "6");
		bst.BSTInsert(root, 2, "2");
		bst.BSTInsert(root, 8, "8");
		bst.BSTInsert(root, 3, "3");
		bst.BSTInsert(root, 5, "5");
		
		TreeNode search;
		
		search = bst.BSTSearch(root, 1);
		
		if(search == null)
		{
			System.out.println("Ž�� ����");
		}
		else
		{
			System.out.println("Ű �� "+ search.key + "�� ã�ҽ��ϴ�.");
		}
		
		search = bst.BSTSearch(root, 4);
		
		if(search == null)
		{
			System.out.println("Ž�� ����");
		}
		else
		{
			System.out.println("Ű �� "+ search.key + "�� ã�ҽ��ϴ�.");
		}
		
		search = bst.BSTSearch(root, 6);
		
		if(search == null)
		{
			System.out.println("Ž�� ����");
		}
		else
		{
			System.out.println("Ű �� "+ search.key + "�� ã�ҽ��ϴ�.");
		}
		search = bst.BSTSearch(root, 7);
		
		if(search == null)
		{
			System.out.println("Ž�� ����");
		}
		else
		{
			System.out.println("Ű �� "+ search.key + "�� ã�ҽ��ϴ�.");
		}
		
		*/


