package TopPackage;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultEditorKit.CopyAction;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class BuildTree{ 
	JFrame frame = null;
	BufferedReader reader;
	static JScrollPane scroller = new JScrollPane();
	String[] values;
	String status = "ausverkauft";
	String status2 = "abgesagt";

	static String filenameString = Paths.get("src//TopPackage//verantstaltung_funfactory.csv").toAbsolutePath().toString();
	static String filenameString2 = Paths.get("src//TopPackage//verantstaltung_funfactory2.csv").toAbsolutePath().toString();
	//static String fileName = "C:\\Users\\angel\\eclipse-workspace\\Java Tutorial\\src\\verantstaltung_funfactory.csv";
	//static String fileName2 = "C:\\Users\\angel\\eclipse-workspace\\Java Tutorial\\src\\verantstaltung_funfactory2.csv";

	public static void main(String[] args) throws Exception {
		System.out.println(filenameString2);
		/*
         * Hier wird der Frame minimalistisch dargestellt
         */
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        
		DefaultMutableTreeNode dataTree = BuildSubTree(filenameString2);
		DefaultMutableTreeNode dataTree2 = BuildSubTree2(filenameString);
		DefaultMutableTreeNode rootTreeNode = new DefaultMutableTreeNode("Veranstaltungsübersicht");
		rootTreeNode.add(dataTree);
		rootTreeNode.add(dataTree2);
		JTree tree = new JTree(rootTreeNode);
		
		scroller = new JScrollPane(tree);
		scroller.setBounds(0,60,350,450);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		frame.add(scroller);
        frame.pack();
        frame.setVisible(true);
	}
//	TreeNode root = createTree();
//	//Neues tree Objekt aufrufen mit root
//	JTree tree = new JTree(root);
//	
//	scroller = new JScrollPane(tree);
	private static DefaultMutableTreeNode BuildSubTree(String fileName) {
        // Auslesen aller Zeilen aus der CSV Datei
        ArrayList<String> lines = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filenameString2))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	String[] valueStrings = line.split(",");
//            	if(lineNumber != linetoSkip) {
//            		lineNumber++;
//            		continue;
//            	}
            	for(String values : valueStrings) {
            		lines.add(values);
            	}
//              break;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(lines);
        System.out.println(lines.size());
        /*
//       * Hier erfolgt der hierarische Aufbau der Veranstaltungsübersicht (DataStruture Baum: JTree)
//       */
        List<String> zone1 = lines.subList(13, 21);
        System.out.println(zone1);
        String zonecomplete1 = zone1.get(0) + ": Plätze: " + zone1.get(1) + ": " + zone1.get(4) + ": " + zone1.get(5);
        List<String> zone2 = lines.subList(21, 29);
        System.out.println(zone2);
        String zonecomplete2 = zone2.get(0) + ": Plätze: " + zone2.get(1) + ": " + zone2.get(4) + ": " + zone2.get(5);
        List<String> zone3 = lines.subList(29, 37);
        System.out.println(zone3);
        String zonecomplete3 = zone3.get(0) + ": Plätze: " + zone3.get(1) + ": " + zone3.get(4) + ": " + zone3.get(5);
        String zonecompleteString = "Preis Übersicht";
        DefaultMutableTreeNode zoneNode1 = new DefaultMutableTreeNode(zonecomplete1);
        DefaultMutableTreeNode zoneNode2 = new DefaultMutableTreeNode(zonecomplete2);
        DefaultMutableTreeNode zoneNode3 = new DefaultMutableTreeNode(zonecomplete3);
        DefaultMutableTreeNode zoneParentNode = new DefaultMutableTreeNode(zonecompleteString);
        zoneParentNode.add(zoneNode1);
        zoneParentNode.add(zoneNode2);
        zoneParentNode.add(zoneNode3);

        String timecomplete = lines.get(9) + ": " + lines.get(10);
        DefaultMutableTreeNode timeNode = new DefaultMutableTreeNode(timecomplete);
        timeNode.add(zoneParentNode);
        DefaultMutableTreeNode timeNode1 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode2 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode3 = copyNode(timeNode);
        List<String> dateList = lines.subList(6, 9);
        DefaultMutableTreeNode dateNode1 = new DefaultMutableTreeNode(dateList.get(0));
        dateNode1.add(timeNode1);
        DefaultMutableTreeNode dateNode2 = new DefaultMutableTreeNode(dateList.get(1));
        dateNode2.add(timeNode2);
        DefaultMutableTreeNode dateNode3 = new DefaultMutableTreeNode(dateList.get(2));
        dateNode3.add(timeNode3);

        DefaultMutableTreeNode dateGrandfahterNode = new DefaultMutableTreeNode("Termine:");
        dateGrandfahterNode.add(dateNode1);
        dateGrandfahterNode.add(dateNode2);
        dateGrandfahterNode.add(dateNode3);

        List<String> subList = lines.subList(0,5);
        
//        System.out.println(subList);
//        System.out.println(dateList);
        DefaultMutableTreeNode subroot = new DefaultMutableTreeNode(subList.get(0));
        DefaultMutableTreeNode placeNode = new DefaultMutableTreeNode(subList.get(1) + ": " + subList.get(2));
        DefaultMutableTreeNode stateNode = new DefaultMutableTreeNode(subList.get(3) + ": " + subList.get(4));
        stateNode.add(dateGrandfahterNode);
        placeNode.add(stateNode);
        subroot.add(placeNode);
