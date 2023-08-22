
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
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ai_sCertificate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ai_sSessionContex" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "aiSCertificate",
    "aiSSessionContex"
})
@XmlRootElement(name = "loginWithCertificate")
public class LoginWithCertificate implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "ai_sCertificate", required = true)
  protected String aiSCertificate;

  @XmlElement(name = "ai_sSessionContex", required = true)
  protected String aiSSessionContex;

  /**
   * Gets the value of the aiSCertificate property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getAiSCertificate() {
    return aiSCertificate;
  }

  /**
   * Sets the value of the aiSCertificate property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAiSCertificate(String value) {
    this.aiSCertificate = value;
  }

  /**
   * Gets the value of the aiSSessionContex property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getAiSSessionContex() {
    return aiSSessionContex;
  }

  /**
   * Sets the value of the aiSSessionContex property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAiSSessionContex(String value) {
    this.aiSSessionContex = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final LoginWithCertificate that = ((LoginWithCertificate) object);
    {
      String lhsAiSCertificate;
      lhsAiSCertificate = this.getAiSCertificate();
      String rhsAiSCertificate;
      rhsAiSCertificate = that.getAiSCertificate();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "aiSCertificate", lhsAiSCertificate),
          LocatorUtils.property(thatLocator, "aiSCertificate", rhsAiSCertificate), lhsAiSCertificate, rhsAiSCertificate,
          (this.aiSCertificate != null), (that.aiSCertificate != null))) {
        return false;
      }
    }
    {
      String lhsAiSSessionContex;
      lhsAiSSessionContex = this.getAiSSessionContex();
      String rhsAiSSessionContex;
      rhsAiSSessionContex = that.getAiSSessionContex();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "aiSSessionContex", lhsAiSSessionContex),
          LocatorUtils.property(thatLocator, "aiSSessionContex", rhsAiSSessionContex), lhsAiSSessionContex, rhsAiSSessionContex,
          (this.aiSSessionContex != null), (that.aiSSessionContex != null))) {
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
      String theAiSCertificate;
      theAiSCertificate = this.getAiSCertificate();
      strategy.appendField(locator, this, "aiSCertificate", buffer, theAiSCertificate, (this.aiSCertificate != null));
    }
    {
      String theAiSSessionContex;
      theAiSSessionContex = this.getAiSSessionContex();
      strategy.appendField(locator, this, "aiSSessionContex", buffer, theAiSSessionContex, (this.aiSSessionContex != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      String theAiSCertificate;
      theAiSCertificate = this.getAiSCertificate();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aiSCertificate", theAiSCertificate), currentHashCode,
          theAiSCertificate, (this.aiSCertificate != null));
    }
    {
      String theAiSSessionContex;
      theAiSSessionContex = this.getAiSSessionContex();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aiSSessionContex", theAiSSessionContex), currentHashCode,
          theAiSSessionContex, (this.aiSSessionContex != null));
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
    if (draftCopy instanceof LoginWithCertificate) {
      final LoginWithCertificate copy = ((LoginWithCertificate) draftCopy);
      {
        Boolean aiSCertificateShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.aiSCertificate != null));
        if (aiSCertificateShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceAiSCertificate;
          sourceAiSCertificate = this.getAiSCertificate();
          String copyAiSCertificate = ((String) strategy.copy(LocatorUtils.property(locator, "aiSCertificate", sourceAiSCertificate),
              sourceAiSCertificate, (this.aiSCertificate != null)));
          copy.setAiSCertificate(copyAiSCertificate);
        } else {
          if (aiSCertificateShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.aiSCertificate = null;
          }
        }
      }
      {
        Boolean aiSSessionContexShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.aiSSessionContex != null));
        if (aiSSessionContexShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceAiSSessionContex;
          sourceAiSSessionContex = this.getAiSSessionContex();
          String copyAiSSessionContex = ((String) strategy.copy(LocatorUtils.property(locator, "aiSSessionContex", sourceAiSSessionContex),
              sourceAiSSessionContex, (this.aiSSessionContex != null)));
          copy.setAiSSessionContex(copyAiSSessionContex);
        } else {
          if (aiSSessionContexShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.aiSSessionContex = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new LoginWithCertificate();
  }

}
