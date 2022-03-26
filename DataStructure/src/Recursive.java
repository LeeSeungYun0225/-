import java.io.*;


public class Recursive { // ��� �˰���
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("��� �Լ� ���\n");
		bw.write("1. ���丮��\n");
		bw.write("2. �Ǻ���ġ\n");
		bw.write("3. ���� Ž��\n");
		bw.write("4. �ϳ��� Ÿ��\n");
		bw.flush();
		
		
		
	
		int selection = Integer.parseInt(br.readLine());
		Select(selection);
		bw.close();
	}
	
	
	
	public static void Select(int selection) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		switch(selection)
		{
		
			case 1:
			{
				bw.write("���丮�� N �Է�\n");
				bw.flush();
				int n = Integer.parseInt(br.readLine());
				bw.write(n+"! = " +Factorial(n));
				bw.flush();
				bw.close();
				
				break;	
			}
			case 2:
			{
				bw.write("�Ǻ���ġ N �Է�\n");
				bw.flush();
				int n = Integer.parseInt(br.readLine());
				for(int i=1;i<=n;i++)
				{
					bw.write(Fibonacci(i)+" ");
				}
				
				bw.flush();
				bw.close();
				break;
			}
			case 3:
			{
				int arr[] = {1,4,6,7,8,11,14,33,34,37,42,53,66,72};
				bw.write("ã���� �ϴ� �� �Է�\n");
				bw.flush();
				int n = Integer.parseInt(br.readLine());
				if(Binarysearch(arr,0,arr.length,n)==-1)
				{
					bw.write("�迭�� ���� ���Դϴ�.");
				}
				else
				{
					bw.write(n +"�� �ε��� "+Binarysearch(arr,0,arr.length,n)+"�� �ֽ��ϴ�.");
				}
				
				
				
				bw.flush();
				bw.close();
				break;
			}
			case 4:
			{
				bw.write("���� ���� �Է�\n");
				bw.flush();
				
				int n= Integer.parseInt(br.readLine());
				HonoiTower(n,'A','B','C');
				
				bw.flush();
				bw.close();
				break;
			}
		}
	
	
	
		
	}
	
	public static void HonoiTower(int num,char from,char by, char to) // �ϳ��� Ÿ�� , from���� by�� ���� to�� �̵� 
	{
		
		if(num==1)
		{
			System.out.println("����1�� "+ from +"���� " + to+"�� �̵�");
		}
		else
		{
			HonoiTower(num-1,from,to,by);
			System.out.println("����"+num+"�� "+from+"���� " +to +"�� �̵�");
			HonoiTower(num-1,by,from,to);
		}
	}
	
	public static int Binarysearch(int[] arr,int first,int last,int target) // ����Ž�� 
	{
		if(first>last)
		{
			return -1;
		}
		int mid = (first+last)/2;
	
		return arr[mid]==target ? mid : arr[mid]>target ? Binarysearch(arr,first,mid-1,target) : arr[mid]<target ? Binarysearch(arr,mid+1,last,target) : -1;
	}
	
	public static int Fibonacci(int n) // �Ǻ���ġ ���� ���̽��� �޸������̼� ������� ���� ȿ�������� ���� ����
	{
		if(n == 1)
		{
			return 0;
			
		}
		else if(n==2)
		{
			return 1;
		}
		else 
		{
			return Fibonacci(n-1)+Fibonacci(n-2);
		}
	}
	
	public static int Factorial(int n) // ���丮�� 
	{
		if(n == 0)
		{
			return 1;
		}
		else
		{
			return n*Factorial(n-1);
		}
	}
	
}
