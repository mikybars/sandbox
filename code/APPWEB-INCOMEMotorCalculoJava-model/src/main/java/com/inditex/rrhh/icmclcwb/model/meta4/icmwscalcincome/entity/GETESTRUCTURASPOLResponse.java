
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
 *         &lt;element name="GETESTRUCTURASPOLReturn" type="{http://schemas.meta4.com/}GetestructuraspolOutput"/&gt;
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
    "getestructuraspolReturn"
})
@XmlRootElement(name = "GETESTRUCTURASPOLResponse")
public class GETESTRUCTURASPOLResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "GETESTRUCTURASPOLReturn", required = true)
  protected GetestructuraspolOutput getestructuraspolReturn;

  /**
   * Gets the value of the getestructuraspolReturn property.
   *
   * @return possible object is {@link GetestructuraspolOutput }
   *
   */
  public GetestructuraspolOutput getGETESTRUCTURASPOLReturn() {
    return getestructuraspolReturn;
  }

  /**
   * Sets the value of the getestructuraspolReturn property.
   *
   * @param value allowed object is {@link GetestructuraspolOutput }
   *
   */
  public void setGETESTRUCTURASPOLReturn(GetestructuraspolOutput value) {
    this.getestructuraspolReturn = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final GETESTRUCTURASPOLResponse that = ((GETESTRUCTURASPOLResponse) object);
    {
      GetestructuraspolOutput lhsGETESTRUCTURASPOLReturn;
      lhsGETESTRUCTURASPOLReturn = this.getGETESTRUCTURASPOLReturn();
      GetestructuraspolOutput rhsGETESTRUCTURASPOLReturn;
      rhsGETESTRUCTURASPOLReturn = that.getGETESTRUCTURASPOLReturn();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "getestructuraspolReturn", lhsGETESTRUCTURASPOLReturn),
          LocatorUtils.property(thatLocator, "getestructuraspolReturn", rhsGETESTRUCTURASPOLReturn), lhsGETESTRUCTURASPOLReturn,
          rhsGETESTRUCTURASPOLReturn, (this.getestructuraspolReturn != null), (that.getestructuraspolReturn != null))) {
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
      GetestructuraspolOutput theGETESTRUCTURASPOLReturn;
      theGETESTRUCTURASPOLReturn = this.getGETESTRUCTURASPOLReturn();
      strategy.appendField(locator, this, "getestructuraspolReturn", buffer, theGETESTRUCTURASPOLReturn,
          (this.getestructuraspolReturn != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      GetestructuraspolOutput theGETESTRUCTURASPOLReturn;
      theGETESTRUCTURASPOLReturn = this.getGETESTRUCTURASPOLReturn();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getestructuraspolReturn", theGETESTRUCTURASPOLReturn),
          currentHashCode, theGETESTRUCTURASPOLReturn, (this.getestructuraspolReturn != null));
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
    if (draftCopy instanceof GETESTRUCTURASPOLResponse) {
      final GETESTRUCTURASPOLResponse copy = ((GETESTRUCTURASPOLResponse) draftCopy);
      {
        Boolean getestructuraspolReturnShouldBeCopiedAndSet =
            strategy.shouldBeCopiedAndSet(locator, (this.getestructuraspolReturn != null));
        if (getestructuraspolReturnShouldBeCopiedAndSet == Boolean.TRUE) {
          GetestructuraspolOutput sourceGETESTRUCTURASPOLReturn;
          sourceGETESTRUCTURASPOLReturn = this.getGETESTRUCTURASPOLReturn();
          GetestructuraspolOutput copyGETESTRUCTURASPOLReturn = ((GetestructuraspolOutput) strategy.copy(
              LocatorUtils.property(locator, "getestructuraspolReturn", sourceGETESTRUCTURASPOLReturn), sourceGETESTRUCTURASPOLReturn,
              (this.getestructuraspolReturn != null)));
          copy.setGETESTRUCTURASPOLReturn(copyGETESTRUCTURASPOLReturn);
        } else {
          if (getestructuraspolReturnShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.getestructuraspolReturn = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new GETESTRUCTURASPOLResponse();
  }

}
