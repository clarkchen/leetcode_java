package BFSSurroundedRegions; /**
 * 
 */

import java.util.*;
/**
 * @author chenxi
 * 这道题和扫雷双击是一个效果的题目，但是这次是确认之后，再改变
 * BFS 宽度优先搜索的好处就是 遍历时间复杂度为 N*N
 * 我已经深深的被这道题给击溃了，太屌了，这道题深刻的告诉我们不仅要省时间复杂度，更要节省空间复杂度
 * DFS 的算法非常快，但是时间复杂度过高，超过200的数据就会爆栈
 * BFS 的算法如果同时保留X,Y的话空间复杂度高，另外设置 visited 访问数组，空间复杂度增高
 * 如果用扫雷的方式上下左右扫描，虽然只是常熟倍的时间复杂度升高，一样超时，但是C++写的代码就不会
 * 
 * 这道题深刻的告诉我们，代码的优化，最基本的优化是不要写浪费空间的代码，
 * 
 */
public class Solution {
	
	int width, height;
	void init(char[][]board)
	{
		height = board.length;
		width = board[0].length;
	}
	
	int x[]={0,1,0,-1};
	int y[]={-1,0,1,0};
	
	void visitAroundNoTurn(int i, int j, char[][] board)
	{
		if(board[i][j]!='O') return;
		Queue<Integer> q = new LinkedList<Integer>();
		int code = i*width +j;
		q.offer(code);
 	 
		while(!q.isEmpty())
		{
			code =q.poll();
			int row= code/width;
			int col= code%width;
			board[row][col] = 'A';
			
//			这段代码会导致超时
//			for(int k=0;k<x.length;k++)
//			{
//				int x1 = row+x[k];
//				int y1 = col+y[k];
//				if(x1>=0&&x1<height&&y1>=0&&y1<width
//						&&board[x1][y1]=='O')
//				{
//					q.offer(x1*width+y1);
//				}
//			}
			
			if(row>0 && board[row-1][col]=='O')
			{
			    q.offer((row-1)*board[0].length+col);
			    board[row-1][col]='#';
			}
			if(row<board.length-1 && board[row+1][col]=='O')
			{
			    q.offer((row+1)*board[0].length+col);
			    board[row+1][col]='#';
			}
			if(col>0 && board[row][col-1]=='O')
			{
			    q.offer(row*board[0].length+col-1);
			    board[row][col-1]='#';
			}
			if(col<board[0].length-1 && board[row][col+1]=='O')
			{
			    q.offer(row*board[0].length+col+1);
			    board[row][col+1]='#';
			}            
			       
		}
		 
}
	
	public void solve(char[][] board) {
        //X O
		if(board==null|| board.length==0) return;
		init(board);
		//first and last row
		for(int j=0;j<width;j++)
		{
			visitAroundNoTurn(0, j, board);
			visitAroundNoTurn(height-1,j, board);
		}
		 
		
		//first and last column
		for(int i=0;i<height;i++)
		{
			visitAroundNoTurn(i,0,board);
			visitAroundNoTurn(i,width-1,board);
		}
		
		
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
			{
				if( board[i][j]=='O' )
				{
					board[i][j] = 'X';
				}
				else if( board[i][j]=='A' )
				{
					board[i][j] = 'O';
				}
				
			}
		 
		
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][] C;
//		char[][]D = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','O'}};
		// ["XOXOXO","OXOXOX","XOXOXO","OXOXOX"]
		//char[][]D =  {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
//		String str[] = {"XOOOOOOOOOOOOOOOOOOO",
//						"OXOOOOXOOOOOOOOOOOXX",
//						"OOOOOOOOXOOOOOOOOOOX",
//						"OOXOOOOOOOOOOOOOOOXO",
//						"OOOOOXOOOOXOOOOOXOOX",
//						"XOOOXOOOOOXOXOXOXOXO",
//						"OOOOXOOXOOOOOXOOXOOO",
//						"XOOOXXXOXOOOOXXOXOOO",
//						"OOOOOXXXXOOOOXOOXOOO",
//						"XOOOOXOOOOOOXXOOXOOX",
//						"OOOOOOOOOOXOOXOOOXOX",
//						"OOOOXOXOOXXOOOOOXOOO",
//						"XXOOOOOXOOOOOOOOOOOO",
//						"OXOXOOOXOXOOOXOXOXOO",
//						"OOXOOOOOOOXOOOOOXOXO",
//						"XXOOOOOOOOXOXXOOOXOO",
//						"OOXOOOOOOOXOOXOXOXOO",
//						"OOOXOOOOOXXXOOXOOOXO",
//						"OOOOOOOOOOOOOOOOOOOO",
//						"XOOOOXOOOXXOOXOXOXOO"};
//		String str[]={"OOOOXX","OOOOOO","OXOXOO","OXOOXO","OXOXOO","OXOOOO"};
		String str[] = {"XO","OX"};
		char [][] D  = new char[str.length][str[0].length()];
		for(int i=0;i<str.length;i++)
		{
			for(int j=0;j<str[i].length();j++)
			{
				D[i][j] = str[i].charAt(j);
			}
		}
		Solution s= new Solution();
		s.solve(D);
		for(char[]i:D)
		{
			for(char c:i)
				System.out.print(c);
			System.out.println();
		}
	}

}
