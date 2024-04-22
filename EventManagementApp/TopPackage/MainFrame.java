package TopPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);

            BuyWithoutRegistration buyPanel = new BuyWithoutRegistration();
            frame.add(buyPanel);

            frame.setVisible(true);
        });
    }
}


class BuyWithoutRegistrationPanel2 extends JPanel implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    // Implementieren Sie hier Ihre Logik, die BuyWithoutRegistration hatte.

	
}

