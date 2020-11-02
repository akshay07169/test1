package linkedList;

public class Linkedlistswap {
	node head;
	public class node{
		int data;
		node next;
		node(int d){
			data=d;
			next=null;
		}
	}
	
	 public void printList() 
	    { 
	        node tnode = head; 
	        while (tnode != null) 
	        { 
	            System.out.print(tnode.data+" "); 
	            tnode = tnode.next; 
	        } System.out.println();
	    } 
	
	public static void main(String[] args) {
		Linkedlistswap list = new Linkedlistswap();
		list.push(1);
		list.printList();
		list.push(4);
		list.printList();
		list.append(5);
		list.append(6);
		list.insertafter(list.head.next.next, 7);
		list.printList();
		list.delete(4);
		list.delete(1);
		list.printList();
		list.swap(4, 7);
		list.printList();
		list.head = list.reverse(list.head);
		list.printList();
		
	}
	
	void push(int newdata) {
		node newnode=new node(newdata);
		newnode.next=head;
		head = newnode;
	}
	
	void append(int newdata) {
		if(head==null) {
			head = new node(newdata);
			return;
		}else {
			node newnode= new node(newdata);
			newnode.next=null;
			node last=head;
			while(last.next!=null) {
				last=last.next;
			}
			last.next=newnode;
		}
	}
	void insertafter(node prevnode,int newdata) {
		if(prevnode==null)
			return;
		else {
			node newnode=new node(newdata);
			newnode.next = prevnode.next;
			prevnode.next=newnode;
		}
	}
	void delete(int pos) {
		if(head==null)
			return;
		node temp = head;
		if(pos==0) {
			head=temp.next;
			return;
		}
		for(int i=0;temp!=null&&i<pos-1;i++) {
			temp=temp.next;
			if(temp.next==null)
				return;
		}
		node newnode=temp.next.next;
		temp.next=newnode;
	}
	void swap(int x,int y) {
		if(x==y)
			return;
		node prevx=null,currx=head;
		while(currx!=null&&currx.data!=x) {
			prevx=currx;
			currx=currx.next;
		}
		node prevy=null,curry=head;
		while(curry!=null&&curry.data!=y) {
			prevy=curry;
			curry=curry.next;
		}
		if(prevx!=null) {
			prevx.next=curry;
		}else
			head=curry;
		if(prevy!=null) {
			prevy.next=currx;
		}else
			head=currx;
		
		node temp=currx.next;
		currx.next=curry.next;
		curry.next=temp;
	}
	node reverse(node node) 
    { 
        node prev = null; 
        node current = node; 
        node next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        node = prev; 
        return node; 
    } 
}
