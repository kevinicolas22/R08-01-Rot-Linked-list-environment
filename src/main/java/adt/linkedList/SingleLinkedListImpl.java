package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		return size(head);
	}

	private int size(SingleLinkedListNode<T> node) {
		if (node.isNIL()) {
			return 0;
		}
		return 1 + size(node.getNext());
	}

	@Override
	public T search(T element) {
		return search(element, head);
	}

	private T search(T element, SingleLinkedListNode<T> node) {
		if (node.isNIL()) {
			return null;
		}
		if (node.getData().equals(element)) {
			return node.getData();
		}
		return search(element, node.getNext());
	}

	@Override
	public void insert(T element) {
		insert(element, head);
	}

	private void insert(T element, SingleLinkedListNode<T> node) {
		if (node.isNIL()) {
			node.setData(element);
			node.setNext(new SingleLinkedListNode<T>());
		} else {
			insert(element, node.getNext());
		}
	}

	@Override
	public void remove(T element) {
		remove(element, head, null);
	}

	private void remove(T element, SingleLinkedListNode<T> currentNode, SingleLinkedListNode<T> previousNode) {
		if (currentNode.isNIL()) {
			return;
		}
		if (currentNode.getData().equals(element)) {
			if (previousNode != null) {
				previousNode.setNext(currentNode.getNext());
			} else {
				head = currentNode.getNext();
			}
		} else {
			remove(element, currentNode.getNext(), currentNode);
		}
	}

	@Override
	public T[] toArray() {
		int size = size();
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[size];
		toArray(array, head, 0);
		return array;
	}

	private void toArray(T[] array, SingleLinkedListNode<T> node, int index) {
		if (node.isNIL()) {
			return;
		}
		array[index] = node.getData();
		toArray(array, node.getNext(), index + 1);
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
}
