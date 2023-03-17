package pa_graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class GraphMain {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fileName="D:\\graphfile.txt";
		try {
		
			final FileInputStream fileInput=new FileInputStream(fileName);
			final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInput));
			
			
			InMatrix(bufferedReader);
			
			
			
			//Lấy phần tử đàu tiên
			int FristLine=Integer.valueOf(bufferedReader.readLine());
			
			//Tạo ma trận
			int Matrix[][] = new int[FristLine][FristLine];
			
			//arr Lấy từng hàng và arrGet khởi tạo chuẩn bị tách
			String[] arr = new String[FristLine];
			String[] arrGet = new String[FristLine];
			
			String line; int a=0;
			while((line=bufferedReader.readLine())!=null) {
				
				if(a!=FristLine)
				arr[a]=line;
				else break;
				
				a++;
				
			}
			
			for(int i =0 ;i<FristLine;i++) {
				//arrGet tách
				arrGet=arr[i].split(" ");
				for(int j =0 ;j<FristLine;j++) {
					//Đưa vào matrix
					Matrix[i][j]=Integer.valueOf(arrGet[j]);
				}
			}
			
			
			
			
			
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					System.out.print(Matrix[i][j]);
				}
				System.out.println();

			}
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void InMatrix(BufferedReader bufferedReader) {
		
		String line;
		
		try {
		
		while((line=bufferedReader.readLine())!=null)
			{
				System.out.println(line);
			}
		
		}catch(IOException IOe) {
			IOe.printStackTrace();
		}
		
	}
	
	
	
	
}
