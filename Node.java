class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
	private E mData;
	private Node<E> mLeft;
	private Node<E> mRight;
	private int mSize;

	public Node() {
		mData = null;
		mLeft = null;
		mRight= null;
		mSize = 1;
	}

	public Node(E data) {
		mData = data;
		mLeft = null;
		mRight= null;
		mSize = 1;
	}

	public void setData(E data) { mData = data; }
	public E getData() { return mData; }

	public void setLeft(Node<E> left) { mLeft = left; }
	public Node<E> getLeft() { return mLeft; }

	public void setRight(Node<E> right) { mRight = right; }
	public Node<E> getRight() { return mRight; }

	public void setSize(int size) { mSize = size; }
	public int getSize() { return mSize; }

	public int compareTo(Node<E> o) {
		return mData.compareTo(o.getData());
	}
}
