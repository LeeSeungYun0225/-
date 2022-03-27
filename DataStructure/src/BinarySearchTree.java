
public class BinarySearchTree extends List_Tree { // ���� Ž�� Ʈ��, ���� Ʈ��(���Ḯ��Ʈ��)�� ��ӹ޴´�. 	
	 // ���� Ž�� Ʈ���� �������� ���� ���� �ſ� ȿ�������� �����͸� Ž���� �� �ִٴ� ������ ���´�. 

	
	public void BSTMakeAndInit(TreeNode node) // BST�� ������ �ʱ�ȭ �޼ҵ� 
	{
		node.next = null;
		node.prev = null;
		node.data = '.';
		node.key = -999;
	}
	
	public void BSTInsert(TreeNode root,int key,Object data) // BST�� �� ��� �߰�, ������ ���� , ��� ���������� ���Ե� 
	{
		TreeNode parent = null;
		TreeNode newnode = null;
		TreeNode current = root;
		
		// �� ����� ������ ��ġ ã�� ���� while��, while�� Ż�� ��, ���ԵǴ� ���� parent�� �����Ų��. 
		while(current != null)
		{
			if(key == getKey(current)) // �ߺ��� Ű��� ������ �ߴ��Ѵ�. (Ű�� ���ϼ� ����)
			{
				return;
			}
			
			
			parent = current;
			
			if(getKey(current) > key) // ���� ��庸�� ���� Ű�� ��쿡 
			{
				current =current.prev; //current = getLeftSubTree(current);
				
			}
			else // ���� ��庸�� ū Ű�� ��쿡,
			{
				current = current.next;
			}
		}
		
		newnode = new TreeNode(key,data);
		
		if(parent != null) // �����Ϸ��� ��尡 ��Ʈ ��尡 �ƴ� ���
		{
			if(parent.key > key) 
			{
				chainLeftSubTree(parent,newnode);
			}
			else
			{
				chainRightSubTree(parent,newnode);
			}
		}
		else // ��Ʈ ��带 ó�� ������ ��� 
		{
			root = newnode;
		}
		
	}
	
	
	
	public TreeNode BSTSearch(TreeNode node,int targetKey) // BST���� Ÿ�� Ű�� Ž���ϴ� �޼ҵ� 
	{
		TreeNode current = node;
		
		while(current !=null) // current�� null�� �Ǿ� Ż���ϴ� ��� >> �ش� Ű�� �������� ������ �ǹ� 
		{
			if(targetKey == current.key) // Ű�� ã���� 
			{
				return current; // �ش� ��� ��ȯ 
			}
			else if(targetKey < current.key) // ã�� Ű�� ���ݳ���� Ű���� ������ 
			{
				current  = current.prev; // ���� ���� 
			}
			else
			{
				current = current.next; // ���� ���� 
			}
		}
		
		return null; // �ش� Ű�� ����Ǿ� ���� �ʴ�.  
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


