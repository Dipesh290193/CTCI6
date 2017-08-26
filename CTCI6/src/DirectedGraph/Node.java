package DirectedGraph;

public class Node<T> {

	private T data;
	
	public Node(T data)
	{
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		if(!(o instanceof Node))
			return false;
		Node node = (Node)o;
		return getData() != null ? getData().equals(node.getData()): node.getData() == null;
	}
	
	@Override
	public int hashCode()
	{
		return getData() != null ? getData().hashCode() : 0;
	}
}
