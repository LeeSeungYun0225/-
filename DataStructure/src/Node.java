class Node<T> // ���� ����Ʈ�� ��� 
{
	T data;
	Node<T> next;
	
	Node()
	{
		data = null;
		next = null;
	}
	
	public void printData() // ������ ��� �׽�Ʈ�� ���� �Լ�, data�� ���¿� ���� ������ �ʿ���   ,, ���׸� ���¸� �����ϸ鼭 ������¸� �����ϴ� ����� ������..
	{
		System.out.println("Data : " + data);
	}
	
	public String printData_simple() // ������ ��� �׽�Ʈ�� ���� �Լ�, data�� ���¿� ���� ������ �ʿ��� 
	{
		return ""+data;
	}
}