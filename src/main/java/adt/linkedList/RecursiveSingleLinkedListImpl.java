package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {
	}

	@Override
	public boolean isEmpty() {
		return data == null;
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		if (getNext() == null) {
			return 1;
		}
		return 1 + getNext().size();
	}

	@Override
	public T search(T element) {
		if (isEmpty()) {
			return null;
		}
		if (getData().equals(element)) {
			return getData();
		}
		if (getNext() != null) {
			return getNext().search(element);
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			setData(element);
			setNext(new RecursiveSingleLinkedListImpl<>());
		} else {
			getNext().insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (isEmpty()) {
			return;
		}
		if (getData().equals(element)) {
			setData(getNext().getData());
			setNext(getNext().getNext());
		} else {
			getNext().remove(element);
		}
	}

	@Override
	public T[] toArray() {
		int size = size();
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[size];
		toArray(array, this, 0);
		return array;
	}

	private void toArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int index) {
		if (node == null || index >= array.length) {
			return; // Condição de parada: Quando o nó for nulo ou o índice estiver fora dos limites do array
		}
		array[index] = node.getData();
		toArray(array, node.getNext(), index + 1);
	}


	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}
}
