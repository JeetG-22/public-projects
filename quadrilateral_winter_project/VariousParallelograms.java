package quadrilateral_winter_project;

public class VariousParallelograms {

	public static void main(String[] args) {
		System.out.println("********************************");
		for(int i = 1; i <= 20; i++) {
			System.out.println("PARALLELOGRAM #" + i);
			Quadrilateral q = new Quadrilateral("Parallelogram");
			System.out.println("Vertices: " + q);
			System.out.println("Length of AB: " + q.sideLength(q.getA(), q.getB()) + "  AB Slope: " + q.sideSlope(q.getA(), q.getB()));
			System.out.println("Length of BC: " + q.sideLength(q.getB(), q.getC()) + "  BC Slope: " + q.sideSlope(q.getB(), q.getC()));
			System.out.println("Area: " + q.area());
			System.out.println("Perimeter: " + q.perimeter());
			System.out.println(q.getType().toUpperCase());
			System.out.println("********************************");
		}

	}

}