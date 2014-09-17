package fr.afcepf.atod21.cov.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.afcepf.atod21.cov.action.ActionCov;

public class RecupConfigCov {

    public static void main(String[] args) throws SAXException, IOException,
            InstantiationException, IllegalAccessException,
            ClassNotFoundException {
        String fichier = "src/main/webapp/WEB-INF/cov-config.xml";
        Map<String, String> mapLiaison = new HashMap<String, String>();
        Map<String, String> mapActions = new HashMap<String, String>();
        String actionName = null;
        String formClass = null;
        String urlPattern = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(fichier);
            Element racine = document.getDocumentElement();
            NodeList bases = racine.getElementsByTagName("action");

            for (int i = 0; i < bases.getLength(); i++) {
                Node base = bases.item(i);
                Node base2 = null;
                Node enfant2 = null;
                NodeList elements = base.getChildNodes();
                boolean resultat = false;
                for (int j = 0; j < elements.getLength(); j++) {
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
                        for (int k = 0; k < forms.getLength(); k++) {
                            base2 = forms.item(k);
                            NodeList elements2 = base2.getChildNodes();

                            for (int l = 0; l < elements2.getLength(); l++) {
                                enfant2 = elements2.item(l);
                                if (enfant2.getNodeName().equals("form-class")) {
                                    formClass = enfant2.getTextContent();
                                }
                                if ((enfant2.getNodeName().equals("form-name"))
                                        && (enfant2.getTextContent().equals(enfant.getTextContent()))) {
                                    resultat = true;
                                    mapLiaison.put(actionName, actionName);
                                    mapActions.put(urlPattern, formClass);

                                }
                            }
                        }

                    }
                    

                }

                if (!resultat) {
                    System.out.println("erreur de liaison entre actions et forms");
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, String> entry : mapLiaison.entrySet()) {
            System.out.println("contenu de mapLiaison : " + entry.getKey()
                    + " = " + entry.getValue());
        }
        for (Map.Entry<String, String> entry : mapActions.entrySet()) {
            System.out.println("contenu de mapActions : " + entry.getKey() + " = " + entry.getValue());
        }

    }

}
