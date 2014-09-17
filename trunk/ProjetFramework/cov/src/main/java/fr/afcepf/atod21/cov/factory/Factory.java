package fr.afcepf.atod21.cov.factory;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.afcepf.atod21.cov.action.ActionCov;
import fr.afcepf.atod21.cov.action.ActionCovForm;

public class Factory implements IFactory{

	private static Factory instanceFactory;
	
	private static String pathToConf = "src/main/webapp/WEB-INF/cov-config.xml";
	private Map<String, ActionCov> mapAction= new HashMap<String, ActionCov>();
	private Map<String, ActionCovForm> mapForm= new HashMap<String, ActionCovForm>();
	
	private static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	private static DocumentBuilder db;
	private static Document document;
	
	public Factory getInstance() throws SAXException, IOException{
		if(instanceFactory == null){
			instanceFactory = new Factory();
		}
		
		try {
			db = dbf.newDocumentBuilder();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			URL resource = loader.getResource(pathToConf);
			document = db.parse(resource.toString());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		return instanceFactory;
	}
	
	@Override
	public ActionCovForm getActionForm(String tagName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, DOMException {
//		Element racine = document.getDocumentElement();
//		NodeList bases = racine.getElementsByTagName(tagName);
//		System.out.println(" nombre base "+bases.getLength());
//		String nomForm = null;
		ActionCovForm classForm = null ;
//		for( int i = 0 ;  i < bases.getLength(); i++){
//			Node base =  bases.item(i);
//			NodeList elements =  base.getChildNodes();
//			System.out.println(" elements : " + elements.getLength());
//			 for( int j= 0 ; j < elements.getLength() ; j++){
//				 Node enfant = elements.item(j);
//				 if(enfant.getNodeName().equals("form-name")){
//					nomForm =  enfant.getTextContent();
//				 }
//				 if(enfant.getNodeName().equals("form-class")){
//					 System.out.println(" node enfant " + enfant.getTextContent());
//				 classForm = (ActionCovForm) Class.forName(enfant.getTextContent()).newInstance();
//				 }
//			 }
//			 mapForm.put(nomForm, classForm);
//		}
		
		return classForm;
	}

	@Override
	public ActionCov getAction(String uri) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//		Element element = document.getDocumentElement();
//		NodeList bases = element.getElementsByTagName("action");
//		String classAction = null;
		ActionCov monAction = null;
//
//		for (int i = 0; i < bases.getLength(); i++) {
//
//			Node item = bases.item(i);
//			NodeList enfant = item.getChildNodes();
//			String nom = null;
//			for (int j = 0; j < enfant.getLength(); j++) {
//
//				Node itemEnfant = enfant.item(j);
//
//				if (itemEnfant.getNodeName().equals("action-name")) {
//					nom = itemEnfant.getTextContent();
//
//					classAction = itemEnfant.getTextContent();
//					monAction = (ActionCov) Class.forName(classAction).newInstance();
//					System.out.println(monAction);
//				}
//			}
//			mapAction.put(nom, monAction);
//		}

		return monAction;
	}
	
}
