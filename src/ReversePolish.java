import java.util.*;

public class ReversePolish {
	public static void main(String args[])
	{
		String[] tokens = new String[]{"4","-2","/","2","-3","-","-"};
		ReversePolish rp = new ReversePolish();
		System.out.println(rp.evalRPN(tokens));
	}
	
	public int evalRPN(String[] tokens) 
	{
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++)
        {
        	String tk = tokens[i];
        	
        	if (tk.equals("+") || tk.equals("-") || tk.equals("*") || tk.equals("/"))
        	{
        		int b = st.pop();
        		int a = st.pop();
        		switch (tk.charAt(0))
        		{
        			case '+': st.push(a + b); break;
        			case '-': st.push(a - b); break;
        			case '*': st.push(a * b); break;
        			case '/': st.push(a / b); break;
        		}
        	}
        	else
        		st.push(Integer.parseInt(tk));
        		
        }
        return st.pop();
    }
}
