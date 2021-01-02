/* 
     Author: D-madhukar
     This file contains basic operations on LinkedList
*/

package cp.linkedlist;

class Node<T> {
	T data;
	Node<T> next;
	Node(T data , Node<T> next) {
		this.data = data;
		this.next = next;
	}
	@Override
	public String toString() {
		return this.data.toString() + "->";
	}
	
}
class DNode<T> {
	T data;
	DNode<T> next;
	DNode<T> prev;
	DNode(T data, DNode<T> next, DNode<T> prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	@Override
	public String toString() {
		return this.data.toString() + "<->";
	}
	
}
// Implementation of SinglyLinkedList
public class LinkedList<T> {
	private Node<T> head;
	
	private LinkedList(Node<T> head) {
		this.head = head;
	}
	LinkedList() {
		this(null);
	}
	
	/* Insert Operations*/
	//addFirst O(1)
	public void addFirst(T data) {
		Node<T> nn = new Node<>(data, head);
		head = nn;
		return;
	}
	
	//addLast O(n)
	public void addLast(T data) {
		if(head==null) {
			addFirst(data);
			return;
		}
		Node<T> temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = new Node<>(data,null);
	}
	
	//addMiddle O(n)
	public void addMiddle(int idx, T data) throws Exception {
		if(idx<0) {
			throw new Exception("Index cannot be negative");
		}
		if(idx==0) {
			addFirst(data);
			return ;
		}
		Node<T> temp = this.head;
		for(int i=1;i<idx;i++) {
			temp = temp.next;
		}
		temp.next = new Node<>(data, temp.next);
	}
	
	/* Delete Operations*/
	//Delete first O(1)
	public T deleteFirst() throws Exception {
		if(head==null)
			throw new Exception("LinkedList is empty");
		T data = head.data;
		head = head.next;
		return data;
	}
	
	//DeleteLast O(n)
	public T deleteLast() throws Exception  {
		if(head==null)
			throw new Exception("LinkedList is empty");
		if(head.next == null)
			return deleteFirst();
		Node<T> temp = head;
		while(temp.next.next!=null)
			temp = temp.next;
		T data = (T) temp.next.data;
		temp.next = null;
		return data;
	}
	
	//deleteMiddle O(n)
	public T deleteMiddle(int idx) throws Exception  {
		if(head==null)
			throw new Exception("LinkedList is empty");
		Node<T> temp = head;
		for(int i=0;i<idx;i++) {
			if(temp==null)
				return null;
			temp=temp.next;
		}
		return temp.data;
	}
	
	public Node<T> getHead() {
		return head;
	}
	
	//reverse using Recursive approach
	public Node<T> reverse(Node<T> head) {
		if(head==null || head.next==null)
			return head;
		Node<T> tmp = reverse(head.next);
		head.next.next = head;
		head.next = null;
		this.head= tmp;
		return this.head;
	} 
	// reverse using Iterative approach
	public Node<T> iterativeReverse(Node<T> head) {
		Node<T> prev = null, current = head, next = null;
		while(current!=null) {
			 next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		this.head = prev;
		return this.head;
	}
	// Find Mid element
	public Node<T> mid(Node<T> head) {
		Node<T> slow=head, fast=head;
		while(fast!=null && fast.next!=null && fast.next.next!=null) {
			slow= slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	@Override
	public String toString() {
		String s = "";
		Node<T> tmp = this.head;
		while(tmp!=null) {
			s+=tmp.toString();
			tmp = tmp.next;
		}
		s+="null";
		return s;
	}
		
}

// Stack Implementation using SinglyLinkedList
class Stack<T> {
	private Node<T> top;
	Stack() {
		this.top = null;
	}
	/* All Operations are O(1)*/
	public void push(T data) {
		Node<T> nn = new Node<>(data, this.top);
		this.top = nn;
	}
	public T top() {
		return this.top!=null ?  top.data: null;
	}
	public T pop() {
		if(this.top==null)
			return null;
		T tmp = top.data;
		this.top=top.next;
		return tmp;
	}
	public boolean isEmpty() {
		return this.top==null;
	}
}
// Queue Implementation using SinglyLinkedList 
class Queue<T> {
	private Node<T> front;
	private Node<T> rear;
	Queue() {
		this.front=null;
		this.rear=null;
	}
	/* All Operations are O(1)*/
	public void enQueue(T data) {
		Node<T> nn = new Node<>(data, null);
		if(rear==null)
			rear = nn;
		else {
			rear.next = nn;
			rear = nn;
		}
	}
	public T deQueue() {
		if(this.front==null)
			return null;
		T t = this.front.data;
		this.front = this.front.next;
		return t;
	}
	public boolean isEmpty() {
		return this.front ==null;
	}
}

// DoubleEnded Queue Implementation using DoublyLinkedList
class DeQueue<T> {
	private DNode<T> front;
	private DNode<T> rear;
	DeQueue() {
		this.front = null;
		this.rear = null;
	}
	/* All Operations are O(1)*/
	public void addFirst(T data) {
		DNode<T> nn = new DNode(data, this.front, null);
		if(this.front == null) {
			this.front = nn;
			this.rear = nn;
		}
		else {
			this.front.prev = nn;
			this.front = nn;
		}
	}
	public void addLast(T data) {
		DNode<T> nn = new DNode(data, null, this.rear);
		if(this.rear == null) {
			this.front = nn;
			this.rear = nn;
		}
		else {
			this.rear.next = nn;
			this.rear = nn;
		}
	}
	public T deleteFirst() {
		if(this.front == null)
			return null;
		DNode<T> tmp = this.front.next;
		T t = this.front.data;
		if(tmp==null) {
			this.front = null;
			this.rear = null;
		} else {
			this.front.next.prev = null;
			this.front = this.front.next;
		}
		return t;
 	}
	public T deleteLast() {
		if(this.rear == null)
			return null;
		DNode<T> tmp = this.rear.prev;
		T t = this.rear.data;
		if(tmp==null) {
			this.front = null;
			this.rear = null;
		} else {
			this.rear.prev.next = null;
			this.rear = this.rear.prev;
		}
		return t;
	}
}