//       
          return subroot;
//        for (String line : lines) {
//            String[] values = line.split(",");
//            DefaultMutableTreeNode parent = root;
//            
//            for (String value : values) {
//                DefaultMutableTreeNode node = new DefaultMutableTreeNode(value);
//                parent.add(node);
//                parent = node;
//            }
//        }
    }
	private static DefaultMutableTreeNode BuildSubTree2(String fileName) {
        // Auslesen aller Zeilen aus der CSV Datei
        ArrayList<String> lines2 = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	String[] valueStrings = line.split(",");
//            	if(lineNumber != linetoSkip) {
//            		lineNumber++;
//            		continue;
//            	}
            	for(String values : valueStrings) {
            		lines2.add(values);
            	}
//              break;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        /*
         * Hier erfolgt der hierarische Aufbau der Veranstaltungsübersicht (DataStruture Baum: JTree)
         */
        List<String> zone1 = lines2.subList(20, 30);
        String zone1complete = zone1.get(0) + ": Plätze: " + zone1.get(1) + ": " + zone1.get(7) + ": " + zone1.get(8) + "." + zone1.get(9) + "€";
        List<String> zone2 = lines2.subList(40, 50);
        String zone2complete = zone2.get(0) + ": Plätze: " + zone2.get(1) + ": " + zone2.get(7) + ": " + zone2.get(8) + "." + zone2.get(9) + "€";
        List<String> zone3 = lines2.subList(60, 70);
        String zone3complete = zone3.get(0) + ": Plätze: " + zone3.get(1) + ": " + zone3.get(7) + ": " + zone3.get(8) + "." + zone3.get(9) + "€";
        String zonecompleteString = "Zonen Übersicht";
        DefaultMutableTreeNode zone1Node = new DefaultMutableTreeNode(zone1complete);
        DefaultMutableTreeNode zone2Node = new DefaultMutableTreeNode(zone2complete);
        DefaultMutableTreeNode zone3Node = new DefaultMutableTreeNode(zone3complete);
        DefaultMutableTreeNode zone = new DefaultMutableTreeNode(zonecompleteString);
        zone.add(zone1Node);
        zone.add(zone2Node);
        zone.add(zone3Node);
       
        String timecomplete = lines2.get(13) + ": " + lines2.get(14);
        DefaultMutableTreeNode timeNode = new DefaultMutableTreeNode(timecomplete);
        timeNode.add(zone);
        DefaultMutableTreeNode timeNode1 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode2 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode3 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode4 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode5 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode6 = copyNode(timeNode);
        List<String> dateList = lines2.subList(7, 13); 
        DefaultMutableTreeNode dateNode1 = new DefaultMutableTreeNode(dateList.get(0));
        dateNode1.add(timeNode1);
        DefaultMutableTreeNode dateNode2 = new DefaultMutableTreeNode(dateList.get(1));
        dateNode2.add(timeNode2);
        DefaultMutableTreeNode dateNode3 = new DefaultMutableTreeNode(dateList.get(2));
        dateNode3.add(timeNode3);
        DefaultMutableTreeNode dateNode4 = new DefaultMutableTreeNode(dateList.get(3));
        dateNode4.add(timeNode4);
        DefaultMutableTreeNode dateNode5 = new DefaultMutableTreeNode(dateList.get(4));
        dateNode5.add(timeNode5);
        DefaultMutableTreeNode dateNode6 = new DefaultMutableTreeNode(dateList.get(5));
        dateNode6.add(timeNode6);
        DefaultMutableTreeNode dateNodeMaster = new DefaultMutableTreeNode("Termine:");
        dateNodeMaster.add(dateNode1);
        dateNodeMaster.add(dateNode2);
        dateNodeMaster.add(dateNode3);
        dateNodeMaster.add(dateNode4);
        dateNodeMaster.add(dateNode5);
        dateNodeMaster.add(dateNode6);
        List<String> subList = lines2.subList(0,6);
        
        DefaultMutableTreeNode subroot = new DefaultMutableTreeNode(subList.get(0));
        DefaultMutableTreeNode placeNode = new DefaultMutableTreeNode(subList.get(2) + ": " + subList.get(3));
        DefaultMutableTreeNode stateNode = new DefaultMutableTreeNode(subList.get(4) + ": " + subList.get(5));
        stateNode.add(dateNodeMaster);
        placeNode.add(stateNode);
        subroot.add(placeNode);
       
       return subroot;
//        for (String line : lines) {
//            String[] values = line.split(",");
//            DefaultMutableTreeNode parent = root;
//            
//            for (String value : values) {
//                DefaultMutableTreeNode node = new DefaultMutableTreeNode(value);
//                parent.add(node);
//                parent = node;
//            }
//        }
    }

    /* Hier wird ein Knoten mit mehreren KindKnoten rekursiv kopiert
     * @param DefaultMutableTreeNode
     * 
     * Der Rückgabeparameter ist die Kopie eines Knotens inkl. KindKnoten
     * 
     */
    public static DefaultMutableTreeNode copyNode(DefaultMutableTreeNode node) {
    	DefaultMutableTreeNode copy = new DefaultMutableTreeNode(node.getUserObject());
    	
    	for(int i=0;i<node.getChildCount();i++) {
    		copy.add(copyNode((DefaultMutableTreeNode) node.getChildAt(i)));
    	}
    	
    	return copy;
    }
}
