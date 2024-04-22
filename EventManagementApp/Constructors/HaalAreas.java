package Constructors;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Settings.MainSettings;

public class HaalAreas extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Color[] color = { MainSettings.getColorSGreen(), MainSettings.getColorSRed(), MainSettings.getColorSYellow() };
	
	private String HaalNameString; 
	private static int height = 20;
	private static int width = 20;
	
	public HaalAreas(int rows, int numberOfSeatsPerRow, String name) {
		HaalNameString = name;
		
		setLayout(new GridBagLayout());

		for (int i = 0; i < numberOfSeatsPerRow; i++) {
			for (int j = 0; j < rows; j++) {
				final SitzPanel p = new SitzPanel(i, j);
				p.setSize(new Dimension(height, width));
				p.setBackground(color[p.getColorNumber()]);
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridx = i;
				gbc.gridy = j;
				int left = 1;
				int top = 1;
				// so k�nnte man bspw G�nge darstellen...ganz rudiment�r
				// angedacht
				// if (i % 5 == 0) {
				// left = 5;
				// }
				// if (j % 5 == 0) {
				// top = 5;
				// }
				gbc.insets = new Insets(top, left, 1, 1);
				p.setBorder(BorderFactory.createBevelBorder(0));
				p.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
					}

					@Override
					public void mouseExited(MouseEvent e) {
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						
					System.out.println("Reihe: " + (p.getRow() + 1)
									+ "	Platz: " + (p.getNumber() + 1));
						
					}
					

					@Override
					public void mouseClicked(MouseEvent e) {
						int actualColor = p.getColorNumber();
						p.setBackground(color[actualColor]);
						String s = "";
						switch (actualColor) {
						case 0:
							s = "frei";
							break;
						case 1:
							s = "vergeben";
							break;
						case 2:
							s = "reserviert";
						default:
							break;
						}
						if (actualColor == color.length - 1) {
							actualColor = 0;
							p.setColorNumber(actualColor);
						} else {
							p.setColorNumber(actualColor + 1);
						}
						
						System.out.println("Reihe: " + (p.getRow() + 1)
										+ "	Platz: " + (p.getNumber() + 1) + " ist "
										+ s);
						
					}
				});
				add(p, gbc);
			}
		}
	}
	
	public void setName(String nameString) {
    	this.HaalNameString = nameString;
    }
    
    public String getName() {
    	return HaalNameString;
    }

	public static int getSeatHeight() {
		return height;
	}
	
	public static int getSeatWidth() {
		return width;
	}
}

