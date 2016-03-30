import java.util.Scanner;

class BST<E extends Comparable<E>> {
	private Node<E> mRoot;

	public BST() {
		mRoot = null;
	}

	public void add(E data) {
		mRoot = add(mRoot, data);
	}

	private <E extends Comparable<E>> Node<E> add(Node<E> root, E data) {

		if (root == null) {
			root = new Node<>(data);
			return root;
		}

		if (root.getData().compareTo(data) <= 0) {
			root.setRight( add(root.getRight(), data) );
		} else {
			root.setLeft( add(root.getLeft(), data) );
		}

		return root;
	}

	public void printInOrder() {
		System.out.print("Print In Order> ");
		printInOrder(mRoot);
		System.out.println("\n");
	}

	private void printInOrder(Node<E> root) {
		if (root == null) return;

		printInOrder(root.getLeft());
		System.out.print(root.getData() + " ");
		printInOrder(root.getRight());
	}

	public void print() {
		Queue<Node<E>> queue = new Queue<>();
		int level = 0;

		queue.enqueue(mRoot, level);

		while (!queue.isEmpty()) {
			int queue_level = queue.getHeadLevel();

			while (!queue.isEmpty() && level == queue_level) {
				Node<E> node = queue.dequeue();
				queue = print(queue, node, level);
				queue_level = queue.getHeadLevel();
			}

			++level;
			System.out.println("");
		}
	}

	private Queue<Node<E>> print(Queue<Node<E>> queue, Node<E> root, int level) {
		if (root == null) {
			System.out.print("-- ");
			return queue;
		}

		queue.enqueue(root.getLeft(), level + 1);
		queue.enqueue(root.getRight(),level + 1);

		System.out.print(root.getData() + " ");

		return queue;
	}
}
