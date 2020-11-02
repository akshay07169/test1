package stack;

public class Stack {
	static final int max=1000;
	int arr[]=new int[max];
	int top;
	Stack() {
		top=-1;
	}
	boolean isempty() {
		return (top<0);
	}
	
	boolean push(int x) {
		if(top>=max-1) {
			System.out.println("stack overflow");
			return false;
		}else {
			arr[++top]=x;
			System.out.println(x+" pushed to stack");
			return true;
		}
	}
	int pop() {
		if(top<0) {
			System.out.println("Stack underflow");
			return 0;
		}else {
			int x = arr[top--];
			return x;
		}
	}
	int peek() {
		if(top<0) {
			System.out.println("underflow");
			return 0;
		}else {
			int x = arr[top];
			return x;
		}
	}
	
	public static void main(String[] args) {
		
		Stack s = new Stack();
		s.isempty();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop()+" is removed");
		System.out.println(s.peek()+" is at top");
	}
	
}
