package Utils.iotest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class ScannerTest {
	public void inputFromConsole()
	{
		Scanner scanner=new Scanner(System.in);
        for(int i=0;i<5;i++){
        	double a=scanner.nextDouble();
        	System.out.println(a);
        }
	}
	
	public void inputFromFile(String path)
	{
		try {
			FileWriter fout=new FileWriter(path);
	        fout.write("2 2.2  done test \n 5");//往文件里写入这一字符串
	        fout.close();
	        
			Scanner scanner  = new Scanner(new File(path));
			int a = scanner.nextInt();
			double b =scanner.nextDouble();
			String s = scanner.next();
			String s2 = scanner.next();
			int c  =scanner.nextInt();
			
			System.out.println(a+" "+b+" "+s2+" "+c);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScannerTest st =  new ScannerTest();
		//st.inputFromConsole();
		String path = "Utils/iotest/test.txt";
		st.inputFromFile(path);
	}

}
