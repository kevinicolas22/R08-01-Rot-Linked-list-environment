package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	private DoubleLinkedList<T> top;
	private int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		if (element != null) {
			top.insertFirst(element);
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()){
			throw new StackUnderflowException();
		}
		T value =  this.top();
		this.top.removeFirst();
		return value;
	}

	@Override
	public T top() {
		if (this.isEmpty())
			return null;

		return ((DoubleLinkedListImpl<T>) this.top).getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		return top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return top.size() == size;
	}
}
