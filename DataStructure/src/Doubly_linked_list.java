
public class Doubly_linked_list<T> { // ����� ���� ����Ʈ 
	
	Doubly_node<T> head;
	Doubly_node<T> cur;
	Doubly_node<T> tail;
	int numOfData;
	
	public Doubly_linked_list()
	{
		head  = null;
		cur =  null;
		tail =  null;
		numOfData = 0;
	}
	
	public boolean list_IsEmpty() // ����Ʈ�� ��������� true or false ��ȯ 
	{
		return head == null ? true : false;
	}
	
	public void list_InsertFirst(Object data_in) // ����Ʈ ù ������ ���� 
	{
		Doubly_node<T> newnode = new Doubly_node<T>();
		newnode.data = (T) data_in;
		newnode.prev = null;

		newnode.next = head;
		
		if(!list_IsEmpty())
		{
			head.prev = newnode;
		}
		
		head = newnode;
		numOfData ++;
		if(tail == null)
		{
			tail = newnode;
		}
	}
	
	public void list_InsertLast(Object data_in) // ����Ʈ ������ ������ ���� 
	{
		Doubly_node<T> newnode = new Doubly_node<T>();
		newnode.data = (T) data_in;
		newnode.next = null;
		
		newnode.prev = tail;
		if(!list_IsEmpty())
		{
			tail.next = newnode;
		}
		
		tail = newnode;
		
		numOfData++;
		
		if(head == null)
		{
			head = newnode;
		}
		
	}
	
	
	public Object list_deleteFirst() // ����Ʈ ù ������ ��ȯ , ���� 
	{
		
		
		if(list_IsEmpty())
		{
			System.out.println("������ ����");
			return null;
		}
		else
		{
			Doubly_node<T> temp = head;
			if(cur == head)
			{
				cur = null;
			}
			head = head.next;
			head.prev = null;
			numOfData--;
			return temp.data;
		}
		
	}
	
	public Object list_deleteLast() // ����Ʈ ������ ������ ��ȯ, ���� 
	{
		if(list_IsEmpty())
		{
			System.out.println("������ ����");
			return null;
		}
		else
		{
			Doubly_node<T> temp = tail;
			if(cur == tail)
			{
				cur = null;
			}
			tail = tail.prev;
			tail.next = null;
			numOfData--;
			return temp.data;
		}

	}
	
	public void list_Search() // ����Ʈ�� �տ������� ��� 
	{
		if(list_IsEmpty())
		{
			System.out.println("������ �������� ����.");
		}
		else 
		{
			cur = head;  // Ŀ���� ��带 ����Ű���� 
			cur.printData();
			
			while(cur.next !=null)
			{
				cur = cur.next;
				cur.printData();
			}
		}
	}
	
	public void list_RSearch() // ����Ʈ�� �ڿ������� ��� 
	{
		if(list_IsEmpty())
		{
			System.out.println("������ �������� ����.");
		}
		else 
		{
			cur = tail;  // Ŀ���� ��带 ����Ű���� 
			cur.printData();
			
			while(cur.prev !=null)
			{
				cur = cur.prev;
				cur.printData();
			}
		}
	}
	
	public int list_Count() // ����Ʈ ��� ���� ��ȯ 
	{
		return numOfData;
	}
	
	
	public Object list_First() // ����Ʈ ù��° ������ ��ȯ 
	{
		if(list_IsEmpty())
		{
			System.out.println("������ �������� ����.");
			return null;
		}
		return head.data;
	}
	
	public Object list_Last() // ����Ʈ ������ ������ ��ȯ 
	{
		if(list_IsEmpty())
		{
			System.out.println("������ �������� ����.");
			return null;
		}
		return tail.data;
	}
	
	public Object list_Next() // Ŀ���� ���� ������ ��ȯ 
	{
		if(list_IsEmpty())
		{
			System.out.println("������ �������� ����.");
			return null;
		}
		if(cur == null)
		{
			cur = head;
			return cur.data;
		}
		if(cur.next != null)
		{
			cur = cur.next;
			return cur.data;
		}
		else
		{
			System.out.println("Ŀ���� ���Դϴ�.");
			return null;
		}
		
	}
	public Object list_Prev() // Ŀ���� ���� ������ ��ȯ 
	{
		if(list_IsEmpty())
		{
			System.out.println("������ �������� ����.");
			return null;
		}
		if(cur == null) // Ŀ���� �ʱ�ȭ ���� �ʾ����� , 
		{
			cur = tail;
			return cur.data;
		}
		if(cur.prev != null)
		{
			cur = cur.prev;
			return cur.data;
		}
		else
		{
			System.out.println("Ŀ���� ó���Դϴ�.");
			return null;
		}
		
	}
	

	
}

/*
 * Doubly_linked_list<Integer> dll = new Doubly_linked_list<Integer>();
		
		dll.list_InsertFirst(3);
		dll.list_InsertFirst(2);
		dll.list_InsertFirst(1);

		System.out.println(dll.list_Next());
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Prev());
		System.out.println(dll.list_Prev());
		System.out.println(dll.list_Prev());
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Prev());
		System.out.println(dll.list_Prev());
		
		dll.list_InsertLast(4);
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Next());
		dll.list_InsertLast(5);
		System.out.println(dll.list_Next());
		
		System.out.println(dll.numOfData);
		
		System.out.println(dll.list_deleteFirst());
		System.out.println(dll.list_deleteLast());
		System.out.println(dll.list_Prev());
		
		System.out.println(dll.numOfData);
		dll.list_RSearch();
		dll.list_Search();
		
		*/
