
package com.inditex.rrhh.icmclcwb.model.meta4.login.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="logoutReturn" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "logoutReturn"
})
@XmlRootElement(name = "logoutResponse")
public class LogoutResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  /**
   * -- GETTER -- Gets the value of the logoutReturn property.
   */
  protected int logoutReturn;

  /**
   * Sets the value of the logoutReturn property.
   *
   */
  public void setLogoutReturn(final int value) {
    this.logoutReturn = value;
  }

  public boolean equals(final ObjectLocator thisLocator, final ObjectLocator thatLocator, final Object object,
      final EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final LogoutResponse that = ((LogoutResponse) object);
    {
      final int lhsLogoutReturn;
      lhsLogoutReturn = this.getLogoutReturn();
      final int rhsLogoutReturn;
      rhsLogoutReturn = that.getLogoutReturn();
      return strategy.equals(LocatorUtils.property(thisLocator, "logoutReturn", lhsLogoutReturn),
          LocatorUtils.property(thatLocator, "logoutReturn", rhsLogoutReturn), lhsLogoutReturn, rhsLogoutReturn, true, true);
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
      final int theLogoutReturn;
      theLogoutReturn = this.getLogoutReturn();
      strategy.appendField(locator, this, "logoutReturn", buffer, theLogoutReturn, true);
    }
    return buffer;
  }

  public int hashCode(final ObjectLocator locator, final HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      final int theLogoutReturn;
      theLogoutReturn = this.getLogoutReturn();
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "logoutReturn", theLogoutReturn), currentHashCode, theLogoutReturn, true);
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
    if (draftCopy instanceof LogoutResponse) {
      final LogoutResponse copy = ((LogoutResponse) draftCopy);
      {
        final Boolean logoutReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, true);
        if (logoutReturnShouldBeCopiedAndSet == Boolean.TRUE) {
          final int sourceLogoutReturn;
          sourceLogoutReturn = this.getLogoutReturn();
          final int copyLogoutReturn =
              strategy.copy(LocatorUtils.property(locator, "logoutReturn", sourceLogoutReturn), sourceLogoutReturn, true);
          copy.setLogoutReturn(copyLogoutReturn);
        } else {
          if (logoutReturnShouldBeCopiedAndSet == Boolean.FALSE) {
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new LogoutResponse();
  }

}
