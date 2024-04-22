package Constructors;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*************************
 *** CLASS ENTRYPANELA *** 
 *************************/
public class EntryPanelB extends JPanel {

    private static final long serialVersionUID = 1L;
    String panelNameString;
    String startString;
    JTextField rowsJTextField = new JTextField();
    JTextField columnsJTextField = new JTextField();
    
    /*******************************
     *** ENTRYPANELA CONSTRUCTOR *** 
     *******************************/
    public EntryPanelB(String a, String b) {
    	panelNameString = a;
    	startString = b;
    	// Füge einen DocumentListener zum rowsJTextField hinzu
        rowsJTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleTextChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleTextChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleTextChange();
            }
        });
        columnsJTextField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				handleTextChange();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				handleTextChange();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				handleTextChange();
			}
		});
    }
    
    private void handleTextChange() {
        // Hier wird auf Textänderungen reagiert
        System.out.println("Rows Field Text: " + rowsJTextField.getText());
        System.out.println("Columns Field Text: " + columnsJTextField.getText());
    }

    public void setName(String nameString) {
    	this.panelNameString = nameString;
    }
    
    public String getName() {
    	return panelNameString;
    }
    
    public JTextField getRowsField() {
        return rowsJTextField;
    }
    
    public JTextField getColumnsField() {
    	return columnsJTextField;
    }
    
    public void setRowsFieldText(String b) {
    	this.startString = b;
    	//rowsJTextField.setText(startString);
    }
    
    public void setColumnsFieldText(String b) {
    	this.startString = b;
    	//columnsJTextField.setText(startString);
    }
}

