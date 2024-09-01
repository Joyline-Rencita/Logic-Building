import java.util.Stack;
public class MaxElementInStack
{
	public static void main(String[] args)
	{
		MaxStack stack = new MaxStack();
		stack.push(54);
		stack.push(72);
		stack.push(89);
		stack.push(23);
		stack.push(60);
		stack.push(68);
 
		int maxElement = stack.getMax();
		System.out.println("Maximum Element in Stack : " + maxElement);
	}
}
 
class MaxStack
{
	private Stack<Integer> stack;
	private Stack<Integer> maxStack;
 
	public MaxStack()
	{
		stack = new Stack<>();
		maxStack = new Stack<>();
	}
 
	public void push(int value)
	{
		stack.push(value);
		if (maxStack.isEmpty() || value >= maxStack.peek())
		{
			maxStack.push(value);
		}
	}
 
	public int pop()
	{
		if (stack.isEmpty())
		{
			throw new IllegalStateException("Stack is Empty");
		}
 
		int popped = stack.pop();
		if (popped == maxStack.peek())
		{
			maxStack.pop();
		}
 
		return popped;
	}
 
	public int getMax()
	{
		if (maxStack.isEmpty())
		{
			throw new IllegalStateException("Stack is Empty");
		}
 
		return maxStack.peek();
	}
}
