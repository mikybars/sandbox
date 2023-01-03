
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
 *         &lt;element name="ai_sessionId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "aiSessionId"
})
@XmlRootElement(name = "retrieveM4Session")
public class RetrieveM4Session implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ai_sessionId", required = true)
    protected String aiSessionId;

    /**
     * Obtiene el valor de la propiedad aiSessionId.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAiSessionId() {
        return aiSessionId;
    }

    /**
     * Define el valor de la propiedad aiSessionId.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAiSessionId(String value) {
        this.aiSessionId = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final RetrieveM4Session that = ((RetrieveM4Session) object);
        {
            String lhsAiSessionId;
            lhsAiSessionId = this.getAiSessionId();
            String rhsAiSessionId;
            rhsAiSessionId = that.getAiSessionId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "aiSessionId", lhsAiSessionId), LocatorUtils.property(thatLocator, "aiSessionId", rhsAiSessionId), lhsAiSessionId, rhsAiSessionId, (this.aiSessionId!= null), (that.aiSessionId!= null))) {
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
            String theAiSessionId;
            theAiSessionId = this.getAiSessionId();
            strategy.appendField(locator, this, "aiSessionId", buffer, theAiSessionId, (this.aiSessionId!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theAiSessionId;
            theAiSessionId = this.getAiSessionId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aiSessionId", theAiSessionId), currentHashCode, theAiSessionId, (this.aiSessionId!= null));
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
        if (draftCopy instanceof RetrieveM4Session) {
            final RetrieveM4Session copy = ((RetrieveM4Session) draftCopy);
            {
                Boolean aiSessionIdShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.aiSessionId!= null));
                if (aiSessionIdShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceAiSessionId;
                    sourceAiSessionId = this.getAiSessionId();
                    String copyAiSessionId = ((String) strategy.copy(LocatorUtils.property(locator, "aiSessionId", sourceAiSessionId), sourceAiSessionId, (this.aiSessionId!= null)));
                    copy.setAiSessionId(copyAiSessionId);
                } else {
                    if (aiSessionIdShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.aiSessionId = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new RetrieveM4Session();
    }

}
