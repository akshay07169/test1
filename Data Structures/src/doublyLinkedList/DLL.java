package doublyLinkedList;

public class DLL {
	static node head;
	
	static class node{
		int data;
		node next,prev;
		node(int d){
			data=d;
		}
	}
	
	public void printlist(node n) {
		while(n!=null) {
			System.out.print(n.data+" ");
			n = n.next;
		}
	}
	
	public static void main(String[] args) {
		
		DLL list = new DLL();
		
		list.push(1);
		
		list.printlist(head);
		
		list.append(2);
		
		System.out.println();
		list.printlist(head);
		
		list.insertafter(head, 3);
		System.out.println();
		list.printlist(head);
		
		list.deletenode(head.next);
		
		System.out.println();
		list.printlist(head);
		
		list.reverse();
		System.out.println();
		list.printlist(head);
		
	}

	public void push(int newdata) {
		
		node newnode = new node(newdata);
		newnode.next = head;
		newnode.prev = null;
		if(head!=null)
			head.prev=newnode;
		head = newnode;
	}
	
	public void insertafter(node prevnode,int newdata) {
		if(prevnode==null) {
			System.out.println("previous node cannot be null");
			return;
		}
		node newnode = new node(newdata);
		
		newnode.next = prevnode.next;
		prevnode.next = newnode;
		newnode.prev = prevnode;
		if(newnode.next!=null) {
			newnode.next.prev=newnode;
		}
	}
	
	public void append(int newdata) {
		node newnode = new node(newdata);
		newnode.next = null;
		
		node last = head;
		
		if(head==null) {
			newnode.prev=null;
			head = newnode;
		}
		
		while(last.next!=null) {
			last = last.next;
		}
		last.next=newnode;
		newnode.prev=last;
	}
	
	public void deletenode(node del) {
		if(head==null||del==null) {
			return;
		}
		if(head==del) {
			head = del.next;
		}
		if(del.prev!=null) {
			del.prev.next=del.next;
		}
		return;
	}
	
	void reverse() {
		node temp=null;
		node curr = head;
		
		while(curr!=null) {
			temp=curr.prev;
			curr.prev = curr.next;
			curr.next=temp;
			curr = curr.prev;
		}if(temp!=null) {
			head = temp.prev;
		}
	}
}
