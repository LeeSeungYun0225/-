public class HashTable { // ���� �ؽø� ����� ������ �ؽ� ���̺� ���� 
	 // ���� ��巹�� ������δ� 
	// linear probing ���� ����� / ���� ����� quadratic probing / double hash ���� �ؽ� �� �ִ� . 
	// �����Ͱ� ���� �� ȿ����, 
	
	private int[] table;
	private int sizeOfTable = 100;
	private int secondHashFunPrimeNum= 53; 
	private int basicInt = -1;
	
	public HashTable()
	{
		table = new int[sizeOfTable];
		initTable();
	}
	
	public void insert(int in)
	{
		int temp = hashFun(in);
		
		if(table[temp] == basicInt)
		{
			table[temp] = in;
		}
		else
		{
			temp = hashFun2(in);
			if(table[temp] == basicInt)
			{
				table[temp] = in;
				
			}
			else
			{
				System.out.println("Collision!");
			}
		}
	}
	
	public int find(int in)
	{
		int temp = hashFun(in);
		if(table[temp] == in)
		{
			return temp;
		}
		else
		{
			temp = hashFun2(in);
			if(table[temp] == in)
			{
				return temp;
			}
		}
		
		System.out.println("������ ����");
		return -1;
	}
	
	public int hashFun(int in) // 1�� �ؽ� �Լ� - �迭�� ���̷� ���� �������� ��ȯ 
	{
		return in%sizeOfTable;
	}
	
	public int hashFun2(int in) // 2�� �ؽ� �Լ� - �迭�� ���̺��� ���� �Ҽ��� ���� - �Ҽ��� �����ϴ� ������ Ŭ�����Ͱ� ���� ���� �߻��ϱ� �����̴� 
	{
		return 1+(in%secondHashFunPrimeNum);
	}
	
	
	public void showTable()
	{
		for(int i=0;i<sizeOfTable;i++)
		{
			System.out.print(" " + table[i]);
		}
	}
	
	public void initTable()
	{
		for(int i=0;i<sizeOfTable;i++)
		{
			table[i] = basicInt;
		}
	}
	
	
	
}

/*HashTable ht = new HashTable();
		
		ht.insert(3);
		ht.insert(17);
		ht.insert(103);
		ht.insert(103);
		ht.showTable();*/
