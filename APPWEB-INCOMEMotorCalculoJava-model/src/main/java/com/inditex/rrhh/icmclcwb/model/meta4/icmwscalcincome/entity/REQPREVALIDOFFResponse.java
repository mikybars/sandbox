
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
 *         &lt;element name="REQPREVALIDOFFReturn" type="{http://schemas.meta4.com/}ReqprevalidoffOutput"/&gt;
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
        "reqprevalidoffReturn"
})
@XmlRootElement(name = "REQPREVALIDOFFResponse")
public class REQPREVALIDOFFResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

    private final static long serialVersionUID = 1L;

    @XmlElement(name = "REQPREVALIDOFFReturn", required = true)
    protected ReqprevalidoffOutput reqprevalidoffReturn;

    /**
     * Obtiene el valor de la propiedad reqprevalidoffReturn.
     * @return possible object is {@link ReqprevalidoffOutput }
     *
     */
    public ReqprevalidoffOutput getREQPREVALIDOFFReturn() {
        return reqprevalidoffReturn;
    }

    /**
     * Define el valor de la propiedad reqprevalidoffReturn.
     * @param value allowed object is {@link ReqprevalidoffOutput }
     *
     */
    public void setREQPREVALIDOFFReturn(ReqprevalidoffOutput value) {
        this.reqprevalidoffReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object,
            EqualsStrategy2 strategy) {
        if ((object == null) || (this.getClass() != object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final REQPREVALIDOFFResponse that = ((REQPREVALIDOFFResponse) object);
        {
            ReqprevalidoffOutput lhsREQPREVALIDOFFReturn;
            lhsREQPREVALIDOFFReturn = this.getREQPREVALIDOFFReturn();
            ReqprevalidoffOutput rhsREQPREVALIDOFFReturn;
            rhsREQPREVALIDOFFReturn = that.getREQPREVALIDOFFReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "reqprevalidoffReturn", lhsREQPREVALIDOFFReturn),
                    LocatorUtils.property(thatLocator, "reqprevalidoffReturn", rhsREQPREVALIDOFFReturn),
                    lhsREQPREVALIDOFFReturn, rhsREQPREVALIDOFFReturn, (this.reqprevalidoffReturn != null),
                    (that.reqprevalidoffReturn != null))) {
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
            ReqprevalidoffOutput theREQPREVALIDOFFReturn;
            theREQPREVALIDOFFReturn = this.getREQPREVALIDOFFReturn();
            strategy.appendField(locator, this, "reqprevalidoffReturn", buffer, theREQPREVALIDOFFReturn,
                    (this.reqprevalidoffReturn != null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            ReqprevalidoffOutput theREQPREVALIDOFFReturn;
            theREQPREVALIDOFFReturn = this.getREQPREVALIDOFFReturn();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "reqprevalidoffReturn", theREQPREVALIDOFFReturn), currentHashCode,
                    theREQPREVALIDOFFReturn, (this.reqprevalidoffReturn != null));
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
        final Object draftCopy = ((target == null) ? createNewInstance() : target);
        if (draftCopy instanceof REQPREVALIDOFFResponse) {
            final REQPREVALIDOFFResponse copy = ((REQPREVALIDOFFResponse) draftCopy);
            {
                Boolean reqprevalidoffReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.reqprevalidoffReturn != null));
                if (reqprevalidoffReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    ReqprevalidoffOutput sourceREQPREVALIDOFFReturn;
                    sourceREQPREVALIDOFFReturn = this.getREQPREVALIDOFFReturn();
                    ReqprevalidoffOutput copyREQPREVALIDOFFReturn = ((ReqprevalidoffOutput) strategy.copy(
                            LocatorUtils.property(locator, "reqprevalidoffReturn", sourceREQPREVALIDOFFReturn),
                            sourceREQPREVALIDOFFReturn, (this.reqprevalidoffReturn != null)));
                    copy.setREQPREVALIDOFFReturn(copyREQPREVALIDOFFReturn);
                } else {
                    if (reqprevalidoffReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.reqprevalidoffReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new REQPREVALIDOFFResponse();
    }

}
