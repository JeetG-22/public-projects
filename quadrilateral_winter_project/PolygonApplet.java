package quadrilateral_winter_project;

import java.applet.*;
import java.awt.*;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;

//import javax.swing.JFrame;

public class PolygonApplet extends Applet {

	int[] pointsX, pointsY;
	int numPoints = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PolygonApplet() {
	}

	public PolygonApplet(int[] pointsX, int[] pointsY) {
		this.pointsX = pointsX;
		this.pointsY = pointsY;
		this.numPoints = Math.min(pointsX.length, pointsY.length);
	}

	public void paint(Graphics g) {
		// System.out.println(this.numPoints);
		if (this.numPoints > 0)
			g.fillPolygon(pointsX, pointsY, numPoints);
		for (int x = 0; x < numPoints; x++) {
			g.setColor(new Color(0, 0, 0));
			char alpha = 'X';
			switch (x) {
			case 0:
				alpha = 'A';
				break;
			case 1:
				alpha = 'B';
				break;
			case 2:
				alpha = 'C';
				break;
			case 3:
				alpha = 'D';
				break;
			default:
				break;
			}
			g.drawString(alpha + " (" + pointsX[x] + " , " + pointsY[x] + ")", pointsX[x], pointsY[x]);
		}
	}

}
