package newRoadways;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

//---------------------------------------------------------------------------------------------------	
public class MainGUI extends JFrame {
	//*************************************************************************************************	
	public static void main(String [] args){
		new MainGUI().setVisible(true);
	}
	//*************************************************************************************************	
	private JMenuItem open = new JMenuItem("Open File...");
	private JFileChooser jfc = new JFileChooser();
	static ArrayList <Car> CarArray= new ArrayList <Car>();
	//---------------------------------------------------------------------------------------------------	
	public MainGUI(){

		super("Roadway Simulator"); //title
		setSize(700,500);
		setLocationRelativeTo(null); //appears in middle
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JMenuBar mb = new JMenuBar(); //adds the bar
		JMenu file = new JMenu("File");
		mb.add(file); //adds File to bar
		setJMenuBar(mb);
		file.add(open);
		setVisible(true);
			
		
		//---------------------------------------------------------------------------------------------------				
		open.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me){
				int fileReturnVal = jfc.showOpenDialog(MainGUI.this);

				if(fileReturnVal == JFileChooser.APPROVE_OPTION){
					File file = jfc.getSelectedFile();
					System.out.println("file = "+file);
					String fileName=file.getAbsolutePath();
					readXMLdata.loadXML(fileName);

					DrawGrid mainPanel = new DrawGrid();
					getContentPane().add(mainPanel);
					setBackground(Color.yellow);
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					getContentPane().add(mainPanel);
					setMinimumSize(new Dimension(750,570));
					pack();
					//setLocationByPlatform(true);
					setVisible(true);
				}
			}
		}); 
	}
}
