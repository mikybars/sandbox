
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
 *         &lt;element name="loginWithCertificateReturn" type="{http://schemas.meta4.com/}M4loginOutput"/&gt;
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
    "loginWithCertificateReturn"
})
@XmlRootElement(name = "loginWithCertificateResponse")
public class LoginWithCertificateResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(required = true)
  protected M4LoginOutput loginWithCertificateReturn;

  /**
   * Gets the value of the loginWithCertificateReturn property.
   *
   * @return possible object is {@link M4LoginOutput }
   *
   */
  public M4LoginOutput getLoginWithCertificateReturn() {
    return loginWithCertificateReturn;
  }

  /**
   * Sets the value of the loginWithCertificateReturn property.
   *
   * @param value allowed object is {@link M4LoginOutput }
   *
   */
  public void setLoginWithCertificateReturn(M4LoginOutput value) {
    this.loginWithCertificateReturn = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final LoginWithCertificateResponse that = ((LoginWithCertificateResponse) object);
    {
      M4LoginOutput lhsLoginWithCertificateReturn;
      lhsLoginWithCertificateReturn = this.getLoginWithCertificateReturn();
      M4LoginOutput rhsLoginWithCertificateReturn;
      rhsLoginWithCertificateReturn = that.getLoginWithCertificateReturn();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "loginWithCertificateReturn", lhsLoginWithCertificateReturn),
          LocatorUtils.property(thatLocator, "loginWithCertificateReturn", rhsLoginWithCertificateReturn), lhsLoginWithCertificateReturn,
          rhsLoginWithCertificateReturn, (this.loginWithCertificateReturn != null), (that.loginWithCertificateReturn != null))) {
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
      M4LoginOutput theLoginWithCertificateReturn;
      theLoginWithCertificateReturn = this.getLoginWithCertificateReturn();
      strategy.appendField(locator, this, "loginWithCertificateReturn", buffer, theLoginWithCertificateReturn,
          (this.loginWithCertificateReturn != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      M4LoginOutput theLoginWithCertificateReturn;
      theLoginWithCertificateReturn = this.getLoginWithCertificateReturn();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "loginWithCertificateReturn", theLoginWithCertificateReturn),
          currentHashCode, theLoginWithCertificateReturn, (this.loginWithCertificateReturn != null));
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
    if (draftCopy instanceof LoginWithCertificateResponse) {
      final LoginWithCertificateResponse copy = ((LoginWithCertificateResponse) draftCopy);
      {
        Boolean loginWithCertificateReturnShouldBeCopiedAndSet =
            strategy.shouldBeCopiedAndSet(locator, (this.loginWithCertificateReturn != null));
        if (loginWithCertificateReturnShouldBeCopiedAndSet == Boolean.TRUE) {
          M4LoginOutput sourceLoginWithCertificateReturn;
          sourceLoginWithCertificateReturn = this.getLoginWithCertificateReturn();
          M4LoginOutput copyLoginWithCertificateReturn =
              ((M4LoginOutput) strategy.copy(LocatorUtils.property(locator, "loginWithCertificateReturn", sourceLoginWithCertificateReturn),
                  sourceLoginWithCertificateReturn, (this.loginWithCertificateReturn != null)));
          copy.setLoginWithCertificateReturn(copyLoginWithCertificateReturn);
        } else {
          if (loginWithCertificateReturnShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.loginWithCertificateReturn = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new LoginWithCertificateResponse();
  }

}
