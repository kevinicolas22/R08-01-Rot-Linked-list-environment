package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	private DoubleLinkedList<T> list;
	private int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		if (element != null) {
			list.insert(element);
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T element;
		if (this.isEmpty())
			throw new QueueUnderflowException();
		else {
			element = list.toArray()[0];
			list.removeFirst();
		}
		return element;
	}

	@Override
	public T head() {
		T result = null;
		if(!isEmpty()){
			result = ((DoubleLinkedListImpl<T>) list).getHead().getData();
		}
		return result;
	}


	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return list.size() == size;
	}
}
