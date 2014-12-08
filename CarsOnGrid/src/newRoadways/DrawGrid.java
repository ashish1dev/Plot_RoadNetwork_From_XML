package newRoadways;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;


public class DrawGrid extends JPanel {

	static int GRID_SIZE=10;
	public static String[][] dataValues;
	private ArrayList<Tile> tileList;
	public DrawGrid() {
		dataValues=new String[100][3];
	
		GridLayout gridLayout = new GridLayout(GRID_SIZE,GRID_SIZE);
		JPanel gridPanel = new JPanel(gridLayout);
		gridPanel.setBackground(Color.yellow);
		for (int i = 0; i < readXMLdata.rowArrayList.size()+1; i++) {
			System.out.println(" i = "+i);
			if (i!=0){
				tileList = readXMLdata.rowArrayList.get(i-1).getTileList();
			}
			for (int j = 0; j < GRID_SIZE; j++) {
				if(i==0 && j!=0){
					GridLabel_Top_Left cname = new GridLabel_Top_Left();
					cname.str=(j)+"";
					gridPanel.add(cname);
				}
				if(j==0 ){
					 
						GridLabel_Top_Left cname = new GridLabel_Top_Left();
						if (i==0)
							cname.str="";
						else
							cname.str=""+(char)(65+i-1);
						gridPanel.add(cname);
					 
				}
				else if((j!=0 || i!=0) && tileList!=null){
					Tile tile=tileList.get(j-1);
					String type=tile.getType();
					int degree=tile.getDegree();
					if(type.equals("blank")){
						gridPanel.add(new BlankTile());
					}else if(type.equals("+")){
						gridPanel.add(new Plus_Tile());
					}else if(type.equals("l")){
						L_Tile L = new L_Tile();
						L.setRotate(degree);
						gridPanel.add(L);
					}else if(type.equals("t")){
						T_Tile T = new T_Tile();
						T.setRotate(degree);
						gridPanel.add(T);
					}else if(type.equals("i")){
						I_Tile I = new I_Tile();
						I.setRotate(degree);
						gridPanel.add(I);
					}
				}
			}


		}

		for (int i = 0; i < readXMLdata.CarArray.size(); i++) {
			Car car = readXMLdata.CarArray.get(i);
			int col=car.getLocX();
			char row=car.getLocY();
			String color=car.getColor();
			System.out.println("Car "+i+" has row = "+row+" and col = "+col);
			int cellIndex=getGridCellIndex(row,col);
			System.out.println("cell index = "+cellIndex);

			String type=readXMLdata.rowArrayList.get(row-'A').getTileList().get(col-1).getType();
			System.out.println("Type="+type);
			float rotate=readXMLdata.rowArrayList.get(row-'A').getTileList().get(col-1).getDegree();
			System.out.println("rotate="+rotate);
			CarLabel cLabel = new CarLabel();
			cLabel.alreadyShape=type;
			cLabel.rotate=rotate;
			cLabel.txt=i+1+"";
			cLabel.color=color;
			gridPanel.remove(cellIndex-1);
			gridPanel.add(cLabel,cellIndex-1);

			dataValues[i]=new String[3];
			dataValues[i][0]=cLabel.txt;
			dataValues[i][1]=""+col;
			dataValues[i][2]=""+row;
		}

		add(gridPanel,BorderLayout.CENTER);
		add(SimpleTable(),BorderLayout.EAST);
		setBackground(Color.yellow);
		gridPanel.setPreferredSize(new Dimension(430,430));
		gridPanel.setVisible(true);
	}

	private int getGridCellIndex(char row, int col) {
		return ((row-'A'+1)*10)+(col+1);
	}

	// Constructor of main frame
	public JPanel SimpleTable()
	{
		// Instance attributes used 
		JPanel		rightPanel;
		JTable		table;
		JScrollPane scrollPane;

		// Create a panel to hold all other components
		rightPanel = new JPanel();

		// Create columns names
		String columnNames[] = { "Car #", "X", "Y" };

		// Create a new table instance
		table = new JTable( dataValues, columnNames );
		TableColumn column = null;
		for (int i = 0; i < columnNames.length; i++) {
			column = table.getColumnModel().getColumn(i);		         
			column.setPreferredWidth(60);
		}
		table.setPreferredSize(new Dimension(200,450));
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		// Add the table to a scrolling pane
		scrollPane = new JScrollPane( table );
		rightPanel.add( scrollPane);
		//rightPanel.setPreferredSize(new Dimension(180,150));
		rightPanel.setVisible(true);
		rightPanel.setBackground(Color.RED);
		return rightPanel;
	}
	static void createAndShowGui() {
		DrawGrid mainPanel = new DrawGrid();

		JFrame frame = new JFrame("Roadway");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);

		frame.setMinimumSize(new Dimension(650,450));
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}
}