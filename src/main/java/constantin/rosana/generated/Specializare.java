//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.26 at 10:23:49 PM EEST 
//


package constantin.rosana.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for specializare.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="specializare"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Cardiologie"/&gt;
 *     &lt;enumeration value="Diabetologie"/&gt;
 *     &lt;enumeration value="Medic de familie"/&gt;
 *     &lt;enumeration value="Chirurgie"/&gt;
 *     &lt;enumeration value="Pediatrie"/&gt;
 *     &lt;enumeration value="Dermatologie"/&gt;
 *     &lt;enumeration value="Neurologie"/&gt;
 *     &lt;enumeration value="Ginecologie"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "specializare")
@XmlEnum
public enum Specializare {

    @XmlEnumValue("Cardiologie")
    CARDIOLOGIE("Cardiologie"),
    @XmlEnumValue("Diabetologie")
    DIABETOLOGIE("Diabetologie"),
    @XmlEnumValue("Medic de familie")
    MEDIC_DE_FAMILIE("Medic de familie"),
    @XmlEnumValue("Chirurgie")
    CHIRURGIE("Chirurgie"),
    @XmlEnumValue("Pediatrie")
    PEDIATRIE("Pediatrie"),
    @XmlEnumValue("Dermatologie")
    DERMATOLOGIE("Dermatologie"),
    @XmlEnumValue("Neurologie")
    NEUROLOGIE("Neurologie"),
    @XmlEnumValue("Ginecologie")
    GINECOLOGIE("Ginecologie");
    private final String value;

    Specializare(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Specializare fromValue(String v) {
        for (Specializare c: Specializare.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
