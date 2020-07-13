package com.linkedlist;

public class LinkedList<T> {

	private Node<T> head;

	public LinkedList(Node<T> head) {
		super();
		this.head = head;
	}

	public LinkedList() {
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public void insertAtStart(T data) {
		Node<T> node = new Node<T>(data);
		if (this.head == null) {
			this.head = node;
		} else {
			node.setNext(head);
			head = node;
		}
	}

	public void insertAtEnd(T data) {
		Node<T> node = new Node<T>(data);
		if (this.head == null) {
			this.head = node;
		} else {
			Node<T> curr = this.head;
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(node);
		}
	}

	public boolean deleteNode(T data) {
		boolean success = false;
		if (head != null && head.getData() == data) {
			this.head = this.head.getNext();
			success = true;
		} else if (head != null) {
			Node<T> prev = this.head;
			Node<T> curr = this.head.getNext();
			while (curr != null) {
				if (curr.getData() == data) {
					prev.setNext(curr.getNext());
					success = true;
					break;
				}
				prev = curr;
				curr = curr.getNext();
			}
		}
		return success;
	}

	public boolean insertBefore(T exData, T newData) {
		Node<T> node = new Node<T>(newData);
		boolean success = false;
		if (head != null && head.getData() == exData) {
			node.setNext(this.head);
			this.head = node;
			success = true;
		} else if (head != null) {
			Node<T> prev = this.head;
			Node<T> curr = this.head.getNext();
			while (curr != null) {
				if (curr.getData() == exData) {
					prev.setNext(node);
					node.setNext(curr);
					success = true;
					break;
				}
				prev = curr;
				curr = curr.getNext();
			}
		}

		return success;
	}

	public boolean insertAfter(T exData, T newData) {
		Node<T> node = new Node<>(newData);
		boolean success = false;

		Node<T> curr = this.head;
		while (curr != null && curr.getData() != exData) {
			curr = curr.getNext();
		}

		if (curr != null) {
			node.setNext(curr.getNext());
			curr.setNext(node);
			success = true;
		}

		return success;

	}

	public int size() {

		int count = 0;
		if (this.head != null) {
			count++;
			Node<T> curr = this.head.getNext();
			while (curr != null) {
				count++;
				curr = curr.getNext();
			}
		}

		return count;
	}

	public Node<T> at(int index) {
		if (index > -1) {
			Node<T> curr = this.head;

			while (curr != null && index != 0) {
				index--;
				curr = curr.getNext();
			}
			return curr;
		} else {
			return null;
		}
	}
	
	public int indexOf(T data) {
		int index = -1;
		Node<T> curr = this.head;
		while(curr != null) {
			if(curr.getData() == data) {
				return index + 1;
			}
			curr = curr.getNext();
		}
		return index;
	}

	@Override
	public String toString() {
		String text = "";
		Node<T> curr = this.head;
		while (curr != null) {
			text.concat(curr.getData().toString() + " -> ");
			curr = curr.getNext();
		}
		return text;
	}

}
