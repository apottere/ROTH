package com.ROTH.Framwork;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ROTHMap {
	
	private DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder builder;
	private Document document;
	private Element root;
	private NodeList nodes;
	
	public final String name;

	public ROTHMap(FileInputStream filename) throws MalformedRMLException {
		
		builder = null;
		try {
		    builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
		    e.printStackTrace();  
		}
		
		try {
		    document = builder.parse(filename);
		} catch (SAXException e) {
		    throw new MalformedRMLException(e);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		root = document.getDocumentElement();
		nodes = root.getChildNodes();
		
			
		name = nodes.item(1).getTextContent();
		
	}

}
