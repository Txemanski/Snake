package logic.levels;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LevelParser {

	private LinkedList<WallDefinition> walls = new LinkedList<WallDefinition>();
	private WallDefinition tempWall;

	public void parse(File filetoParse) throws ParserConfigurationException, SAXException, IOException, DOMException, ParseNumbersException {
		
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document xml = builder.parse(filetoParse);

			Node firstNode = xml.getFirstChild();
			
			if (firstNode.getNodeName().equals("level")) {

				NodeList listofWalls = firstNode.getChildNodes();

				for (int i = 0; i < listofWalls.getLength(); i++) {
					
					if (listofWalls.item(i).getNodeName().equals("wall")) 
						getStartofWall(listofWalls.item(i));

				}
			} 
			else throw new DOMException(DOMException.SYNTAX_ERR, "Invalid XML");

	}

	private void getStartofWall(Node n) throws DOMException, ParseNumbersException {

			NodeList wallNodes = n.getChildNodes();

			for (int i = 0; i < wallNodes.getLength(); i++) {

				if (wallNodes.item(i).getNodeName().equals("start"))
					getStartXandY(wallNodes.item(i));
				else if (wallNodes.item(i).getNodeName().equals("end"))
					getEndXandY(wallNodes.item(i));

			}

	}

	private void getStartXandY(Node n) throws DOMException, ParseNumbersException {

		tempWall = new WallDefinition();

		NodeList startNodes = n.getChildNodes();

		for (int i = 0; i < startNodes.getLength(); i++) {
			if (startNodes.item(i).getNodeName().equals("x"))
				tempWall.getStart().x = parseFractions(startNodes.item(i).getTextContent());
			else if (startNodes.item(i).getNodeName().equals("y"))
				tempWall.getStart().y = parseFractions(startNodes.item(i).getTextContent());
		}

	}

	private void getEndXandY(Node n) throws DOMException, ParseNumbersException {

		NodeList endNodes = n.getChildNodes();

		for (int i = 0; i < endNodes.getLength(); i++) {
			if (endNodes.item(i).getNodeName().equals("x"))
				tempWall.getEnd().x = parseFractions(endNodes.item(i).getTextContent());
			else if (endNodes.item(i).getNodeName().equals("y"))
				tempWall.getEnd().y = parseFractions(endNodes.item(i).getTextContent());
		}

		walls.add(tempWall);

	}
	
	private int parseFractions(String sNumber) throws ParseNumbersException {
		
		String[] numberstoDivide = sNumber.split("/");
		
		if (sNumber.equals("0") || sNumber.equals("1")) return Integer.valueOf(sNumber) * 100;
		else if (numberstoDivide.length == 2) return Integer.valueOf(numberstoDivide[0]) * 100 / Integer.valueOf(numberstoDivide[1]);
		else throw new ParseNumbersException("sNumber is not a valid number");
	}

	public LinkedList<WallDefinition> getWalls(int level) {
		try {
			parse(new File("levels/level" + level + ".xml"));
		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseNumbersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return walls;
	}
}
