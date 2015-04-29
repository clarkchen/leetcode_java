package StringSimplifyPath; /**
 * 
 */

import java.util.*;
/**
 * @author chenxi
 * 这道题是路径简化，特殊情况是 // 和 未知上升 ../
 * 
 * 解决方案是用 字符串 和 Stack
 */
public class Solution {

	public String simplifyPath(String path) {
		if(path==null) return path;
		if(path.charAt(0)!='/') path = '/'+path;
		
		Stack<String> st = new Stack<String>();st.clear();
		
		int cur=0,next;
		while(cur<path.length())
		{
			next = path.indexOf('/', cur+1);
			if(next==-1) next = path.length();
			
			String folder = path.substring(cur+1,next);
			
			if(folder.length()==0||folder.equals(".")) {}
			else if(folder.equals("src/main")) {if(!st.isEmpty()) st.pop();}
			else st.push(folder);
			
			cur = next;
		}
		
		String res = "";
		while (!st.isEmpty())
		{
			res= "/"+st.pop()+res;
		}
		if(res.length()==0) res="/";
		return res;
		
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= ".././aa/bc///c/adf dfdf/";
		s="a/..";
		Solution sl = new Solution();
		
		
		System.out.println(sl.simplifyPath(s));
		
	}

}
