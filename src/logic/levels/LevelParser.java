package logic.levels;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LevelParser {

	private LinkedList<WallDefinition> walls = new LinkedList<WallDefinition>();
	private WallDefinition tempWall;

	public void parse() {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document xml = builder.parse(new File("src/test/level1.xml"));

			Node firstNode = xml.getFirstChild();

			if (firstNode.getNodeName().equals("level")) {

				NodeList listofWalls = firstNode.getChildNodes();

				for (int i = 0; i < listofWalls.getLength(); i++) {

					getStartofWall(listofWalls.item(i));

				}
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getStartofWall(Node n) {

		if (n.getNodeName().equals("wall")) {
			
			NodeList wallNodes = n.getChildNodes();

			for (int i = 0; i < wallNodes.getLength(); i++) {
				
				tempWall = new WallDefinition();
				if (wallNodes.item(i).getNodeName().equals("start"))
					getStartXandY(wallNodes.item(i));
				else if (wallNodes.item(i).getNodeName().equals("End"))
					getEndXandY(wallNodes.item(i));
				walls.add(tempWall);
			}

		}

	}

	private void getStartXandY(Node n) {

		if (n.getNodeName().equals("start")) {

			NodeList startNodes = n.getChildNodes();

			for (int i = 0; i < startNodes.getLength(); i++) {
				if (startNodes.item(i).getNodeName().equals("x"))
					tempWall.getStart().x = Integer.valueOf(startNodes.item(i).getTextContent());
				else if (startNodes.item(i).getNodeName().equals("y"))
					tempWall.getStart().y = Integer.valueOf(startNodes.item(i).getTextContent());
			}

		}

	}
	
	private void getEndXandY(Node n) {

		if (n.getNodeName().equals("end")) {

			NodeList endNodes = n.getChildNodes();

			for (int i = 0; i < endNodes.getLength(); i++) {
				if (endNodes.item(i).getNodeName().equals("x"))
					tempWall.getEnd().x = Integer.valueOf(endNodes.item(i).getTextContent());
				else if (endNodes.item(i).getNodeName().equals("y"))
					tempWall.getEnd().y = Integer.valueOf(endNodes.item(i).getTextContent());
			}

		}

	}
	
	public LinkedList<WallDefinition> getWalls(){
		return walls;
	}
}
