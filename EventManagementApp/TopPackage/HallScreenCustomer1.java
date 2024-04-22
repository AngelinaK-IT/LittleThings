package TopPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


import Constructors.SitzPanel;

public class HallScreenCustomer1 extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/********************
	 *** GUI ELEMENTS *** 
	 ********************/
	JFrame mainFrame;
	
	// *** PANELS *** // 
	JPanel mainPanel;
	JPanel haalArea1P = new JPanel();
	JPanel haalArea2P = new JPanel();
	JPanel haalArea3P = new JPanel();
	JPanel viewPanel;
	JPanel scrollPanel = new JPanel();
	JScrollPane scroller = new JScrollPane();
	
	// *** LABEL *** //
	JLabel topLabel;
	
	// *** SIMPLE ELEMENTS *** // 
	LineBorder line1 = new LineBorder(cyellow, 2, true);
	
	// *** TEXTFIELD_ARRAYS *** //
	JTextField[] textFieldsArea1;
	JTextField[] textFieldsArea2;
	JTextField[] textFieldsArea3;
	
	// *** ARRAYLISTS *** //
	ArrayList<ArrayList<ArrayList<SitzPanel>>> eventDatArrayList = new ArrayList<>();
	List<List<SitzPanel>> selectedSeatsArea1 = new ArrayList<>();
	List<List<SitzPanel>> selectedSeatsArea2 = new ArrayList<>();
	List<List<SitzPanel>> selectedSeatsArea3 = new ArrayList<>();
	
	ArrayList<String> currReservedArrayList = new ArrayList<>();
	ArrayList<String> currSelledArrayList = new ArrayList<>(); 
	
	// *** COLORS *** // 
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop  =new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);

	private static final Color GREEN = Color.GREEN;
	private static final Color GRAY = Color.gray;
	private static final Color YELLOW = Color.yellow;
	
					//color[0] = Green, color[1] = Yellow
	Color[] color = { GREEN, YELLOW, GRAY };
	
	// *** MAIN FOR TEST PURPOSE *** //
	public static void main(String[] args) {
			
		HallScreenCustomer1 hf = new HallScreenCustomer1();
		hf.GUIHaalFrameCustomer();
			
	}
		
	/***********
	 *** GUI ***
	 ***********/
	public void GUIHaalFrameCustomer() {
		
		mainFrame = new JFrame("Haal of Event");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(440,750);					
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0,0,440, 750);
		mainPanel.setBackground(c2);
		mainPanel.setLayout(null);
		
		topLabel = new JLabel("Stage", SwingConstants.CENTER);
		topLabel.setOpaque(true);
		topLabel.setBounds(10,10,400, 85);
		topLabel.setBackground(ctop);
		topLabel.setForeground(cwhite);
		//topLabel.setVisible(true);
		
		haalArea1P = new JPanel();
		//haalArea1P.setBounds(10, 100, 100, 170);
		haalArea1P.setBackground(Color.RED);
		haalArea1P.add(CreateHaalArea1(10, 10));
		
		
		haalArea2P = new JPanel();
		haalArea2P.setBounds(10, 270, 100, 170);
		haalArea2P.setBackground(Color.BLUE);
		haalArea2P.add(createHaalArea2(10, 10));
		
		haalArea3P = new JPanel();
		haalArea3P.setBounds(10, 440, 100, 170);
		haalArea3P.setBackground(Color.GREEN);
		haalArea3P.add(createHaalArea3(10, 10));
		
		
		
		scrollPanel = new JPanel();
		scrollPanel.setBackground(c2);
		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
		//scrollPanel.setBounds(10,10,400,400);
		//scrollPanel.add(topLabel);
		scrollPanel.add(haalArea1P);
		scrollPanel.add(haalArea2P);
		scrollPanel.add(haalArea3P);
		
		scroller = new JScrollPane();
		scroller.setBackground(c2);
		scroller.setViewportView(scrollPanel);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);;
		
		//scroller.add(scrollPanel);
		scroller.setBounds(10,100,400,340);
		//scroller.setLayout(null);
	
		 // *** COMPLETE THE SINGLE ELEMENTS TO ONE *** // 
		mainPanel.add(topLabel);
		mainPanel.add(scroller);
		
		//mainPanel.add(viewPanel);
		mainFrame.add(mainPanel);
		
		mainFrame.setVisible(true);
		
	}
	
	/*
	 * 
	 */
	public Component CreateHaalArea1(int rows, int numberOfSeatsPerRow) {
	    JPanel haalArea1 = new JPanel();
	    haalArea1.setSize(50,300);
	    haalArea1.setLayout(new GridBagLayout());
	    new ArrayList<>();
 	    for (int i = 0; i < numberOfSeatsPerRow; i++) {
	        for (int j = 0; j < rows; j++) {
	            final SitzPanel p = new SitzPanel(i, j);
	            p.setSize(new Dimension(25, 25));
	            p.setBackground(color[p.getColorNumber()]);
	            
	            GridBagConstraints gbc = new GridBagConstraints();
	            gbc.gridx = i;
	            gbc.gridy = j;
	            int left = 1;
	            int top = 1;
	            // so k�nnte man bspw G�nge darstellen...ganz rudiment�r
	            // angedacht
	            if (i % 5 == 0) {
	            	left = 5;
	            }
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
	                  
	                	System.out.println("Reihe: " + (p.getRow() + 1) + " Platz: " + (p.getNumber() + 1));
	                }
	                
					//			color[0] = Green, color[1] = Yellow
	            	//Color[] color = { GREEN, YELLOW, RED };
	                
	                @Override
	 	            public void mouseClicked(MouseEvent e) {
	 	                    int actualColor = p.getColorNumber();
	 	                    p.setBackground(color[actualColor]);
	 	                    String s = "";
	 	                    switch (actualColor) {
	 	                   
	 	                        case 0:
	 	                            s = "frei";
	 	                         
	 	                            System.out.println(currReservedArrayList);
	 	                            System.out.println(currSelledArrayList);
	 	                            break;
	 	                        case 1:
	 	                            s = "reserviert";
	 	                            String complReservedString = "Reihe: " + (p.getRow() + 1) + "	Platz: " + (p.getNumber() + 1);
	 	                            currReservedArrayList.add(complReservedString);
	 	                           System.out.println(currReservedArrayList);
	 	                            break;
	 	                        case 2:
	 	                            s = "vergeben";
	 	                            String complSelledString = "Reihe: " + (p.getRow() + 1) + "	Platz: " + (p.getNumber() + 1);
	 	                            currSelledArrayList.add(complSelledString);
	 	                           System.out.println(currSelledArrayList);
	 	                            break;
	 	                        default:
	 	                            break;
	 	                            
	 	                    }
	 	                    if (actualColor == color.length - 1) {
								actualColor = 0;
								p.setColorNumber(actualColor);
								
							} else {
								p.setColorNumber(actualColor + 1);
							}
							
							System.out.println("Reihe: " + (p.getRow() + 1) + "	Platz: " + (p.getNumber() + 1) + " ist " + s);
							
						
	                	
	                   /*
	                    // Daten der ausgew�hlten Sitze in das Textfeld-Array speichern
	                    for (int k = 0; k < selectedSeatsArea1.size(); k++) {
	                        SitzPanel selectedSeat = selectedSeatsArea1.get(k);
	                        String statusText = "Row: " + (selectedSeat.getRow() + 1) + ", Platz: " + (selectedSeat.getNumber() + 1) + ", Status: " + s;
	                        if(selectedSeat.getColorNumber() == 0) {
	                        	textFieldsArea1[k].setText("");
	                        } else {
	                        	textFieldsArea1[k].setText(statusText);
	                        }
	                    }

						
	                    // Erstellen Sie eine separate Liste, um den Text für die ausgewählten Sitze zu speichern
	                    List<String> selectedSeatsText = new ArrayList<>();

	                    // Daten der ausgewählten Sitze in die separate Liste speichern
	                    for (int k = 0; k < selectedSeatsArea1.size(); k++) {
	                        SitzPanel2 selectedSeat = selectedSeatsArea1.get(k);
	                        String statusText = "Row: " + (selectedSeat.getRow() + 1) + ", Platz: " + (selectedSeat.getNumber() + 1) + ", Status: " + s;
	                        selectedSeatsText.add(statusText);
	                    }

	                    // Aktualisieren Sie die Textfelder mit den Werten aus der separaten Liste
	                    for (int k = 0; k < selectedSeatsText.size(); k++) {
	                        String statusText = selectedSeatsText.get(k);
	                        textFieldsArea1[k].setText(statusText);
	                    }
                     */   
	                	 
	                }
	            });
	            haalArea1.add(p, gbc);
	        }
	    }
	    //return haalArea1;
		return haalArea1;
	}
	
	/*
	 * 
	 */
	public Component createHaalArea2(int rows, int numberOfSeatsPerRow) {
	    JPanel haalArea2 = new JPanel();
	    haalArea2.setLayout(new GridBagLayout());
	    new ArrayList<>();
	    for (int i = 0; i < numberOfSeatsPerRow; i++) {
	        for (int j = 0; j < rows; j++) {
	            final SitzPanel p = new SitzPanel(i, j);
	            p.setSize(new Dimension(20, 20));
	            p.setBackground(color[p.getColorNumber()]);
	            GridBagConstraints gbc = new GridBagConstraints();
	            gbc.gridx = i;
	            gbc.gridy = j;
	            int left = 1;
	            int top = 1;
	            // so k�nnte man bspw G�nge darstellen...ganz rudiment�r
	            // angedacht
	             if (i % 5 == 0) {
	            	 left = 5;
	             }
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
	                   System.out.println("Reihe: " + (p.getRow() + 1) + " Platz: " + (p.getNumber() + 1));
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
	                            break;
	                        default:
	                            break;
	                    }
	                    if (actualColor == color.length - 1) {
	                        actualColor = 0;
	                        p.setColorNumber(actualColor);
	                    } else {
	                        p.setColorNumber(actualColor + 1);
	                    }
	                    
	                   if (selectedSeatsArea2.contains(p)) {
                            selectedSeatsArea2.remove(p);
                            p.setBackground(color[p.getColorNumber()]); // Setze die Hintergrundfarbe zur�ck
                        } else {
                            //selectedSeatsArea2.add(p);
                            p.setBackground(Color.ORANGE); // Setze eine Farbe, um ausgew�hlte Sitze hervorzuheben
                        }
	                   /*
	                    // Daten der ausgew�hlten Sitze in das Textfeld-Array speichern
                        for (int k = 0; k < selectedSeatsArea2.size(); k++) {
                            SitzPanel selectedSeat = selectedSeatsArea2.get(k);
                            textFieldsArea2[k].setText("Row: " + (selectedSeat.getRow() + 1) + ", Platz: " + (selectedSeat.getNumber() + 1) + ", Status: " + s);
                        }
	                    //seat1_row.setText("Row: " + (p.getRow() + 1) + " Platz: " + (p.getNumber() + 1) + " Statis: " + s);

	                    System.out.println("Reihe: " + (p.getRow() + 1) + " Platz: " + (p.getNumber() + 1) + " ist " + s);
	                	*/
	                }
	                
	            });
	            haalArea2.add(p, gbc);
	        }
	    }
	    return haalArea2;
	}
	
	/*
	 * 
	 */
	public Component createHaalArea3(int rows, int numberOfSeatsPerRow) {
	    JPanel haalArea3 = new JPanel();
	    haalArea3.setLayout(new GridBagLayout());
	    new ArrayList<>();
	    for (int i = 0; i < numberOfSeatsPerRow; i++) {
	        for (int j = 0; j < rows; j++) {
	            final SitzPanel p = new SitzPanel(i, j);
	            p.setSize(new Dimension(20, 20));
	            p.setBackground(color[p.getColorNumber()]);
	            GridBagConstraints gbc = new GridBagConstraints();
	            gbc.gridx = i;
	            gbc.gridy = j;
	            int left = 1;
	            int top = 1;
	            // so k�nnte man bspw G�nge darstellen...ganz rudiment�r
	            // angedacht
	            if (i % 5 == 0) {
	            	left = 5;
	             }
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
	                   // System.out.println("Reihe: " + (p.getRow() + 1) + " Platz: " + (p.getNumber() + 1));
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
	                            break;
	                        default:
	                            break;
	                    }
	                    if (actualColor == color.length - 1) {
	                        actualColor = 0;
	                        p.setColorNumber(actualColor);
	                    } else {
	                        p.setColorNumber(actualColor + 1);
	                    }
	                    
	                   if (selectedSeatsArea3.contains(p)) {
                            selectedSeatsArea3.remove(p);
                            p.setBackground(color[p.getColorNumber()]); // Setze die Hintergrundfarbe zur�ck
                        } else {
                            //selectedSeatsArea3.add(p);
                            p.setBackground(Color.ORANGE); // Setze eine Farbe, um ausgew�hlte Sitze hervorzuheben
                        }
	                   /*
	                    // Daten der ausgew�hlten Sitze in das Textfeld-Array speichern
                        for (int k = 0; k < selectedSeatsArea3.size(); k++) {
                            SitzPanel selectedSeat = selectedSeatsArea3.get(k);
                            textFieldsArea3[k].setText("Row: " + (selectedSeat.getRow() + 1) + ", Platz: " + (selectedSeat.getNumber() + 1) + ", Status: " + s);
                        }
	                    //seat1_row.setText("Row: " + (p.getRow() + 1) + " Platz: " + (p.getNumber() + 1) + " Statis: " + s);

	                    //System.out.println("Reihe: " + (p.getRow() + 1) + " Platz: " + (p.getNumber() + 1) + " ist " + s);
	                	*/
	                }
	            });
	            haalArea3.add(p, gbc);
	        }
	    }
	    return haalArea3;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

