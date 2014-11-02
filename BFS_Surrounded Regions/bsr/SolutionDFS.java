package bsr;
import java.util.*;

/**
 * @author chenxi
 *
 */
public class SolutionDFS {
	int width, height;
	void init(char[][]board)
	{
		height = board.length;
		width = board[0].length;
	}
	
  
	void visitAroundDFS(int i,int j, char[][] board)
	{
		board[i][j] = 'A';
		
		if(i>0&&board[i-1][j]=='O')
		{
			visitAroundDFS(i-1, j, board);
		}
		if(i<height-1&&board[i+1][j]=='O')
		{
			visitAroundDFS(i+1,j,board);
		}
		if(j>0 && board[i][j-1]=='O')
		{
			visitAroundDFS(i,j-1,board);
		}
		if(j<width-1 && board[i][j+1]=='O')
		{
			visitAroundDFS(i,j+1,board);
		}
	
	}
	
	
	public void solve(char[][] board) {
        //X O
		if(board==null|| board.length==0) return;
		init(board);
		//first and last row
		for(int j=0;j<width;j++)
		{
			//第一条边，向下，向右搜索
			if( board[0][j]=='O')
			{
				visitAroundDFS(0, j, board);
				visitAroundDFS(height-1,j, board);
			}
			
		}
		 
		
		//first and last column
		for(int i=0;i<height;i++)
		{
			if(board[i][0]=='O'){
				visitAroundDFS(i,0,board);
				visitAroundDFS(i,width-1,board);
			}
		}
		
		
		
		for(int i=1;i<height-1;i++)
			for(int j=1;j<width-1;j++)
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
		String str[] = {"XOOOOOOOOOOOOOOOOOOO",
						"OXOOOOXOOOOOOOOOOOXX",
						"OOOOOOOOXOOOOOOOOOOX",
						"OOXOOOOOOOOOOOOOOOXO",
						"OOOOOXOOOOXOOOOOXOOX",
						"XOOOXOOOOOXOXOXOXOXO",
						"OOOOXOOXOOOOOXOOXOOO",
						"XOOOXXXOXOOOOXXOXOOO",
						"OOOOOXXXXOOOOXOOXOOO",
						"XOOOOXOOOOOOXXOOXOOX",
						"OOOOOOOOOOXOOXOOOXOX",
						"OOOOXOXOOXXOOOOOXOOO",
						"XXOOOOOXOOOOOOOOOOOO",
						"OXOXOOOXOXOOOXOXOXOO",
						"OOXOOOOOOOXOOOOOXOXO",
						"XXOOOOOOOOXOXXOOOXOO",
						"OOXOOOOOOOXOOXOXOXOO",
						"OOOXOOOOOXXXOOXOOOXO",
						"OOOOOOOOOOOOOOOOOOOO",
						"XOOOOXOOOXXOOXOXOXOO"};
//		String str[]={"OOOOXX","OOOOOO","OXOXOO","OXOOXO","OXOXOO","OXOOOO"};
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
