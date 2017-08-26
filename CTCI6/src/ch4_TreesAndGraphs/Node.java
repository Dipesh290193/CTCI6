package ch4_TreesAndGraphs;

public class Node<T> {

	private final T data;

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

	@Override
	public String toString() {
		return "Node{" + "data=" + this.data + "}";
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Node))
			return false;

		Node<?> node = (Node<?>) o;

		return getData() != null ? getData().equals(node.getData()) : node.getData() == null;
	}

	@Override
	public int hashCode() {
		return getData() != null ? getData().hashCode() : 0;
	}
}
