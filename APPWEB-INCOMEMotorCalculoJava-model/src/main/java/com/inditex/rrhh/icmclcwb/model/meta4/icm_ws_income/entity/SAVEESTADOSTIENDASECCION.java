
package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.CopyStrategy2;
import org.jvnet.jaxb2_commons.lang.CopyTo2;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy2;
import org.jvnet.jaxb2_commons.lang.HashCode2;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy2;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ICM_ESTADOSTIENDASECCION" type="{http://schemas.meta4.com/}Icm_EstadostiendaseccionBlock"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "icmestadostiendaseccion"
})
@XmlRootElement(name = "SAVEESTADOSTIENDASECCION")
public class SAVEESTADOSTIENDASECCION implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "ICM_ESTADOSTIENDASECCION", required = true)
    protected IcmEstadostiendaseccionBlock icmestadostiendaseccion;

    /**
     * Obtiene el valor de la propiedad icmestadostiendaseccion.
     * 
     * @return
     *     possible object is
     *     {@link IcmEstadostiendaseccionBlock }
     *     
     */
    public IcmEstadostiendaseccionBlock getICMESTADOSTIENDASECCION() {
        return icmestadostiendaseccion;
    }

    /**
     * Define el valor de la propiedad icmestadostiendaseccion.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEstadostiendaseccionBlock }
     *     
     */
    public void setICMESTADOSTIENDASECCION(IcmEstadostiendaseccionBlock value) {
        this.icmestadostiendaseccion = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SAVEESTADOSTIENDASECCION that = ((SAVEESTADOSTIENDASECCION) object);
        {
            IcmEstadostiendaseccionBlock lhsICMESTADOSTIENDASECCION;
            lhsICMESTADOSTIENDASECCION = this.getICMESTADOSTIENDASECCION();
            IcmEstadostiendaseccionBlock rhsICMESTADOSTIENDASECCION;
            rhsICMESTADOSTIENDASECCION = that.getICMESTADOSTIENDASECCION();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmestadostiendaseccion", lhsICMESTADOSTIENDASECCION), LocatorUtils.property(thatLocator, "icmestadostiendaseccion", rhsICMESTADOSTIENDASECCION), lhsICMESTADOSTIENDASECCION, rhsICMESTADOSTIENDASECCION, (this.icmestadostiendaseccion!= null), (that.icmestadostiendaseccion!= null))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        {
            IcmEstadostiendaseccionBlock theICMESTADOSTIENDASECCION;
            theICMESTADOSTIENDASECCION = this.getICMESTADOSTIENDASECCION();
            strategy.appendField(locator, this, "icmestadostiendaseccion", buffer, theICMESTADOSTIENDASECCION, (this.icmestadostiendaseccion!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            IcmEstadostiendaseccionBlock theICMESTADOSTIENDASECCION;
            theICMESTADOSTIENDASECCION = this.getICMESTADOSTIENDASECCION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmestadostiendaseccion", theICMESTADOSTIENDASECCION), currentHashCode, theICMESTADOSTIENDASECCION, (this.icmestadostiendaseccion!= null));
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof SAVEESTADOSTIENDASECCION) {
            final SAVEESTADOSTIENDASECCION copy = ((SAVEESTADOSTIENDASECCION) draftCopy);
            {
                Boolean icmestadostiendaseccionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmestadostiendaseccion!= null));
                if (icmestadostiendaseccionShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmEstadostiendaseccionBlock sourceICMESTADOSTIENDASECCION;
                    sourceICMESTADOSTIENDASECCION = this.getICMESTADOSTIENDASECCION();
                    IcmEstadostiendaseccionBlock copyICMESTADOSTIENDASECCION = ((IcmEstadostiendaseccionBlock) strategy.copy(LocatorUtils.property(locator, "icmestadostiendaseccion", sourceICMESTADOSTIENDASECCION), sourceICMESTADOSTIENDASECCION, (this.icmestadostiendaseccion!= null)));
                    copy.setICMESTADOSTIENDASECCION(copyICMESTADOSTIENDASECCION);
                } else {
                    if (icmestadostiendaseccionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmestadostiendaseccion = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SAVEESTADOSTIENDASECCION();
    }

}
