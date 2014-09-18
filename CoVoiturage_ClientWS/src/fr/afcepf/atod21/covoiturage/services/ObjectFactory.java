
package fr.afcepf.atod21.covoiturage.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.atod21.covoiturage.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RechercherTrajetParVilleDepartSOAP_QNAME = new QName("http://services.coVoiturage.atod21.afcepf.fr/", "rechercherTrajetParVilleDepartSOAP");
    private final static QName _RechercherTrajetSOAPResponse_QNAME = new QName("http://services.coVoiturage.atod21.afcepf.fr/", "rechercherTrajetSOAPResponse");
    private final static QName _FileNotFoundException_QNAME = new QName("http://services.coVoiturage.atod21.afcepf.fr/", "FileNotFoundException");
    private final static QName _EntryMethod_QNAME = new QName("http://services.coVoiturage.atod21.afcepf.fr/", "entryMethod");
    private final static QName _AuthentifierClientResponse_QNAME = new QName("http://services.coVoiturage.atod21.afcepf.fr/", "authentifierClientResponse");
    private final static QName _TrajetDto_QNAME = new QName("http://services.coVoiturage.atod21.afcepf.fr/", "trajetDto");
    private final static QName _RechercherTrajetParVilleDepartSOAPResponse_QNAME = new QName("http://services.coVoiturage.atod21.afcepf.fr/", "rechercherTrajetParVilleDepartSOAPResponse");
    private final static QName _Exception_QNAME = new QName("http://services.coVoiturage.atod21.afcepf.fr/", "Exception");
    private final static QName _AuthentifierClient_QNAME = new QName("http://services.coVoiturage.atod21.afcepf.fr/", "authentifierClient");
    private final static QName _RechercherTrajetSOAP_QNAME = new QName("http://services.coVoiturage.atod21.afcepf.fr/", "rechercherTrajetSOAP");
    private final static QName _IOException_QNAME = new QName("http://services.coVoiturage.atod21.afcepf.fr/", "IOException");
    private final static QName _EntryMethodResponse_QNAME = new QName("http://services.coVoiturage.atod21.afcepf.fr/", "entryMethodResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.atod21.covoiturage.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RechercherTrajetParVilleDepartSOAPResponse }
     * 
     */
    public RechercherTrajetParVilleDepartSOAPResponse createRechercherTrajetParVilleDepartSOAPResponse() {
        return new RechercherTrajetParVilleDepartSOAPResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link AuthentifierClient }
     * 
     */
    public AuthentifierClient createAuthentifierClient() {
        return new AuthentifierClient();
    }

    /**
     * Create an instance of {@link RechercherTrajetSOAP }
     * 
     */
    public RechercherTrajetSOAP createRechercherTrajetSOAP() {
        return new RechercherTrajetSOAP();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link EntryMethodResponse }
     * 
     */
    public EntryMethodResponse createEntryMethodResponse() {
        return new EntryMethodResponse();
    }

    /**
     * Create an instance of {@link FileNotFoundException }
     * 
     */
    public FileNotFoundException createFileNotFoundException() {
        return new FileNotFoundException();
    }

    /**
     * Create an instance of {@link RechercherTrajetSOAPResponse }
     * 
     */
    public RechercherTrajetSOAPResponse createRechercherTrajetSOAPResponse() {
        return new RechercherTrajetSOAPResponse();
    }

    /**
     * Create an instance of {@link RechercherTrajetParVilleDepartSOAP }
     * 
     */
    public RechercherTrajetParVilleDepartSOAP createRechercherTrajetParVilleDepartSOAP() {
        return new RechercherTrajetParVilleDepartSOAP();
    }

    /**
     * Create an instance of {@link EntryMethod }
     * 
     */
    public EntryMethod createEntryMethod() {
        return new EntryMethod();
    }

    /**
     * Create an instance of {@link TrajetDto }
     * 
     */
    public TrajetDto createTrajetDto() {
        return new TrajetDto();
    }

    /**
     * Create an instance of {@link AuthentifierClientResponse }
     * 
     */
    public AuthentifierClientResponse createAuthentifierClientResponse() {
        return new AuthentifierClientResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercherTrajetParVilleDepartSOAP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.coVoiturage.atod21.afcepf.fr/", name = "rechercherTrajetParVilleDepartSOAP")
    public JAXBElement<RechercherTrajetParVilleDepartSOAP> createRechercherTrajetParVilleDepartSOAP(RechercherTrajetParVilleDepartSOAP value) {
        return new JAXBElement<RechercherTrajetParVilleDepartSOAP>(_RechercherTrajetParVilleDepartSOAP_QNAME, RechercherTrajetParVilleDepartSOAP.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercherTrajetSOAPResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.coVoiturage.atod21.afcepf.fr/", name = "rechercherTrajetSOAPResponse")
    public JAXBElement<RechercherTrajetSOAPResponse> createRechercherTrajetSOAPResponse(RechercherTrajetSOAPResponse value) {
        return new JAXBElement<RechercherTrajetSOAPResponse>(_RechercherTrajetSOAPResponse_QNAME, RechercherTrajetSOAPResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.coVoiturage.atod21.afcepf.fr/", name = "FileNotFoundException")
    public JAXBElement<FileNotFoundException> createFileNotFoundException(FileNotFoundException value) {
        return new JAXBElement<FileNotFoundException>(_FileNotFoundException_QNAME, FileNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntryMethod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.coVoiturage.atod21.afcepf.fr/", name = "entryMethod")
    public JAXBElement<EntryMethod> createEntryMethod(EntryMethod value) {
        return new JAXBElement<EntryMethod>(_EntryMethod_QNAME, EntryMethod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthentifierClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.coVoiturage.atod21.afcepf.fr/", name = "authentifierClientResponse")
    public JAXBElement<AuthentifierClientResponse> createAuthentifierClientResponse(AuthentifierClientResponse value) {
        return new JAXBElement<AuthentifierClientResponse>(_AuthentifierClientResponse_QNAME, AuthentifierClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrajetDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.coVoiturage.atod21.afcepf.fr/", name = "trajetDto")
    public JAXBElement<TrajetDto> createTrajetDto(TrajetDto value) {
        return new JAXBElement<TrajetDto>(_TrajetDto_QNAME, TrajetDto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercherTrajetParVilleDepartSOAPResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.coVoiturage.atod21.afcepf.fr/", name = "rechercherTrajetParVilleDepartSOAPResponse")
    public JAXBElement<RechercherTrajetParVilleDepartSOAPResponse> createRechercherTrajetParVilleDepartSOAPResponse(RechercherTrajetParVilleDepartSOAPResponse value) {
        return new JAXBElement<RechercherTrajetParVilleDepartSOAPResponse>(_RechercherTrajetParVilleDepartSOAPResponse_QNAME, RechercherTrajetParVilleDepartSOAPResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.coVoiturage.atod21.afcepf.fr/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthentifierClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.coVoiturage.atod21.afcepf.fr/", name = "authentifierClient")
    public JAXBElement<AuthentifierClient> createAuthentifierClient(AuthentifierClient value) {
        return new JAXBElement<AuthentifierClient>(_AuthentifierClient_QNAME, AuthentifierClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercherTrajetSOAP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.coVoiturage.atod21.afcepf.fr/", name = "rechercherTrajetSOAP")
    public JAXBElement<RechercherTrajetSOAP> createRechercherTrajetSOAP(RechercherTrajetSOAP value) {
        return new JAXBElement<RechercherTrajetSOAP>(_RechercherTrajetSOAP_QNAME, RechercherTrajetSOAP.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.coVoiturage.atod21.afcepf.fr/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntryMethodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.coVoiturage.atod21.afcepf.fr/", name = "entryMethodResponse")
    public JAXBElement<EntryMethodResponse> createEntryMethodResponse(EntryMethodResponse value) {
        return new JAXBElement<EntryMethodResponse>(_EntryMethodResponse_QNAME, EntryMethodResponse.class, null, value);
    }

}
