package quadrilateral_winter_project;

import java.text.DecimalFormat;

public class Point3 {

	static DecimalFormat fmt = new DecimalFormat("0.##");
	private double x;
	private double y;

	public Point3() {
		x = 0;
		y = 0;
	}

	public Point3(double a, double b) {
		x = a;
		y = b;
	}

	public Point3(Rational a, Rational b) {
		x = a.decimalValue();
		y = b.decimalValue();
	}

	public Point3(Point3 P) {
		x = P.getX();
		y = P.getY();
	}

	public Point3 midPoint(Point3 N) {
		return new Point3();
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double newX) {
		x = newX;
	}

	public void setY(double newY) {
		y = newY;
	}

	public void setXY(double newX, double newY) {
		x = newX;
		y = newY;
	}

	public boolean equals(Point3 P) {
		return (this.getX() == P.getX() && this.getY() == P.getY());
	}

	public double distanceTo(Point3 P) {
		double distance = Math.sqrt(Math.pow((P.getX() - this.getX()), 2.0) + Math.pow((P.getY() - this.getY()), 2.0));
		return distance;
	}

	public String toString() {
		return "(" + fmt.format(x) + "  ,  " + fmt.format(y) + ")";
	}

}
