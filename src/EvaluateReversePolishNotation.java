/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

import java.util.*;

public class EvaluateReversePolishNotation {
	public static void main(String args[])
	{
		String[] tokens = new String[]{"4","-2","/","2","-3","-","-"};
		EvaluateReversePolishNotation rp = new EvaluateReversePolishNotation();
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
