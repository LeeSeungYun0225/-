
public class Deque<T> extends Doubly_linked_list<T>{ // ��, ����� ����� �ڷᱸ��, ����� ���� ����Ʈ�� ��ӹ޾� �״�� ��� 

	
	public Deque() // �⺻ �����ڸ� �̿��� �ʱ�ȭ 
	{
		head  = null;
		cur =  null;
		tail =  null;
		numOfData = 0;
	}	
	
	public boolean dequeIsEmpty() // ���� ������� true or false ��ȯ 
	{
		return list_IsEmpty();
	}
	
	public void dequeAddFirst(Object data_in) // ���� �տ� ������ �Է� 
	{
		list_InsertFirst(data_in);
	}
	
	public void dequeAddLast(Object data_in) // ���� �������� ������ �Է� 
	{
		list_InsertLast(data_in);
	}
	
	public Object dequeRemoveFirst() // ���� ù ������ ���� �� ��ȯ 
	{
		return list_deleteFirst();
	}
	public Object dequeRemoveLast() // ���� ������ ������ ���� �� ��ȯ 
	{
		return list_deleteLast();
	}
	
	
	public Object dequeGetFirst() // ���� ù ������ ��ȯ�ϰ� ������ �Ͼ�� ���� 
	{
		return  list_First();
	}
	
	public Object dequeGetLast() // ���� ������ �����͸� ��ȯ�ϰ� ������ �Ͼ�� ���� 
	{
		return list_Last();
	}

}
