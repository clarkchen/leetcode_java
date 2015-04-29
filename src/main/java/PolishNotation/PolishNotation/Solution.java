package PolishNotation.PolishNotation;

import java.util.Stack;


public class Solution {
	
	private boolean isoperator(String s)
	{
		return (s.equals("+") || s.equals("-")||
				s.equals("/") || s.equals("*") );
		
	}
	
	public Integer getValue(Integer v1, String op, Integer v2)
	{
		Integer rtValue = 0;

		if (op== "+") {rtValue =  v1+v2; }
		else if (op=="-") {rtValue =  v1-v2; }
		else if (op.equals("*")) rtValue = v1*v2;
		else if(op.equals("/")) rtValue = v1/v2;

		return rtValue;
	}
	public int evalRPN(String[] tokens) {
		Stack<Integer> values =  new Stack<Integer>();
		values.clear();
		 
		for(int i =0 ;i <tokens.length;i++)
		{
			String cur = tokens[i];

			if(isoperator(cur))
			{
				Integer v2 = values.pop();
				Integer v1 = values.pop();
				values.push(getValue(v1, cur, v2));
			}
			else
			{
				Integer temp = Integer.valueOf(cur);
				values.push(temp);
				 
			}
			
			
		}
		
		return values.pop();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String [] tokens ;
		//tokens =  new String [] {"2", "1", "+", "3", "*"};
		tokens =  new String [] {"4", "13", "5", "/", "+"};
		tokens =  new String [] {"4", "13", "5", "/", "+","20","+","2","*"};
//		tokens =  new String [] {'/'};
		System.out.println(s.evalRPN(tokens));
	}

}
