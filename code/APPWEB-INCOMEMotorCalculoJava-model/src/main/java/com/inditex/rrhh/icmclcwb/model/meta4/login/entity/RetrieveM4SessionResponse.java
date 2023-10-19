
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
 *         &lt;element name="retrieveM4SessionReturn" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "retrieveM4SessionReturn"
})
@XmlRootElement(name = "retrieveM4SessionResponse")
public class RetrieveM4SessionResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  /**
   * -- GETTER -- Gets the value of the retrieveM4SessionReturn property.
   */
  protected int retrieveM4SessionReturn;

  /**
   * Sets the value of the retrieveM4SessionReturn property.
   *
   */
  public void setRetrieveM4SessionReturn(final int value) {
    this.retrieveM4SessionReturn = value;
  }

  public boolean equals(final ObjectLocator thisLocator, final ObjectLocator thatLocator, final Object object,
      final EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final RetrieveM4SessionResponse that = ((RetrieveM4SessionResponse) object);
    {
      final int lhsRetrieveM4SessionReturn;
      lhsRetrieveM4SessionReturn = this.getRetrieveM4SessionReturn();
      final int rhsRetrieveM4SessionReturn;
      rhsRetrieveM4SessionReturn = that.getRetrieveM4SessionReturn();
      return strategy.equals(LocatorUtils.property(thisLocator, "retrieveM4SessionReturn", lhsRetrieveM4SessionReturn),
          LocatorUtils.property(thatLocator, "retrieveM4SessionReturn", rhsRetrieveM4SessionReturn), lhsRetrieveM4SessionReturn,
          rhsRetrieveM4SessionReturn, true, true);
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
      final int theRetrieveM4SessionReturn;
      theRetrieveM4SessionReturn = this.getRetrieveM4SessionReturn();
      strategy.appendField(locator, this, "retrieveM4SessionReturn", buffer, theRetrieveM4SessionReturn, true);
    }
    return buffer;
  }

  public int hashCode(final ObjectLocator locator, final HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      final int theRetrieveM4SessionReturn;
      theRetrieveM4SessionReturn = this.getRetrieveM4SessionReturn();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "retrieveM4SessionReturn", theRetrieveM4SessionReturn),
          currentHashCode, theRetrieveM4SessionReturn, true);
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
    if (draftCopy instanceof RetrieveM4SessionResponse) {
      final RetrieveM4SessionResponse copy = ((RetrieveM4SessionResponse) draftCopy);
      {
        final Boolean retrieveM4SessionReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, true);
        if (retrieveM4SessionReturnShouldBeCopiedAndSet == Boolean.TRUE) {
          final int sourceRetrieveM4SessionReturn;
          sourceRetrieveM4SessionReturn = this.getRetrieveM4SessionReturn();
          final int copyRetrieveM4SessionReturn =
              strategy.copy(LocatorUtils.property(locator, "retrieveM4SessionReturn", sourceRetrieveM4SessionReturn),
                  sourceRetrieveM4SessionReturn, true);
          copy.setRetrieveM4SessionReturn(copyRetrieveM4SessionReturn);
        } else {
          if (retrieveM4SessionReturnShouldBeCopiedAndSet == Boolean.FALSE) {
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new RetrieveM4SessionResponse();
  }

}
