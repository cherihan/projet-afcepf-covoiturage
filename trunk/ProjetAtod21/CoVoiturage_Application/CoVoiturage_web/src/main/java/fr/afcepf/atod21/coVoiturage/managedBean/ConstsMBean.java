package fr.afcepf.atod21.coVoiturage.managedBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.atod21.coVoiturage.utils.Consts;


@ManagedBean
@SessionScoped
public class ConstsMBean {

    private String PROPOSE = Consts.PROPOSE;
    private String EN_COURS = Consts.EN_COURS;
    private String COMPLET = Consts.COMPLET;
    private String TERMINE = Consts.TERMINE;
    /**
     * @return the pROPOSE
     */
    public String getPROPOSE() {
        return PROPOSE;
    }
    /**
     * @param paramPROPOSE the pROPOSE to set
     */
    public void setPROPOSE(String paramPROPOSE) {
        PROPOSE = paramPROPOSE;
    }
    /**
     * @return the eN_COURS
     */
    public String getEN_COURS() {
        return EN_COURS;
    }
    /**
     * @param paramEN_COURS the eN_COURS to set
     */
    public void setEN_COURS(String paramEN_COURS) {
        EN_COURS = paramEN_COURS;
    }
    /**
     * @return the cOMPLET
     */
    public String getCOMPLET() {
        return COMPLET;
    }
    /**
     * @param paramCOMPLET the cOMPLET to set
     */
    public void setCOMPLET(String paramCOMPLET) {
        COMPLET = paramCOMPLET;
    }
    /**
     * @return the tERMINE
     */
    public String getTERMINE() {
        return TERMINE;
    }
    /**
     * @param paramTERMINE the tERMINE to set
     */
    public void setTERMINE(String paramTERMINE) {
        TERMINE = paramTERMINE;
    }

    

}
