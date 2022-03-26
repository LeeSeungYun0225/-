
public class ArrayList { // �迭 ����� ����Ʈ , 
	public static void main(String args[])
	{
		List<XY> list = new List();
		
		XY fir = new XY(4,7);
		XY sec = new XY(7,2);
		XY thr = new XY(10,64);
		
		XY temp = new XY();
		
		temp.printxy();
		list.list_Insert(fir);
		list.list_Insert(sec);
		list.list_Insert(thr);
		temp = list.list_First();
		
		temp.printxy();
		
		temp = list.list_Next();
		temp.printxy();
		temp = list.list_Next();
		temp.printxy();
		
		temp = list.list_Remove();
		temp.printxy();
		temp = list.list_Remove();
		temp.printxy();
	}


}

class XY // ����Ʈ �׽�Ʈ�� Ŭ���� 
{
	int x;
	int y;
	
	XY()
	{
		x=y=0;
	}
	
	XY(int x_,int y_)
	{
		x =x_;
		y = y_;
	}
	public void printxy() {
		System.out.println("x : " + x + "\ny : " + y );
	}
}

class List<T>{ // ���׸��� Ȱ���Ͽ� ���뼺�� ���� �� �ִ� 
	private final int array_length = 10;
	private int numOfData;
	private int cursor;
	private Object[] arr = new Object[array_length];
	List() // �⺻ ������ 
	{
		numOfData = 0;
		cursor = -1;
	}
	
	public void list_Insert(Object data) // �����͸� �߰��Ѵ� . 
	{
		if(numOfData>=array_length)
		{
			return;
		}
		arr[numOfData] = data;
		numOfData ++;
	}
	
	public T list_First() // Ŀ���� 0�ε����� �ʱ�ȭ �ϰ� ù ��° ������ ���� 
	{
		if(numOfData == 0)
		{
			return null;
		}
		
		cursor =0;
		return (T) arr[cursor];
	}
	
	public T list_Next() // Ŀ���� ��ĭ �������� �̵� ��Ű�� �ش� ��ġ�� ������ ���� 
	{
		if(cursor >= numOfData-1)
		{
			return null;
		}
		
		cursor ++;
		return (T) arr[cursor];
	}
	
	public T list_Remove()
	{
		int cursortemp = cursor;
		int num = numOfData;
		
		T temp = (T) arr[cursor];
		
		for(int i=cursortemp;i<num-1;i++)
		{
			arr[i] = arr[i+1];
		}
		numOfData --;
		cursor--;
		
		return temp;
	}
}