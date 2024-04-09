
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
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
 *         &lt;element name="LIQUIDACIONReturn" type="{http://schemas.meta4.com/}LiquidacionOutput"/&gt;
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
    "liquidacionReturn"
})
@XmlRootElement(name = "LIQUIDACIONResponse")
public class LIQUIDACIONResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "LIQUIDACIONReturn", required = true)
  protected LiquidacionOutput liquidacionReturn;

  /**
   * Gets the value of the liquidacionReturn property.
   *
   * @return possible object is {@link LiquidacionOutput }
   *
   */
  public LiquidacionOutput getLIQUIDACIONReturn() {
    return liquidacionReturn;
  }

  /**
   * Sets the value of the liquidacionReturn property.
   *
   * @param value allowed object is {@link LiquidacionOutput }
   *
   */
  public void setLIQUIDACIONReturn(LiquidacionOutput value) {
    this.liquidacionReturn = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final LIQUIDACIONResponse that = ((LIQUIDACIONResponse) object);
    {
      LiquidacionOutput lhsLIQUIDACIONReturn;
      lhsLIQUIDACIONReturn = this.getLIQUIDACIONReturn();
      LiquidacionOutput rhsLIQUIDACIONReturn;
      rhsLIQUIDACIONReturn = that.getLIQUIDACIONReturn();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "liquidacionReturn", lhsLIQUIDACIONReturn),
          LocatorUtils.property(thatLocator, "liquidacionReturn", rhsLIQUIDACIONReturn), lhsLIQUIDACIONReturn, rhsLIQUIDACIONReturn,
          (this.liquidacionReturn != null), (that.liquidacionReturn != null))) {
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
      LiquidacionOutput theLIQUIDACIONReturn;
      theLIQUIDACIONReturn = this.getLIQUIDACIONReturn();
      strategy.appendField(locator, this, "liquidacionReturn", buffer, theLIQUIDACIONReturn, (this.liquidacionReturn != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      LiquidacionOutput theLIQUIDACIONReturn;
      theLIQUIDACIONReturn = this.getLIQUIDACIONReturn();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "liquidacionReturn", theLIQUIDACIONReturn), currentHashCode,
          theLIQUIDACIONReturn, (this.liquidacionReturn != null));
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
    if (draftCopy instanceof LIQUIDACIONResponse) {
      final LIQUIDACIONResponse copy = ((LIQUIDACIONResponse) draftCopy);
      {
        Boolean liquidacionReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.liquidacionReturn != null));
        if (liquidacionReturnShouldBeCopiedAndSet == Boolean.TRUE) {
          LiquidacionOutput sourceLIQUIDACIONReturn;
          sourceLIQUIDACIONReturn = this.getLIQUIDACIONReturn();
          LiquidacionOutput copyLIQUIDACIONReturn =
              ((LiquidacionOutput) strategy.copy(LocatorUtils.property(locator, "liquidacionReturn", sourceLIQUIDACIONReturn),
                  sourceLIQUIDACIONReturn, (this.liquidacionReturn != null)));
          copy.setLIQUIDACIONReturn(copyLIQUIDACIONReturn);
        } else {
          if (liquidacionReturnShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.liquidacionReturn = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new LIQUIDACIONResponse();
  }

}
