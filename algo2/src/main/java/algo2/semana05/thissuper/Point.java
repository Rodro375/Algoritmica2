package algo2.semana05.thissuper;

class Point{
	double x, y;
	Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	Point(){
		this(0, 0);
	}
	
	public String toString() {
		return String.format("%f, %f", x, y);
	}
	
	public static void main(String[] args) {
		Point p1 = new Point();
		Point p2 = new Point(2, 3);
		System.out.println(p1);
		System.out.println(p2);
	}
}