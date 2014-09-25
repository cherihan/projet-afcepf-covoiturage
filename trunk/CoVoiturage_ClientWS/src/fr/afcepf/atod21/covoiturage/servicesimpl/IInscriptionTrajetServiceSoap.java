
package fr.afcepf.atod21.covoiturage.servicesimpl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import fr.afcepf.atod21.covoiturage.services.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IInscriptionTrajetServiceSoap", targetNamespace = "http://services.coVoiturage.atod21.afcepf.fr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IInscriptionTrajetServiceSoap {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sInscrireTrajetDto", targetNamespace = "http://services.coVoiturage.atod21.afcepf.fr/", className = "fr.afcepf.atod21.covoiturage.services.SInscrireTrajetDto")
    @ResponseWrapper(localName = "sInscrireTrajetDtoResponse", targetNamespace = "http://services.coVoiturage.atod21.afcepf.fr/", className = "fr.afcepf.atod21.covoiturage.services.SInscrireTrajetDtoResponse")
    public boolean sInscrireTrajetDto(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Integer arg1);

}