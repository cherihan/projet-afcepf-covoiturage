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
public class OrderMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public String sortStatutByOrderAsc(List<Trajet> liste) {

        Collections.sort(liste, new Comparator<Trajet>() {
 
            @Override
            public int compare(Trajet o1, Trajet o2) {
                return o1.getStatut().compareTo(o2.getStatut());
            }
        });
       return "";
    }

    public String sortStatutByOrderDesc(List<Trajet> liste) {

        Collections.sort(liste, new Comparator<Trajet>() {

            @Override
            public int compare(Trajet o1, Trajet o2) {
                return o2.getStatut().compareTo(o1.getStatut());
            }
        });
       return "";
    }

    public String sortVilleDepartByOrderAsc(List<Trajet> liste) {

        Collections.sort(liste, new Comparator<Trajet>() {
 
            @Override
            public int compare(Trajet o1, Trajet o2) {
                return o1.getVilleDepart().getNom().compareTo(o2.getVilleDepart().getNom());
            }
        });
       return "";
    }

    public String sortVilleDepartByOrderDesc(List<Trajet> liste) {

        Collections.sort(liste, new Comparator<Trajet>() {

            @Override
            public int compare(Trajet o1, Trajet o2) {
                return o2.getVilleDepart().getNom().compareTo(o1.getVilleDepart().getNom());
            }
        });
       return "";
    }

    public String sortVilleArriveeByOrderAsc(List<Trajet> liste) {

        Collections.sort(liste, new Comparator<Trajet>() {
 
            @Override
            public int compare(Trajet o1, Trajet o2) {
                return o1.getVilleArrivee().getNom().compareTo(o2.getVilleArrivee().getNom());
            }
        });
       return "";
    }

    public String sortVilleArriveeByOrderDesc(List<Trajet> liste) {

        Collections.sort(liste, new Comparator<Trajet>() {

            @Override
            public int compare(Trajet o1, Trajet o2) {
                return o2.getVilleArrivee().getNom().compareTo(o1.getVilleArrivee().getNom());
            }
        });
       return "";
    }

}
