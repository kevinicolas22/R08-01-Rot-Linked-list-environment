package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			data = element;
			next = new RecursiveDoubleLinkedListImpl<T>();
			if (previous == null) {
				previous = new RecursiveDoubleLinkedListImpl<T>();
			}
		} else {
			next.insert(element);
		}
	}


	@Override
	public void insertFirst(T element) {
		if (element != null){
			if (this.isEmpty()) {
				this.insert(element);
			} else {
				RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<>();

				newNode.setData(this.data);
				this.data = element;
				newNode.setNext(this.next);
				this.next = newNode;
				newNode.setPrevious(this);
				((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(newNode);
			}
		}
	}


	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if (getData().equals(element)) {
				if (next.isEmpty() && previous.isEmpty()) {
					data = null;
					previous = new RecursiveDoubleLinkedListImpl<T>();
					next = new RecursiveDoubleLinkedListImpl<T>();
				} else {
					data = next.getData();
					next = next.next;
					if (!next.isEmpty()) {
						((RecursiveDoubleLinkedListImpl<T>) next).previous = this;
					}
				}
			} else {
				next.remove(element);
			}
		}
	}

	@Override
	public void removeFirst() {

		if (!isEmpty()) {
			if (getPrevious().isEmpty()) {

				setData(getNext().getData());
				setNext(getNext().getNext());
				if (getNext() != null)
					((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);

			} else
				getPrevious().removeFirst();
		}
	}


	@Override
	public void removeLast() {
		if(!isEmpty()){
			if(this.next.isEmpty()){
				this.data = null;
				this.next = null;
			} else {
				((RecursiveDoubleLinkedListImpl)this.next).removeLast();
			}
		}
	}


	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}
}
