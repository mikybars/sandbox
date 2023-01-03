
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

import java.io.Serializable;
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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ICM_PARAMETROSENTRADA" type="{http://schemas.meta4.com/}Icm_ParametrosentradaBlock"/&gt;
 *         &lt;element name="ICM_PARAMETROSPAGINACION" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "icmparametrosentrada",
    "icmparametrospaginacion"
})
@XmlRootElement(name = "GETCONFPRODVENTA")
public class GETCONFPRODVENTA implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ICM_PARAMETROSENTRADA", required = true)
    protected IcmParametrosentradaBlock icmparametrosentrada;
    @XmlElement(name = "ICM_PARAMETROSPAGINACION", required = true)
    protected IcmParametrospaginacionBlock icmparametrospaginacion;

    /**
     * Obtiene el valor de la propiedad icmparametrosentrada.
     *
     * @return
     *     possible object is
     *     {@link IcmParametrosentradaBlock }
     *
     */
    public IcmParametrosentradaBlock getICMPARAMETROSENTRADA() {
        return icmparametrosentrada;
    }

    /**
     * Define el valor de la propiedad icmparametrosentrada.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParametrosentradaBlock }
     *
     */
    public void setICMPARAMETROSENTRADA(IcmParametrosentradaBlock value) {
        this.icmparametrosentrada = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparametrospaginacion.
     *
     * @return
     *     possible object is
     *     {@link IcmParametrospaginacionBlock }
     *
     */
    public IcmParametrospaginacionBlock getICMPARAMETROSPAGINACION() {
        return icmparametrospaginacion;
    }

    /**
     * Define el valor de la propiedad icmparametrospaginacion.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParametrospaginacionBlock }
     *
     */
    public void setICMPARAMETROSPAGINACION(IcmParametrospaginacionBlock value) {
        this.icmparametrospaginacion = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETCONFPRODVENTA that = ((GETCONFPRODVENTA) object);
        {
            IcmParametrosentradaBlock lhsICMPARAMETROSENTRADA;
            lhsICMPARAMETROSENTRADA = this.getICMPARAMETROSENTRADA();
            IcmParametrosentradaBlock rhsICMPARAMETROSENTRADA;
            rhsICMPARAMETROSENTRADA = that.getICMPARAMETROSENTRADA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrosentrada", lhsICMPARAMETROSENTRADA), LocatorUtils.property(thatLocator, "icmparametrosentrada", rhsICMPARAMETROSENTRADA), lhsICMPARAMETROSENTRADA, rhsICMPARAMETROSENTRADA, (this.icmparametrosentrada!= null), (that.icmparametrosentrada!= null))) {
                return false;
            }
        }
        {
            IcmParametrospaginacionBlock lhsICMPARAMETROSPAGINACION;
            lhsICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            IcmParametrospaginacionBlock rhsICMPARAMETROSPAGINACION;
            rhsICMPARAMETROSPAGINACION = that.getICMPARAMETROSPAGINACION();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrospaginacion", lhsICMPARAMETROSPAGINACION), LocatorUtils.property(thatLocator, "icmparametrospaginacion", rhsICMPARAMETROSPAGINACION), lhsICMPARAMETROSPAGINACION, rhsICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null), (that.icmparametrospaginacion!= null))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE2;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE2;
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
            IcmParametrosentradaBlock theICMPARAMETROSENTRADA;
            theICMPARAMETROSENTRADA = this.getICMPARAMETROSENTRADA();
            strategy.appendField(locator, this, "icmparametrosentrada", buffer, theICMPARAMETROSENTRADA, (this.icmparametrosentrada!= null));
        }
        {
            IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
            theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            strategy.appendField(locator, this, "icmparametrospaginacion", buffer, theICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            IcmParametrosentradaBlock theICMPARAMETROSENTRADA;
            theICMPARAMETROSENTRADA = this.getICMPARAMETROSENTRADA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrosentrada", theICMPARAMETROSENTRADA), currentHashCode, theICMPARAMETROSENTRADA, (this.icmparametrosentrada!= null));
        }
        {
            IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
            theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrospaginacion", theICMPARAMETROSPAGINACION), currentHashCode, theICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null));
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE2;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE2;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof GETCONFPRODVENTA) {
            final GETCONFPRODVENTA copy = ((GETCONFPRODVENTA) draftCopy);
            {
                Boolean icmparametrosentradaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparametrosentrada!= null));
                if (icmparametrosentradaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrosentradaBlock sourceICMPARAMETROSENTRADA;
                    sourceICMPARAMETROSENTRADA = this.getICMPARAMETROSENTRADA();
                    IcmParametrosentradaBlock copyICMPARAMETROSENTRADA = ((IcmParametrosentradaBlock) strategy.copy(LocatorUtils.property(locator, "icmparametrosentrada", sourceICMPARAMETROSENTRADA), sourceICMPARAMETROSENTRADA, (this.icmparametrosentrada!= null)));
                    copy.setICMPARAMETROSENTRADA(copyICMPARAMETROSENTRADA);
                } else {
                    if (icmparametrosentradaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparametrosentrada = null;
                    }
                }
            }
            {
                Boolean icmparametrospaginacionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparametrospaginacion!= null));
                if (icmparametrospaginacionShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrospaginacionBlock sourceICMPARAMETROSPAGINACION;
                    sourceICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
                    IcmParametrospaginacionBlock copyICMPARAMETROSPAGINACION = ((IcmParametrospaginacionBlock) strategy.copy(LocatorUtils.property(locator, "icmparametrospaginacion", sourceICMPARAMETROSPAGINACION), sourceICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null)));
                    copy.setICMPARAMETROSPAGINACION(copyICMPARAMETROSPAGINACION);
                } else {
                    if (icmparametrospaginacionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparametrospaginacion = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETCONFPRODVENTA();
    }

}
