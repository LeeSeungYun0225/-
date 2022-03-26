
public class List_Tree<T>  {
	
	List_Tree<T> prev;
	List_Tree<T> next;
	T data;
	List_Tree()
	{
		data = null;
		prev = null;
		next = null;
		
	}
	
	public Object getData() // ������ ��ȯ 
	{
		return data;
	}
	
	public void setData(T in) // ������ ����
	{
		data = in;
	}
	
	public List_Tree<T> getLeftSubTree() // ���� ����Ʈ�� ��ȯ
	{
		return prev;
	}
	
	public List_Tree<T> getRightSubTree() // ������ ����Ʈ�� ��ȯ
	{
		return next;
	}
	
	
	
	
	public void chainLeftSubTree(List_Tree<T> sub) // ���� ����Ʈ�� ���� 
	{
		prev = sub;
	}
	
	public void chainRightSubTree(List_Tree<T> sub) // ������ ����Ʈ�� ���� 
	{
		next = sub;
	}
	
	
	public void InorderTraverse()  // ������ȸ ,
	{
		
		if(getLeftSubTree() != null)
		{
			getLeftSubTree().InorderTraverse();
		}
		
		System.out.print(data+ "");
		if(getRightSubTree() != null)
		{
			getRightSubTree().InorderTraverse();
		}
		
	}
	
	public void PreorderTraverse() // ���� ��ȸ,
	{
		System.out.print(data+ "");
		if(getLeftSubTree() != null)
		{
			getLeftSubTree().InorderTraverse();
		}
		if(getRightSubTree() != null)
		{
			getRightSubTree().InorderTraverse();
		}
	}
	
	public void PostorderTraverse() // ������ȸ 
	{
		if(getLeftSubTree() != null)
		{
			getLeftSubTree().InorderTraverse();
		}
		if(getRightSubTree() != null)
		{
			getRightSubTree().InorderTraverse();
		}
		System.out.print(data+ "");
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
