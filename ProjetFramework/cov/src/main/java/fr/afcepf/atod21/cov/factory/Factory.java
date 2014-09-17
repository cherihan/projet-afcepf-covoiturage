package fr.afcepf.atod21.cov.factory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
	private static Map<String, ActionCov> mapAction= new HashMap<String, ActionCov>();
	private static Map<String, ActionCovForm> mapForm= new HashMap<String, ActionCovForm>();

	private static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	private static DocumentBuilder db;
	private static Document document;

	public Factory() {
		super();
	}


	public static Factory getInstance() throws SAXException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		if(instanceFactory == null){
			instanceFactory = new Factory();
		}
		
		try {
			db = dbf.newDocumentBuilder();
			document = db.parse(pathToConf);
			validateConfig();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		return instanceFactory;
	}
	
	
	public static void validateConfig() throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{	
		Element racine = document.getDocumentElement();
        NodeList bases = racine.getElementsByTagName("action");
        String actionName = null;
        String formClass = null;
        String urlPattern = null;
        ActionCovForm classForm = null;
        ActionCov classAction = null;
        
        for (int i = 0; i < bases.getLength(); i++) 
        {
            Node base = bases.item(i);
            Node base2 = null;
            Node enfant2 = null;
            NodeList elements = base.getChildNodes();
            boolean resultat = false;
            
            for (int j = 0; j < elements.getLength(); j++) 
            {    
            	Node enfant = elements.item(j);
                
                if (enfant.getNodeName().equals("action-name")) {
                    actionName = enfant.getTextContent();
                }
                
                if (enfant.getNodeName().equals("url-pattern")) {
                    urlPattern = enfant.getTextContent();
                }
                
                if (enfant.getNodeName().equals("form-name"))
                {
                    NodeList forms = racine.getElementsByTagName("form");
                    for (int k = 0; k < forms.getLength(); k++) 
                    {
                        base2 = forms.item(k);
                        NodeList elements2 = base2.getChildNodes();

                        for (int l = 0; l < elements2.getLength(); l++) 
                        {
                            
                        	enfant2 = elements2.item(l);
                        	
                            if (enfant2.getNodeName().equals("form-class")) {
                                formClass = enfant2.getTextContent();
                            }
                            
                            if ((enfant2.getNodeName().equals("form-name")) && (enfant2.getTextContent().equals(enfant.getTextContent()))) {
                            	
                                resultat = true;
                                
                                classForm = (ActionCovForm) Class.forName(formClass).newInstance();
                                mapForm.put(urlPattern, classForm);
                                
                                classAction = (ActionCov) Class.forName(actionName).newInstance();
                                mapAction.put(actionName, classAction);

                            }
                        }
                    }
                }
                
                if (!resultat) {
                    System.out.println("erreur de liaison entre actions et forms");
                }
            }
        }
    }
	
	@Override
	public ActionCovForm getActionForm(String formName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {	
		return mapForm.get(formName);
	}

	@Override
	public ActionCov getAction(String uri) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return mapAction.get(uri);
	}
	
}
