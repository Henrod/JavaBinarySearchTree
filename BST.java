import java.util.Scanner;

class BST<E extends Comparable<E>> {
	private Node mRoot;

	public BST() {
		mRoot = null;
	}

	public void add(E data) {
		mRoot = add(mRoot, data);
	}

	public void printInOrder() {
		System.out.print("Print In Order> ");
		printInOrder(mRoot);
		System.out.println("\n");
	}

	public void print() {
		Queue<Node> queue = new Queue<>();
		int level = 0;

		queue.enqueue(mRoot, level);

		while (!queue.isEmpty()) {
			int queue_level = queue.getHeadLevel();

			while (!queue.isEmpty() && level == queue_level) {
				Node node = queue.dequeue();
				queue = print(queue, node, level);
				queue_level = queue.getHeadLevel();
			}

			++level;
			System.out.println("");
		}
	}

	public Node select (int ith) {
		return select(mRoot, ith);
	}

	public int rankWithParentLink(E data) {
		if (data == null) return -1;

		Node node = getNode(data);
		if (node == null) return -1;

		int r = size(node.getLeft()) + 1;

		while (node != mRoot) {
			if (node == node.getParent().getRight()) {
				r += size(node.getParent().getLeft()) + 1;
			}
			node = node.getParent();
		}

		return r;
	}

	public int rankNoParentLink(E data) {
		if (data == null || mRoot == null) return -1;

		Node node = mRoot;
		int r = size(node.getLeft()) + 1;

		while (node != null) {
			if (node.getData().equals(data)) {
				return r;
			} else if (node.getData().compareTo(data) > 0) {
				node = node.getLeft();
				if (node != null) {
					r = r - size(node.getRight()) - 1;
				}
			} else {
				node = node.getRight();
				if (node != null) {
					r = r + size(node.getLeft()) + 1;
				}
			}
		}

		return -1;
	}

	private Node add(Node root, E data) {

		if (root == null) {
			root = new Node(data);
			return root;
		}

		Node descendent = null;

		if (root.getData().compareTo(data) <= 0) {
			descendent = add(root.getRight(), data);
			root.setRight(descendent);
		} else {
			descendent = add(root.getLeft(), data);
			root.setLeft(descendent);
		}

		descendent.setParent(root);
		root.setSize(size(root.getLeft()) + size(root.getRight()) + 1);
		return root;
	}

	private void printInOrder(Node root) {
		if (root == null) return;

		printInOrder(root.getLeft());
		System.out.print(root.getData() + " ");
		printInOrder(root.getRight());
	}

	private Queue<Node> print(Queue<Node> queue, Node root, int level) {
		if (root == null) {
			System.out.print("-- ");
			return queue;
		}

		queue.enqueue(root.getLeft(), level + 1);
		queue.enqueue(root.getRight(),level + 1);

		System.out.print(root.getData() + " ");

		return queue;
	}

	private int size(Node node)  {
		if (node == null) return 0;

		return node.getSize();
	}

	private Node select(Node root, int ith) {
		if (root == null) return null;

		int r = size(root.getLeft()) + 1;
		if (ith == r) {
			return root;
		} else if (ith < r) {
			return select(root.getLeft(), ith);
		}

		return select(root.getRight(), ith - r);
	}

	private Node getNode(E data) {
		Node node = mRoot;

		while (node != null) {
			if (node.getData().equals(data)) {
				return node;
			} else if (node.getData().compareTo(data) < 0) {
				node = node.getRight();
			} else {
				node = node.getLeft();
			}
		}

		return node;
	}

	class Node implements Comparable<Node> {
		private E mData;
		private Node mLeft;
		private Node mRight;
		private Node mParent;
		private int mSize;

		public Node() {
			setAttributes(null, null);
		}

		public Node(E data) {
			setAttributes(data, null);
		}

		public Node(E data, Node parent) {
			setAttributes(data, parent);
		}

		private void setAttributes(E data, Node parent) {
			mParent = parent;
			mData = data;
			mLeft = null;
			mRight= null;
			mParent = null;
			mSize = 1;
		}

		public void setData(E data) { mData = data; }
		public E getData() { return mData; }

		public void setLeft(Node left) { mLeft = left; }
		public Node getLeft() { return mLeft; }

		public void setRight(Node right) { mRight = right; }
		public Node getRight() { return mRight; }

		public void setSize(int size) { mSize = size; }
		public int getSize() { return mSize; }

		public void setParent(Node parent) { mParent = parent; }
		public Node getParent() { return mParent; }

		public int compareTo(Node o) {
			return mData.compareTo(o.getData());
		}
	}

}
