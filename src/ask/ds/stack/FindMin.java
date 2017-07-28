package ask.ds.stack;

import java.util.Stack;



//1st way: use another min. value during stacking 

class NodeWithMin 
{
	    public int value;
	    public int min;
	    
	    public NodeWithMin(int v, int min)
	    {
	        value = v;
	        this.min = min;
	    }
}

class StackWithMin extends Stack<NodeWithMin> 
{
	    public void push(int value) 
	    {
	        int newMin = Math.min(value, min());
	        super.push(new NodeWithMin(value, newMin));
	    }
	    
	    public int min() 
	    {
	    	if (this.isEmpty()) {
	    		return Integer.MAX_VALUE;
	    	} else {
	    		return peek().min;
	    	}
	    }
}

// 2nd way:  another stack

class StackWithMin2 extends Stack<Integer> 
{
	Stack<Integer> s2; // another stack
	
	public StackWithMin2() {
		s2 = new Stack<Integer>();		
	}
	
	public void push(int value){
		if (value <= min()) {
			s2.push(value);
		}
		super.push(value);
	}
	
	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s2.pop();			
		}
		return value;
	}
	
	public int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
}


public class FindMin
{
	public static void main(String[] args) 
	{
		StackWithMin stack = new StackWithMin();
		StackWithMin2 stack2 = new StackWithMin2();
		
		int[] array = {2, 1, 3, 1};
		
		for (int value : array) {
			stack.push(value);
			stack2.push(value);
			System.out.print(value + ", ");
		}
		System.out.println('\n');
		
		for (int i = 0; i < array.length; i++) 
		{
			System.out.println("Popped " + stack.pop().value + ", " + stack2.pop());
			System.out.println("New min is " + stack.min() + ", " + stack2.min());
		}
	}

}



/*


// input value = positive integer, 
const int max_size = 100;
public class Stack ()
{
public:
    Stack()
    {
        count = 0;
    }
    void push(int v)
    {
        s[count] = v;
        
        if(count_m == 0) {
            m[count_m] = v;
            count_m++;
        }
        else if(v < m[count_m-1]) {
            m[count_m] = v;
            count_m++;;
        }            
        count++;
    }
    int pop()
    {
        if(count > 0) {
            int v = s[count];
            count--;
            
            if(v == m[count_m])
                count_m--;
                
            return v;
        }
        else
            return -1;
    }
    int peekMin()
    {
        return m[count_m];
    }
    
private:
    int s[max_size];
    int count;       
    
    int m[max_size];
    int count_m; 
}

*/
