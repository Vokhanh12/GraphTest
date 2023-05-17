package pa_graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphMain {

	public static final int MAX = 100;
	public static final String[] MATRIX_ONLY = { "0", "1" };
	public static boolean checkNumber;

	public static ArrayList<EDGE> listEDGE = new ArrayList<EDGE>();

	public static Queue<EDGE> ChoiceMinElement = new PriorityQueue<>(Comparator.comparingInt(EDGE::getWeight));

	public static List<Integer> V_list = new ArrayList<>();
	public static List<Integer> X1_list = new ArrayList<>();
	public static List<EDGE> T_list = new ArrayList<>();
	public static Queue<EDGE> SELECT_WIDTH_GRAPH = new PriorityQueue<>(Comparator.comparingInt(EDGE::getWeight));
	public static Boolean Duyet_V = true;

	public class GRAPH_MATRIX {
		private int n;
		private int[][] Matrix = new int[MAX][MAX];

		private int Line = 0;

		public int getLine() {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (Matrix[i][j] != 0) {
						Line++;
					}
				}
			}

			return Line;

		}

		public GRAPH_MATRIX(int n) {
			this.n = n;

		}

		public int nGet() {
			return n;
		}

		public void nSet(int nSet) {
			this.n = nSet;
		}

		public void MatrixSet(int cols, int rows, int value) {
			this.Matrix[cols][rows] = value;
		}

		public void MatrixGet(int cols, int rows) {

			for (int i = 0; i < cols; i++) {
				for (int j = 0; j < rows; j++) {
					System.out.print(Matrix[i][j] + " ");
				}
				System.out.println("");
			}
		}
		public int calculateDegreeSum() {
		    int degreeSum = 0;
		    for (int i = 0; i < n; i++) {
		        int degree = 0;
		        for (int j = 0; j < n; j++) {
		            degree += Matrix[i][j];
		        }
		        degreeSum += degree;
		    }
		    return degreeSum;
		}
		
		public void KiemTraMaTranHopLe() {
			int check = 0;
			if (checkNumber) {
				for (int i = 0; i < this.n; i++) {
					if (Matrix[i][i] != 0) {
						System.out.println("Ma tran khong hop le");
						break;
					} else if (check != n - 1)
						check++;
					else {
						MatrixGet(n, n);
						System.out.println("Ma tran nay hop le");
					}
				}
			}
		}

		public void KiemTraDoThiVoHuong() {

			boolean check = false;

			for (int i = 0; i < this.n; i++) {
				for (int j = 0; j < this.n; j++) {
					if (Matrix[i][j] != Matrix[j][i]) {
						check = false;
						break;
					} else
						check = true;
				}
			}

			if (check) {
				System.out.println("Day la do thi vo huong");
			} else {
				System.out.println("Day khong phai la do thi vo huong");
			}

		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GraphMain gm = new GraphMain();
		GraphMain.GRAPH_MATRIX g = gm.new GRAPH_MATRIX(5);
		

		 int[][] matrix1 = {
		            {0, 3, 3, 2, 2},
		            {3, 0, 2, 3, 2},
		            {3, 2, 0, 1, 4},
		            {2, 3, 1, 0, 4},
		            {2, 2, 4, 5, 0}
		        };

		        int n = matrix1.length;
		        int[] degrees = new int[n];
		        int sumDegree = 0;
		        int oddDegreeCount = 0;
		        int evenDegreeCount = 0;

		        // Tính tổng bậc của các đỉnh
		        for (int i = 0; i < n; i++) {
		            int degree = 0;
		            for (int j = 0; j < n; j++) {
		                degree += matrix1[i][j];
		            }
		            degrees[i] = degree;
		            sumDegree += degree;
		        }

		        // Đếm số đỉnh bậc lẻ và bậc chẳn
		        for (int i = 0; i < n; i++) {
		            if (degrees[i] % 2 == 0) {
		                evenDegreeCount++;
		            } else {
		                oddDegreeCount++;
		            }
		        }

		        System.out.println("Tổng bậc của đồ thị: " + sumDegree);
		        System.out.println("Số đỉnh bậc lẻ: " + oddDegreeCount);
		        System.out.println("Số đỉnh bậc chẳn: " + evenDegreeCount);

		
		

		String fileName = "D:\\file.txt";
		try {

			FileInputStream fileInput = new FileInputStream(fileName);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInput));

			// Lấy phần tử đàu tiên
			int FristLine = Integer.valueOf(bufferedReader.readLine());

			// Tạo ma trận

			// arr Lấy từng hàng và arrGet khởi tạo chuẩn bị tách
			String[] arr = new String[FristLine];
			String[] arrGet = new String[FristLine];

			String line;
			int a = 0;
			while ((line = bufferedReader.readLine()) != null) {

				if (a != FristLine)
					arr[a] = line;
				else
					break;

				a++;

			}

			loop0: for (int i = 0; i < FristLine; i++) {
				// arrGet tách
				arrGet = arr[i].split(" ");
				loop1: for (int j = 0; j < FristLine; j++) {

					if (arrGet[j].equals("0") || arrGet[j].equals("1") || arrGet[j].equals("2") || arrGet[j].equals("3")
							|| arrGet[j].equals("4") || arrGet[j].equals("5") || arrGet[j].equals("6")
							|| arrGet[j].equals("7") || arrGet[j].equals("8") || arrGet[j].equals("9")
							|| arrGet[j].equals("10")) {
						// Đưa vào matrix
						g.Matrix[i][j] = Integer.valueOf(arrGet[j]);
						checkNumber = true;

					} else {
						System.out.println("Trong ma tran khong co con so nay:" + arrGet[j]);
						checkNumber = false;
						break loop0;

					}

				}
			}

			/*
			 * for(int i=0;i<4;i++) { for(int j=0;j<4;j++) {
			 * System.out.print(g.Matrix[i][j]); } System.out.println();
			 * 
			 * }
			 * 
			 */

			bufferedReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Kiểm tra ma trận hợp lê
		g.KiemTraMaTranHopLe();
		// Kiểm tra ma trận Vô hướng
		g.KiemTraDoThiVoHuong();

		 int degreeSum = g.calculateDegreeSum();
	        System.out.println("Tổng bậc của đồ thị: " + degreeSum);
		//In ra cây khung
		PrinAlg(g, 1);
		
		//PrinDijsktra(g,1);

	}

	public static void InMatrix(BufferedReader bufferedReader) {

		String line;

		try {

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException IOe) {
			IOe.printStackTrace();
		}

	}
	
	
	public static void PrinDijsktra(GRAPH_MATRIX graph,int run) {

		int n = graph.nGet();

		int DUYET;

		//Thêm phần tử V_list bắt đầu là -1
		V_list.add(-1);

		// Start graph 1
		// V_list.add(DUYET);
		// Start graph remaining elment
		for (int i = 0; i < n; i++) {
			X1_list.add(i);
		}

		// Thêm và xem các phần tử EDGE(đỉnh 1,đỉnh 2,Trọng số)
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				if (graph.Matrix[j][k] != 0) {
					listEDGE.add(new EDGE(j, k, graph.Matrix[j][k]));
					ChoiceMinElement.offer(new EDGE(j, k, graph.Matrix[j][k]));
				}
			}

		}

		/*
		 * for(EDGE edge : listEDGE) { System.out.println(""+edge.toString()); }
		 */

		System.out.println("Line in graph:" + ChoiceMinElement.size());
		System.out.println(X1_list);

		while (!ChoiceMinElement.isEmpty()) {
			EDGE edge = ChoiceMinElement.poll();
			System.out.println(edge.toString());
		}

		DUYET_prim(0, graph);

		
		
	}
	

	public static void PrinAlg(GRAPH_MATRIX graph, int run) {
		
		
		
		
		
		int n = graph.nGet();

		int DUYET;

		//Thêm phần tử V_list bắt đầu là -1
		V_list.add(-1);

		// Start graph 1
		// V_list.add(DUYET);
		// Start graph remaining elment
		for (int i = 0; i < n; i++) {
			X1_list.add(i);
		}

		// Thêm và xem các phần tử EDGE(đỉnh 1,đỉnh 2,Trọng số)
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				if (graph.Matrix[j][k] != 0) {
					listEDGE.add(new EDGE(j, k, graph.Matrix[j][k]));
					ChoiceMinElement.offer(new EDGE(j, k, graph.Matrix[j][k]));
				}
			}

		}

		/*
		 * for(EDGE edge : listEDGE) { System.out.println(""+edge.toString()); }
		 */

		System.out.println("Line in graph:" + ChoiceMinElement.size());
		System.out.println(X1_list);

		while (!ChoiceMinElement.isEmpty()) {
			EDGE edge = ChoiceMinElement.poll();
			System.out.println(edge.toString());
		}

		DUYET(0, graph);

	}

	public static void DUYET_prim(int Dinh, GRAPH_MATRIX graph) {
		//public static List<Integer> V_list = new ArrayList<>();
		//public static List<Integer> X1_list = new ArrayList<>();
		//public static List<EDGE> T_list = new ArrayList<>();
		//public static Queue<EDGE> SELECT_WIDTH_GRAPH = new PriorityQueue<>(Comparator.comparingInt(EDGE::getWeight));

		
		//x1_list= {0,1,2,3,4,5,6,7,8,9,10}
		//V_list={-1}
		//graph.n = 10
		
		//0 4 5 0 8 3 0 0 0 0 0 
		//0 0 8 8 0 2 0 4 0 0 0 
		//0 0 0 3 2 0 0 0 10 0 0 
		//8 0 0 0 0 0 0 9 0 0 0 
		//0 0 0 0 4 0 9 0 0 0 0 
		//0 0 0 0 0 10 0 0 0 5 4 
		//0 0 0 0 0 0 0 0 5 0 10 
		//0 0 0 0 0 0 0 0 4 10 0 
		
		
		if (!X1_list.isEmpty()) {
			
			loop1: for (int i = 0; i < graph.n; i++) {
				if (graph.Matrix[Dinh][i] != 0) {
					int count =0;
					loop2: for(int j = 0;j < V_list.size(); j++) {
						int item = V_list.get(j);
							if (item != Dinh && item != i) {
								count++;
								if(count == V_list.size()) {
									SELECT_WIDTH_GRAPH.offer(new EDGE(Dinh, i, graph.Matrix[Dinh][i]));
								}
								else {
									
								}
							}
					}
					//T_list.add(new EDGE(Dinh,i,graph.Matrix[Dinh][i]));}

				}
			}
			
			V_list.add(Dinh);
			System.out.println("X1_LIST_AFTER"+X1_list.toString());
			System.out.println("V_LIST:"+V_list);

			if(Dinh==0) {
				X1_list.remove(Integer.valueOf(0));
			}
			else {
				X1_list.remove(Integer.valueOf(Dinh));
			}
			System.out.println("X1_LIST_BEFORE"+X1_list.toString());
			
			
			
			// Dùng để loại bỏ trùng
			// Lặp qua các phần tử trong hàng đợi
			for (int i = 0; i < V_list.size(); i++) {
			    final int itemvl_slow_browsing = V_list.get(i);

			    // Tạo một Comparator để so sánh phần tử
			    Comparator<EDGE> edgeComparator = Comparator.comparingInt(EDGE::getWeight);

			    for (int j = 0; j < V_list.size(); j++) {
			        final int itemvl_fast_browsing = V_list.get(j);
			        EDGE targetEdge = null;

			        for (Iterator<EDGE> iterator = SELECT_WIDTH_GRAPH.iterator(); iterator.hasNext();) {
			            EDGE edge = iterator.next();

			            if (edge.getX() == itemvl_slow_browsing && edge.getE() == itemvl_fast_browsing) {
			                targetEdge = edge;
			                iterator.remove(); // Xóa phần tử từ iterator
			                break;
			            }
			        }

			        if (targetEdge != null) {
			            // Phần tử đã được xóa khỏi hàng đợi
			            System.out.println("Tìm thấy phần tử trùng: " + targetEdge.toString());
			            System.out.println("Phần tử đã được xóa khỏi hàng đợi.");
			        } else {
			            System.out.println("Không tìm thấy phần tử cần xóa trong hàng đợi.");
			        }
			    }
			}
			
			for(int i = 0 ; i < V_list.size() ; i++) {
				
			}
			
			System.out.println("T_LIST:"+T_list);
			System.out.println("SELECT_WIDTG_GRAPH_AFTER:"+SELECT_WIDTH_GRAPH);
			EDGE edge = SELECT_WIDTH_GRAPH.poll();
			System.out.println("SELECT_WIDTG_GRAPH_BEFORE:"+SELECT_WIDTH_GRAPH);
			

			
				int count1=0;
				for(int i = 0;i < V_list.size(); i++) {
					int itemvl = V_list.get(i);
					System.out.println("V_List1:"+itemvl);
					System.out.println("current_edge:"+edge.E);
					System.out.println("current_edge_get:"+edge.getE());
							if (itemvl != edge.E) {
								count1++;
								System.out.println("Thêm +");
								System.out.println("size_Vlist:"+V_list.size());
								if(count1 == V_list.size()) {
									System.out.println("size_Vlist success");
								try {

							System.out.println("E:" + edge.getE());

							
							T_list.add(edge);


							DUYET(edge.getE(), graph);

						} catch (Exception ex) {
							ex.printStackTrace();
						}

					}
				}
			}
			
			
			
			
			
			
		}
		
	}
	
	public static void DUYET(int Dinh, GRAPH_MATRIX graph) {
			
			//public static List<Integer> V_list = new ArrayList<>();
			//public static List<Integer> X1_list = new ArrayList<>();
			//public static List<EDGE> T_list = new ArrayList<>();
			//public static Queue<EDGE> SELECT_WIDTH_GRAPH = new PriorityQueue<>(Comparator.comparingInt(EDGE::getWeight));
	
			
			//x1_list= {0,1,2,3,4,5,6,7,8,9,10}
			//V_list={-1}
			//graph.n = 10
			
			//0 4 5 0 8 3 0 0 0 0 0 
			//0 0 8 8 0 2 0 4 0 0 0 
			//0 0 0 3 2 0 0 0 10 0 0 
			//8 0 0 0 0 0 0 9 0 0 0 
			//0 0 0 0 4 0 9 0 0 0 0 
			//0 0 0 0 0 10 0 0 0 5 4 
			//0 0 0 0 0 0 0 0 5 0 10 
			//0 0 0 0 0 0 0 0 4 10 0 
	
			if (!X1_list.isEmpty()) {
	
				loop1: for (int i = 0; i < graph.n; i++) {
					if (graph.Matrix[Dinh][i] != 0) {
						int count =0;
						loop2: for(int j = 0;j < V_list.size(); j++) {
							int item = V_list.get(j);
								if (item != Dinh && item != i) {
									count++;
									if(count == V_list.size()) {
										SELECT_WIDTH_GRAPH.offer(new EDGE(Dinh, i, graph.Matrix[Dinh][i]));
									}
									else {
										
									}
								}
						}
						//T_list.add(new EDGE(Dinh,i,graph.Matrix[Dinh][i]));}
	
					}
				}
	
				/*
				 * while(!SELECT_WIDTH_GRAPH.isEmpty()) { EDGE edge = SELECT_WIDTH_GRAPH.poll();
				 * System.out.println(edge.toString()); }
				 */
				
				V_list.add(Dinh);
				System.out.println("X1_LIST_AFTER"+X1_list.toString());
				System.out.println("V_LIST:"+V_list);
	
				if(Dinh==0) {
					X1_list.remove(Integer.valueOf(0));
				}
				else {
				X1_list.remove(Integer.valueOf(Dinh));
				}
				System.out.println("X1_LIST_BEFORE"+X1_list.toString());
	
				
	
				// Dùng để loại bỏ trùng
				// Lặp qua các phần tử trong hàng đợi
				for (int i = 0; i < V_list.size(); i++) {
				    final int itemvl_slow_browsing = V_list.get(i);
	
				    // Tạo một Comparator để so sánh phần tử
				    Comparator<EDGE> edgeComparator = Comparator.comparingInt(EDGE::getWeight);
	
				    for (int j = 0; j < V_list.size(); j++) {
				        final int itemvl_fast_browsing = V_list.get(j);
				        EDGE targetEdge = null;
	
				        for (Iterator<EDGE> iterator = SELECT_WIDTH_GRAPH.iterator(); iterator.hasNext();) {
				            EDGE edge = iterator.next();
	
				            if (edge.getX() == itemvl_slow_browsing && edge.getE() == itemvl_fast_browsing) {
				                targetEdge = edge;
				                iterator.remove(); // Xóa phần tử từ iterator
				                break;
				            }
				        }
	
				        if (targetEdge != null) {
				            // Phần tử đã được xóa khỏi hàng đợi
				            System.out.println("Tìm thấy phần tử trùng: " + targetEdge.toString());
				            System.out.println("Phần tử đã được xóa khỏi hàng đợi.");
				        } else {
				            System.out.println("Không tìm thấy phần tử cần xóa trong hàng đợi.");
				        }
				    }
				}
				
				
				System.out.println("T_LIST:"+T_list);
				System.out.println("SELECT_WIDTG_GRAPH_AFTER:"+SELECT_WIDTH_GRAPH);
				EDGE edge = SELECT_WIDTH_GRAPH.poll();
				System.out.println("SELECT_WIDTG_GRAPH_BEFORE:"+SELECT_WIDTH_GRAPH);
				
	
				
					int count1=0;
					for(int i = 0;i < V_list.size(); i++) {
						int itemvl = V_list.get(i);
						System.out.println("V_List1:"+itemvl);
						System.out.println("current_edge:"+edge.E);
						System.out.println("current_edge_get:"+edge.getE());
								if (itemvl != edge.E) {
									count1++;
									System.out.println("Thêm +");
									System.out.println("size_Vlist:"+V_list.size());
									if(count1 == V_list.size()) {
										System.out.println("size_Vlist success");
									try {
	
								System.out.println("E:" + edge.getE());
	
								
								T_list.add(edge);
	
	
								DUYET(edge.getE(), graph);
	
							} catch (Exception ex) {
								ex.printStackTrace();
							}
	
						}
					}
					/*
				try {
					EDGE edge = SELECT_WIDTH_GRAPH.poll();
	
					System.out.println("E:" + edge.getE());
	
					V_list.add(Dinh);
					
					T_list.add(edge);
					
					if(Dinh==0) {
						X1_list.remove(Integer.valueOf(0));
					}
					else {
					X1_list.remove(Integer.valueOf(edge.getE()));
					}
	
					DUYET(edge.getE(), graph);
	
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				*/
	
			}
	
		}
	}
}
