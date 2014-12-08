package newRoadways;

import java.util.ArrayList;

public class Row {

	/**
	 * @param args
	 */
	String label;
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	ArrayList<Tile> TileList ; 
	/**
	 * @param tileList the tileList to set
	 */
	public void setTileList(ArrayList<Tile> tileList) {
		TileList = tileList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Row [label=" + label + ", TileList=" + printArrayList(TileList) + "]";
	}
	private String printArrayList(ArrayList<Tile> tileList) {
		// TODO Auto-generated method stub
		String str="";
		for (Tile t : tileList){
			str += t.toString()+"\n";
		}
		return str;
	}
	/**
	 * @return the tileList
	 */
	public ArrayList<Tile> getTileList() {
		return TileList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
