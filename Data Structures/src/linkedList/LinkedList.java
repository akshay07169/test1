package linkedList;

public class LinkedList {
	/*static node head;
	
	static class node{
		int data;
		node next;
		node (int d){
			data = d;
			next = null;
			
		}
	}
	
	public static void main(String[] args) {
		
		LinkedList list1 = new LinkedList();
		
		list1.head =new node(1);
		node second = new node(2);
		node third = new node(3);
		
		list1.head.next = second;
		second.next = third;
			
		list1.printlist(head);
		
	}
	
	static void printlist(node n) {
		while(n!=null) {
			System.out.print(n.data+" ");
			n= n.next;
		}
	}*/
	
	static node head;
	
	static class node{
		int data;
		node next;
		node(int d){
			data = d;
			next = null;
		}
	}
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.head = new node(1);
		node second = new node(2);
		node third = new node(3);
		list.head.next = second;
		second.next = third;
		
		list.printlist(head);
		System.out.println();
		list.count();
		System.out.println();
		list.swapNodes(1,2);
		list.printlist(head);
		
	}
	public void printlist(node n) {
		while(n!=null) {
			System.out.print(n.data+" ");
			n = n.next;
		}
	}
	public void count() {
		int count=0;
		node temp = head;
		while(temp!=null) {
			temp=temp.next;
			count++;
		}System.out.println("total nodes : "+count);
	}
	public void swapNodes(int x, int y) 
    { 
         
        if (x == y) return; 
  
        
        node prevX = null, currX = head; 
        while (currX != null && currX.data != x) 
        { 
            prevX = currX; 
            currX = currX.next; 
        } 
  
        node prevY = null, currY = head; 
        while (currY != null && currY.data != y) 
        { 
            prevY = currY; 
            currY = currY.next; 
        } 
  
        if (currX == null || currY == null) 
            return; 
  
        // If x is not head of linked list 
        if (prevX != null) 
            prevX.next = currY; 
        else //make y the new head 
            head = currY; 
  
        // If y is not head of linked list 
        if (prevY != null) 
            prevY.next = currX; 
        else // make x the new head 
            head = currX; 
  
        
        node temp = currX.next; 
        currX.next = currY.next; 
        currY.next = temp; 
    }
	
	public int detectloop(node node) {
		node slow= node,fast=node;
		while(slow!=null&&fast!=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				removeloop(slow,node);
				return 1;
		}
	}return 0;
}
	public void removeloop(node loop, node curr) {
		node ptr1= null,ptr2=null;
		ptr1=curr;
		while(true) {
			ptr2 = loop;
			while(ptr2.next!=loop&&ptr2.next!=ptr1) {
				ptr2=ptr2.next;
			}
			if(ptr2.next==ptr1)
				break;
			ptr1=ptr1.next;
		}
		ptr2.next=null;
	}
}
