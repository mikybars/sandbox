
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
 *         &lt;element name="GETDESPLAZREALReturn" type="{http://schemas.meta4.com/}GetdesplazrealOutput"/&gt;
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
    "getdesplazrealReturn"
})
@XmlRootElement(name = "GETDESPLAZREALResponse")
public class GETDESPLAZREALResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "GETDESPLAZREALReturn", required = true)
  protected GetdesplazrealOutput getdesplazrealReturn;

  /**
   * Obtiene el valor de la propiedad getdesplazrealReturn.
   *
   * @return possible object is {@link GetdesplazrealOutput }
   *
   */
  public GetdesplazrealOutput getGETDESPLAZREALReturn() {
    return getdesplazrealReturn;
  }

  /**
   * Define el valor de la propiedad getdesplazrealReturn.
   *
   * @param value allowed object is {@link GetdesplazrealOutput }
   *
   */
  public void setGETDESPLAZREALReturn(GetdesplazrealOutput value) {
    this.getdesplazrealReturn = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final GETDESPLAZREALResponse that = ((GETDESPLAZREALResponse) object);
    {
      GetdesplazrealOutput lhsGETDESPLAZREALReturn;
      lhsGETDESPLAZREALReturn = this.getGETDESPLAZREALReturn();
      GetdesplazrealOutput rhsGETDESPLAZREALReturn;
      rhsGETDESPLAZREALReturn = that.getGETDESPLAZREALReturn();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "getdesplazrealReturn", lhsGETDESPLAZREALReturn),
          LocatorUtils.property(thatLocator, "getdesplazrealReturn", rhsGETDESPLAZREALReturn), lhsGETDESPLAZREALReturn,
          rhsGETDESPLAZREALReturn, (this.getdesplazrealReturn != null), (that.getdesplazrealReturn != null))) {
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
      GetdesplazrealOutput theGETDESPLAZREALReturn;
      theGETDESPLAZREALReturn = this.getGETDESPLAZREALReturn();
      strategy.appendField(locator, this, "getdesplazrealReturn", buffer, theGETDESPLAZREALReturn, (this.getdesplazrealReturn != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      GetdesplazrealOutput theGETDESPLAZREALReturn;
      theGETDESPLAZREALReturn = this.getGETDESPLAZREALReturn();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getdesplazrealReturn", theGETDESPLAZREALReturn), currentHashCode,
          theGETDESPLAZREALReturn, (this.getdesplazrealReturn != null));
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
    if (draftCopy instanceof GETDESPLAZREALResponse) {
      final GETDESPLAZREALResponse copy = ((GETDESPLAZREALResponse) draftCopy);
      {
        Boolean getdesplazrealReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getdesplazrealReturn != null));
        if (getdesplazrealReturnShouldBeCopiedAndSet == Boolean.TRUE) {
          GetdesplazrealOutput sourceGETDESPLAZREALReturn;
          sourceGETDESPLAZREALReturn = this.getGETDESPLAZREALReturn();
          GetdesplazrealOutput copyGETDESPLAZREALReturn =
              ((GetdesplazrealOutput) strategy.copy(LocatorUtils.property(locator, "getdesplazrealReturn", sourceGETDESPLAZREALReturn),
                  sourceGETDESPLAZREALReturn, (this.getdesplazrealReturn != null)));
          copy.setGETDESPLAZREALReturn(copyGETDESPLAZREALReturn);
        } else {
          if (getdesplazrealReturnShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.getdesplazrealReturn = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new GETDESPLAZREALResponse();
  }

}
