
public class Stack<T> { // LIFO, ���Լ��� , �迭 ��� 
	private final int Array_Size = 10;
	T data[];
	int top;
	
	

	Stack()
	{
		data = (T[]) new Object[Array_Size];
		top = -1;
	}
	
	
	public void push(Object data_in) // ���� 
	{
		
		data[++top] = (T) data_in;
	}
	
	public Object pop() // ������ 
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			return data[top--];
		}
		
	}
	
	public Object peek() // ��ȸ 
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			return (T) data[top];
		}
	}
	
	public boolean isEmpty() // ������ ����°��� ��ȯ 
	{
		return top==-1 ? true : false;
	}
}

/* main testing 
 * 		Stack<Integer> stack = new Stack();
		
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(1);
		System.out.println(stack.peek());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
 */


