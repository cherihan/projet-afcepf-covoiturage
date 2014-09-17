
package fr.afcepf.atod21.coVoiturage.ria;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "InscriptionTrajetServiceSoapService", targetNamespace = "http://servicesImpl.coVoiturage.atod21.afcepf.fr/", wsdlLocation = "http://localhost:8080/CoVoiturage_web/ws/SOAP/InscriptionTrajetService?wsdl")
public class InscriptionTrajetServiceSoapService
    extends Service
{

    private final static URL INSCRIPTIONTRAJETSERVICESOAPSERVICE_WSDL_LOCATION;
    private final static WebServiceException INSCRIPTIONTRAJETSERVICESOAPSERVICE_EXCEPTION;
    private final static QName INSCRIPTIONTRAJETSERVICESOAPSERVICE_QNAME = new QName("http://servicesImpl.coVoiturage.atod21.afcepf.fr/", "InscriptionTrajetServiceSoapService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/CoVoiturage_web/ws/SOAP/InscriptionTrajetService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        INSCRIPTIONTRAJETSERVICESOAPSERVICE_WSDL_LOCATION = url;
        INSCRIPTIONTRAJETSERVICESOAPSERVICE_EXCEPTION = e;
    }

    public InscriptionTrajetServiceSoapService() {
        super(__getWsdlLocation(), INSCRIPTIONTRAJETSERVICESOAPSERVICE_QNAME);
    }

    public InscriptionTrajetServiceSoapService(WebServiceFeature... features) {
        super(__getWsdlLocation(), INSCRIPTIONTRAJETSERVICESOAPSERVICE_QNAME, features);
    }

    public InscriptionTrajetServiceSoapService(URL wsdlLocation) {
        super(wsdlLocation, INSCRIPTIONTRAJETSERVICESOAPSERVICE_QNAME);
    }

    public InscriptionTrajetServiceSoapService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, INSCRIPTIONTRAJETSERVICESOAPSERVICE_QNAME, features);
    }

    public InscriptionTrajetServiceSoapService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public InscriptionTrajetServiceSoapService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IInscriptionTrajetServiceSoap
     */
    @WebEndpoint(name = "InscriptionTrajetServiceSoapPort")
    public IInscriptionTrajetServiceSoap getInscriptionTrajetServiceSoapPort() {
        return super.getPort(new QName("http://servicesImpl.coVoiturage.atod21.afcepf.fr/", "InscriptionTrajetServiceSoapPort"), IInscriptionTrajetServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IInscriptionTrajetServiceSoap
     */
    @WebEndpoint(name = "InscriptionTrajetServiceSoapPort")
    public IInscriptionTrajetServiceSoap getInscriptionTrajetServiceSoapPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servicesImpl.coVoiturage.atod21.afcepf.fr/", "InscriptionTrajetServiceSoapPort"), IInscriptionTrajetServiceSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (INSCRIPTIONTRAJETSERVICESOAPSERVICE_EXCEPTION!= null) {
            throw INSCRIPTIONTRAJETSERVICESOAPSERVICE_EXCEPTION;
        }
        return INSCRIPTIONTRAJETSERVICESOAPSERVICE_WSDL_LOCATION;
    }

}