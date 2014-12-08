package newRoadways;



import java.io.File;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class readXMLdata {

	private static Car car;
	static ArrayList <Car> CarArray= new ArrayList <Car>();
	private static Row row;
	private static Tile tile;
	public static ArrayList<Row> rowArrayList = new ArrayList <Row>();
	private static ArrayList<Tile> tileArrayList = new ArrayList<Tile>();
	public static void main(String[] args) {

		loadXML("C:/Users/NK/Downloads/Roadway/Roadway/cars.xml");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DrawGrid.createAndShowGui();
			}
		});
	}
	
	public static void loadXML(String fileName){
		try {
			//File file = new File("C:/Users/NK/Downloads/Roadway/Roadway/cars.xml");
			File file = new File(fileName);
			
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			if (doc.hasChildNodes()) {
				printNote(doc.getChildNodes());
			}
			for  (Car tempCar:CarArray){
				System.out.println(tempCar.toString());
			}
			System.out.println("----------------------------------------");
			System.out.println("----------------------------------------");
			for  (Row tempRow:rowArrayList){
				System.out.println(tempRow.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void printNote(NodeList nodeList) {

		for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);
			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				// get node name and value
				System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
				//System.out.println("Node Value =" + tempNode.getTextContent());
				if (tempNode.getNodeName().equals("car")){
					car = new Car();
				}
				if (tempNode.getNodeName().equals("row")){
					row = new Row();
				}
				if (tempNode.getNodeName().equals("tile")){
					tile = new Tile();
				}

				if (tempNode.hasAttributes()) {
					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();

					for (int i = 0; i < nodeMap.getLength(); i++) {

						Node node = nodeMap.item(i);
						String attr_name=node.getNodeName();
						String attr_value=node.getNodeValue();

						System.out.println("1 attr name : " + attr_name);
						System.out.println("1 attr value : " + attr_value);
						
						if (tempNode.getNodeName().equals("car")){
							if(attr_name.equals("ai")){
								int carAi = Integer.parseInt(tempNode.getAttributes().getNamedItem("ai").getNodeValue());
								car.setCarN(carAi);
							}
							if(attr_name.equals("speed")){
								Double speed = Double.parseDouble(tempNode.getAttributes().getNamedItem("speed").getNodeValue());
								car.setSpeed(speed);
							}
							if(attr_name.equals("color")){
								String color = tempNode.getAttributes().getNamedItem("color").getNodeValue();
								car.setColor(color);
							}
						}

						if (tempNode.getNodeName().equals("location")){
							if(attr_name.equals("x")){
								car.setLocX(Integer.parseInt(tempNode.getAttributes().getNamedItem("x").getNodeValue()));
							}
							if(attr_name.equals("y")){
								car.setLocY(tempNode.getAttributes().getNamedItem("y").getNodeValue().charAt(0));
							}
						}
						
						if (tempNode.getNodeName().equals("row")){
							if(attr_name.equals("label")){
								row.setLabel(tempNode.getAttributes().getNamedItem("label").getNodeValue());
							}
							System.out.println("row.setLabel = "+row.getLabel());
						}

						if (tempNode.getNodeName().equals("tile")){
							if(attr_name.equals("column")){
								tile.setColumn(Integer.parseInt(tempNode.getAttributes().getNamedItem("column").getNodeValue()));
							}
							if(attr_name.equals("type")){
								tile.setType(tempNode.getAttributes().getNamedItem("type").getNodeValue());
							}
							if(attr_name.equals("degree")){
								tile.setDegree(Integer.parseInt(tempNode.getAttributes().getNamedItem("degree").getNodeValue()));
							}
						}
						System.out.println("attr name : " + attr_name);
						System.out.println("attr value : " + attr_value);
					}
					System.out.println(" -- > "+tempNode.getNodeName());
					if (tempNode.getNodeName().equals("car")){
						car.toString();
						CarArray.add(car);
					}
					if (tempNode.getNodeName().equals("tile")){
						tileArrayList.add(tile);
					}
				}

				if (tempNode.hasChildNodes()) {
					// loop again if has child nodes
					printNote(tempNode.getChildNodes());
				}

				if (tempNode.getNodeName().equals("row")){
					 row.setTileList(tileArrayList);
					 rowArrayList.add(row);
					 tileArrayList = new ArrayList<Tile>();
				}
				System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
			}
		}
	}
}