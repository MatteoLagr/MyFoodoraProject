package users;

public class Point2D {
	
	private double x;
	private double y;
	
	
	public Point2D(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x=x;
	}
	
	public void setY(double y) {
		this.y=y;
	}
	
	public double distanceTo(Point2D point) {
		double dx = this.x - point.x;
		double dy = this.y - point.y;
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	
}
