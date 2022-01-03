package quadrilateral_winter_project;

/*STUDENT VERSION DO NOT EDIT*/

public class Quadrilateral {
	/*
	 * Point3s are created in clockwise order such that: A is top left B is top right
	 * C is bottom right D is bottom left
	 */
	private Point3 A;
	private Point3 B;
	private Point3 C;
	private Point3 D;
	private String type;

	// default constructor
	public Quadrilateral() {
		genA();
		genB();
		genC();
		genD();
		type = classify();
		// assign value to type using classify method
	}

	// overloaded constructor
	/*
	 * Creates a quadrilateral based upon the String type passed as a parameter.
	 * type: Parallelogram, Rhombus, Rectangle, Square and Trapezoid EXTRA CREDIT:
	 * kite Use classify method to initialize type.
	 */
	public Quadrilateral(String str) {
		type = str;
		if (type.equalsIgnoreCase("Parallelogram")) {
			initParallelogram();
		} else if (type.equalsIgnoreCase("Rectangle")) {
			initRectangle();
		} else if (type.equalsIgnoreCase("Square")) {
			initSquare();
		} else if (type.equalsIgnoreCase("Rhombus")) {
			initRhombus();
		} else if (type.equalsIgnoreCase("Kite")) {
			initKite();
		} else {
			System.out.println("Error! Didn't Specify A Correct Type.");
		}
	}

	// random point with x ->[0-90], y->[0,90], x and y are multiples of 10
	private void genA() {
		int x = (int) (Math.random() * 10) * 10;
		int y = (int) (Math.random() * 10) * 10;
		A = new Point3(x, y);
	}

	// random point with x ->[110-200], y->[0,90], x and y are multiples of 10
	private void genB() {
		int x = (int) (Math.random() * 10) * 10 + 110;
		int y = (int) (Math.random() * 10) * 10;
		B = new Point3(x, y);
	}

	// random point with x ->[110-200], y->[110,200], x and y are multiples of 10
	private void genC() {
		int x = (int) (Math.random() * 10) * 10 + 110;
		int y = (int) (Math.random() * 10) * 10 + 110;
		C = new Point3(x, y);
	}

	// random point with x ->[0-90], y->[110,200], x and y are multiples of 10
	private void genD() {
		int x = (int) (Math.random() * 10) * 10;
		int y = (int) (Math.random() * 10) * 10 + 110;
		D = new Point3(x, y);
	}

	public Point3 getA() {
		return A;
	}

	public Point3 getB() {
		return B;
	}

	public Point3 getC() {
		return C;
	}

	public Point3 getD() {
		return D;
	}

	private void initParallelogram() {
		boolean allPoint3sValid = true;
		final int MINCX = 110, MAXCX = 200, MINCY = 110, MAXCY = 200;
		do {
			// Generate Point3 A, B, D
			genA();
			genB();
			genD();

			// Change in X and Y to be used as the vertical and horizontal change being
			// applied of points D,B
			double changeY = D.getY() - A.getY();
			double changeX = B.getX() - A.getX();

			// Finding Point3 C
			double cx = D.getX() + changeX;
			double cy = B.getY() + changeY;
			C = new Point3(cx, cy);

			allPoint3sValid = (MINCX <= C.getX() && C.getX() <= MAXCX) && (MINCY <= C.getY() && C.getY() <= MAXCY);
		} while (allPoint3sValid == false);

	}

	private void initRhombus2() {
		boolean allPoint3sValid = true;
		final int MINCX = 110, MAXCX = 200, MINCY = 110, MAXCY = 200;
		final int MINBX = 110, MAXBX = 200, MINBY = 0, MAXBY = 90;
		do {
			genA();
			genC();
			genB();
			genD();

			// Finding The Perpendicular Slope
			double x1 = A.getX(), y1 = -A.getY(), x2 = C.getX(), y2 = -C.getY();
			Line l1 = new Line(new Point3(x1, y1), new Point3(x2, y2));
			System.out.println("Slope: " + l1.getSlope());
			System.out.println(l1.getYintercept());
			double pSlope = -1 / l1.getSlope();

			// Finding The MidPoint3
			double midX = (x1 + x2) / 2;
			double midY = (y1 + y2) / 2;
			System.out.println(midX);
			System.out.println(midY);

			// Perpendicular Line Based Off the Midpoint
			double yInt = midY - (pSlope * midX);
			System.out.println("P Slope: " + pSlope + ", B: " + yInt);

			// Creating A Horizontal Line

			int b = (int) (Math.random() * 10) * 10 + 110;
			Line l2 = new Line(0, b);

			// Creating Point3 D
			System.out.println(b);
			double dx = (b + yInt) / pSlope;
			D = new Point3(dx, b);
		} while (allPoint3sValid == false);

	}

