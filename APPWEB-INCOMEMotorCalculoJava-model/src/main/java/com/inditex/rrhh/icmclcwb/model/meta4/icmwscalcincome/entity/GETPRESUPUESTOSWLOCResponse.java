
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
 *         &lt;element name="GETPRESUPUESTOSWLOCReturn" type="{http://schemas.meta4.com/}GetpresupuestoswlocOutput"/&gt;
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
    "getpresupuestoswlocReturn"
})
@XmlRootElement(name = "GETPRESUPUESTOSWLOCResponse")
public class GETPRESUPUESTOSWLOCResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "GETPRESUPUESTOSWLOCReturn", required = true)
  protected GetpresupuestoswlocOutput getpresupuestoswlocReturn;

  /**
   * Obtiene el valor de la propiedad getpresupuestoswlocReturn.
   *
   * @return possible object is {@link GetpresupuestoswlocOutput }
   *
   */
  public GetpresupuestoswlocOutput getGETPRESUPUESTOSWLOCReturn() {
    return getpresupuestoswlocReturn;
  }

  /**
   * Define el valor de la propiedad getpresupuestoswlocReturn.
   *
   * @param value allowed object is {@link GetpresupuestoswlocOutput }
   *
   */
  public void setGETPRESUPUESTOSWLOCReturn(GetpresupuestoswlocOutput value) {
    this.getpresupuestoswlocReturn = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final GETPRESUPUESTOSWLOCResponse that = ((GETPRESUPUESTOSWLOCResponse) object);
    {
      GetpresupuestoswlocOutput lhsGETPRESUPUESTOSWLOCReturn;
      lhsGETPRESUPUESTOSWLOCReturn = this.getGETPRESUPUESTOSWLOCReturn();
      GetpresupuestoswlocOutput rhsGETPRESUPUESTOSWLOCReturn;
      rhsGETPRESUPUESTOSWLOCReturn = that.getGETPRESUPUESTOSWLOCReturn();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "getpresupuestoswlocReturn", lhsGETPRESUPUESTOSWLOCReturn),
          LocatorUtils.property(thatLocator, "getpresupuestoswlocReturn", rhsGETPRESUPUESTOSWLOCReturn), lhsGETPRESUPUESTOSWLOCReturn,
          rhsGETPRESUPUESTOSWLOCReturn, (this.getpresupuestoswlocReturn != null), (that.getpresupuestoswlocReturn != null))) {
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
      GetpresupuestoswlocOutput theGETPRESUPUESTOSWLOCReturn;
      theGETPRESUPUESTOSWLOCReturn = this.getGETPRESUPUESTOSWLOCReturn();
      strategy.appendField(locator, this, "getpresupuestoswlocReturn", buffer, theGETPRESUPUESTOSWLOCReturn,
          (this.getpresupuestoswlocReturn != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      GetpresupuestoswlocOutput theGETPRESUPUESTOSWLOCReturn;
      theGETPRESUPUESTOSWLOCReturn = this.getGETPRESUPUESTOSWLOCReturn();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getpresupuestoswlocReturn", theGETPRESUPUESTOSWLOCReturn),
          currentHashCode, theGETPRESUPUESTOSWLOCReturn, (this.getpresupuestoswlocReturn != null));
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
    if (draftCopy instanceof GETPRESUPUESTOSWLOCResponse) {
      final GETPRESUPUESTOSWLOCResponse copy = ((GETPRESUPUESTOSWLOCResponse) draftCopy);
      {
        Boolean getpresupuestoswlocReturnShouldBeCopiedAndSet =
            strategy.shouldBeCopiedAndSet(locator, (this.getpresupuestoswlocReturn != null));
        if (getpresupuestoswlocReturnShouldBeCopiedAndSet == Boolean.TRUE) {
          GetpresupuestoswlocOutput sourceGETPRESUPUESTOSWLOCReturn;
          sourceGETPRESUPUESTOSWLOCReturn = this.getGETPRESUPUESTOSWLOCReturn();
          GetpresupuestoswlocOutput copyGETPRESUPUESTOSWLOCReturn = ((GetpresupuestoswlocOutput) strategy.copy(
              LocatorUtils.property(locator, "getpresupuestoswlocReturn", sourceGETPRESUPUESTOSWLOCReturn), sourceGETPRESUPUESTOSWLOCReturn,
              (this.getpresupuestoswlocReturn != null)));
          copy.setGETPRESUPUESTOSWLOCReturn(copyGETPRESUPUESTOSWLOCReturn);
        } else {
          if (getpresupuestoswlocReturnShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.getpresupuestoswlocReturn = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new GETPRESUPUESTOSWLOCResponse();
  }

}
