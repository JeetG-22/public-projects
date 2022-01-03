package quadrilateral_winter_project;

//import java.applet.Applet;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
/*
 * DO NOT EDIT STUDENT VERSION
 */

public class QuadrilateralRunner {
	static PolygonApplet applet;
	
	public static void main(String[] args) {
		Quadrilateral Q = new Quadrilateral("Square");
		System.out.println(Q);
		displayQuad(Q.getA(), Q.getB(), Q.getC(), Q.getD());
	}
	
	/*
	 *  This methods accepts 4 points as a parameter and uses this to
	 *  draw quadrilateral.  
	 */
	public static void displayQuad(Point3 A, Point3 B, Point3 C, Point3 D){
		JFrame frame = new JFrame();
		frame.setSize(400, 300);
		int x1 = (int)A.getX();
		int x2 = (int)B.getX();
		int x3 = (int)C.getX();
		int x4 = (int)D.getX();
		// 25, 156, 175, 80
		int y1 = (int)A.getY();
		int y2 = (int)B.getY();
		int y3 = (int)C.getY(); 
		int y4 = (int)D.getY();
		// 10, 70, 150, 120
		// will display a sample rectangle
//		applet = new PolygonApplet(new int[] {50, 150, 150, 50 },
//				new int[] { 70, 70, 150, 150 });
		// random quad
		applet = new PolygonApplet(new int[] {x1, x2, x3, x4 },
				new int[] { y1, y2, y3, y4 });
		int R = (int)((Math.random())*256);
		int G = (int)((Math.random())*256);
		int Bb = (int)((Math.random())*256);
		
		applet.setForeground(new Color(R, G, Bb, 40));
		frame.getContentPane().add(applet);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				applet.stop();
				applet.destroy();
				System.exit(0);
			}
		});

		frame.setVisible(true);
		applet.init();
		applet.start();
		
	}

}
