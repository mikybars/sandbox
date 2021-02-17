
package com.inditex.rrhh.icmclcwb.model.meta4.login.entity;

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
 *         &lt;element name="loginReturn" type="{http://schemas.meta4.com/}M4loginOutput"/&gt;
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
        "loginReturn"
})
@XmlRootElement(name = "loginResponse")
public class LoginResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

    private final static long serialVersionUID = 1L;

    @XmlElement(required = true)
    protected M4LoginOutput loginReturn;

    /**
     * Obtiene el valor de la propiedad loginReturn.
     * @return possible object is {@link M4LoginOutput }
     *
     */
    public M4LoginOutput getLoginReturn() {
        return this.loginReturn;
    }

    /**
     * Define el valor de la propiedad loginReturn.
     * @param value allowed object is {@link M4LoginOutput }
     *
     */
    public void setLoginReturn(final M4LoginOutput value) {
        this.loginReturn = value;
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
        final LoginResponse that = ((LoginResponse) object);
        {
            final M4LoginOutput lhsLoginReturn;
            lhsLoginReturn = this.getLoginReturn();
            final M4LoginOutput rhsLoginReturn;
            rhsLoginReturn = that.getLoginReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "loginReturn", lhsLoginReturn),
                    LocatorUtils.property(thatLocator, "loginReturn", rhsLoginReturn), lhsLoginReturn, rhsLoginReturn,
                    (this.loginReturn != null), (that.loginReturn != null))) {
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
    public StringBuilder append(final ObjectLocator locator, final StringBuilder buffer, final ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        this.appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    @Override
    public StringBuilder appendFields(final ObjectLocator locator, final StringBuilder buffer, final ToStringStrategy2 strategy) {
        {
            final M4LoginOutput theLoginReturn;
            theLoginReturn = this.getLoginReturn();
            strategy.appendField(locator, this, "loginReturn", buffer, theLoginReturn, (this.loginReturn != null));
        }
        return buffer;
    }

    @Override
    public int hashCode(final ObjectLocator locator, final HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            final M4LoginOutput theLoginReturn;
            theLoginReturn = this.getLoginReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "loginReturn", theLoginReturn),
                    currentHashCode, theLoginReturn, (this.loginReturn != null));
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
        if (draftCopy instanceof LoginResponse) {
            final LoginResponse copy = ((LoginResponse) draftCopy);
            {
                final Boolean loginReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.loginReturn != null));
                if (loginReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    final M4LoginOutput sourceLoginReturn;
                    sourceLoginReturn = this.getLoginReturn();
                    final M4LoginOutput copyLoginReturn = ((M4LoginOutput) strategy.copy(
                            LocatorUtils.property(locator, "loginReturn", sourceLoginReturn), sourceLoginReturn,
                            (this.loginReturn != null)));
                    copy.setLoginReturn(copyLoginReturn);
                } else {
                    if (loginReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.loginReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    @Override
    public Object createNewInstance() {
        return new LoginResponse();
    }

}
