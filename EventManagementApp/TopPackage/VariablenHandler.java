package TopPackage;

import java.security.AlgorithmParameterGenerator;
//*** Hier werden funktionen bereitgestellt, die genutzt werden um Daten in ArrayList zu sammeln
import java.util.ArrayList;

public class VariablenHandler {
	
	//*** Data pack to DataType ArrayList ***
	/*
	 * @param1...n = gesammelte Daten(Werte) aus Textfeldern, werden in eine ArrayList<String> gepeichert
	 */
	public static ArrayList<String> CollectAndSaveInList(String...strings){
		ArrayList<String> list = new ArrayList<>();
		for (String s : strings) {
			list.add(s);
		}
		return list;
	}
	
	public static ArrayList<String> CollectAndSaveInList2(String geschaeftsemail, char[] passwort){
		ArrayList<String> list = new ArrayList<>();
		list.add(geschaeftsemail);
		String passwortString = new String(passwort);
		list.add(passwortString);
		
		return list;
	}
	
	// *** PACK SINGLE ARRAYLISTS IN ONE 2D ARRAYLIST<STRING> *** //
	/*
	 * @param1...n = Alle gepackten ArrayList werden zu einer ArrayList verpackt
	 */
	@SafeVarargs
	public static ArrayList<ArrayList<String>> CollectAndSaveMatrixList(ArrayList<String>... arrayLists){
		ArrayList<ArrayList<String>> matrixList = new ArrayList<>();
		for(ArrayList<String> al : arrayLists) {
			matrixList.add(al);
		}
		return matrixList;
	}
	
	// *** UNPACK 2D ARRAYLIST<STRING> *** //
	/*
	 * @param1 Integer: index
	 * @param2 ArrayList<ArrayList<String>>: dataList
	 */
	public static ArrayList<String> UnpackMatrixList(Integer Index, ArrayList<ArrayList<String>> dataList) {
		
		ArrayList<String> innerList = new ArrayList<>();
		innerList = dataList.get(Index);
		return innerList;
		
	}
}
