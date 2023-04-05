package pa_graph;

public class EDGE {
	
	int X;
	int E;
	
	public EDGE (int X,int E) {
		this.X=X;
		this.E=E;
	}

	@Override
	public String toString() {
		return "@EDGE[X="+X+",E="+E+"]";
	}
	
}
