
package com.inditex.rrhh.icmclcwb.model.meta4.login.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import lombok.Getter;
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
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
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
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "aiSessionId"
})
@XmlRootElement(name = "retrieveM4Session")
public class RetrieveM4Session implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  /**
   * -- GETTER -- Gets the value of the aiSessionId property.
   *
   * @return possible object is {@link String }
   */
  @XmlElement(name = "ai_sessionId", required = true)
  protected String aiSessionId;

  /**
   * Sets the value of the aiSessionId property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAiSessionId(final String value) {
    this.aiSessionId = value;
  }

  public boolean equals(final ObjectLocator thisLocator, final ObjectLocator thatLocator, final Object object,
      final EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final RetrieveM4Session that = ((RetrieveM4Session) object);
    {
      final String lhsAiSessionId;
      lhsAiSessionId = this.getAiSessionId();
      final String rhsAiSessionId;
      rhsAiSessionId = that.getAiSessionId();
      return strategy.equals(LocatorUtils.property(thisLocator, "aiSessionId", lhsAiSessionId),
          LocatorUtils.property(thatLocator, "aiSessionId", rhsAiSessionId), lhsAiSessionId, rhsAiSessionId, (this.aiSessionId != null),
          (that.aiSessionId != null));
    }
  }

  public boolean equals(final Object object) {
    final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE2;
    return this.equals(null, null, object, strategy);
  }

  public String toString() {
    final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE2;
    final StringBuilder buffer = new StringBuilder();
    this.append(null, buffer, strategy);
    return buffer.toString();
  }

  public StringBuilder append(final ObjectLocator locator, final StringBuilder buffer, final ToStringStrategy2 strategy) {
    strategy.appendStart(locator, this, buffer);
    this.appendFields(locator, buffer, strategy);
    strategy.appendEnd(locator, this, buffer);
    return buffer;
  }

  public StringBuilder appendFields(final ObjectLocator locator, final StringBuilder buffer, final ToStringStrategy2 strategy) {
    {
      final String theAiSessionId;
      theAiSessionId = this.getAiSessionId();
      strategy.appendField(locator, this, "aiSessionId", buffer, theAiSessionId, (this.aiSessionId != null));
    }
    return buffer;
  }

  public int hashCode(final ObjectLocator locator, final HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      final String theAiSessionId;
      theAiSessionId = this.getAiSessionId();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aiSessionId", theAiSessionId), currentHashCode, theAiSessionId,
          (this.aiSessionId != null));
    }
    return currentHashCode;
  }

  public int hashCode() {
    final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE2;
    return this.hashCode(null, strategy);
  }

  public Object clone() {
    return this.copyTo(this.createNewInstance());
  }

  public Object copyTo(final Object target) {
    final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE2;
    return this.copyTo(null, target, strategy);
  }

  public Object copyTo(final ObjectLocator locator, final Object target, final CopyStrategy2 strategy) {
    final Object draftCopy = ((target == null) ? this.createNewInstance() : target);
    if (draftCopy instanceof RetrieveM4Session) {
      final RetrieveM4Session copy = ((RetrieveM4Session) draftCopy);
      {
        final Boolean aiSessionIdShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.aiSessionId != null));
        if (aiSessionIdShouldBeCopiedAndSet == Boolean.TRUE) {
          final String sourceAiSessionId;
          sourceAiSessionId = this.getAiSessionId();
          final String copyAiSessionId = ((String) strategy.copy(LocatorUtils.property(locator, "aiSessionId", sourceAiSessionId),
              sourceAiSessionId, (this.aiSessionId != null)));
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
