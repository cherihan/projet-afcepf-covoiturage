package fr.afcepf.atod21.coVoiturage.services;

import fr.afcepf.atod21.coVoiturage.ria.IInscriptionTrajetServiceSoap;
import fr.afcepf.atod21.coVoiturage.ria.InscriptionTrajetServiceSoapService;

public class Test {

    public static void main(String[] args) {
      InscriptionTrajetServiceSoapService service=new InscriptionTrajetServiceSoapService();
      IInscriptionTrajetServiceSoap ria=service.getInscriptionTrajetServiceSoapPort();
      
      System.out.println(ria.sInscrireTrajetDto(1, 27));

    }

}
