package fr.afcepf.atod21.coVoiturage.managedBean;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;

@ManagedBean(name="order")
@SessionScoped
public class OrderMBean implements Serializable{

    private static final long serialVersionUID = 1L;

    public String sortByOrderAsc(List<Trajet> liste) {

        Collections.sort(liste, new Comparator<Trajet>() {
 
            @Override
            public int compare(Trajet o1, Trajet o2) {
                return o1.getStatut().compareTo(o2.getStatut());
            }
        });
       return "";
    }

    public String sortByOrderDesc(List<Trajet> liste) {

        Collections.sort(liste, new Comparator<Trajet>() {

            @Override
            public int compare(Trajet o1, Trajet o2) {
                return o2.getStatut().compareTo(o1.getStatut());
            }
        });
       return "";
    }

}
