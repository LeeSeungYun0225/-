
public class AVL extends List_Tree {
	
	
	private TreeNode root = new TreeNode();
	
	public AVL()
	{
		root =null;
	}
	
	public void left(TreeNode node)
	{
		if(node.getLeftSubTree()!= null)
		{
			System.out.println(node.getLeftSubTree().getKey()+" >> left");
		}
	}
	public void right(TreeNode node)
	{
		if(node.getRightSubTree()!= null)
		{
			System.out.println(node.getRightSubTree().getKey()+" >> right");
		}
		
	}
	
	public TreeNode getRoot()
	{
		return root;
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
		
		
		AVLSearch(key);
	}


	public void findParentAndChain(int targetKey,TreeNode newsubTree)
	{
		TreeNode temp = root;
		
		while(true)
		{
			if(targetKey>temp.key)
			{
				if(temp.getRightSubTree().key == targetKey)
				{
					temp.chainRightSubTree(newsubTree);
					return;
				}
				else
				{
					temp = temp.getRightSubTree();
				}
			}
			else
			{
				if(temp.getLeftSubTree().key== targetKey)
				{
					temp.chainLeftSubTree(newsubTree);
					return;
				}
				else
				{
					temp = temp.getLeftSubTree();
				}
			}
		}
	}
		
