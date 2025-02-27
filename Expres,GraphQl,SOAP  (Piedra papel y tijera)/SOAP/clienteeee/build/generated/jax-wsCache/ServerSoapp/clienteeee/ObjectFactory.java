
package clienteeee;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clienteeee package. 
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

    private final static QName _IniciarPartida_QNAME = new QName("http://ServerSoapp/", "iniciarPartida");
    private final static QName _IniciarPartidaResponse_QNAME = new QName("http://ServerSoapp/", "iniciarPartidaResponse");
    private final static QName _ObtenerResultado_QNAME = new QName("http://ServerSoapp/", "obtenerResultado");
    private final static QName _ObtenerResultadoResponse_QNAME = new QName("http://ServerSoapp/", "obtenerResultadoResponse");
    private final static QName _RegistrarJugada_QNAME = new QName("http://ServerSoapp/", "registrarJugada");
    private final static QName _RegistrarJugadaResponse_QNAME = new QName("http://ServerSoapp/", "registrarJugadaResponse");
    private final static QName _ReiniciarPartida_QNAME = new QName("http://ServerSoapp/", "reiniciarPartida");
    private final static QName _ReiniciarPartidaResponse_QNAME = new QName("http://ServerSoapp/", "reiniciarPartidaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clienteeee
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IniciarPartida }
     * 
     */
    public IniciarPartida createIniciarPartida() {
        return new IniciarPartida();
    }

    /**
     * Create an instance of {@link IniciarPartidaResponse }
     * 
     */
    public IniciarPartidaResponse createIniciarPartidaResponse() {
        return new IniciarPartidaResponse();
    }

    /**
     * Create an instance of {@link ObtenerResultado }
     * 
     */
    public ObtenerResultado createObtenerResultado() {
        return new ObtenerResultado();
    }

    /**
     * Create an instance of {@link ObtenerResultadoResponse }
     * 
     */
    public ObtenerResultadoResponse createObtenerResultadoResponse() {
        return new ObtenerResultadoResponse();
    }

    /**
     * Create an instance of {@link RegistrarJugada }
     * 
     */
    public RegistrarJugada createRegistrarJugada() {
        return new RegistrarJugada();
    }

    /**
     * Create an instance of {@link RegistrarJugadaResponse }
     * 
     */
    public RegistrarJugadaResponse createRegistrarJugadaResponse() {
        return new RegistrarJugadaResponse();
    }

    /**
     * Create an instance of {@link ReiniciarPartida }
     * 
     */
    public ReiniciarPartida createReiniciarPartida() {
        return new ReiniciarPartida();
    }

    /**
     * Create an instance of {@link ReiniciarPartidaResponse }
     * 
     */
    public ReiniciarPartidaResponse createReiniciarPartidaResponse() {
        return new ReiniciarPartidaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IniciarPartida }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IniciarPartida }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServerSoapp/", name = "iniciarPartida")
    public JAXBElement<IniciarPartida> createIniciarPartida(IniciarPartida value) {
        return new JAXBElement<IniciarPartida>(_IniciarPartida_QNAME, IniciarPartida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IniciarPartidaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IniciarPartidaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServerSoapp/", name = "iniciarPartidaResponse")
    public JAXBElement<IniciarPartidaResponse> createIniciarPartidaResponse(IniciarPartidaResponse value) {
        return new JAXBElement<IniciarPartidaResponse>(_IniciarPartidaResponse_QNAME, IniciarPartidaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerResultado }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerResultado }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServerSoapp/", name = "obtenerResultado")
    public JAXBElement<ObtenerResultado> createObtenerResultado(ObtenerResultado value) {
        return new JAXBElement<ObtenerResultado>(_ObtenerResultado_QNAME, ObtenerResultado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerResultadoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerResultadoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServerSoapp/", name = "obtenerResultadoResponse")
    public JAXBElement<ObtenerResultadoResponse> createObtenerResultadoResponse(ObtenerResultadoResponse value) {
        return new JAXBElement<ObtenerResultadoResponse>(_ObtenerResultadoResponse_QNAME, ObtenerResultadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarJugada }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistrarJugada }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServerSoapp/", name = "registrarJugada")
    public JAXBElement<RegistrarJugada> createRegistrarJugada(RegistrarJugada value) {
        return new JAXBElement<RegistrarJugada>(_RegistrarJugada_QNAME, RegistrarJugada.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarJugadaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistrarJugadaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServerSoapp/", name = "registrarJugadaResponse")
    public JAXBElement<RegistrarJugadaResponse> createRegistrarJugadaResponse(RegistrarJugadaResponse value) {
        return new JAXBElement<RegistrarJugadaResponse>(_RegistrarJugadaResponse_QNAME, RegistrarJugadaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReiniciarPartida }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReiniciarPartida }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServerSoapp/", name = "reiniciarPartida")
    public JAXBElement<ReiniciarPartida> createReiniciarPartida(ReiniciarPartida value) {
        return new JAXBElement<ReiniciarPartida>(_ReiniciarPartida_QNAME, ReiniciarPartida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReiniciarPartidaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReiniciarPartidaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServerSoapp/", name = "reiniciarPartidaResponse")
    public JAXBElement<ReiniciarPartidaResponse> createReiniciarPartidaResponse(ReiniciarPartidaResponse value) {
        return new JAXBElement<ReiniciarPartidaResponse>(_ReiniciarPartidaResponse_QNAME, ReiniciarPartidaResponse.class, null, value);
    }

}