	private void initRhombus() {
		boolean allPoint3sValid = true;
		final int MINCX = 110, MAXCX = 200, MINCY = 110, MAXCY = 200;
		final int MINBX = 110, MAXBX = 200, MINBY = 0, MAXBY = 90;
		do {
			// Generate Point3 A,D
			genA();
			genD();

			// Creating Point3 B
			double xChange = D.getX() - A.getX();
			double yChange = D.getY() - A.getY();
			double bx = A.getX() + yChange; // Change in Y Coord of D-A is used to find the X Coord of B from Point3 A
			double by = A.getY() + xChange; // Change in X Coord of D-A is used to find the Y Coord of B from Point3 A
			B = new Point3(bx, by);

			// Creating Point3 C
			// Traslation for x,y should be the same since all sides are equal
			double cx = D.getX() + yChange;
			double cy = D.getY() + xChange;
			C = new Point3(cx, cy);

			allPoint3sValid = ((MINCX <= C.getX() && C.getX() <= MAXCX) && (MINCY <= C.getY() && C.getY() <= MAXCY))
					&& ((MINBX <= B.getX() && B.getX() <= MAXBX) && (MINBY <= B.getY() && B.getY() <= MAXBY));
		} while (allPoint3sValid == false || (sideLength(A, C) == sideLength(B, D)));
	}

	private void initSquare() {
		boolean allPoint3sValid = true;
		final int MINCX = 110, MAXCX = 200, MINCY = 110, MAXCY = 200;
		final int MINDX = 0, MAXDX = 90, MINDY = 110, MAXDY = 200;
		do {
			// Generate Point3 A and B
			genA();
			genB();

			// Changing X and Y
			double changeX = B.getX() - A.getX();
			double changeY = A.getY() - B.getY();

			// Finding Point3 C
			double cy = B.getY() + changeX;
			double cx = B.getX() + changeY;
			C = new Point3(cx, cy);

			// Finding Point3 D
			double dy = A.getY() + changeX;
			double dx = A.getX() + changeY;
			D = new Point3(dx, dy);
			allPoint3sValid = ((MINCX <= C.getX() && C.getX() <= MAXCX) && (MINCY <= C.getY() && C.getY() <= MAXCY))
					&& ((MINDX <= D.getX() && D.getX() <= MAXDX) && (MINDY <= D.getY() && D.getY() <= MAXDY));
		} while (allPoint3sValid == false);

	}

	private void initRectangle() {
		boolean allPoint3sValid = true;
		final int MINCX = 110, MAXCX = 200, MINCY = 110, MAXCY = 200;
		final int MINDX = 0, MAXDX = 90, MINDY = 110, MAXDY = 200;
		do {
			// Generate Point3 A and B
			genA();
			genB();

			// Finding Slope of Point3 A,B
			// Changed Y Coordinates To Negative To Make It Like A Real Coordinate Plane
			double y1 = -A.getY(), y2 = -B.getY(), x1 = A.getX(), x2 = B.getX();
			Line a_b = new Line(new Point3(x1, y1), new Point3(x2, y2));
			double slope = a_b.getSlope();

			// Perpendicular Line Based Off Of Point3 B
			double pSlope = (-1 / slope);
			double yInt = -B.getY() - (pSlope * B.getX());

			// Finding Point3 C
			double cx = 0, cy = 0;
			if (a_b.isHorizontal()) {
				cx = B.getX();
				cy = (int) (Math.random() * 10) * 10 + 110;
			} else if (pSlope < 0) {
				cy = MINCY;
				cx = (-MINCY - yInt) / pSlope;
			} else if (pSlope > 0) {
				if (-MINCX * pSlope - yInt > MAXCY) {
					cy = MAXCY;
					cx = (-MAXCY - yInt) / pSlope;
				} else {
					cx = MINCX;
					cy = -MINCX * pSlope - yInt;
				}
			}
			C = new Point3(cx, cy);

			// Finding Point3 D
			double dx = 0, dy = 0;
			if (a_b.isHorizontal()) {
				dx = A.getX();
				dy = C.getY();
			} else {
				double changeX = x1 - x2, changeY = y1 - y2;
				dx = C.getX() + changeX;
				dy = C.getY() - changeY;
			}
			D = new Point3(dx, dy);
			allPoint3sValid = ((MINCX <= C.getX() && C.getX() <= MAXCX) && (MINCY <= C.getY() && C.getY() <= MAXCY))
					&& ((MINDX <= D.getX() && D.getX() <= MAXDX) && (MINDY <= D.getY() && D.getY() <= MAXDY));
		} while (allPoint3sValid == false);

	}

	private void initKite() {

	}

	/*
	 * returns true or false based upon if quadrilateral is a parallelogram with all
	 * equal side and all equal angles.
	 */
	public boolean isSquare() {
		// Check for Parallel
		boolean ab_dc = sideSlope(A, B).getP() == sideSlope(D, C).getP()
				&& sideSlope(A, B).getQ() == sideSlope(D, C).getQ();
		boolean bc_ad = sideSlope(B, C).getP() == sideSlope(A, D).getP()
				&& sideSlope(B, C).getQ() == sideSlope(A, D).getQ();

		if (ab_dc && bc_ad) { // Check if opposite slopes are parallel
			// Checks if all side lengths are equal and diagonals are equal
			if ((sideLength(A, B) == sideLength(B, C)) && (sideLength(A, C) == sideLength(B, D))) {
				return true;
			}
		}
		return false;
	}

