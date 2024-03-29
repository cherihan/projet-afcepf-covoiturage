
package fr.afcepf.atod21.covoiturage.servicesimpl;

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
@WebServiceClient(name = "OrchestrateurSoapService", targetNamespace = "http://servicesImpl.coVoiturage.atod21.afcepf.fr/", wsdlLocation = "http://192.168.11.52:8080/CoVoiturage_web/ws/SOAP/OrchestrateurService?wsdl")
public class OrchestrateurSoapService extends Service
{
    private final static URL ORCHESTRATEURSOAPSERVICE_WSDL_LOCATION;
    private final static WebServiceException ORCHESTRATEURSOAPSERVICE_EXCEPTION;
    private final static QName ORCHESTRATEURSOAPSERVICE_QNAME = new QName("http://servicesImpl.coVoiturage.atod21.afcepf.fr/", "OrchestrateurSoapService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.11.52:8080/CoVoiturage_web/ws/SOAP/OrchestrateurService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ORCHESTRATEURSOAPSERVICE_WSDL_LOCATION = url;
        ORCHESTRATEURSOAPSERVICE_EXCEPTION = e;
    }

    public OrchestrateurSoapService() {
        super(__getWsdlLocation(), ORCHESTRATEURSOAPSERVICE_QNAME);
    }

    public OrchestrateurSoapService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ORCHESTRATEURSOAPSERVICE_QNAME, features);
    }

    public OrchestrateurSoapService(URL wsdlLocation) {
        super(wsdlLocation, ORCHESTRATEURSOAPSERVICE_QNAME);
    }

    public OrchestrateurSoapService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ORCHESTRATEURSOAPSERVICE_QNAME, features);
    }

    public OrchestrateurSoapService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OrchestrateurSoapService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IOrchestrateurSoap
     */
    @WebEndpoint(name = "OrchestrateurSoapPort")
    public IOrchestrateurSoap getOrchestrateurSoapPort() {
        return super.getPort(new QName("http://servicesImpl.coVoiturage.atod21.afcepf.fr/", "OrchestrateurSoapPort"), IOrchestrateurSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IOrchestrateurSoap
     */
    @WebEndpoint(name = "OrchestrateurSoapPort")
    public IOrchestrateurSoap getOrchestrateurSoapPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servicesImpl.coVoiturage.atod21.afcepf.fr/", "OrchestrateurSoapPort"), IOrchestrateurSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ORCHESTRATEURSOAPSERVICE_EXCEPTION!= null) {
            throw ORCHESTRATEURSOAPSERVICE_EXCEPTION;
        }
        return ORCHESTRATEURSOAPSERVICE_WSDL_LOCATION;
    }

}
