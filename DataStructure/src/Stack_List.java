
public class Stack_List<T> extends _linkedList<T>{ // ���� ����Ʈ�� Ȱ���� ���� ���� 
	
	
	//top�� ������ �ʿ䰡 ���� > tail ������ top�� ������ �Ѵ�.  
	
	public Stack_List()
	{
		head = null;
		tail = null;
	}
	
	public void push(T data_in)
	{
		list_Insert(data_in);
	}
	
	public T peek() {
		
		return head== null ? null : tail.data;
	}
	
	public T pop()
	{
		if(head == null)
		{
			return null;
		}
		else
		{
			
			Node temp = new Node<T>();
			temp = head;
			
			if(temp == tail) // �����Ͱ� 1�� ���� ��� 
			{
				head = null;
				tail = null;
				return (T) temp.data;
			}
			else
			{
				while(temp.next !=tail)
				{
					temp= temp.next;
				}
				
				tail = temp;
				temp = temp.next;
				tail.next = null;
			
				return (T) temp.data;
			}
		}
	
	}
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
}


/* main testing 
 * 		Stack_List<Integer> stack = new Stack_List();
		stack.list_Search();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.list_Search();
		System.out.println( stack.peek() == null ? "������ ������ ����" : "������ ���� : " + stack.pop());
		System.out.println( stack.peek() == null ? "������ ������ ����" : "������ ���� : " + stack.pop());
		System.out.println( stack.peek() == null ? "������ ������ ����" : "������ ���� : " + stack.pop());
		System.out.println( stack.peek() == null ? "������ ������ ����" : "������ ���� : " + stack.pop());
		
		stack.list_Search();*/
