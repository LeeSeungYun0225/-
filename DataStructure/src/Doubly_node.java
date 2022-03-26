
public class Doubly_node<T> {
	
	T data;
	Doubly_node<T> next;
	Doubly_node<T> prev;
	public Doubly_node()
	{
		data = null;
		prev = null;
		next = null;
	}
	
	public void printData() // ������ ��� �׽�Ʈ�� ���� �Լ�, data�� ���¿� ���� ������ �ʿ��� 
	{
		System.out.println("Data : " + data);
	}
	
	public String printData_simple() // ������ ��� �׽�Ʈ�� ���� �Լ�, data�� ���¿� ���� ������ �ʿ��� 
	{
		return ""+data;
	}
}
