package pa_graph;

public class EDGE {

	int X;
	int E;

	int weight;

	public EDGE(int X, int E, int weight) {
		this.X = X;
		this.E = E;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "@EDGE[X=" + X + ",E=" + E + "]" + "Weight:" + weight;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getE() {
		return E;
	}

	public void setE(int e) {
		E = e;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
