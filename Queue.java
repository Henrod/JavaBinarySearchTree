class Queue<E> {
	private class QueueNode<E> {
		public E mData;
		public int mLevel;
		public QueueNode<E> mNext;

		public QueueNode(E data, QueueNode<E> next, int level) {
			mData = data;
			mNext = next;
			mLevel = level;
		}
	}

	private QueueNode<E> mTail;

	public Queue() {
		mTail = null;
	}

	public boolean isEmpty() {
		return mTail == null;
	}

	public void enqueue(E data, int level) {
		QueueNode<E> node = new QueueNode<>(data, mTail, level);
		mTail = node;
	}

	public int getHeadLevel() {
		if (mTail == null) return -1;

		QueueNode<E> next = mTail;

		while (next.mNext != null) {
			next = next.mNext;
		}

		return next.mLevel;
	}

	public E dequeue() {
		QueueNode<E> next = mTail;
		QueueNode<E> previous = mTail;

		while (next.mNext != null) {
			previous = next;
			next = next.mNext;
		}

		previous.mNext = null;
		E data = next.mData;

		if (next == previous) mTail = null;

		return data;
	}

	public void print() {
		for (QueueNode<E> node = mTail; node != null; node = node.mNext) {
			System.out.print(node.mData + " ");
		}
		System.out.println("");
	}
}