	/*
	 * returns true or false based upon if quadrilateral is a parallelogram. There
	 * are many sufficient conditions to prove that shape is a parallelogram. You
	 * can decide to choose any you like.
	 */
	public boolean isParallelogram() {
		// Check for Parallel
		boolean ab_dc = sideSlope(A, B).getP() == sideSlope(D, C).getP()
				&& sideSlope(A, B).getQ() == sideSlope(D, C).getQ();
		boolean bc_ad = sideSlope(B, C).getP() == sideSlope(A, D).getP()
				&& sideSlope(B, C).getQ() == sideSlope(A, D).getQ();

		if (ab_dc && bc_ad) {
			// If opposite side lengths are equal and diagonals are equal
			if (((sideLength(A, B) == sideLength(C, D)) && (sideLength(A, D) == sideLength(B, C)))
					&& (sideLength(A, C) != sideLength(B, D))) {
				return true;
			} else if (isSquare() || isRectangle() || isRhombus()) {
				return true;
			}
		}
		return false;
	}

	/*
	 * returns true or false based upon if quadrilateral is a quadrilateral with all
	 * 90 degree angles
	 */
	public boolean isRectangle() {
		// Check for Parallel
		boolean ab_dc = sideSlope(A, B).getP() == sideSlope(D, C).getP()
				&& sideSlope(A, B).getQ() == sideSlope(D, C).getQ();
		boolean bc_ad = sideSlope(B, C).getP() == sideSlope(A, D).getP()
				&& sideSlope(B, C).getQ() == sideSlope(A, D).getQ();
		if (ab_dc && bc_ad) {
			// If opposite side lengths are equal and diagonals are equal
			if ((sideLength(A, B) == sideLength(C, D)) && (sideLength(A, D) == sideLength(B, C))
					&& (sideLength(A, C) == sideLength(B, D))) {
				return true;
			}
		}
		return false;
	}

	/*
	 * returns true or false based upon if quadrilateral is a parallelogram with all
	 * equal sides
	 */
	public boolean isRhombus() {
		// Check for Parallel
		boolean ab_dc = sideSlope(A, B).getP() == sideSlope(D, C).getP()
				&& sideSlope(A, B).getQ() == sideSlope(D, C).getQ();
		boolean bc_ad = sideSlope(B, C).getP() == sideSlope(A, D).getP()
				&& sideSlope(B, C).getQ() == sideSlope(A, D).getQ();
		if (ab_dc && bc_ad) { // Check if opposite slopes are parallel
			// Checks if all side lengths are equal and diagonals are not equal
			if ((sideLength(A, B) == sideLength(B, C)) && (sideLength(A, C) != sideLength(B, D))) {
				return true;
			}
		}
		return false;
	}

	/*
	 * returns true of false based upon if quadrilateral has congruent consecutive
	 * sides.
	 */
	public boolean isKite() {

		return true;
	}

	/*
	 * returns area of the quadrilateral, in order to do this you may want to check
	 * this link: https://www.youtube.com/watch?v=JVZud7ZBEKg OR You may want to use
	 * Heron's Formula, in this case you will treat quadrilateral as two triangles
	 * and find length of the diagonal.
	 */
	public double area() {
		double area = 0;
		if (isRhombus()) { // For rhombus... multiply diagonals and divide by 2
			area = (sideLength(A, C) * sideLength(B, D)) / 2;
		} else { // Parallelogram, Square, Rectangle
			area = sideLength(A, B) * sideLength(B, C);
		}
		return area;
	}

	// returns perimeter of a quadrilateral
	public double perimeter() {
		double perimeter = 0;
		if (isParallelogram() || isRectangle()) {
			perimeter = 2 * (sideLength(A, B) + sideLength(B, C));
		} else { // Square and Rhombus
			perimeter = 4 * sideLength(A, B);
		}
		return perimeter;
	}

	// returns slope of the line formed by points L and N
	public Rational sideSlope(Point3 L, Point3 N) {
		int y1 = (int) -L.getY(), y2 = (int) -N.getY(), x1 = (int) L.getX(), x2 = (int) N.getX();
		int num = y2 - y1;
		int denom = x2 - x1;
		Rational r = new Rational(num, denom); // you will need to change this declaration
		return r;
	}

	// returns length of the line with end points in parameter
	public double sideLength(Point3 L, Point3 N) {
		double len = 0;
		double x1 = L.getX(), y1 = L.getY(), x2 = N.getX(), y2 = N.getY();
		len = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
		return len;
	}

	/*
	 * Classify quadrilateral as parallelogram, rectangle, rhombus, square or
	 * trapezoid. write code below for this method
	 */
	private String classify() {
		String result = "";
		if (isSquare()) {
			result = "Square";
		} else if (isRectangle()) {
			result = "Rectangle";
		} else if (isRhombus()) {
			result = "Rhombus";
		} else if (isParallelogram()) {
			result = "Parallelogram";
		}
		return result;
	}

	public String getType() {
		return classify();
	}

	/*
	 * should return coordinates of 4 corners Area: Perimeter: Type:
	 */
	public String toString() {
		return "A: " + A + ", B: " + B + ", C: " + C + ", D: " + D;
	}

}
