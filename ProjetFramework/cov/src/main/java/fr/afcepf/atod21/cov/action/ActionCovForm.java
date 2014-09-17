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
	    
	    List<String> attributesList = new ArrayList<>(); //Contient la liste de l'ensemble des attributs à récupérer dans la requête.
	    Boolean allAttributesCorrect = true; // Devient false si un champ n'a pas été rempli par l'utilisateur.
	    
	    attributesList = (List<String>) request.getAttributeNames(); //On recupère l'ensemble des noms des attributs de la requête.
	    
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
