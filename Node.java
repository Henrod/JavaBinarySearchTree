// class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
// 	private E mData;
// 	private Node<E> mLeft;
// 	private Node<E> mRight;
// 	private Node<E> mParent;
// 	private int mSize;

// 	public Node() {
// 		setAttributes(null, null);
// 	}

// 	public Node(E data) {
// 		setAttributes(data, null);
// 	}

// 	public Node(E data, Node<E> parent) {
// 		setAttributes(data, parent);
// 	}

// 	private void setAttributes(E data, Node<E> parent) {
// 		mParent = parent;
// 		mData = data;
// 		mLeft = null;
// 		mRight= null;
// 		mParent = null;
// 		mSize = 1;
// 	}

// 	public void setData(E data) { mData = data; }
// 	public E getData() { return mData; }

// 	public void setLeft(Node<E> left) { mLeft = left; }
// 	public Node<E> getLeft() { return mLeft; }

// 	public void setRight(Node<E> right) { mRight = right; }
// 	public Node<E> getRight() { return mRight; }

// 	public void setSize(int size) { mSize = size; }
// 	public int getSize() { return mSize; }

// 	public void setParent(Node<E> parent) { mParent = parent; }
// 	public Node<E> getParent() { return mParent; }

// 	public int compareTo(Node<E> o) {
// 		return mData.compareTo(o.getData());
// 	}
// }
