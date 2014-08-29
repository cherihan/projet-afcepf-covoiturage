
package fr.afcepf.atod21.coVoiturage.ria;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.atod21.coVoiturage.ria package. 
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

    private final static QName _SInscrireTrajetDtoResponse_QNAME = new QName("http://services.coVoiturage.atod21.afcepf.fr/", "sInscrireTrajetDtoResponse");
    private final static QName _SInscrireTrajetDto_QNAME = new QName("http://services.coVoiturage.atod21.afcepf.fr/", "sInscrireTrajetDto");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.atod21.coVoiturage.ria
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SInscrireTrajetDtoResponse }
     * 
     */
    public SInscrireTrajetDtoResponse createSInscrireTrajetDtoResponse() {
        return new SInscrireTrajetDtoResponse();
    }

    /**
     * Create an instance of {@link SInscrireTrajetDto }
     * 
     */
    public SInscrireTrajetDto createSInscrireTrajetDto() {
        return new SInscrireTrajetDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SInscrireTrajetDtoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.coVoiturage.atod21.afcepf.fr/", name = "sInscrireTrajetDtoResponse")
    public JAXBElement<SInscrireTrajetDtoResponse> createSInscrireTrajetDtoResponse(SInscrireTrajetDtoResponse value) {
        return new JAXBElement<SInscrireTrajetDtoResponse>(_SInscrireTrajetDtoResponse_QNAME, SInscrireTrajetDtoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SInscrireTrajetDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.coVoiturage.atod21.afcepf.fr/", name = "sInscrireTrajetDto")
    public JAXBElement<SInscrireTrajetDto> createSInscrireTrajetDto(SInscrireTrajetDto value) {
        return new JAXBElement<SInscrireTrajetDto>(_SInscrireTrajetDto_QNAME, SInscrireTrajetDto.class, null, value);
    }

}
