package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.last = new DoubleLinkedListNode<>();
		this.head = this.last;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T>
					newNode = new DoubleLinkedListNode<>(),
					nil = new DoubleLinkedListNode<>();

			newNode.setData(element);
			newNode.setNext(nil);
			nil.setPrevious(newNode);
			this.last.setNext(newNode);
			newNode.setPrevious(this.last);

			if (this.last.isNIL())
				this.head = newNode;

			this.last = newNode;
		}
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHeadNode = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(),
				new DoubleLinkedListNode<T>());
		newHeadNode.next = head;
		((DoubleLinkedListNode<T>) head).previous = newHeadNode;

		if (head.isNIL()) {
			last = newHeadNode;
		}

		head = newHeadNode;

	}


	@Override
	public void removeFirst() {
		if (!head.isNIL()) {
			head = head.next;
			if (head.isNIL()) {
				last = (DoubleLinkedListNode<T>) head;
			}
			((DoubleLinkedListNode<T>) head).previous = new DoubleLinkedListNode<T>();
		}
	}

	@Override
	public void removeLast() {
		if (!last.isNIL()) {
			last = last.getPrevious();

			if (last.isNIL()) {
				head = last;
			}
			last.setNext(new DoubleLinkedListNode<T>());
		}

	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}