//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.22 at 09:59:24 PM EET 
//


package constantin.rosana.generated;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Java class for reteta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reteta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="diagnostic" type="{}diagnostic"/&gt;
 *         &lt;element name="numarPrescriere" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="dataEliberarii" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="medic" type="{}medic"/&gt;
 *         &lt;element name="pacient" type="{}pacient"/&gt;
 *         &lt;element name="listaMedicamente" type="{}listaMedicamente"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="tip" type="{}tipReteta" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reteta", propOrder = {
    "diagnostic",
    "numarPrescriere",
    "dataEliberarii",
    "medic",
    "pacient",
    "listaMedicamente"
})
public class Reteta {

    @XmlElement(required = true)
    protected Diagnostic diagnostic;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger numarPrescriere;
    @XmlElement(required = true)
    protected String dataEliberarii;
    @XmlElement(required = true)
    protected Medic medic;
    @XmlElement(required = true)
    protected Pacient pacient;
    @XmlElement(required = true)
    protected ListaMedicamente listaMedicamente;
    @XmlAttribute(name = "tip")
    protected TipReteta tip;

    /**
     * Gets the value of the diagnostic property.
     * 
     * @return
     *     possible object is
     *     {@link Diagnostic }
     *     
     */
    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    /**
     * Sets the value of the diagnostic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Diagnostic }
     *     
     */
    public void setDiagnostic(Diagnostic value) {
        this.diagnostic = value;
    }

    /**
     * Gets the value of the numarPrescriere property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumarPrescriere() {
        return numarPrescriere;
    }

    /**
     * Sets the value of the numarPrescriere property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumarPrescriere(BigInteger value) {
        this.numarPrescriere = value;
    }

    /**
     * Gets the value of the dataEliberarii property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataEliberarii() {
        return dataEliberarii;
    }

    /**
     * Sets the value of the dataEliberarii property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataEliberarii(String value) {
        this.dataEliberarii = value;
    }

    /**
     * Gets the value of the medic property.
     * 
     * @return
     *     possible object is
     *     {@link Medic }
     *     
     */
    public Medic getMedic() {
        return medic;
    }

    /**
     * Sets the value of the medic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Medic }
     *     
     */
    public void setMedic(Medic value) {
        this.medic = value;
    }

    /**
     * Gets the value of the pacient property.
     * 
     * @return
     *     possible object is
     *     {@link Pacient }
     *     
     */
    public Pacient getPacient() {
        return pacient;
    }

    /**
     * Sets the value of the pacient property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pacient }
     *     
     */
    public void setPacient(Pacient value) {
        this.pacient = value;
    }

    /**
     * Gets the value of the listaMedicamente property.
     * 
     * @return
     *     possible object is
     *     {@link ListaMedicamente }
     *     
     */
    public ListaMedicamente getListaMedicamente() {
        return listaMedicamente;
    }

    /**
     * Sets the value of the listaMedicamente property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaMedicamente }
     *     
     */
    public void setListaMedicamente(ListaMedicamente value) {
        this.listaMedicamente = value;
    }

    /**
     * Gets the value of the tip property.
     * 
     * @return
     *     possible object is
     *     {@link TipReteta }
     *     
     */
    public TipReteta getTip() {
        return tip;
    }

    /**
     * Sets the value of the tip property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipReteta }
     *     
     */
    public void setTip(TipReteta value) {
        this.tip = value;
    }

}
