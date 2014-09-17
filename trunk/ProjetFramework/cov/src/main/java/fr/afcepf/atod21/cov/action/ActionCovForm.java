package fr.afcepf.atod21.cov.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import fr.afcepf.atod21.cov.errors.ActionCovErrors;
import fr.afcepf.atod21.cov.mapping.ActionCovMapping;

public class ActionCovForm implements IActionCovForm {

	@Override
	public ActionCovErrors validate(ActionCovMapping mapping, ServletRequest request) {
	    
	    List<String> attributesList = new ArrayList<>(); //Contient la liste de l'ensemble des attributs � r�cup�rer dans la requ�te.
	    Boolean allAttributesCorrect = true; // Devient false si un champ n'a pas �t� rempli par l'utilisateur.
	    
	    attributesList = (List<String>) request.getAttributeNames(); //On recup�re l'ensemble des noms des attributs de la requ�te.
	    
	    for (String currentAttribute : attributesList) {
            if (request.getAttribute(currentAttribute).equals(null)
                    || request.getAttribute(currentAttribute).equals("")){
                System.out.println("Erreur dans le remplissage des champs : le champ " +
                                    currentAttribute + " est vide !");
                allAttributesCorrect = false;
            }
        }
	    if (allAttributesCorrect = true){
	        return null;
	    } else {
	        ActionCovErrors champNonRempli = new ActionCovErrors();
            return champNonRempli;
	    }
	}

}
