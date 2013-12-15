import java.util.*;

public class ReversePolish {
	public static void main(String args[])
	{
		
	}
	
	public int evalRPN(String[] tokens) 
	{
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++)
        {
        	char tk = tokens[i].charAt(0);
        	if (Character.isDigit(tk))
        		st.push(tk - '0');
        	else
        	{
        		int a = (Integer)st.pop();
        		int b = (Integer)st.pop();
        	}
        }
        return 0;
    }
}
