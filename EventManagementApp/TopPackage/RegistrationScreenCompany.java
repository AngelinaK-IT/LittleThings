package TopPackage;

/*
 * Hier wird die Firmenregistrierung durchgeführt. In diesem Bildschirm kommt man über den Bildschirm der Registrierung und dem Knopf Firmenregistrierung.
 * 
 * @version 1.0.
 * @author xxx
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

//RegistrationScreenCompany GUICompanyReg
public class RegistrationScreenCompany extends JFrame implements ActionListener {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = null;
	JPanel panel = new JPanel();
	JLabel label, lxdomain, lxa, lxab, lxabt, lxmaster;
	JTextField xdomain, xa, xab, xabt, xmaster;
	JButton re, ba, abo;
	
	Color c2 = new Color(20, 26, 50);
	Color cwhite = new Color(210, 210, 215);
	Color ctop = new Color(128, 156, 245);
	Color cyellow = new Color(207, 180, 94);
	Color cblue = new Color(62, 101, 251);
	Color c1 = new Color(55, 63, 93);
	
	LineBorder line = new LineBorder(c1, 1, true);
	
	public static String mastercode = "SE2022";
	public static String domain, a, ab, abt, newServerPathString;
	
	
	
	public static void main(String[] args) {
		
		//ApplicationScreenCompany GUIStartCompany
		RegistrationScreenCompany go = new RegistrationScreenCompany();
		go.GUICompanyReg();
		
		PathHandler2.variablenHandler();
		
	}
	
	
  /*
   * Diese Funktion erstellt das Fenster in dem die Eingaben zur Registrierung einer Firma getätigt werden können.
   * 
   * es gibt keine Ein- & Ausgabeparameter.
   */
  public void GUICompanyReg(){
	  
	  frame = new JFrame ("Ultimate-events");
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setSize(500,450);
	  frame.setLocationRelativeTo(null);
	  frame.add(panel);
	  frame.setResizable(false);
	  panel.setBackground(c2);
	  panel.setLayout(null);
    
	  label = new JLabel("Company Registration", SwingConstants.CENTER);
	  label.setOpaque(true);
	  label.setBounds(0,0,500,30);
	  label.setBackground(ctop);
	  label.setForeground(c2);
    
	  lxdomain= new JLabel("Company Domain",0);
	  lxdomain.setOpaque(true);
	  lxdomain.setBackground(ctop);
	  lxdomain.setForeground(c2);
	  lxdomain.setBounds(40, 50, 140, 30);
	  xdomain = new JTextField();
	  xdomain.setBounds(190, 50, 260, 30);
	  xdomain.setOpaque(true);
	  xdomain.setBackground(c1);
	  xdomain.setForeground(Color.white);
	  xdomain.setBorder(line);
    
	  lxa= new JLabel("Departmentname 1",0);
	  lxa.setOpaque(true);
	  lxa.setBackground(ctop);
	  lxa.setForeground(c2);
	  lxa.setBounds(40, 90, 140, 30);
	  xa = new JTextField();
	  xa.setBounds(190, 90, 260, 30);
	  xa.setOpaque(true);
	  xa.setBackground(c1);
	  xa.setForeground(Color.white);
	  xa.setBorder(line);
    
	  lxab= new JLabel("Departmentname 2",0);  
	  lxab.setOpaque(true);
	  lxab.setBackground(ctop);
	  lxab.setForeground(c2);
	  lxab.setBounds(40, 130, 140, 30);
	  xab = new JTextField();
	  xab.setBounds(190, 130, 260, 30);
	  xab.setOpaque(true);
	  xab.setBackground(c1);
	  xab.setForeground(Color.white);
	  xab.setBorder(line);
    
	  lxabt= new JLabel("Departmentname 3",0);
	  lxabt.setOpaque(true);
	  lxabt.setBackground(ctop);
	  lxabt.setForeground(c2);
	  lxabt.setBounds(40, 170, 140, 30);
	  xabt = new JTextField();
	  xabt.setBounds(190, 170, 260, 30);
	  xabt.setOpaque(true);
	  xabt.setBackground(c1);
	  xabt.setForeground(Color.white);
	  xabt.setBorder(line);
    
	  lxmaster= new JLabel("Activation code",0);
	  lxmaster.setOpaque(true);
	  lxmaster.setBackground(ctop);
	  lxmaster.setForeground(c2);
	  lxmaster.setBounds(40, 210, 140, 30);
	  xmaster = new JTextField();
	  xmaster.setBounds(190, 210, 260, 30);
	  xmaster.setOpaque(true);
	  xmaster.setBackground(c1);
	  xmaster.setForeground(Color.white);
	  xmaster.setBorder(line);
    
	  re = new JButton("Registration");
	  re.setBounds(40, 250, 140, 30);
	  re.setBackground(cblue);
	  re.setForeground(Color.WHITE);
	  re.addActionListener(this);
      
	  ba = new JButton("Back");
	  ba.setBounds(40, 290, 140, 30);
	  ba.setBackground(cblue);
	  ba.setForeground(Color.WHITE);
	  ba.addActionListener(this);
		
	  abo = new JButton("Back to Main Menu");
	  abo.setBounds(40, 330, 140, 30);
	  abo.setBackground(cblue);
	  abo.setForeground(Color.WHITE);
	  abo.addActionListener(this);
	  
	  panel.add(xdomain);
	  panel.add(lxdomain);
	  panel.add(xa);
	  panel.add(lxa);
	  panel.add(xab);
	  panel.add(lxab);
	  panel.add(xabt);
	  panel.add(lxabt);
	  panel.add(xmaster);
	  panel.add(lxmaster);
	  panel.add(re);
	  panel.add(label);
	  panel.add(ba);
	  panel.add(abo);
    
	  frame.setVisible(true);
  }
  
  /*
   * Diese Methode übernimmt die eingegebenen Abteilungsbezeichnungen und gibt diese an FirmRegister weiter.
   * 
   * @see FirmRegister
   * @param e ist der Typ des ActioEvent mit dieser Aufgerufen wird.
   * 
   * Es gibt keinen Rückgabewert
   */
  //RegistrationCompany CompReg
  public void actionPerformed(ActionEvent e){
	  if (e.getSource() == re) {
		 if (xmaster.getText().equals(mastercode)) {
			  domain = xdomain.getText();
			  a = xa.getText();
			  ab = xab.getText();
			  abt = xabt.getText();
			  
			  newServerPathString = PathHandler2.startCompany();
			  System.out.println("RegistrationScreenCompany:" +newServerPathString);
			  //PathHandler2.sendString(newServerPathString);
			  FuncCompanyRegister freg = new FuncCompanyRegister();
			  freg.FuncCompanyRegister(newServerPathString, domain, a, ab, abt);
			  
			  frame.setVisible(false);
			  
		  } // end of if
		  else {
			  JOptionPane.showMessageDialog(null, "The access code is wrong", "Warnung", JOptionPane.PLAIN_MESSAGE);
		  } // end of if-else
	  } // end of if
	  if (e.getSource() == ba) {
			
			//TopRegistrationScreen GUITopRegistrierung
			TopRegistrationScreen registrierung = new TopRegistrationScreen();
			registrierung.GUITopRegistrierung();
			
			frame.setVisible(false);
			  
	  }
	  if (e.getSource() == abo) {
			
		  	//ApplicationScreenCompany GUIStartCompany
			ApplicationScreenCompany go = new ApplicationScreenCompany();
			go.GUIStartCompany();
			
			frame.setVisible(false);
			
	  }
   }

}
