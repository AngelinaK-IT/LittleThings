package Settings;

import java.awt.Color;

import javax.swing.border.LineBorder;

public class MainSettings {

	// *** COLOR VARIABLES *** //
	private static Color c1 = new Color(55, 63, 93);
	private static Color c2 = new Color(20, 26, 50);
	private static Color cblue = new Color(62, 101, 251);
	private static Color ctop = new Color(128, 156, 245);
	private static Color cyellow = new Color(207, 180, 94);
	private static Color cwhite = new Color(210, 210, 215);
	
	private static Color sgray = Color.gray;
	private static Color sgreen = Color.GREEN;
	private static Color sred = Color.RED; 
	private static Color syellow = Color.YELLOW;  
	private static Color smagenta = Color.MAGENTA;
	private static Color scyan = Color.CYAN;
	private static Color sorange = Color.ORANGE;
	private static Color spink = Color.PINK;
	
	// *** LINES *** //
	private static LineBorder line = new LineBorder(c2, 1, true);
	
	// *** COLOR GETTER *** //
	public static Color getColorC1() {
		return c1;
	}
	
	public static Color getColorC2() {
		return c2;
	}
	
	public static Color getColorCWhite() {
		return cwhite;
	}
	
	public static Color getColorCTop() {
		return ctop;
	}
	
	public static Color getColorCYellor() {
		return cyellow;
	}
	
	public static Color getColorCBlue() {
		return cblue;
	}
	
	public static Color getColorSGray() {
		return sgray;
	}
	
	public static Color getColorSGreen() {
		return sgreen;
	}
	
	public static Color getColorSRed() {
		return sred;
	}
	
	public static Color getColorSYellow() {
		return syellow;
	}
	
	public static Color getColorSPink() {
		return spink;
	}
	
	public static Color getColorSMagenta() {
		return smagenta;
	}
	
	public static Color getColorSCyan() {
		return scyan;
	}
	
	public static Color getColorSOrange() {
		return sorange;
	}
	
	public static LineBorder getLineBorder() {
		return line;
	}

	
}
