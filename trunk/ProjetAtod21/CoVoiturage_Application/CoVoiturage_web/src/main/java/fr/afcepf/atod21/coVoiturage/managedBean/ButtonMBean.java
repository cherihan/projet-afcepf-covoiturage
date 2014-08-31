package fr.afcepf.atod21.coVoiturage.managedBean;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;  
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;  
import javax.faces.event.ActionEvent;  
 
@ManagedBean
@SessionScoped
public class ButtonMBean {  

	
	public ButtonMBean() {
		super();
	}

	public void destroyWorld(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error",  "Please try again later.");  
          
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
}
