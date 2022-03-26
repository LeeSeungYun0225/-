
public class Array_tree<T> { // ���� ����Ʈ�� , ���ʺ��� ä������ 
	
	private static final int sizeof_tree = 20;
	T[] arr; //���׸� Ÿ�� T�� ���� ��� ���´� �޶������Ѵ� (show_... �޼ҵ�)
	int cursor = 0;
	
	
	Array_tree()
	{
		arr = (T[]) new Object[sizeof_tree+1];
	}
	

	
	public void init_Tree()
	{
		for(int i=1;i<arr.length;i++)
		{
			arr[i] = null;
		}
	}
	
	
	public boolean isEmpty()
	{
		return arr[1] == null ? true : false;
	}
	
	public boolean isFull()
	{
		return cursor == sizeof_tree ? true : false;
	}
	
	
	public void add_Node(T in)
	{
		if(isFull())
		{
			return;
		}
		arr[++cursor] = in;
		
	}
	
	public Object delete_Node()// ������ ��� ���� 
	{
		if(isEmpty())
		{
			return null;
		}
		return arr[cursor--];
	}
	
	public void show_Lchild(int position) // �Է¹��� ��ġ�� ���� �ڽ� ��� 
	{
		if(position > cursor)
		{
			System.out.println("�������� �ʴ� ������ ��ġ�Դϴ�.");
		}
		else if(position*2 > cursor)
		{	
			System.out.println("�ش� ��ġ�� ���� �ڽ��� �������� �ʽ��ϴ�.");
		}
		else
		{
			System.out.println("���� �ڽ��� " + arr[position*2] + "�Դϴ�");
		}
	}
	
	public void show_Rchild(int position) // �Է¹��� ��ġ�� ������ �ڽ� ��� 	
	{
		if(position > cursor)
		{
			System.out.println("�������� �ʴ� ������ ��ġ�Դϴ�.");
		}
		else if(position*2+1 > cursor)
		{	
			System.out.println("�ش� ��ġ�� ���� �ڽ��� �������� �ʽ��ϴ�.");
		}
		else
		{
			System.out.println("������ �ڽ��� " + arr[position*2+1] + "�Դϴ�");
		}
	}
	
	public void show_Parents(int position) // �Է¹��� ��ġ�� �θ� ��� ��� 
	{
		if(position <=1 || position > cursor)
		{
			return;
		}

		
		System.out.println("�θ��� : " + arr[position/2]);
		show_Parents(position/2);
	}
}


/* main Statement
 *  	Array_tree<String> tree = new Array_tree<String>();
		
		tree.add_Node("A");
		tree.add_Node("B");
		tree.add_Node("C");
		tree.add_Node("D");
		tree.add_Node("E");
		tree.add_Node("F");
		tree.add_Node("G");
		tree.add_Node("H");
		
		tree.show_Lchild(1);
		tree.show_Rchild(2);
		tree.show_Parents(6);
		
		tree.delete_Node();
		
		tree.show_Parents(8);  */
