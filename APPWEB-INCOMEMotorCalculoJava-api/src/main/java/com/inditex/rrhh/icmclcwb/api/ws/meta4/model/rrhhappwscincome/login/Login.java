
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login;

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
 *         &lt;element name="in0" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="in1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="in2" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "in0",
    "in1",
    "in2"
})
@XmlRootElement(name = "login")
public class Login implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(required = true)
    protected String in0;
    @XmlElement(required = true)
    protected String in1;
    @XmlElement(required = true)
    protected String in2;

    /**
     * Obtiene el valor de la propiedad in0.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIn0() {
        return in0;
    }

    /**
     * Define el valor de la propiedad in0.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIn0(String value) {
        this.in0 = value;
    }

    /**
     * Obtiene el valor de la propiedad in1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIn1() {
        return in1;
    }

    /**
     * Define el valor de la propiedad in1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIn1(String value) {
        this.in1 = value;
    }

    /**
     * Obtiene el valor de la propiedad in2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIn2() {
        return in2;
    }

    /**
     * Define el valor de la propiedad in2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIn2(String value) {
        this.in2 = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Login that = ((Login) object);
        {
            String lhsIn0;
            lhsIn0 = this.getIn0();
            String rhsIn0;
            rhsIn0 = that.getIn0();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "in0", lhsIn0), LocatorUtils.property(thatLocator, "in0", rhsIn0), lhsIn0, rhsIn0, (this.in0 != null), (that.in0 != null))) {
                return false;
            }
        }
        {
            String lhsIn1;
            lhsIn1 = this.getIn1();
            String rhsIn1;
            rhsIn1 = that.getIn1();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "in1", lhsIn1), LocatorUtils.property(thatLocator, "in1", rhsIn1), lhsIn1, rhsIn1, (this.in1 != null), (that.in1 != null))) {
                return false;
            }
        }
        {
            String lhsIn2;
            lhsIn2 = this.getIn2();
            String rhsIn2;
            rhsIn2 = that.getIn2();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "in2", lhsIn2), LocatorUtils.property(thatLocator, "in2", rhsIn2), lhsIn2, rhsIn2, (this.in2 != null), (that.in2 != null))) {
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
            String theIn0;
            theIn0 = this.getIn0();
            strategy.appendField(locator, this, "in0", buffer, theIn0, (this.in0 != null));
        }
        {
            String theIn1;
            theIn1 = this.getIn1();
            strategy.appendField(locator, this, "in1", buffer, theIn1, (this.in1 != null));
        }
        {
            String theIn2;
            theIn2 = this.getIn2();
            strategy.appendField(locator, this, "in2", buffer, theIn2, (this.in2 != null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theIn0;
            theIn0 = this.getIn0();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "in0", theIn0), currentHashCode, theIn0, (this.in0 != null));
        }
        {
            String theIn1;
            theIn1 = this.getIn1();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "in1", theIn1), currentHashCode, theIn1, (this.in1 != null));
        }
        {
            String theIn2;
            theIn2 = this.getIn2();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "in2", theIn2), currentHashCode, theIn2, (this.in2 != null));
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
        if (draftCopy instanceof Login) {
            final Login copy = ((Login) draftCopy);
            {
                Boolean in0ShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.in0 != null));
                if (in0ShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIn0;
                    sourceIn0 = this.getIn0();
                    String copyIn0 = ((String) strategy.copy(LocatorUtils.property(locator, "in0", sourceIn0), sourceIn0, (this.in0 != null)));
                    copy.setIn0(copyIn0);
                } else {
                    if (in0ShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.in0 = null;
                    }
                }
            }
            {
                Boolean in1ShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.in1 != null));
                if (in1ShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIn1;
                    sourceIn1 = this.getIn1();
                    String copyIn1 = ((String) strategy.copy(LocatorUtils.property(locator, "in1", sourceIn1), sourceIn1, (this.in1 != null)));
                    copy.setIn1(copyIn1);
                } else {
                    if (in1ShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.in1 = null;
                    }
                }
            }
            {
                Boolean in2ShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.in2 != null));
                if (in2ShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIn2;
                    sourceIn2 = this.getIn2();
                    String copyIn2 = ((String) strategy.copy(LocatorUtils.property(locator, "in2", sourceIn2), sourceIn2, (this.in2 != null)));
                    copy.setIn2(copyIn2);
                } else {
                    if (in2ShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.in2 = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new Login();
    }

}
