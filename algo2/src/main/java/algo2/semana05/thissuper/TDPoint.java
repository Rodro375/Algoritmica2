package algo2.semana05.thissuper;

class TDPoint extends Point{
	double z;
	TDPoint(double x, double y, double z){
		super(x, y);
		this.z = z;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %f", super.toString(), z);
	}
	
	public static void main(String[] args) {
		TDPoint p1 = new TDPoint(0, 0, 0);
		TDPoint p2 = new TDPoint(1, 2, 3);
		System.out.println(p1);
		System.out.println(p2);
	}
}