	public void AVLSearch(int targetKey) // BST���� Ÿ�� Ű�� Ž���ϴ� �޼ҵ� 
	{
		TreeNode current = root;
		TreeNode temp = null;
		int diff;
		
		while(current !=null) 
		{	
			diff = getHeightDiff(current); // ��� ������ Ű�� ã�� �������鼭 �յ��μ� ���̸� ���Ѵ�.
			if(diff>1 || diff <-1) // �ұ����� ������ temp�� �ӽ� �����ϰ�, 
			{
				temp = current;
			}	
			if(targetKey == current.key) // Ű�� ã���� 
			{
				break; //�ߴ� 
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
		if(temp == null) // �ұ����� ������ ã�� ���Ͽ��ٸ� �Լ� ��Ż 
		{
			return;
		}
		current = temp; // Ž���� �������Ƿ� ���ʿ����� current������ ���� 
		
		current = Rebalance(current); // �ұ��� ������ ���� �ϴܿ� ��ġ�� �������� ���뷱�� ���� 
		
		if(temp.key == root.key) // temp�� ���뷱�� ���� �������� ���뷱�� ���۵� ������ ������ ��Ʈ�̸� 
		{
			root=current; // ��Ʈ�� �뷱�� �� �� ��Ʈ�� ����Ű���� ���� 
		}
		else if(temp.key != current.key)// ���뷱�� �Ŀ� ������ �ұ��� ������ current�� ����Ű�� ������ ���Ͽ�����, >> ���뷱���� ���� ����Ǿ��� ��, 
		{
			findParentAndChain(temp.key,current); // ������ temp�� ����Ű�� �θ� ��忡�� �뷱�� �� �� �ڽ� ��带 ����Ű���� �ϴ� �޼ҵ� ȣ�� 
			
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
		
		Rebalance(root);
		
		return deleteTarget;
	}
	
	public void BSTShowAll()
	{
		InorderTraverse(root);
		
		System.out.println("");
	}
	
	public int getHeightDiff(TreeNode node)
	{
		int leftSubtreeHeight;
		int rightSubtreeHeight;
		
		if(node == null)
		{
			return 0;
		}
		
		leftSubtreeHeight = getHeight(node.getLeftSubTree());	
		rightSubtreeHeight = getHeight(node.getRightSubTree());
		return leftSubtreeHeight-rightSubtreeHeight;
	}
	
	
	public TreeNode Rebalance(TreeNode node) // AVL ���뷱�� �޼ҵ� 
	{
		int heightDiff = getHeightDiff(node); // �����μ� �ޱ� 
	
		if(heightDiff>1) // LL or LR���� ���� �ǹ�
		{
			if(getHeightDiff(node.getLeftSubTree())>0) // LL���� �� ���
			{System.out.println("");
				System.out.println("catch LL");
				System.out.println("Ű "+ node.key + "�������� ȸ�� ����");
				node = RotateLL(node);		
			}
			else // LR ������ ��� 
			{System.out.println("");
				System.out.println("catch LR");
				System.out.println("Ű "+ node.key + "�������� ȸ�� ����");
				node = RotateLR(node);
			}

		}
		
		if(heightDiff<-1) // -2������ ��� RR or RL���� 
		{
			if(getHeightDiff(node.getRightSubTree()) < 0 ) // RR 
			{
				System.out.println("Ű "+ node.key + "�������� ȸ�� ����");
				node = RotateRR(node);
				System.out.println("");
				System.out.println("catch RR");
				
			}
			else //RL���� 
			{
				System.out.println("Ű "+ node.key + "�������� ȸ�� ����");
				node = RotateRL(node);
				System.out.println("");
				System.out.println("catch RL");
				
			}
		}
		
		return node;
	}
	
	public int getHeight(TreeNode node) // ����Ʈ�� �� ���� ���̰� ���� ���̽��� ���̸� ��ȯ 
	{
		int leftHeight,rightHeight;
		
		if(node == null)
		{
			return 0;
		}
		
		leftHeight = getHeight(node.getLeftSubTree());
		rightHeight = getHeight(node.getRightSubTree());
		
		
		if(leftHeight> rightHeight) // ���� / ���� ����Ʈ���� ���̰� ū �� �����ؼ� ��ȯ 
		{
			return leftHeight+1;
		}
		else
		{
			return rightHeight+1;
		}
		
		
		
	}
	
	
	public TreeNode RotateLL(TreeNode node) 
	{
		TreeNode pNode,cNode; // �θ� �ڽ� ��� 
		pNode = node;
		cNode = node.getLeftSubTree();
		
		pNode.chainLeftSubTree(cNode.getRightSubTree());
		cNode.chainRightSubTree(pNode);

		return cNode;
	}
	
	public void key()
	{
		System.out.println();
		System.out.println("���� ��Ʈ Ű : " + root.key);
	}
	
	public TreeNode RotateRR(TreeNode node)
	{
		TreeNode pNode,cNode;
		pNode = node;
		cNode = node.getRightSubTree();
		
		pNode.chainRightSubTree(cNode.getLeftSubTree());
		cNode.chainLeftSubTree(pNode);

		return cNode;
	}
	
	
	public TreeNode RotateLR(TreeNode node)
	{
		TreeNode pNode,cNode;
		pNode = node;
		cNode = node.getLeftSubTree();	

		pNode.chainLeftSubTree(RotateRR(cNode));
		return RotateLL(pNode);
	}
	
	public TreeNode RotateRL(TreeNode node)
	{
		TreeNode pNode,cNode;
		pNode = node;
		cNode = node.getRightSubTree();

		pNode.chainRightSubTree(RotateLL(cNode));
		return RotateRR(pNode);
	}
	
	
}


/*AVL bst = new AVL();



bst.BSTInsert(20, "20");
bst.BSTShowAll();
bst.BSTInsert(15, "15");
bst.BSTShowAll();
bst.BSTInsert(3, "3");
bst.BSTShowAll();
System.out.println("���� ��Ʈ : " + bst.getRoot().getKey());
bst.BSTInsert(12, "12");
bst.BSTShowAll();
bst.BSTInsert(5, "5");
bst.BSTShowAll();
System.out.println("���� ��Ʈ : " + bst.getRoot().getKey());
bst.BSTInsert(11, "11");
bst.BSTShowAll();
System.out.println("���� ��Ʈ : " + bst.getRoot().getKey());
bst.BSTInsert(6, "6");
bst.BSTShowAll();
bst.BSTInsert(40, "40");
bst.BSTShowAll();
System.out.println("���� ��Ʈ : " + bst.getRoot().getKey());
bst.BSTInsert(25, "25");
bst.BSTShowAll();
bst.BSTInsert(18, "18");
bst.BSTShowAll();*/
