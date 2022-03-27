import java.io.*;


public class Search { // Ž�� �˰��� 
	
	public static void main(String[] args) throws IOException
	{

		int arr[] = {1,2,3,4,5,6,7,8,9,10,22,33,44};
		
		int index;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		index = BinarySearch(arr,33);
		
		bw.write(index+"");
		bw.flush();
		bw.close();
		
		
	}
	
	
	
	public static int LinearSearch(int[] array,int target) // ����Ž�� 
	{	
		
		for(int i=0;i<array.length;i++)
		{
			if(array[i]==target)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	
	
	public static int BinarySearch(int[] array,int target)// ����Ž��, �迭�� ���ĵ� ��쿡�� ��� ���� 
	{
		
		int front=0,rear=array.length-1;
		int half;
		
		while(front<=rear)
		{
			half = (front+rear)/2;
			if(array[half]==target)
			{
				return half;
			}
			else if(array[half]>target)
			{
				rear = half-1;
			}
			else if(array[half]<target)
			{
				front = half+1;
			}
			
		}
		
		return -1;
		
	}
	
	
	public int InterpolSearch(int[] array,int target) // ����Ž�� , ����Ž���� �����Ͽ� ���� �� �ڷᱸ�� ������ ã���� �ϴ� �������� ��ġ�� ������� �����Ͽ� ������ ���δ�.
	{
		int front=0,rear=array.length-1;
		double half;
		int idx;
		
		while(!(array[front]>target || array[rear] <target)) // Ż�� ���ǹ��� ����Ž���� �ٸ��� . 
		{
			half = (target-array[front])/(array[rear]-array[front])*(rear-front)+front; // ����Ž���� �ܼ��� �迭�� ������ ��������, ���� Ž���� ����� �������� ���� �������� ���� ���� ���� �뷫�� ��ġ�� ������ ������.
			idx= (int)half;
			if(array[idx]==target)
			{
				return idx;
			}
			else if(array[idx]>target)
			{
				rear = idx-1;
			}
			else if(array[idx]<target)
			{
				front = idx+1;
			}
			
		}
		
		return -1;
		
	}

}
