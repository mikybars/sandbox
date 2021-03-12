
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
 * <p>
 * Clase Java para anonymous complex type.
 *
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ICM_PARAMCALORIGEN" type="{http://schemas.meta4.com/}Icm_ParamcalorigenBlock"/&gt;
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
        "icmparamcalorigen",
        "icmparametrospaginacion"
})
@XmlRootElement(name = "GETAGRUPONLINE")
public class GETAGRUPONLINE implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

    private final static long serialVersionUID = 1L;

    @XmlElement(name = "ICM_PARAMCALORIGEN", required = true)
    protected IcmParamcalorigenBlock icmparamcalorigen;

    @XmlElement(name = "ICM_PARAMETROSPAGINACION", required = true)
    protected IcmParametrospaginacionBlock icmparametrospaginacion;

    /**
     * Obtiene el valor de la propiedad icmparamcalorigen.
     * @return possible object is {@link IcmParamcalorigenBlock }
     *
     */
    public IcmParamcalorigenBlock getICMPARAMCALORIGEN() {
        return this.icmparamcalorigen;
    }

    /**
     * Define el valor de la propiedad icmparamcalorigen.
     * @param value allowed object is {@link IcmParamcalorigenBlock }
     *
     */
    public void setICMPARAMCALORIGEN(final IcmParamcalorigenBlock value) {
        this.icmparamcalorigen = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparametrospaginacion.
     * @return possible object is {@link IcmParametrospaginacionBlock }
     *
     */
    public IcmParametrospaginacionBlock getICMPARAMETROSPAGINACION() {
        return this.icmparametrospaginacion;
    }

    /**
     * Define el valor de la propiedad icmparametrospaginacion.
     * @param value allowed object is {@link IcmParametrospaginacionBlock }
     *
     */
    public void setICMPARAMETROSPAGINACION(final IcmParametrospaginacionBlock value) {
        this.icmparametrospaginacion = value;
    }

    @Override
    public boolean equals(final ObjectLocator thisLocator, final ObjectLocator thatLocator, final Object object,
            final EqualsStrategy2 strategy) {
        if ((object == null) || (this.getClass() != object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETAGRUPONLINE that = ((GETAGRUPONLINE) object);
        {
            final IcmParamcalorigenBlock lhsICMPARAMCALORIGEN;
            lhsICMPARAMCALORIGEN = this.getICMPARAMCALORIGEN();
            final IcmParamcalorigenBlock rhsICMPARAMCALORIGEN;
            rhsICMPARAMCALORIGEN = that.getICMPARAMCALORIGEN();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalorigen", lhsICMPARAMCALORIGEN),
                    LocatorUtils.property(thatLocator, "icmparamcalorigen", rhsICMPARAMCALORIGEN), lhsICMPARAMCALORIGEN,
                    rhsICMPARAMCALORIGEN, (this.icmparamcalorigen != null), (that.icmparamcalorigen != null))) {
                return false;
            }
        }
        {
            final IcmParametrospaginacionBlock lhsICMPARAMETROSPAGINACION;
            lhsICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            final IcmParametrospaginacionBlock rhsICMPARAMETROSPAGINACION;
            rhsICMPARAMETROSPAGINACION = that.getICMPARAMETROSPAGINACION();
            if (!strategy.equals(
                    LocatorUtils.property(thisLocator, "icmparametrospaginacion", lhsICMPARAMETROSPAGINACION),
                    LocatorUtils.property(thatLocator, "icmparametrospaginacion", rhsICMPARAMETROSPAGINACION),
                    lhsICMPARAMETROSPAGINACION, rhsICMPARAMETROSPAGINACION, (this.icmparametrospaginacion != null),
                    (that.icmparametrospaginacion != null))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(final Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE2;
        return this.equals(null, null, object, strategy);
    }

    @Override
    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE2;
        final StringBuilder buffer = new StringBuilder();
        this.append(null, buffer, strategy);
        return buffer.toString();
    }

    @Override
    public StringBuilder append(final ObjectLocator locator, final StringBuilder buffer,
            final ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        this.appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    @Override
    public StringBuilder appendFields(final ObjectLocator locator, final StringBuilder buffer,
            final ToStringStrategy2 strategy) {
        {
            final IcmParamcalorigenBlock theICMPARAMCALORIGEN;
            theICMPARAMCALORIGEN = this.getICMPARAMCALORIGEN();
            strategy.appendField(locator, this, "icmparamcalorigen", buffer, theICMPARAMCALORIGEN,
                    (this.icmparamcalorigen != null));
        }
        {
            final IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
            theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            strategy.appendField(locator, this, "icmparametrospaginacion", buffer, theICMPARAMETROSPAGINACION,
                    (this.icmparametrospaginacion != null));
        }
        return buffer;
    }

    @Override
    public int hashCode(final ObjectLocator locator, final HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            final IcmParamcalorigenBlock theICMPARAMCALORIGEN;
            theICMPARAMCALORIGEN = this.getICMPARAMCALORIGEN();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmparamcalorigen", theICMPARAMCALORIGEN), currentHashCode,
                    theICMPARAMCALORIGEN, (this.icmparamcalorigen != null));
        }
        {
            final IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
            theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmparametrospaginacion", theICMPARAMETROSPAGINACION),
                    currentHashCode, theICMPARAMETROSPAGINACION, (this.icmparametrospaginacion != null));
        }
        return currentHashCode;
    }

    @Override
    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE2;
        return this.hashCode(null, strategy);
    }

    @Override
    public Object clone() {
        return this.copyTo(this.createNewInstance());
    }

    @Override
    public Object copyTo(final Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE2;
        return this.copyTo(null, target, strategy);
    }

    @Override
    public Object copyTo(final ObjectLocator locator, final Object target, final CopyStrategy2 strategy) {
        final Object draftCopy = ((target == null) ? this.createNewInstance() : target);
        if (draftCopy instanceof GETAGRUPONLINE) {
            final GETAGRUPONLINE copy = ((GETAGRUPONLINE) draftCopy);
            {
                final Boolean icmparamcalorigenShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmparamcalorigen != null));
                if (icmparamcalorigenShouldBeCopiedAndSet == Boolean.TRUE) {
                    final IcmParamcalorigenBlock sourceICMPARAMCALORIGEN;
                    sourceICMPARAMCALORIGEN = this.getICMPARAMCALORIGEN();
                    final IcmParamcalorigenBlock copyICMPARAMCALORIGEN = ((IcmParamcalorigenBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmparamcalorigen", sourceICMPARAMCALORIGEN),
                            sourceICMPARAMCALORIGEN, (this.icmparamcalorigen != null)));
                    copy.setICMPARAMCALORIGEN(copyICMPARAMCALORIGEN);
                } else {
                    if (icmparamcalorigenShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalorigen = null;
                    }
                }
            }
            {
                final Boolean icmparametrospaginacionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmparametrospaginacion != null));
                if (icmparametrospaginacionShouldBeCopiedAndSet == Boolean.TRUE) {
                    final IcmParametrospaginacionBlock sourceICMPARAMETROSPAGINACION;
                    sourceICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
                    final IcmParametrospaginacionBlock copyICMPARAMETROSPAGINACION = ((IcmParametrospaginacionBlock) strategy
                        .copy(LocatorUtils.property(locator, "icmparametrospaginacion", sourceICMPARAMETROSPAGINACION),
                                sourceICMPARAMETROSPAGINACION, (this.icmparametrospaginacion != null)));
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

    @Override
    public Object createNewInstance() {
        return new GETAGRUPONLINE();
    }

}
