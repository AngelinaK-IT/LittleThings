package Constructors;

import javax.swing.JPanel;

public class SitzPanel extends JPanel {
	
		/*
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int row;
		private int number;
		private int colorNumber = 0;

		public SitzPanel(int number, int row) {
			this.row = row;
			this.number = number;
		}

		public int getNumber() {
			return number;
		}

		public int getRow() {
			return row;
		}

		public void setColorNumber(int colorNumber) {
			this.colorNumber = colorNumber;
		}

		public int getColorNumber() {
			return colorNumber;
		}
}
