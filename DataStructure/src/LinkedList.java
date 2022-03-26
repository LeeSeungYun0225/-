import java.io.*;

public class LinkedList { // ���� ����Ʈ 
	public static void main(String[] args) throws IOException
	{

		_linkedList<Integer> list = new _linkedList();
		list.list_Insert(1);
		list.list_Insert(2);
		list.list_Insert(3);
		list.list_Insert(4);
		System.out.println("" + list.list_Count());
		list.list_Search();
		list.list_Clear();
	}
	
	
}




class _linkedList<T>  // ���׸� Ÿ������ �ڵ� ���뼺 ���� 
{
	Node<T> head;
	Node<T> cur;
	Node<T> tail;
	int numOfData;
	_linkedList()
	{
		head = null;
		cur = null;

		tail = null;
		numOfData = 0;
	}

	public void list_Insert(Object data) // ����Ʈ�� data �߰� 
	{
		Node newnode = new Node();
		newnode.data = (T) data;
		newnode.next = null;
		
		if(head == null) // �� ����Ʈ�� ��� 
		{
			head = newnode; // ��尡 �� ��带 ����Ű���� 
		}
		else  // ����Ʈ�� �̹� ������ ��� 
		{
			tail.next = newnode; // ������ ��忡 �� ��� ���� 
		}
		tail = newnode; // ������ �� ��带 ����Ű���� 
		numOfData+=1;
	}

	
	public Object list_deleteFirst()
	{
		if(head == null)
		{
			System.out.println("������ �������� ����");
			return null;
		}
		else 
		{
			Node<T> temp;
			temp = head;
			head = head.next;
			numOfData-=1;
			return temp.data;
		}
		
	}
	
	public void list_Search() // ����Ʈ�� ��ȸ�ϴ� �޼ҵ� 
	{
		if(head == null)
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
	
	public void list_Clear() // ����Ʈ�� �Ҹ��Ŵ 
	{
		if(head ==null)
		{
			System.out.println("������ �������� ����");
		}
		else
		{
			Node delNode = head;
			Node delNext = head.next;
			
			System.out.println("������ "+ delNode.printData_simple() + " ����");
			
			while(delNext != null)
			{
				delNode = delNext;
				delNext = delNode.next;
				System.out.println("������ "+ delNode.printData_simple() + " ����");
			}
			numOfData = 0;
		}
	}
	
	public int list_Count() // ����Ʈ�� ������ �� ��ȯ
	{
		return numOfData;
	}
	
	
	public void list_Remove(Object data)// ������ �˻��Ͽ� ���� 
	{
		if(head == null)
		{
			System.out.println("������ �������� ����");
		}
		else
		{
			Node delNode = head;
			Node temp;
			if(delNode.data == data) // ù �����Ͱ� ���� ����� ��� 
			{
				System.out.println("������ "+ delNode.printData_simple() + " ����");
				head = delNode.next;
			}
			temp = head;
			
			
			while(delNode !=null)
			{
				delNode = delNode.next;
				if(delNode.data == data)
				{
					if(head == delNode)
					{
						head = delNode.next;
						temp = head;
					}
					else
					{
						temp.next = delNode.next;
						temp = temp.next;
					}
				}
			}
		}
	}
	

}


/*
class Node{

	Node next;
	int data; // �������� ���´� ���� Ȥ�� ��ü�� ���� 
	public Node(int i) {
		// TODO Auto-generated constructor stub
		data = i;
	}

	public Node() // ��带 �ʱ�ȭ�Ѵ� . default constructor �⺻ ������ 
	{	
		data = 0;
		next=null;
	}
	
	public void printNode()// ����� ��ü�� ����Ѵ� 
	{
		if(this.nodeFirst())
		{
			Node temp = this.next;
			while(temp !=null)
			{
				System.out.print(temp.data + " ");
				temp =temp.next;
			}
		}
		
	}
	public boolean nodeFirst() // ��忡 ������ �����ϴ��� Ȯ��, true or false ���� 
	{
		return this.next == null ? false : true;
	}
	
	public void deleteNode(int data) // data ���� �����Ͽ� ��带 ����
	{
		if(this.nodeFirst())
		{
			Node temp = this.next;
			Node temp2 = this;
			while(temp != null)
			{
				if(temp.data == data)
				{
					temp2.next =temp.next; 
					temp = temp.next;
				}
				else
				{
					temp2 = temp;
					temp = temp.next;
					
				}
				
			}
		}
	}
	
	public void addNode(int data) // ����Ʈ�� ���� ������ �߰� 
	{
		Node temp = this;
		while(temp.next!=null)
		{
			temp = temp.next;
		}
		
		Node newnode = new Node();
		newnode.data = data;
		newnode.next= null;
		temp.next = newnode;
	}
	
	public int nodeCount() // ����Ʈ ��� ���� ��ȯ int�� 
	{
		if(this.nodeFirst() == false)
		{
			return 0;
		}
		int count = 0;
		Node temp = this;
		while(temp.next!=null)
		{
			count+=1;
			temp = temp.next;
		}
		return count;
	}

}
*/


