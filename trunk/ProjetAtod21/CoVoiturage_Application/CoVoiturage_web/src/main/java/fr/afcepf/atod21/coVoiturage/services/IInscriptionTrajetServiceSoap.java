package fr.afcepf.atod21.coVoiturage.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IInscriptionTrajetServiceSoap {

    @WebMethod
    boolean sInscrireTrajetDto(Integer IdTrajet, Integer IdUser);
    //void seDesinscrireTrajet(Integer idTrajet, Integer idUser);

}
