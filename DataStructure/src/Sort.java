
public class Sort { // ���� �˰��� 
	
	
	public Sort()
	{}
	
	// ����Ʈ�� �־� n^2, ��������� nlog_2 n, �������� �̵��� ���� �߻��ϰ� ������ �޸𸮰����� �ʿ����� ������ ��������� ���� ���� 
	public void QuickSort(int[] arr,int left,int right) // �Ǻ�(������)�� ���� �̸� �������� �������� ū ������ ������ �����ϴ� ��� ��
	{
		if(left <= right)
		{
			int pivot = Partition(arr,left,right); // ��Ƽ�� �Լ��� ���� ���� �� �� 
			QuickSort(arr,left,pivot-1);
			QuickSort(arr,pivot+1,right);
		}
	}
	
	public int Partition(int[] arr,int left,int right) {
		int pivot = arr[left]; //  �Ǻ� ���� 
		int low = left+1; // ���������� �̵��ϸ� �Ǻ����� ū �� ã�� 
		int high = right; // �������� �̵��ϸ� �Ǻ����� ū �� ã�� 
		
		while(low<=high) // �ο� ���̰� �����Ǹ� Ż���Ѵ� . 
		{
			while(pivot > arr[low])
			{
				low++;
			}
			
			while(pivot<arr[high])
			{
				high--;
			}
			
			if(low<=high) // ���� �� ���°� �ƴϸ� ��ȯ 
			{
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
		}
		
		int temp = arr[left];
		arr[left] = arr[high];
		arr[high] = temp;
		
		return high;
		
	}
	
	public static void MergeSort(int[] arr,int start,int end) // ��������  ���� 
	{
		int mid;
		
		if(start<end) // ��� Ż�� ���� 
		{
			mid = (start+end)/2;
			
			MergeSort(arr,start,mid); // ���ۺ��� �߰� �������� �������� ȣ�� 
			MergeSort(arr,mid+1,end); // �߰�����+1���� �� �������� �������� ȣ�� 
			
			Merge(arr,start,mid,end); // ���� �Լ� ȣ�� >> ��ġ�鼭 �տ������� �����ϸ� ��ģ�� . 
			
		}
	}
	
	public static void Merge(int[] arr,int start,int mid, int end) // ���������� ���� �Լ� 
	{
		int[] temp = new int[arr.length]; // ������ �����͸� ������� �ӽ� �迭 
		int left = start; 
		int right = mid+1;
		int tempstart = left;
		
		while(left <=mid && right <=end) // ���� �ϰ��� �ϴ� �迭 �ΰ� A, B�� �����Ͱ� ��� �����ִ� ���� ���� 
		{
			if(arr[left] <= arr[right])
			{
				temp[tempstart++] = arr[left++];
				
			}
			else
			{
				temp[tempstart++] = arr[right++];
			}
		}
		
		if(left>mid) // �����ϰ��� �ϴ� �迭 �� ���� �迭 (A)�� �����Ͱ� ��� �����Ǿ��� �ÿ�, 
		{
			for(int i=right;i<=end;i++) // ���� �迭 B�� �����͸� ���� ������ �ϳ��� �־��ش�. 
			{
				temp[tempstart++] = arr[i];
			}
		}
		else // �����ϰ��� �ϴ� �迭 �� ���� �迭 B�� �����Ͱ� ��� �����Ǿ��� ��� 
		{
			for(int i=left;i<=mid;i++)
			{
				temp[tempstart++] = arr[i];
			}
		}
		
		for(int i=start;i<=end;i++) // ������ �迭 arr�� ���ĵ� �迭 temp���� �־��ش�. 
		{
			arr[i] = temp[i];
			
		}
	}
	
	public static void HeapSort(int[] arr) // ����Ʈ > �� �ڷᱸ���� �̿��� ���� ��� , ���� �����͸� �־��ٰ� �����ϸ� ���ĵǾ� ������ ������ �̿���  O(nLog_2 N)
	{
		PQueue pq = new PQueue();
		pq.HeapInit();
		
		for(int i=0;i<arr.length;i++) // ���� ��� ������ ���� 
		{
			pq.HeapInsert(arr[i]);
		}
		
		for(int i=0;i<arr.length;i++) // ������ ���� ��� ������ ���� 
		{
			arr[i] = pq.HeapDelete();
		}
	}
	
	
	public void InsertionSort(int[] arr)  // �̹� ���� �� �� �迭 �ȿ� �ε����� �߰��ϴ� ���·� ���� O(N^2)	
	{
		int target;
		for(int i=1;i<arr.length;i++) //  i �ε����� �̹��� �߰��Ǵ� �ε���, 
		{
			target = arr[i];
			
			for(int j=i-1;j>=0;j--) // j�ε����� �� ��ȸ �ϸ� �߰��� �ε����� ���� ��, 
			{
				if(target<arr[j])
				{
					arr[j+1] = arr[j]; // �߰��� ���� �� ���� ���̸� ���� ���� �� �� ���� �ڷ� ��ĭ�� �о�� . 
				}
				else
				{
					
					break;
				}
				arr[j] = target; // ���� �߰��� ���� ��ġ�� ã���� �´� ��ġ�� �ش� �����͸� �����Ͽ� ����.
				
				
			}
			
		}
	}
	
	
	public void SelectionSort(int[] arr)  // ���� ������ �°� �ϳ��� �����ؼ� �Ű� ���Ľ�Ű�� ��� . O(N^2)
	{
		int minidx;
		int temp;
		
		for(int i=0;i<arr.length-1;i++) // i �� �̹��� ������ �ϼ��ϰ��� �ϴ� �ε��� 
		{
			minidx =i;
			for(int j=i+1;j<arr.length;j++) //j �� ��ȸ�ϸ� ���� ���� ���� ���� �ε����� �����´� . 
			{
				if(arr[j] < arr[minidx]) 
				{
					minidx = j;
				}
			}
			
			temp =  arr[i];		
			arr[i] = arr[minidx];
			arr[minidx] =  temp;
		}
		
		
	}
	public void BubbleSort(int[] arr) // �迭�� �� �κк��� �ΰ��� �����͸� ���� ���� ������ ���� ��� > ���� ���� �ε������� ���ĵ�. O(N^2) 
	{	
		int temp;
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-i-1;j++)
			{
				if(arr[j] > arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
				}
			}
		}
	}
	
}
