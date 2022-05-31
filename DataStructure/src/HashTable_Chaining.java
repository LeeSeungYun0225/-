
public class HashTable_Chaining<Data> {
	// ü�̴� ����� �̿��� ���� 
	// ü�̴� ����� �����Ͱ� ���� ������ ȿ����
	// ü���� ������� ��ȿ�����̳�, �ؽ� �Լ��� ȿ�������� �����Ͽ� �����Ͱ� ���� �л� ����ȴٸ� ȿ�����̴�.
	
	private int sizeOfTable = 15;
	private Node<Data> hash_List[] = new Node[sizeOfTable];
	
	
	public HashTable_Chaining()
	{
		initTable();
	}

	public void initTable()
	{
		for(int i=0;i<sizeOfTable;i++)
		{
			hash_List[i] = new Node<Data>();
		}
	}
	
	public void insert(int key_in,Data data_in)
	{
		Node newNode = new Node(key_in,data_in);
		
		int index = hashFun(key_in);
		Node current = hash_List[index];
		while(current.next != null)
		{
			current = current.next;
		}
		
		current.next = newNode;
		
	}
	
	public void delete(int key_in)
	{
		int index = hashFun(key_in);
		Node current = hash_List[index];
		while(current.next != null)
		{
			if(current.next.key == key_in)
			{
				current.next = current.next.next;
				System.out.println("������ ���� �Ϸ� _key : " + key_in);
				return;
			}
		
			current = current.next;
		}
		
		System.out.println("������ �������� ����");
		
	}
	
	public void search(int key_in)
	{
		int index = hashFun(key_in);
		int index2 = 0;
		Node current = hash_List[index];
		while(current.next != null)
		{
			if(current.next.key == key_in)
			{
				System.out.println("ã���� �ϴ� Ű "+  key_in + "�� ���̺� �ε��� " +index +"�� " + index2 + "��°�� ����");
				
				return;
			}
			index2++;
			current = current.next;
		}
		System.out.println("������ �������� ����");
		
	}
	
	public void showTable()
	{
		Node current;
		for(int i=0;i<sizeOfTable;i++)
		{
			current = hash_List[i].next;
			System.out.print(i+ "�ε��� ������ : ");
			
			while(current!= null)
			{
				System.out.print(">> " + current.key);
				current = current.next;
			}
			
			System.out.println("");
		}
	}
	
	
	public int hashFun(int key_in)
	{
		return key_in%sizeOfTable;
	}
	
	public class Node<Data>
	{
		int key;
		Data data;
		Node<Data> next;
	
		public Node()
		{
			next = null;
		}
		
		public Node(int key_in,Data data_in)
		{
			key = key_in;
			data =data_in;
			next = null;
		}
		
	}
}


/*		HashTable_Chaining<String> ht = new HashTable_Chaining<String>();

ht.insert(1, "1");
ht.insert(2, "2");
ht.insert(17, "17");
ht.insert(18, "18");

ht.insert(16, "16");
ht.insert(5, "5");
ht.delete(16);
ht.showTable();
*/
