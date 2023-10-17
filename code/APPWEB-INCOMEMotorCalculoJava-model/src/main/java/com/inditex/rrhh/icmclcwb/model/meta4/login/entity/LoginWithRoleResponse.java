
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
 *         &lt;element name="loginWithRoleReturn" type="{http://schemas.meta4.com/}M4loginOutput"/&gt;
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
    "loginWithRoleReturn"
})
@XmlRootElement(name = "loginWithRoleResponse")
public class LoginWithRoleResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

    /**
     * -- GETTER --
     *  Gets the value of the loginWithRoleReturn property.
     *
     * @return possible object is {@link M4LoginOutput }
     */
    @XmlElement(required = true)
  protected M4LoginOutput loginWithRoleReturn;

    /**
   * Sets the value of the loginWithRoleReturn property.
   *
   * @param value allowed object is {@link M4LoginOutput }
   *
   */
  public void setLoginWithRoleReturn(final M4LoginOutput value) {
    this.loginWithRoleReturn = value;
  }

  public boolean equals(final ObjectLocator thisLocator, final ObjectLocator thatLocator, final Object object, final EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final LoginWithRoleResponse that = ((LoginWithRoleResponse) object);
    {
      final M4LoginOutput lhsLoginWithRoleReturn;
      lhsLoginWithRoleReturn = this.getLoginWithRoleReturn();
      final M4LoginOutput rhsLoginWithRoleReturn;
      rhsLoginWithRoleReturn = that.getLoginWithRoleReturn();
      return strategy.equals(LocatorUtils.property(thisLocator, "loginWithRoleReturn", lhsLoginWithRoleReturn),
          LocatorUtils.property(thatLocator, "loginWithRoleReturn", rhsLoginWithRoleReturn), lhsLoginWithRoleReturn, rhsLoginWithRoleReturn,
          (this.loginWithRoleReturn != null), (that.loginWithRoleReturn != null));
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
      final M4LoginOutput theLoginWithRoleReturn;
      theLoginWithRoleReturn = this.getLoginWithRoleReturn();
      strategy.appendField(locator, this, "loginWithRoleReturn", buffer, theLoginWithRoleReturn, (this.loginWithRoleReturn != null));
    }
    return buffer;
  }

  public int hashCode(final ObjectLocator locator, final HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      final M4LoginOutput theLoginWithRoleReturn;
      theLoginWithRoleReturn = this.getLoginWithRoleReturn();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "loginWithRoleReturn", theLoginWithRoleReturn), currentHashCode,
          theLoginWithRoleReturn, (this.loginWithRoleReturn != null));
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
    if (draftCopy instanceof LoginWithRoleResponse) {
      final LoginWithRoleResponse copy = ((LoginWithRoleResponse) draftCopy);
      {
        final Boolean loginWithRoleReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.loginWithRoleReturn != null));
        if (loginWithRoleReturnShouldBeCopiedAndSet == Boolean.TRUE) {
          final M4LoginOutput sourceLoginWithRoleReturn;
          sourceLoginWithRoleReturn = this.getLoginWithRoleReturn();
          final M4LoginOutput copyLoginWithRoleReturn =
              ((M4LoginOutput) strategy.copy(LocatorUtils.property(locator, "loginWithRoleReturn", sourceLoginWithRoleReturn),
                  sourceLoginWithRoleReturn, (this.loginWithRoleReturn != null)));
          copy.setLoginWithRoleReturn(copyLoginWithRoleReturn);
        } else {
          if (loginWithRoleReturnShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.loginWithRoleReturn = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new LoginWithRoleResponse();
  }

}
