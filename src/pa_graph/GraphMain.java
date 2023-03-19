package pa_graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class GraphMain {
	
	public static final int MAX = 100;
	public static final String[] MATRIX_ONLY= {"0","1"};
	
	public class GRAPH_MATRIX{
		private int n;
		private int[][] Matrix = new int[MAX][MAX];
		
		public GRAPH_MATRIX(int n) {
			this.n=n;
		}
		
		public int nGet() {
			return n;
		}
		
		public void nSet(int nSet) {
			this.n=nSet;
		}
		
		public void MatrixSet(int cols,int rows ,int value) {
			this.Matrix[cols][rows]=value;
		}
		
		public void MatrixGet(int cols,int rows) {
			
			for(int i=0;i<cols;i++) {
				for(int j=0;j<rows;j++) {
					System.out.print(Matrix[i][j]+" ");
				}
				System.out.println("");
			}
		}
		
		public void KiemTraMaTranHopLe() {
			int check=0;
			for(int i=0;i<this.n;i++) {
				if(Matrix[i][i]!=0)
				{
					System.out.println("Ma tran khong hop le");
					break;
				} else if(check!=n-1)
					check++;
				  else {MatrixGet(n,n);System.out.println("Ma tran nay hop le");}
			}
		}
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GraphMain gm = new GraphMain();
		GraphMain.GRAPH_MATRIX g = gm.new GRAPH_MATRIX(4);
		
		
		String fileName="D:\\graphfile.txt";
		try {
		
			FileInputStream fileInput=new FileInputStream(fileName);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInput));
			
			
			//Lấy phần tử đàu tiên
			int FristLine=Integer.valueOf(bufferedReader.readLine());
			
			//Tạo ma trận
			
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
			
			loop0:for(int i =0 ;i<FristLine;i++) {
				//arrGet tách
				arrGet=arr[i].split(" ");
				loop1:for(int j =0 ;j<FristLine;j++) {
					
						if(arrGet[j].equals("0")||arrGet[j].equals("1")) {
							//Đưa vào matrix
							g.Matrix[i][j]=Integer.valueOf(arrGet[j]);

						}else {
							System.out.println("Trong ma tran khong co con so nay:"+arrGet[j]);
							break loop0;
						
					}

					
				}
			}
			
			
			
			
			
	/*		for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					System.out.print(g.Matrix[i][j]);
				}
				System.out.println();

			}
			
			*/
			
		bufferedReader.close();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		g.KiemTraMaTranHopLe();
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
