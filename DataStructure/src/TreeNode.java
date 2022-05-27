
public class TreeNode {
	public int key;
	public Object data;
	public TreeNode prev;
	public TreeNode next;
	
	public TreeNode()
	{
	}

	
	public TreeNode(int in_key,Object in_data)
	{
		key = in_key;
		data = in_data;
		prev = next = null;
	}
	
	
	
	public Object getData() // ������ ��ȯ 
	{
		return data;
	}
	
	public int getKey() // Ű ��ȯ 
	{
		return key;
	}
	
	
	public void chainLeftSubTree(TreeNode subnode) // ���� ����Ʈ�� ���� 
	{
		prev = subnode;
	}

	public void chainRightSubTree(TreeNode subnode) // ������ ����Ʈ�� ���� 
	{
		next = subnode;
	}
	public TreeNode getLeftSubTree() // ���� ����Ʈ�� ��ȯ
	{		
		return prev;
	}
	
	public TreeNode getRightSubTree() // ������ ����Ʈ�� ��ȯ
	{
		return next;
	}
	
	public void setData(Object in) // ������ ����
	{
		data = in;
	}
	public void setKey(int in_key)
	{
		key = in_key;
	}
	
	
}
