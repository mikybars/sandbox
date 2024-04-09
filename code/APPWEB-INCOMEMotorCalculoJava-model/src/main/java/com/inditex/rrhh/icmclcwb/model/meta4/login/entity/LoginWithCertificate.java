
package com.inditex.rrhh.icmclcwb.model.meta4.login.entity;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
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
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "aiSCertificate",
    "aiSSessionContex"
})
@XmlRootElement(name = "loginWithCertificate")
public class LoginWithCertificate implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  /**
   * -- GETTER -- Gets the value of the aiSCertificate property.
   *
   * @return possible object is {@link String }
   */
  @XmlElement(name = "ai_sCertificate", required = true)
  protected String aiSCertificate;

  /**
   * -- GETTER -- Gets the value of the aiSSessionContex property.
   *
   * @return possible object is {@link String }
   */
  @XmlElement(name = "ai_sSessionContex", required = true)
  protected String aiSSessionContex;

  /**
   * Sets the value of the aiSCertificate property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAiSCertificate(final String value) {
    this.aiSCertificate = value;
  }

  /**
   * Sets the value of the aiSSessionContex property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAiSSessionContex(final String value) {
    this.aiSSessionContex = value;
  }

  public boolean equals(final ObjectLocator thisLocator, final ObjectLocator thatLocator, final Object object,
      final EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final LoginWithCertificate that = ((LoginWithCertificate) object);
    {
      final String lhsAiSCertificate;
      lhsAiSCertificate = this.getAiSCertificate();
      final String rhsAiSCertificate;
      rhsAiSCertificate = that.getAiSCertificate();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "aiSCertificate", lhsAiSCertificate),
          LocatorUtils.property(thatLocator, "aiSCertificate", rhsAiSCertificate), lhsAiSCertificate, rhsAiSCertificate,
          (this.aiSCertificate != null), (that.aiSCertificate != null))) {
        return false;
      }
    }
    {
      final String lhsAiSSessionContex;
      lhsAiSSessionContex = this.getAiSSessionContex();
      final String rhsAiSSessionContex;
      rhsAiSSessionContex = that.getAiSSessionContex();
      return strategy.equals(LocatorUtils.property(thisLocator, "aiSSessionContex", lhsAiSSessionContex),
          LocatorUtils.property(thatLocator, "aiSSessionContex", rhsAiSSessionContex), lhsAiSSessionContex, rhsAiSSessionContex,
          (this.aiSSessionContex != null), (that.aiSSessionContex != null));
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
      final String theAiSCertificate;
      theAiSCertificate = this.getAiSCertificate();
      strategy.appendField(locator, this, "aiSCertificate", buffer, theAiSCertificate, (this.aiSCertificate != null));
    }
    {
      final String theAiSSessionContex;
      theAiSSessionContex = this.getAiSSessionContex();
      strategy.appendField(locator, this, "aiSSessionContex", buffer, theAiSSessionContex, (this.aiSSessionContex != null));
    }
    return buffer;
  }

  public int hashCode(final ObjectLocator locator, final HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      final String theAiSCertificate;
      theAiSCertificate = this.getAiSCertificate();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aiSCertificate", theAiSCertificate), currentHashCode,
          theAiSCertificate, (this.aiSCertificate != null));
    }
    {
      final String theAiSSessionContex;
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
    return this.copyTo(this.createNewInstance());
  }

  public Object copyTo(final Object target) {
    final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE2;
    return this.copyTo(null, target, strategy);
  }

  public Object copyTo(final ObjectLocator locator, final Object target, final CopyStrategy2 strategy) {
    final Object draftCopy = ((target == null) ? this.createNewInstance() : target);
    if (draftCopy instanceof LoginWithCertificate copy) {
      {
        final Boolean aiSCertificateShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.aiSCertificate != null));
        if (aiSCertificateShouldBeCopiedAndSet == Boolean.TRUE) {
          final String sourceAiSCertificate;
          sourceAiSCertificate = this.getAiSCertificate();
          final String copyAiSCertificate = ((String) strategy.copy(LocatorUtils.property(locator, "aiSCertificate", sourceAiSCertificate),
              sourceAiSCertificate, (this.aiSCertificate != null)));
          copy.setAiSCertificate(copyAiSCertificate);
        } else {
          if (aiSCertificateShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.aiSCertificate = null;
          }
        }
      }
      {
        final Boolean aiSSessionContexShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.aiSSessionContex != null));
        if (aiSSessionContexShouldBeCopiedAndSet == Boolean.TRUE) {
          final String sourceAiSSessionContex;
          sourceAiSSessionContex = this.getAiSSessionContex();
          final String copyAiSSessionContex =
              ((String) strategy.copy(LocatorUtils.property(locator, "aiSSessionContex", sourceAiSSessionContex),
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
