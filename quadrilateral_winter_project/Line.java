package quadrilateral_winter_project;


import chapter5.Rational2;

public class Line {
	private double m;
	private double b;
	private double xIntercept;
	private boolean isVertical;
	private boolean isHorizontal;

	public Line() { // y = x
		m = 1;
		b = 0;
		isHorizontal = false;
		isVertical = false;
		xIntercept = 0;
	}

	public Line(double slope, double yInt) {
		m = slope;
		b = yInt;
		if (m == 0) { // Check for Horizontal
			isHorizontal = true;
		}
		isVertical = false;
		xIntercept = (-1 * b) / m;
	}

	public Line(Point3 A, Point3 B) {
		double x1 = A.getX(), y1 = A.getY(), x2 = B.getX(), y2 = B.getY();
		if (Math.abs(x2 - x1) < .001) { // Check for vertical
			xIntercept = x1;
			isVertical = true;
		} else {
			isVertical = false;
			m = (y2 - y1) / (x2 - x1);
			//System.out.println(m);
			b = y1 - (m * x1);
			xIntercept = (-1 * b) / m;
		}
		if (m == 0) { // Check for horizontal
			isHorizontal = true;
		}
	}

	public Line(Point3 A, double slope) {
		m = slope;
		b = A.getY() - (m * A.getX());
		xIntercept = (-1 * b) / m;
		if (m == 0) {
			isHorizontal = true;
		}
		isVertical = false;
	}

	public Line(int a, int b, int c) {
		if (b == 0) {
			isVertical = true;
			xIntercept = (double)c / a;
		} else {
			m = (double) (-1 * a) / b;
			this.b = (double) c / b;
			xIntercept = (-1 * this.b) / m;
			isVertical = false;
		}
		if (m == 0) {
			isHorizontal = true;
		}
	}

	public boolean isVertical() {
		return isVertical;
	}

	public boolean isHorizontal() {
		return isHorizontal;
	}

	public double getSlope() {
		return m;
	}

	public double getYintercept() {
		return b;
	}

	public double getXintercept() {
		return xIntercept;
	}

	public boolean equals(Line l) {
		return Math.abs(this.getSlope() - l.getSlope()) < .01
				&& Math.abs(this.getYintercept() - l.getYintercept()) < .01;
	}

	public boolean isParallel(Line l) {
		if((l.isVertical && this.isHorizontal) || (this.isVertical && l.isHorizontal)) {
			return false;
		}
		return Math.abs(this.getSlope() - l.getSlope()) < .01;
	}

	public boolean isPerpendicular(Line l) {
		return (Math.abs(this.getSlope() - (-1 / l.getSlope())) < .01);
	}

	public Point3 intersection(Line l) {
		double m1 = this.getSlope(), b1 = this.getYintercept(), m2 = l.getSlope(), b2 = l.getYintercept();
		if (this.isVertical() && l.isVertical()) { // Both l1, l2 Vertical
			if (l.getXintercept() == this.getXintercept()) {
				System.out.println("Infinite Solutions");
				return null;
			} else {
				System.out.println("No Solutions");
				return null;
			}
		} else if (this.isVertical() || l.isVertical()) { // Either l1, l2 vertical
			if(this.isVertical && l.isHorizontal) {
				return new Point3(this.getXintercept(), l.getYintercept());
			}
			else if(l.isVertical && this.isHorizontal) {
				return new Point3(l.getXintercept(), this.getYintercept());
			}
			if (this.isVertical() && !l.isHorizontal) {
				return new Point3(this.getXintercept(), l.evaluate(this.getXintercept()));
			}
			return new Point3(l.getXintercept(), this.evaluate(l.getXintercept()));
		} else if (this.isParallel(l)) { // Parallel Lines
			if (b1 != b2) {
				System.out.println("No solutions");
				return null;
			} else {
				System.out.println("Infinite Solutions");
				return null;
			}
		}
		double x = (b2 - b1) / (m1 - m2);
		return new Point3(x, this.evaluate(x));

	}

	public double evaluate(double x) {
		return x * m + b;
	}

	public String toString() {
		Rational2 b1 = new Rational2(b); // Converts the decimal value of the b to a fraction
		if(isVertical) {
			Rational2 xInt = new Rational2(xIntercept); // Converts the decimal value xInt to a fraction
			return "x = " + xInt;
		}
		else if(isHorizontal) {
			return "y = " + b1;
		}
		Rational2 m1 = new Rational2(m); // Converts the decimal value of m to a fraction
		return "y = " + m1 + "x + " + b1;
	}

}
