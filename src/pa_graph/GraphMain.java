package pa_graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;


public class GraphMain {
	
	public static final int MAX = 100;
	public static final String[] MATRIX_ONLY= {"0","1"};
	public static boolean checkNumber;
	
	public class GRAPH_MATRIX{
		private int n;
		private int[][] Matrix = new int[MAX][MAX];
		
		private int Line=0;
		
		public int getLine() {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(Matrix[i][j]!=0) {
						Line++;
					}
				}
			}
			
			return Line;
			
		}
		
		
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
			if(checkNumber) {
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
		
	public void KiemTraDoThiVoHuong() {
		
		boolean check=false;
		
		for(int i=0;i<this.n;i++) {
			for(int j=0;j<this.n;j++) {
				if(Matrix[i][j]!=Matrix[j][i])
				{
					check=false;
					break;
				}
				else check=true;
			}
		}
		
		if(check) {
			System.out.println("Day la do thi vo huong");
		} else {System.out.println("Day khong phai la do thi vo huong");}
		
	}
}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GraphMain gm = new GraphMain();
		GraphMain.GRAPH_MATRIX g = gm.new GRAPH_MATRIX(6);
		
		
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
					
						if(arrGet[j].equals("0")||arrGet[j].equals("1")||arrGet[j].equals("2")||arrGet[j].equals("3")
								||arrGet[j].equals("4")||arrGet[j].equals("5")||arrGet[j].equals("5")
								||arrGet[j].equals("6")||arrGet[j].equals("7")||arrGet[j].equals("8")||arrGet[j].equals("9")) {
							//Đưa vào matrix
							g.Matrix[i][j]=Integer.valueOf(arrGet[j]);
							checkNumber=true;

						}else {
							System.out.println("Trong ma tran khong co con so nay:"+arrGet[j]);
							checkNumber=false;
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
		g.KiemTraDoThiVoHuong();
		
		
		PrinAlg(g, 1);
		
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
	
	public static void PrinAlg(GRAPH_MATRIX graph,int run) {
		int n = graph.nGet();
		
		
		
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				
			}
		}
		
		LinkedList<EDGE> listEDGE = new LinkedList<EDGE>();
		int[] V = new int[n];
		int[] X1 = new int[n];
		
			
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(graph.Matrix[j][k]!=0) {
						listEDGE.add(new EDGE(j,k));
					}
				}
				
			}
			
			
			
			
			for(EDGE edge : listEDGE) {
				System.out.println(""+edge.toString());
			}
		
		 
		
		
		
		
		
	}        
	
	
}
