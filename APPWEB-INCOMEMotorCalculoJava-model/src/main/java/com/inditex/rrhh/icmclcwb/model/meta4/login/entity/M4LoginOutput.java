
/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.meta4.login.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 * Clase Java para M4loginOutput complex type.
 *
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="M4loginOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "M4loginOutput", propOrder = {
        "sessionID"
})
public class M4LoginOutput implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

    private final static long serialVersionUID = 1L;

    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Obtiene el valor de la propiedad sessionID.
     * @return possible object is {@link String }
     *
     */
    public String getSessionID() {
        return this.sessionID;
    }

    /**
     * Define el valor de la propiedad sessionID.
     * @param value allowed object is {@link String }
     *
     */
    public void setSessionID(final String value) {
        this.sessionID = value;
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
        final M4LoginOutput that = ((M4LoginOutput) object);
        {
            final String lhsSessionID;
            lhsSessionID = this.getSessionID();
            final String rhsSessionID;
            rhsSessionID = that.getSessionID();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sessionID", lhsSessionID),
                    LocatorUtils.property(thatLocator, "sessionID", rhsSessionID), lhsSessionID, rhsSessionID,
                    (this.sessionID != null), (that.sessionID != null))) {
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
            final String theSessionID;
            theSessionID = this.getSessionID();
            strategy.appendField(locator, this, "sessionID", buffer, theSessionID, (this.sessionID != null));
        }
        return buffer;
    }

    @Override
    public int hashCode(final ObjectLocator locator, final HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            final String theSessionID;
            theSessionID = this.getSessionID();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sessionID", theSessionID),
                    currentHashCode, theSessionID, (this.sessionID != null));
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
        if (draftCopy instanceof M4LoginOutput) {
            final M4LoginOutput copy = ((M4LoginOutput) draftCopy);
            {
                final Boolean sessionIDShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.sessionID != null));
                if (sessionIDShouldBeCopiedAndSet == Boolean.TRUE) {
                    final String sourceSessionID;
                    sourceSessionID = this.getSessionID();
                    final String copySessionID = ((String) strategy.copy(
                            LocatorUtils.property(locator, "sessionID", sourceSessionID), sourceSessionID,
                            (this.sessionID != null)));
                    copy.setSessionID(copySessionID);
                } else {
                    if (sessionIDShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.sessionID = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    @Override
    public Object createNewInstance() {
        return new M4LoginOutput();
    }

}
