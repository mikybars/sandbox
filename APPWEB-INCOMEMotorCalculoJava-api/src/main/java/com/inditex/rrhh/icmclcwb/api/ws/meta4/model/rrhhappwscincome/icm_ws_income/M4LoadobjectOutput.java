
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 * <p>Clase Java para M4LoadobjectOutput complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="M4LoadobjectOutput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="logMessage" type="{http://schemas.meta4.com/}LogMessage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Icm_Ws_Tools" type="{http://schemas.meta4.com/}Icm_Ws_ToolsBlock"/>
 *         &lt;element name="Icm_Ventamanual" type="{http://schemas.meta4.com/}Icm_VentamanualBlock"/>
 *         &lt;element name="Icm_Globaltienda" type="{http://schemas.meta4.com/}Icm_GlobaltiendaBlock"/>
 *         &lt;element name="Icm_Presupuestos" type="{http://schemas.meta4.com/}Icm_PresupuestosBlock"/>
 *         &lt;element name="Icm_Buscadortienda" type="{http://schemas.meta4.com/}Icm_BuscadortiendaBlock"/>
 *         &lt;element name="Icm_Cabeceratienda" type="{http://schemas.meta4.com/}Icm_CabeceratiendaBlock"/>
 *         &lt;element name="Icm_Datosgentienda" type="{http://schemas.meta4.com/}Icm_DatosgentiendaBlock"/>
 *         &lt;element name="Icm_Globalempleado" type="{http://schemas.meta4.com/}Icm_GlobalempleadoBlock"/>
 *         &lt;element name="Icm_Ws_Operaciones" type="{http://schemas.meta4.com/}Icm_Ws_OperacionesBlock"/>
 *         &lt;element name="Icm_Empleadostienda" type="{http://schemas.meta4.com/}Icm_EmpleadostiendaBlock"/>
 *         &lt;element name="Icm_Parametrosexcel" type="{http://schemas.meta4.com/}Icm_ParametrosexcelBlock"/>
 *         &lt;element name="Icm_Presenciamanual" type="{http://schemas.meta4.com/}Icm_PresenciamanualBlock"/>
 *         &lt;element name="Icm_Cabeceraempleado" type="{http://schemas.meta4.com/}Icm_CabeceraempleadoBlock"/>
 *         &lt;element name="Icm_Calendariotienda" type="{http://schemas.meta4.com/}Icm_CalendariotiendaBlock"/>
 *         &lt;element name="Icm_Condicionesventa" type="{http://schemas.meta4.com/}Icm_CondicionesventaBlock"/>
 *         &lt;element name="Icm_Datosgenempleado" type="{http://schemas.meta4.com/}Icm_DatosgenempleadoBlock"/>
 *         &lt;element name="Icm_Empleadosdespent" type="{http://schemas.meta4.com/}Icm_EmpleadosdespentBlock"/>
 *         &lt;element name="Icm_Empleadosdespsal" type="{http://schemas.meta4.com/}Icm_EmpleadosdespsalBlock"/>
 *         &lt;element name="Icm_Parametrostienda" type="{http://schemas.meta4.com/}Icm_ParametrostiendaBlock"/>
 *         &lt;element name="Icm_Resultadoguardado" type="{http://schemas.meta4.com/}Icm_ResultadoguardadoBlock"/>
 *         &lt;element name="Icm_Bandaspresupuestos" type="{http://schemas.meta4.com/}Icm_BandaspresupuestosBlock"/>
 *         &lt;element name="Icm_Calendarioempleado" type="{http://schemas.meta4.com/}Icm_CalendarioempleadoBlock"/>
 *         &lt;element name="Icm_Parametrosempleado" type="{http://schemas.meta4.com/}Icm_ParametrosempleadoBlock"/>
 *         &lt;element name="Icm_Tiendacomisionable" type="{http://schemas.meta4.com/}Icm_TiendacomisionableBlock"/>
 *         &lt;element name="Icm_Empleadosestructura" type="{http://schemas.meta4.com/}Icm_EmpleadosestructuraBlock"/>
 *         &lt;element name="Icm_Parametrosplantilla" type="{http://schemas.meta4.com/}Icm_ParametrosplantillaBlock"/>
 *         &lt;element name="Icm_Tpcalculopaiscadena" type="{http://schemas.meta4.com/}Icm_TpcalculopaiscadenaBlock"/>
 *         &lt;element name="Icm_Estadostiendaseccion" type="{http://schemas.meta4.com/}Icm_EstadostiendaseccionBlock"/>
 *         &lt;element name="Icm_Parametrospaginacion" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/>
 *         &lt;element name="Icm_Parametrospaiscadena" type="{http://schemas.meta4.com/}Icm_ParametrospaiscadenaBlock"/>
 *         &lt;element name="Icm_Plantillacondiciones" type="{http://schemas.meta4.com/}Icm_PlantillacondicionesBlock"/>
 *         &lt;element name="Icm_Parametrospresupuesto" type="{http://schemas.meta4.com/}Icm_ParametrospresupuestoBlock"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "M4LoadobjectOutput", propOrder = {
    "_return",
    "logMessage",
    "icmWsTools",
    "icmVentamanual",
    "icmGlobaltienda",
    "icmPresupuestos",
    "icmBuscadortienda",
    "icmCabeceratienda",
    "icmDatosgentienda",
    "icmGlobalempleado",
    "icmWsOperaciones",
    "icmEmpleadostienda",
    "icmParametrosexcel",
    "icmPresenciamanual",
    "icmCabeceraempleado",
    "icmCalendariotienda",
    "icmCondicionesventa",
    "icmDatosgenempleado",
    "icmEmpleadosdespent",
    "icmEmpleadosdespsal",
    "icmParametrostienda",
    "icmResultadoguardado",
    "icmBandaspresupuestos",
    "icmCalendarioempleado",
    "icmParametrosempleado",
    "icmTiendacomisionable",
    "icmEmpleadosestructura",
    "icmParametrosplantilla",
    "icmTpcalculopaiscadena",
    "icmEstadostiendaseccion",
    "icmParametrospaginacion",
    "icmParametrospaiscadena",
    "icmPlantillacondiciones",
    "icmParametrospresupuesto"
})
public class M4LoadobjectOutput implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "return")
    protected double _return;
    @XmlElement(nillable = true)
    protected List<LogMessage> logMessage;
    @XmlElement(name = "Icm_Ws_Tools", required = true, nillable = true)
    protected IcmWsToolsBlock icmWsTools;
    @XmlElement(name = "Icm_Ventamanual", required = true, nillable = true)
    protected IcmVentamanualBlock icmVentamanual;
    @XmlElement(name = "Icm_Globaltienda", required = true, nillable = true)
    protected IcmGlobaltiendaBlock icmGlobaltienda;
    @XmlElement(name = "Icm_Presupuestos", required = true, nillable = true)
    protected IcmPresupuestosBlock icmPresupuestos;
    @XmlElement(name = "Icm_Buscadortienda", required = true, nillable = true)
    protected IcmBuscadortiendaBlock icmBuscadortienda;
    @XmlElement(name = "Icm_Cabeceratienda", required = true, nillable = true)
    protected IcmCabeceratiendaBlock icmCabeceratienda;
    @XmlElement(name = "Icm_Datosgentienda", required = true, nillable = true)
    protected IcmDatosgentiendaBlock icmDatosgentienda;
    @XmlElement(name = "Icm_Globalempleado", required = true, nillable = true)
    protected IcmGlobalempleadoBlock icmGlobalempleado;
    @XmlElement(name = "Icm_Ws_Operaciones", required = true, nillable = true)
    protected IcmWsOperacionesBlock icmWsOperaciones;
    @XmlElement(name = "Icm_Empleadostienda", required = true, nillable = true)
    protected IcmEmpleadostiendaBlock icmEmpleadostienda;
    @XmlElement(name = "Icm_Parametrosexcel", required = true, nillable = true)
    protected IcmParametrosexcelBlock icmParametrosexcel;
    @XmlElement(name = "Icm_Presenciamanual", required = true, nillable = true)
    protected IcmPresenciamanualBlock icmPresenciamanual;
    @XmlElement(name = "Icm_Cabeceraempleado", required = true, nillable = true)
    protected IcmCabeceraempleadoBlock icmCabeceraempleado;
    @XmlElement(name = "Icm_Calendariotienda", required = true, nillable = true)
    protected IcmCalendariotiendaBlock icmCalendariotienda;
    @XmlElement(name = "Icm_Condicionesventa", required = true, nillable = true)
    protected IcmCondicionesventaBlock icmCondicionesventa;
    @XmlElement(name = "Icm_Datosgenempleado", required = true, nillable = true)
    protected IcmDatosgenempleadoBlock icmDatosgenempleado;
    @XmlElement(name = "Icm_Empleadosdespent", required = true, nillable = true)
    protected IcmEmpleadosdespentBlock icmEmpleadosdespent;
    @XmlElement(name = "Icm_Empleadosdespsal", required = true, nillable = true)
    protected IcmEmpleadosdespsalBlock icmEmpleadosdespsal;
    @XmlElement(name = "Icm_Parametrostienda", required = true, nillable = true)
    protected IcmParametrostiendaBlock icmParametrostienda;
    @XmlElement(name = "Icm_Resultadoguardado", required = true, nillable = true)
    protected IcmResultadoguardadoBlock icmResultadoguardado;
    @XmlElement(name = "Icm_Bandaspresupuestos", required = true, nillable = true)
    protected IcmBandaspresupuestosBlock icmBandaspresupuestos;
    @XmlElement(name = "Icm_Calendarioempleado", required = true, nillable = true)
    protected IcmCalendarioempleadoBlock icmCalendarioempleado;
    @XmlElement(name = "Icm_Parametrosempleado", required = true, nillable = true)
    protected IcmParametrosempleadoBlock icmParametrosempleado;
    @XmlElement(name = "Icm_Tiendacomisionable", required = true, nillable = true)
    protected IcmTiendacomisionableBlock icmTiendacomisionable;
    @XmlElement(name = "Icm_Empleadosestructura", required = true, nillable = true)
    protected IcmEmpleadosestructuraBlock icmEmpleadosestructura;
    @XmlElement(name = "Icm_Parametrosplantilla", required = true, nillable = true)
    protected IcmParametrosplantillaBlock icmParametrosplantilla;
    @XmlElement(name = "Icm_Tpcalculopaiscadena", required = true, nillable = true)
    protected IcmTpcalculopaiscadenaBlock icmTpcalculopaiscadena;
    @XmlElement(name = "Icm_Estadostiendaseccion", required = true, nillable = true)
    protected IcmEstadostiendaseccionBlock icmEstadostiendaseccion;
    @XmlElement(name = "Icm_Parametrospaginacion", required = true, nillable = true)
    protected IcmParametrospaginacionBlock icmParametrospaginacion;
    @XmlElement(name = "Icm_Parametrospaiscadena", required = true, nillable = true)
    protected IcmParametrospaiscadenaBlock icmParametrospaiscadena;
    @XmlElement(name = "Icm_Plantillacondiciones", required = true, nillable = true)
    protected IcmPlantillacondicionesBlock icmPlantillacondiciones;
    @XmlElement(name = "Icm_Parametrospresupuesto", required = true, nillable = true)
    protected IcmParametrospresupuestoBlock icmParametrospresupuesto;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     */
    public double getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     */
    public void setReturn(double value) {
        this._return = value;
    }

    /**
     * Gets the value of the logMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessage }
     * 
     * 
     */
    public List<LogMessage> getLogMessage() {
        if (logMessage == null) {
            logMessage = new ArrayList<LogMessage>();
        }
        return this.logMessage;
    }

    /**
     * Obtiene el valor de la propiedad icmWsTools.
     * 
     * @return
     *     possible object is
     *     {@link IcmWsToolsBlock }
     *     
     */
    public IcmWsToolsBlock getIcmWsTools() {
        return icmWsTools;
    }

    /**
     * Define el valor de la propiedad icmWsTools.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmWsToolsBlock }
     *     
     */
    public void setIcmWsTools(IcmWsToolsBlock value) {
        this.icmWsTools = value;
    }

    /**
     * Obtiene el valor de la propiedad icmVentamanual.
     * 
     * @return
     *     possible object is
     *     {@link IcmVentamanualBlock }
     *     
     */
    public IcmVentamanualBlock getIcmVentamanual() {
        return icmVentamanual;
    }

    /**
     * Define el valor de la propiedad icmVentamanual.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmVentamanualBlock }
     *     
     */
    public void setIcmVentamanual(IcmVentamanualBlock value) {
        this.icmVentamanual = value;
    }

    /**
     * Obtiene el valor de la propiedad icmGlobaltienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmGlobaltiendaBlock }
     *     
     */
    public IcmGlobaltiendaBlock getIcmGlobaltienda() {
        return icmGlobaltienda;
    }

    /**
     * Define el valor de la propiedad icmGlobaltienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmGlobaltiendaBlock }
     *     
     */
    public void setIcmGlobaltienda(IcmGlobaltiendaBlock value) {
        this.icmGlobaltienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmPresupuestos.
     * 
     * @return
     *     possible object is
     *     {@link IcmPresupuestosBlock }
     *     
     */
    public IcmPresupuestosBlock getIcmPresupuestos() {
        return icmPresupuestos;
    }

    /**
     * Define el valor de la propiedad icmPresupuestos.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmPresupuestosBlock }
     *     
     */
    public void setIcmPresupuestos(IcmPresupuestosBlock value) {
        this.icmPresupuestos = value;
    }

    /**
     * Obtiene el valor de la propiedad icmBuscadortienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmBuscadortiendaBlock }
     *     
     */
    public IcmBuscadortiendaBlock getIcmBuscadortienda() {
        return icmBuscadortienda;
    }

    /**
     * Define el valor de la propiedad icmBuscadortienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmBuscadortiendaBlock }
     *     
     */
    public void setIcmBuscadortienda(IcmBuscadortiendaBlock value) {
        this.icmBuscadortienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmCabeceratienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmCabeceratiendaBlock }
     *     
     */
    public IcmCabeceratiendaBlock getIcmCabeceratienda() {
        return icmCabeceratienda;
    }

    /**
     * Define el valor de la propiedad icmCabeceratienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmCabeceratiendaBlock }
     *     
     */
    public void setIcmCabeceratienda(IcmCabeceratiendaBlock value) {
        this.icmCabeceratienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmDatosgentienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmDatosgentiendaBlock }
     *     
     */
    public IcmDatosgentiendaBlock getIcmDatosgentienda() {
        return icmDatosgentienda;
    }

    /**
     * Define el valor de la propiedad icmDatosgentienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmDatosgentiendaBlock }
     *     
     */
    public void setIcmDatosgentienda(IcmDatosgentiendaBlock value) {
        this.icmDatosgentienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmGlobalempleado.
     * 
     * @return
     *     possible object is
     *     {@link IcmGlobalempleadoBlock }
     *     
     */
    public IcmGlobalempleadoBlock getIcmGlobalempleado() {
        return icmGlobalempleado;
    }

    /**
     * Define el valor de la propiedad icmGlobalempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmGlobalempleadoBlock }
     *     
     */
    public void setIcmGlobalempleado(IcmGlobalempleadoBlock value) {
        this.icmGlobalempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmWsOperaciones.
     * 
     * @return
     *     possible object is
     *     {@link IcmWsOperacionesBlock }
     *     
     */
    public IcmWsOperacionesBlock getIcmWsOperaciones() {
        return icmWsOperaciones;
    }

    /**
     * Define el valor de la propiedad icmWsOperaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmWsOperacionesBlock }
     *     
     */
    public void setIcmWsOperaciones(IcmWsOperacionesBlock value) {
        this.icmWsOperaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad icmEmpleadostienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmEmpleadostiendaBlock }
     *     
     */
    public IcmEmpleadostiendaBlock getIcmEmpleadostienda() {
        return icmEmpleadostienda;
    }

    /**
     * Define el valor de la propiedad icmEmpleadostienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEmpleadostiendaBlock }
     *     
     */
    public void setIcmEmpleadostienda(IcmEmpleadostiendaBlock value) {
        this.icmEmpleadostienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParametrosexcel.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrosexcelBlock }
     *     
     */
    public IcmParametrosexcelBlock getIcmParametrosexcel() {
        return icmParametrosexcel;
    }

    /**
     * Define el valor de la propiedad icmParametrosexcel.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrosexcelBlock }
     *     
     */
    public void setIcmParametrosexcel(IcmParametrosexcelBlock value) {
        this.icmParametrosexcel = value;
    }

    /**
     * Obtiene el valor de la propiedad icmPresenciamanual.
     * 
     * @return
     *     possible object is
     *     {@link IcmPresenciamanualBlock }
     *     
     */
    public IcmPresenciamanualBlock getIcmPresenciamanual() {
        return icmPresenciamanual;
    }

    /**
     * Define el valor de la propiedad icmPresenciamanual.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmPresenciamanualBlock }
     *     
     */
    public void setIcmPresenciamanual(IcmPresenciamanualBlock value) {
        this.icmPresenciamanual = value;
    }

    /**
     * Obtiene el valor de la propiedad icmCabeceraempleado.
     * 
     * @return
     *     possible object is
     *     {@link IcmCabeceraempleadoBlock }
     *     
     */
    public IcmCabeceraempleadoBlock getIcmCabeceraempleado() {
        return icmCabeceraempleado;
    }

    /**
     * Define el valor de la propiedad icmCabeceraempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmCabeceraempleadoBlock }
     *     
     */
    public void setIcmCabeceraempleado(IcmCabeceraempleadoBlock value) {
        this.icmCabeceraempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmCalendariotienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmCalendariotiendaBlock }
     *     
     */
    public IcmCalendariotiendaBlock getIcmCalendariotienda() {
        return icmCalendariotienda;
    }

    /**
     * Define el valor de la propiedad icmCalendariotienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmCalendariotiendaBlock }
     *     
     */
    public void setIcmCalendariotienda(IcmCalendariotiendaBlock value) {
        this.icmCalendariotienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmCondicionesventa.
     * 
     * @return
     *     possible object is
     *     {@link IcmCondicionesventaBlock }
     *     
     */
    public IcmCondicionesventaBlock getIcmCondicionesventa() {
        return icmCondicionesventa;
    }

    /**
     * Define el valor de la propiedad icmCondicionesventa.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmCondicionesventaBlock }
     *     
     */
    public void setIcmCondicionesventa(IcmCondicionesventaBlock value) {
        this.icmCondicionesventa = value;
    }

    /**
     * Obtiene el valor de la propiedad icmDatosgenempleado.
     * 
     * @return
     *     possible object is
     *     {@link IcmDatosgenempleadoBlock }
     *     
     */
    public IcmDatosgenempleadoBlock getIcmDatosgenempleado() {
        return icmDatosgenempleado;
    }

    /**
     * Define el valor de la propiedad icmDatosgenempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmDatosgenempleadoBlock }
     *     
     */
    public void setIcmDatosgenempleado(IcmDatosgenempleadoBlock value) {
        this.icmDatosgenempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmEmpleadosdespent.
     * 
     * @return
     *     possible object is
     *     {@link IcmEmpleadosdespentBlock }
     *     
     */
    public IcmEmpleadosdespentBlock getIcmEmpleadosdespent() {
        return icmEmpleadosdespent;
    }

    /**
     * Define el valor de la propiedad icmEmpleadosdespent.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEmpleadosdespentBlock }
     *     
     */
    public void setIcmEmpleadosdespent(IcmEmpleadosdespentBlock value) {
        this.icmEmpleadosdespent = value;
    }

    /**
     * Obtiene el valor de la propiedad icmEmpleadosdespsal.
     * 
     * @return
     *     possible object is
     *     {@link IcmEmpleadosdespsalBlock }
     *     
     */
    public IcmEmpleadosdespsalBlock getIcmEmpleadosdespsal() {
        return icmEmpleadosdespsal;
    }

    /**
     * Define el valor de la propiedad icmEmpleadosdespsal.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEmpleadosdespsalBlock }
     *     
     */
    public void setIcmEmpleadosdespsal(IcmEmpleadosdespsalBlock value) {
        this.icmEmpleadosdespsal = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParametrostienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrostiendaBlock }
     *     
     */
    public IcmParametrostiendaBlock getIcmParametrostienda() {
        return icmParametrostienda;
    }

    /**
     * Define el valor de la propiedad icmParametrostienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrostiendaBlock }
     *     
     */
    public void setIcmParametrostienda(IcmParametrostiendaBlock value) {
        this.icmParametrostienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmResultadoguardado.
     * 
     * @return
     *     possible object is
     *     {@link IcmResultadoguardadoBlock }
     *     
     */
    public IcmResultadoguardadoBlock getIcmResultadoguardado() {
        return icmResultadoguardado;
    }

    /**
     * Define el valor de la propiedad icmResultadoguardado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmResultadoguardadoBlock }
     *     
     */
    public void setIcmResultadoguardado(IcmResultadoguardadoBlock value) {
        this.icmResultadoguardado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmBandaspresupuestos.
     * 
     * @return
     *     possible object is
     *     {@link IcmBandaspresupuestosBlock }
     *     
     */
    public IcmBandaspresupuestosBlock getIcmBandaspresupuestos() {
        return icmBandaspresupuestos;
    }

    /**
     * Define el valor de la propiedad icmBandaspresupuestos.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmBandaspresupuestosBlock }
     *     
     */
    public void setIcmBandaspresupuestos(IcmBandaspresupuestosBlock value) {
        this.icmBandaspresupuestos = value;
    }

    /**
     * Obtiene el valor de la propiedad icmCalendarioempleado.
     * 
     * @return
     *     possible object is
     *     {@link IcmCalendarioempleadoBlock }
     *     
     */
    public IcmCalendarioempleadoBlock getIcmCalendarioempleado() {
        return icmCalendarioempleado;
    }

    /**
     * Define el valor de la propiedad icmCalendarioempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmCalendarioempleadoBlock }
     *     
     */
    public void setIcmCalendarioempleado(IcmCalendarioempleadoBlock value) {
        this.icmCalendarioempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParametrosempleado.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrosempleadoBlock }
     *     
     */
    public IcmParametrosempleadoBlock getIcmParametrosempleado() {
        return icmParametrosempleado;
    }

    /**
     * Define el valor de la propiedad icmParametrosempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrosempleadoBlock }
     *     
     */
    public void setIcmParametrosempleado(IcmParametrosempleadoBlock value) {
        this.icmParametrosempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmTiendacomisionable.
     * 
     * @return
     *     possible object is
     *     {@link IcmTiendacomisionableBlock }
     *     
     */
    public IcmTiendacomisionableBlock getIcmTiendacomisionable() {
        return icmTiendacomisionable;
    }

    /**
     * Define el valor de la propiedad icmTiendacomisionable.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmTiendacomisionableBlock }
     *     
     */
    public void setIcmTiendacomisionable(IcmTiendacomisionableBlock value) {
        this.icmTiendacomisionable = value;
    }

    /**
     * Obtiene el valor de la propiedad icmEmpleadosestructura.
     * 
     * @return
     *     possible object is
     *     {@link IcmEmpleadosestructuraBlock }
     *     
     */
    public IcmEmpleadosestructuraBlock getIcmEmpleadosestructura() {
        return icmEmpleadosestructura;
    }

    /**
     * Define el valor de la propiedad icmEmpleadosestructura.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEmpleadosestructuraBlock }
     *     
     */
    public void setIcmEmpleadosestructura(IcmEmpleadosestructuraBlock value) {
        this.icmEmpleadosestructura = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParametrosplantilla.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrosplantillaBlock }
     *     
     */
    public IcmParametrosplantillaBlock getIcmParametrosplantilla() {
        return icmParametrosplantilla;
    }

    /**
     * Define el valor de la propiedad icmParametrosplantilla.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrosplantillaBlock }
     *     
     */
    public void setIcmParametrosplantilla(IcmParametrosplantillaBlock value) {
        this.icmParametrosplantilla = value;
    }

    /**
     * Obtiene el valor de la propiedad icmTpcalculopaiscadena.
     * 
     * @return
     *     possible object is
     *     {@link IcmTpcalculopaiscadenaBlock }
     *     
     */
    public IcmTpcalculopaiscadenaBlock getIcmTpcalculopaiscadena() {
        return icmTpcalculopaiscadena;
    }

    /**
     * Define el valor de la propiedad icmTpcalculopaiscadena.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmTpcalculopaiscadenaBlock }
     *     
     */
    public void setIcmTpcalculopaiscadena(IcmTpcalculopaiscadenaBlock value) {
        this.icmTpcalculopaiscadena = value;
    }

    /**
     * Obtiene el valor de la propiedad icmEstadostiendaseccion.
     * 
     * @return
     *     possible object is
     *     {@link IcmEstadostiendaseccionBlock }
     *     
     */
    public IcmEstadostiendaseccionBlock getIcmEstadostiendaseccion() {
        return icmEstadostiendaseccion;
    }

    /**
     * Define el valor de la propiedad icmEstadostiendaseccion.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEstadostiendaseccionBlock }
     *     
     */
    public void setIcmEstadostiendaseccion(IcmEstadostiendaseccionBlock value) {
        this.icmEstadostiendaseccion = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParametrospaginacion.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospaginacionBlock }
     *     
     */
    public IcmParametrospaginacionBlock getIcmParametrospaginacion() {
        return icmParametrospaginacion;
    }

    /**
     * Define el valor de la propiedad icmParametrospaginacion.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospaginacionBlock }
     *     
     */
    public void setIcmParametrospaginacion(IcmParametrospaginacionBlock value) {
        this.icmParametrospaginacion = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParametrospaiscadena.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospaiscadenaBlock }
     *     
     */
    public IcmParametrospaiscadenaBlock getIcmParametrospaiscadena() {
        return icmParametrospaiscadena;
    }

    /**
     * Define el valor de la propiedad icmParametrospaiscadena.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospaiscadenaBlock }
     *     
     */
    public void setIcmParametrospaiscadena(IcmParametrospaiscadenaBlock value) {
        this.icmParametrospaiscadena = value;
    }

    /**
     * Obtiene el valor de la propiedad icmPlantillacondiciones.
     * 
     * @return
     *     possible object is
     *     {@link IcmPlantillacondicionesBlock }
     *     
     */
    public IcmPlantillacondicionesBlock getIcmPlantillacondiciones() {
        return icmPlantillacondiciones;
    }

    /**
     * Define el valor de la propiedad icmPlantillacondiciones.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmPlantillacondicionesBlock }
     *     
     */
    public void setIcmPlantillacondiciones(IcmPlantillacondicionesBlock value) {
        this.icmPlantillacondiciones = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParametrospresupuesto.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospresupuestoBlock }
     *     
     */
    public IcmParametrospresupuestoBlock getIcmParametrospresupuesto() {
        return icmParametrospresupuesto;
    }

    /**
     * Define el valor de la propiedad icmParametrospresupuesto.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospresupuestoBlock }
     *     
     */
    public void setIcmParametrospresupuesto(IcmParametrospresupuestoBlock value) {
        this.icmParametrospresupuesto = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final M4LoadobjectOutput that = ((M4LoadobjectOutput) object);
        {
            double lhsReturn;
            lhsReturn = this.getReturn();
            double rhsReturn;
            rhsReturn = that.getReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "_return", lhsReturn), LocatorUtils.property(thatLocator, "_return", rhsReturn), lhsReturn, rhsReturn, true, true)) {
                return false;
            }
        }
        {
            List<LogMessage> lhsLogMessage;
            lhsLogMessage = (((this.logMessage!= null)&&(!this.logMessage.isEmpty()))?this.getLogMessage():null);
            List<LogMessage> rhsLogMessage;
            rhsLogMessage = (((that.logMessage!= null)&&(!that.logMessage.isEmpty()))?that.getLogMessage():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "logMessage", lhsLogMessage), LocatorUtils.property(thatLocator, "logMessage", rhsLogMessage), lhsLogMessage, rhsLogMessage, ((this.logMessage!= null)&&(!this.logMessage.isEmpty())), ((that.logMessage!= null)&&(!that.logMessage.isEmpty())))) {
                return false;
            }
        }
        {
            IcmWsToolsBlock lhsIcmWsTools;
            lhsIcmWsTools = this.getIcmWsTools();
            IcmWsToolsBlock rhsIcmWsTools;
            rhsIcmWsTools = that.getIcmWsTools();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmWsTools", lhsIcmWsTools), LocatorUtils.property(thatLocator, "icmWsTools", rhsIcmWsTools), lhsIcmWsTools, rhsIcmWsTools, (this.icmWsTools!= null), (that.icmWsTools!= null))) {
                return false;
            }
        }
        {
            IcmVentamanualBlock lhsIcmVentamanual;
            lhsIcmVentamanual = this.getIcmVentamanual();
            IcmVentamanualBlock rhsIcmVentamanual;
            rhsIcmVentamanual = that.getIcmVentamanual();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmVentamanual", lhsIcmVentamanual), LocatorUtils.property(thatLocator, "icmVentamanual", rhsIcmVentamanual), lhsIcmVentamanual, rhsIcmVentamanual, (this.icmVentamanual!= null), (that.icmVentamanual!= null))) {
                return false;
            }
        }
        {
            IcmGlobaltiendaBlock lhsIcmGlobaltienda;
            lhsIcmGlobaltienda = this.getIcmGlobaltienda();
            IcmGlobaltiendaBlock rhsIcmGlobaltienda;
            rhsIcmGlobaltienda = that.getIcmGlobaltienda();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmGlobaltienda", lhsIcmGlobaltienda), LocatorUtils.property(thatLocator, "icmGlobaltienda", rhsIcmGlobaltienda), lhsIcmGlobaltienda, rhsIcmGlobaltienda, (this.icmGlobaltienda!= null), (that.icmGlobaltienda!= null))) {
                return false;
            }
        }
        {
            IcmPresupuestosBlock lhsIcmPresupuestos;
            lhsIcmPresupuestos = this.getIcmPresupuestos();
            IcmPresupuestosBlock rhsIcmPresupuestos;
            rhsIcmPresupuestos = that.getIcmPresupuestos();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmPresupuestos", lhsIcmPresupuestos), LocatorUtils.property(thatLocator, "icmPresupuestos", rhsIcmPresupuestos), lhsIcmPresupuestos, rhsIcmPresupuestos, (this.icmPresupuestos!= null), (that.icmPresupuestos!= null))) {
                return false;
            }
        }
        {
            IcmBuscadortiendaBlock lhsIcmBuscadortienda;
            lhsIcmBuscadortienda = this.getIcmBuscadortienda();
            IcmBuscadortiendaBlock rhsIcmBuscadortienda;
            rhsIcmBuscadortienda = that.getIcmBuscadortienda();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmBuscadortienda", lhsIcmBuscadortienda), LocatorUtils.property(thatLocator, "icmBuscadortienda", rhsIcmBuscadortienda), lhsIcmBuscadortienda, rhsIcmBuscadortienda, (this.icmBuscadortienda!= null), (that.icmBuscadortienda!= null))) {
                return false;
            }
        }
        {
            IcmCabeceratiendaBlock lhsIcmCabeceratienda;
            lhsIcmCabeceratienda = this.getIcmCabeceratienda();
            IcmCabeceratiendaBlock rhsIcmCabeceratienda;
            rhsIcmCabeceratienda = that.getIcmCabeceratienda();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmCabeceratienda", lhsIcmCabeceratienda), LocatorUtils.property(thatLocator, "icmCabeceratienda", rhsIcmCabeceratienda), lhsIcmCabeceratienda, rhsIcmCabeceratienda, (this.icmCabeceratienda!= null), (that.icmCabeceratienda!= null))) {
                return false;
            }
        }
        {
            IcmDatosgentiendaBlock lhsIcmDatosgentienda;
            lhsIcmDatosgentienda = this.getIcmDatosgentienda();
            IcmDatosgentiendaBlock rhsIcmDatosgentienda;
            rhsIcmDatosgentienda = that.getIcmDatosgentienda();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmDatosgentienda", lhsIcmDatosgentienda), LocatorUtils.property(thatLocator, "icmDatosgentienda", rhsIcmDatosgentienda), lhsIcmDatosgentienda, rhsIcmDatosgentienda, (this.icmDatosgentienda!= null), (that.icmDatosgentienda!= null))) {
                return false;
            }
        }
        {
            IcmGlobalempleadoBlock lhsIcmGlobalempleado;
            lhsIcmGlobalempleado = this.getIcmGlobalempleado();
            IcmGlobalempleadoBlock rhsIcmGlobalempleado;
            rhsIcmGlobalempleado = that.getIcmGlobalempleado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmGlobalempleado", lhsIcmGlobalempleado), LocatorUtils.property(thatLocator, "icmGlobalempleado", rhsIcmGlobalempleado), lhsIcmGlobalempleado, rhsIcmGlobalempleado, (this.icmGlobalempleado!= null), (that.icmGlobalempleado!= null))) {
                return false;
            }
        }
        {
            IcmWsOperacionesBlock lhsIcmWsOperaciones;
            lhsIcmWsOperaciones = this.getIcmWsOperaciones();
            IcmWsOperacionesBlock rhsIcmWsOperaciones;
            rhsIcmWsOperaciones = that.getIcmWsOperaciones();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmWsOperaciones", lhsIcmWsOperaciones), LocatorUtils.property(thatLocator, "icmWsOperaciones", rhsIcmWsOperaciones), lhsIcmWsOperaciones, rhsIcmWsOperaciones, (this.icmWsOperaciones!= null), (that.icmWsOperaciones!= null))) {
                return false;
            }
        }
        {
            IcmEmpleadostiendaBlock lhsIcmEmpleadostienda;
            lhsIcmEmpleadostienda = this.getIcmEmpleadostienda();
            IcmEmpleadostiendaBlock rhsIcmEmpleadostienda;
            rhsIcmEmpleadostienda = that.getIcmEmpleadostienda();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmEmpleadostienda", lhsIcmEmpleadostienda), LocatorUtils.property(thatLocator, "icmEmpleadostienda", rhsIcmEmpleadostienda), lhsIcmEmpleadostienda, rhsIcmEmpleadostienda, (this.icmEmpleadostienda!= null), (that.icmEmpleadostienda!= null))) {
                return false;
            }
        }
        {
            IcmParametrosexcelBlock lhsIcmParametrosexcel;
            lhsIcmParametrosexcel = this.getIcmParametrosexcel();
            IcmParametrosexcelBlock rhsIcmParametrosexcel;
            rhsIcmParametrosexcel = that.getIcmParametrosexcel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrosexcel", lhsIcmParametrosexcel), LocatorUtils.property(thatLocator, "icmParametrosexcel", rhsIcmParametrosexcel), lhsIcmParametrosexcel, rhsIcmParametrosexcel, (this.icmParametrosexcel!= null), (that.icmParametrosexcel!= null))) {
                return false;
            }
        }
        {
            IcmPresenciamanualBlock lhsIcmPresenciamanual;
            lhsIcmPresenciamanual = this.getIcmPresenciamanual();
            IcmPresenciamanualBlock rhsIcmPresenciamanual;
            rhsIcmPresenciamanual = that.getIcmPresenciamanual();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmPresenciamanual", lhsIcmPresenciamanual), LocatorUtils.property(thatLocator, "icmPresenciamanual", rhsIcmPresenciamanual), lhsIcmPresenciamanual, rhsIcmPresenciamanual, (this.icmPresenciamanual!= null), (that.icmPresenciamanual!= null))) {
                return false;
            }
        }
        {
            IcmCabeceraempleadoBlock lhsIcmCabeceraempleado;
            lhsIcmCabeceraempleado = this.getIcmCabeceraempleado();
            IcmCabeceraempleadoBlock rhsIcmCabeceraempleado;
            rhsIcmCabeceraempleado = that.getIcmCabeceraempleado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmCabeceraempleado", lhsIcmCabeceraempleado), LocatorUtils.property(thatLocator, "icmCabeceraempleado", rhsIcmCabeceraempleado), lhsIcmCabeceraempleado, rhsIcmCabeceraempleado, (this.icmCabeceraempleado!= null), (that.icmCabeceraempleado!= null))) {
                return false;
            }
        }
        {
            IcmCalendariotiendaBlock lhsIcmCalendariotienda;
            lhsIcmCalendariotienda = this.getIcmCalendariotienda();
            IcmCalendariotiendaBlock rhsIcmCalendariotienda;
            rhsIcmCalendariotienda = that.getIcmCalendariotienda();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmCalendariotienda", lhsIcmCalendariotienda), LocatorUtils.property(thatLocator, "icmCalendariotienda", rhsIcmCalendariotienda), lhsIcmCalendariotienda, rhsIcmCalendariotienda, (this.icmCalendariotienda!= null), (that.icmCalendariotienda!= null))) {
                return false;
            }
        }
        {
            IcmCondicionesventaBlock lhsIcmCondicionesventa;
            lhsIcmCondicionesventa = this.getIcmCondicionesventa();
            IcmCondicionesventaBlock rhsIcmCondicionesventa;
            rhsIcmCondicionesventa = that.getIcmCondicionesventa();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmCondicionesventa", lhsIcmCondicionesventa), LocatorUtils.property(thatLocator, "icmCondicionesventa", rhsIcmCondicionesventa), lhsIcmCondicionesventa, rhsIcmCondicionesventa, (this.icmCondicionesventa!= null), (that.icmCondicionesventa!= null))) {
                return false;
            }
        }
        {
            IcmDatosgenempleadoBlock lhsIcmDatosgenempleado;
            lhsIcmDatosgenempleado = this.getIcmDatosgenempleado();
            IcmDatosgenempleadoBlock rhsIcmDatosgenempleado;
            rhsIcmDatosgenempleado = that.getIcmDatosgenempleado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmDatosgenempleado", lhsIcmDatosgenempleado), LocatorUtils.property(thatLocator, "icmDatosgenempleado", rhsIcmDatosgenempleado), lhsIcmDatosgenempleado, rhsIcmDatosgenempleado, (this.icmDatosgenempleado!= null), (that.icmDatosgenempleado!= null))) {
                return false;
            }
        }
        {
            IcmEmpleadosdespentBlock lhsIcmEmpleadosdespent;
            lhsIcmEmpleadosdespent = this.getIcmEmpleadosdespent();
            IcmEmpleadosdespentBlock rhsIcmEmpleadosdespent;
            rhsIcmEmpleadosdespent = that.getIcmEmpleadosdespent();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmEmpleadosdespent", lhsIcmEmpleadosdespent), LocatorUtils.property(thatLocator, "icmEmpleadosdespent", rhsIcmEmpleadosdespent), lhsIcmEmpleadosdespent, rhsIcmEmpleadosdespent, (this.icmEmpleadosdespent!= null), (that.icmEmpleadosdespent!= null))) {
                return false;
            }
        }
        {
            IcmEmpleadosdespsalBlock lhsIcmEmpleadosdespsal;
            lhsIcmEmpleadosdespsal = this.getIcmEmpleadosdespsal();
            IcmEmpleadosdespsalBlock rhsIcmEmpleadosdespsal;
            rhsIcmEmpleadosdespsal = that.getIcmEmpleadosdespsal();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmEmpleadosdespsal", lhsIcmEmpleadosdespsal), LocatorUtils.property(thatLocator, "icmEmpleadosdespsal", rhsIcmEmpleadosdespsal), lhsIcmEmpleadosdespsal, rhsIcmEmpleadosdespsal, (this.icmEmpleadosdespsal!= null), (that.icmEmpleadosdespsal!= null))) {
                return false;
            }
        }
        {
            IcmParametrostiendaBlock lhsIcmParametrostienda;
            lhsIcmParametrostienda = this.getIcmParametrostienda();
            IcmParametrostiendaBlock rhsIcmParametrostienda;
            rhsIcmParametrostienda = that.getIcmParametrostienda();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrostienda", lhsIcmParametrostienda), LocatorUtils.property(thatLocator, "icmParametrostienda", rhsIcmParametrostienda), lhsIcmParametrostienda, rhsIcmParametrostienda, (this.icmParametrostienda!= null), (that.icmParametrostienda!= null))) {
                return false;
            }
        }
        {
            IcmResultadoguardadoBlock lhsIcmResultadoguardado;
            lhsIcmResultadoguardado = this.getIcmResultadoguardado();
            IcmResultadoguardadoBlock rhsIcmResultadoguardado;
            rhsIcmResultadoguardado = that.getIcmResultadoguardado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmResultadoguardado", lhsIcmResultadoguardado), LocatorUtils.property(thatLocator, "icmResultadoguardado", rhsIcmResultadoguardado), lhsIcmResultadoguardado, rhsIcmResultadoguardado, (this.icmResultadoguardado!= null), (that.icmResultadoguardado!= null))) {
                return false;
            }
        }
        {
            IcmBandaspresupuestosBlock lhsIcmBandaspresupuestos;
            lhsIcmBandaspresupuestos = this.getIcmBandaspresupuestos();
            IcmBandaspresupuestosBlock rhsIcmBandaspresupuestos;
            rhsIcmBandaspresupuestos = that.getIcmBandaspresupuestos();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmBandaspresupuestos", lhsIcmBandaspresupuestos), LocatorUtils.property(thatLocator, "icmBandaspresupuestos", rhsIcmBandaspresupuestos), lhsIcmBandaspresupuestos, rhsIcmBandaspresupuestos, (this.icmBandaspresupuestos!= null), (that.icmBandaspresupuestos!= null))) {
                return false;
            }
        }
        {
            IcmCalendarioempleadoBlock lhsIcmCalendarioempleado;
            lhsIcmCalendarioempleado = this.getIcmCalendarioempleado();
            IcmCalendarioempleadoBlock rhsIcmCalendarioempleado;
            rhsIcmCalendarioempleado = that.getIcmCalendarioempleado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmCalendarioempleado", lhsIcmCalendarioempleado), LocatorUtils.property(thatLocator, "icmCalendarioempleado", rhsIcmCalendarioempleado), lhsIcmCalendarioempleado, rhsIcmCalendarioempleado, (this.icmCalendarioempleado!= null), (that.icmCalendarioempleado!= null))) {
                return false;
            }
        }
        {
            IcmParametrosempleadoBlock lhsIcmParametrosempleado;
            lhsIcmParametrosempleado = this.getIcmParametrosempleado();
            IcmParametrosempleadoBlock rhsIcmParametrosempleado;
            rhsIcmParametrosempleado = that.getIcmParametrosempleado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrosempleado", lhsIcmParametrosempleado), LocatorUtils.property(thatLocator, "icmParametrosempleado", rhsIcmParametrosempleado), lhsIcmParametrosempleado, rhsIcmParametrosempleado, (this.icmParametrosempleado!= null), (that.icmParametrosempleado!= null))) {
                return false;
            }
        }
        {
            IcmTiendacomisionableBlock lhsIcmTiendacomisionable;
            lhsIcmTiendacomisionable = this.getIcmTiendacomisionable();
            IcmTiendacomisionableBlock rhsIcmTiendacomisionable;
            rhsIcmTiendacomisionable = that.getIcmTiendacomisionable();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmTiendacomisionable", lhsIcmTiendacomisionable), LocatorUtils.property(thatLocator, "icmTiendacomisionable", rhsIcmTiendacomisionable), lhsIcmTiendacomisionable, rhsIcmTiendacomisionable, (this.icmTiendacomisionable!= null), (that.icmTiendacomisionable!= null))) {
                return false;
            }
        }
        {
            IcmEmpleadosestructuraBlock lhsIcmEmpleadosestructura;
            lhsIcmEmpleadosestructura = this.getIcmEmpleadosestructura();
            IcmEmpleadosestructuraBlock rhsIcmEmpleadosestructura;
            rhsIcmEmpleadosestructura = that.getIcmEmpleadosestructura();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmEmpleadosestructura", lhsIcmEmpleadosestructura), LocatorUtils.property(thatLocator, "icmEmpleadosestructura", rhsIcmEmpleadosestructura), lhsIcmEmpleadosestructura, rhsIcmEmpleadosestructura, (this.icmEmpleadosestructura!= null), (that.icmEmpleadosestructura!= null))) {
                return false;
            }
        }
        {
            IcmParametrosplantillaBlock lhsIcmParametrosplantilla;
            lhsIcmParametrosplantilla = this.getIcmParametrosplantilla();
            IcmParametrosplantillaBlock rhsIcmParametrosplantilla;
            rhsIcmParametrosplantilla = that.getIcmParametrosplantilla();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrosplantilla", lhsIcmParametrosplantilla), LocatorUtils.property(thatLocator, "icmParametrosplantilla", rhsIcmParametrosplantilla), lhsIcmParametrosplantilla, rhsIcmParametrosplantilla, (this.icmParametrosplantilla!= null), (that.icmParametrosplantilla!= null))) {
                return false;
            }
        }
        {
            IcmTpcalculopaiscadenaBlock lhsIcmTpcalculopaiscadena;
            lhsIcmTpcalculopaiscadena = this.getIcmTpcalculopaiscadena();
            IcmTpcalculopaiscadenaBlock rhsIcmTpcalculopaiscadena;
            rhsIcmTpcalculopaiscadena = that.getIcmTpcalculopaiscadena();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmTpcalculopaiscadena", lhsIcmTpcalculopaiscadena), LocatorUtils.property(thatLocator, "icmTpcalculopaiscadena", rhsIcmTpcalculopaiscadena), lhsIcmTpcalculopaiscadena, rhsIcmTpcalculopaiscadena, (this.icmTpcalculopaiscadena!= null), (that.icmTpcalculopaiscadena!= null))) {
                return false;
            }
        }
        {
            IcmEstadostiendaseccionBlock lhsIcmEstadostiendaseccion;
            lhsIcmEstadostiendaseccion = this.getIcmEstadostiendaseccion();
            IcmEstadostiendaseccionBlock rhsIcmEstadostiendaseccion;
            rhsIcmEstadostiendaseccion = that.getIcmEstadostiendaseccion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmEstadostiendaseccion", lhsIcmEstadostiendaseccion), LocatorUtils.property(thatLocator, "icmEstadostiendaseccion", rhsIcmEstadostiendaseccion), lhsIcmEstadostiendaseccion, rhsIcmEstadostiendaseccion, (this.icmEstadostiendaseccion!= null), (that.icmEstadostiendaseccion!= null))) {
                return false;
            }
        }
        {
            IcmParametrospaginacionBlock lhsIcmParametrospaginacion;
            lhsIcmParametrospaginacion = this.getIcmParametrospaginacion();
            IcmParametrospaginacionBlock rhsIcmParametrospaginacion;
            rhsIcmParametrospaginacion = that.getIcmParametrospaginacion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrospaginacion", lhsIcmParametrospaginacion), LocatorUtils.property(thatLocator, "icmParametrospaginacion", rhsIcmParametrospaginacion), lhsIcmParametrospaginacion, rhsIcmParametrospaginacion, (this.icmParametrospaginacion!= null), (that.icmParametrospaginacion!= null))) {
                return false;
            }
        }
        {
            IcmParametrospaiscadenaBlock lhsIcmParametrospaiscadena;
            lhsIcmParametrospaiscadena = this.getIcmParametrospaiscadena();
            IcmParametrospaiscadenaBlock rhsIcmParametrospaiscadena;
            rhsIcmParametrospaiscadena = that.getIcmParametrospaiscadena();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrospaiscadena", lhsIcmParametrospaiscadena), LocatorUtils.property(thatLocator, "icmParametrospaiscadena", rhsIcmParametrospaiscadena), lhsIcmParametrospaiscadena, rhsIcmParametrospaiscadena, (this.icmParametrospaiscadena!= null), (that.icmParametrospaiscadena!= null))) {
                return false;
            }
        }
        {
            IcmPlantillacondicionesBlock lhsIcmPlantillacondiciones;
            lhsIcmPlantillacondiciones = this.getIcmPlantillacondiciones();
            IcmPlantillacondicionesBlock rhsIcmPlantillacondiciones;
            rhsIcmPlantillacondiciones = that.getIcmPlantillacondiciones();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmPlantillacondiciones", lhsIcmPlantillacondiciones), LocatorUtils.property(thatLocator, "icmPlantillacondiciones", rhsIcmPlantillacondiciones), lhsIcmPlantillacondiciones, rhsIcmPlantillacondiciones, (this.icmPlantillacondiciones!= null), (that.icmPlantillacondiciones!= null))) {
                return false;
            }
        }
        {
            IcmParametrospresupuestoBlock lhsIcmParametrospresupuesto;
            lhsIcmParametrospresupuesto = this.getIcmParametrospresupuesto();
            IcmParametrospresupuestoBlock rhsIcmParametrospresupuesto;
            rhsIcmParametrospresupuesto = that.getIcmParametrospresupuesto();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrospresupuesto", lhsIcmParametrospresupuesto), LocatorUtils.property(thatLocator, "icmParametrospresupuesto", rhsIcmParametrospresupuesto), lhsIcmParametrospresupuesto, rhsIcmParametrospresupuesto, (this.icmParametrospresupuesto!= null), (that.icmParametrospresupuesto!= null))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
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
            double theReturn;
            theReturn = this.getReturn();
            strategy.appendField(locator, this, "_return", buffer, theReturn, true);
        }
        {
            List<LogMessage> theLogMessage;
            theLogMessage = (((this.logMessage!= null)&&(!this.logMessage.isEmpty()))?this.getLogMessage():null);
            strategy.appendField(locator, this, "logMessage", buffer, theLogMessage, ((this.logMessage!= null)&&(!this.logMessage.isEmpty())));
        }
        {
            IcmWsToolsBlock theIcmWsTools;
            theIcmWsTools = this.getIcmWsTools();
            strategy.appendField(locator, this, "icmWsTools", buffer, theIcmWsTools, (this.icmWsTools!= null));
        }
        {
            IcmVentamanualBlock theIcmVentamanual;
            theIcmVentamanual = this.getIcmVentamanual();
            strategy.appendField(locator, this, "icmVentamanual", buffer, theIcmVentamanual, (this.icmVentamanual!= null));
        }
        {
            IcmGlobaltiendaBlock theIcmGlobaltienda;
            theIcmGlobaltienda = this.getIcmGlobaltienda();
            strategy.appendField(locator, this, "icmGlobaltienda", buffer, theIcmGlobaltienda, (this.icmGlobaltienda!= null));
        }
        {
            IcmPresupuestosBlock theIcmPresupuestos;
            theIcmPresupuestos = this.getIcmPresupuestos();
            strategy.appendField(locator, this, "icmPresupuestos", buffer, theIcmPresupuestos, (this.icmPresupuestos!= null));
        }
        {
            IcmBuscadortiendaBlock theIcmBuscadortienda;
            theIcmBuscadortienda = this.getIcmBuscadortienda();
            strategy.appendField(locator, this, "icmBuscadortienda", buffer, theIcmBuscadortienda, (this.icmBuscadortienda!= null));
        }
        {
            IcmCabeceratiendaBlock theIcmCabeceratienda;
            theIcmCabeceratienda = this.getIcmCabeceratienda();
            strategy.appendField(locator, this, "icmCabeceratienda", buffer, theIcmCabeceratienda, (this.icmCabeceratienda!= null));
        }
        {
            IcmDatosgentiendaBlock theIcmDatosgentienda;
            theIcmDatosgentienda = this.getIcmDatosgentienda();
            strategy.appendField(locator, this, "icmDatosgentienda", buffer, theIcmDatosgentienda, (this.icmDatosgentienda!= null));
        }
        {
            IcmGlobalempleadoBlock theIcmGlobalempleado;
            theIcmGlobalempleado = this.getIcmGlobalempleado();
            strategy.appendField(locator, this, "icmGlobalempleado", buffer, theIcmGlobalempleado, (this.icmGlobalempleado!= null));
        }
        {
            IcmWsOperacionesBlock theIcmWsOperaciones;
            theIcmWsOperaciones = this.getIcmWsOperaciones();
            strategy.appendField(locator, this, "icmWsOperaciones", buffer, theIcmWsOperaciones, (this.icmWsOperaciones!= null));
        }
        {
            IcmEmpleadostiendaBlock theIcmEmpleadostienda;
            theIcmEmpleadostienda = this.getIcmEmpleadostienda();
            strategy.appendField(locator, this, "icmEmpleadostienda", buffer, theIcmEmpleadostienda, (this.icmEmpleadostienda!= null));
        }
        {
            IcmParametrosexcelBlock theIcmParametrosexcel;
            theIcmParametrosexcel = this.getIcmParametrosexcel();
            strategy.appendField(locator, this, "icmParametrosexcel", buffer, theIcmParametrosexcel, (this.icmParametrosexcel!= null));
        }
        {
            IcmPresenciamanualBlock theIcmPresenciamanual;
            theIcmPresenciamanual = this.getIcmPresenciamanual();
            strategy.appendField(locator, this, "icmPresenciamanual", buffer, theIcmPresenciamanual, (this.icmPresenciamanual!= null));
        }
        {
            IcmCabeceraempleadoBlock theIcmCabeceraempleado;
            theIcmCabeceraempleado = this.getIcmCabeceraempleado();
            strategy.appendField(locator, this, "icmCabeceraempleado", buffer, theIcmCabeceraempleado, (this.icmCabeceraempleado!= null));
        }
        {
            IcmCalendariotiendaBlock theIcmCalendariotienda;
            theIcmCalendariotienda = this.getIcmCalendariotienda();
            strategy.appendField(locator, this, "icmCalendariotienda", buffer, theIcmCalendariotienda, (this.icmCalendariotienda!= null));
        }
        {
            IcmCondicionesventaBlock theIcmCondicionesventa;
            theIcmCondicionesventa = this.getIcmCondicionesventa();
            strategy.appendField(locator, this, "icmCondicionesventa", buffer, theIcmCondicionesventa, (this.icmCondicionesventa!= null));
        }
        {
            IcmDatosgenempleadoBlock theIcmDatosgenempleado;
            theIcmDatosgenempleado = this.getIcmDatosgenempleado();
            strategy.appendField(locator, this, "icmDatosgenempleado", buffer, theIcmDatosgenempleado, (this.icmDatosgenempleado!= null));
        }
        {
            IcmEmpleadosdespentBlock theIcmEmpleadosdespent;
            theIcmEmpleadosdespent = this.getIcmEmpleadosdespent();
            strategy.appendField(locator, this, "icmEmpleadosdespent", buffer, theIcmEmpleadosdespent, (this.icmEmpleadosdespent!= null));
        }
        {
            IcmEmpleadosdespsalBlock theIcmEmpleadosdespsal;
            theIcmEmpleadosdespsal = this.getIcmEmpleadosdespsal();
            strategy.appendField(locator, this, "icmEmpleadosdespsal", buffer, theIcmEmpleadosdespsal, (this.icmEmpleadosdespsal!= null));
        }
        {
            IcmParametrostiendaBlock theIcmParametrostienda;
            theIcmParametrostienda = this.getIcmParametrostienda();
            strategy.appendField(locator, this, "icmParametrostienda", buffer, theIcmParametrostienda, (this.icmParametrostienda!= null));
        }
        {
            IcmResultadoguardadoBlock theIcmResultadoguardado;
            theIcmResultadoguardado = this.getIcmResultadoguardado();
            strategy.appendField(locator, this, "icmResultadoguardado", buffer, theIcmResultadoguardado, (this.icmResultadoguardado!= null));
        }
        {
            IcmBandaspresupuestosBlock theIcmBandaspresupuestos;
            theIcmBandaspresupuestos = this.getIcmBandaspresupuestos();
            strategy.appendField(locator, this, "icmBandaspresupuestos", buffer, theIcmBandaspresupuestos, (this.icmBandaspresupuestos!= null));
        }
        {
            IcmCalendarioempleadoBlock theIcmCalendarioempleado;
            theIcmCalendarioempleado = this.getIcmCalendarioempleado();
            strategy.appendField(locator, this, "icmCalendarioempleado", buffer, theIcmCalendarioempleado, (this.icmCalendarioempleado!= null));
        }
        {
            IcmParametrosempleadoBlock theIcmParametrosempleado;
            theIcmParametrosempleado = this.getIcmParametrosempleado();
            strategy.appendField(locator, this, "icmParametrosempleado", buffer, theIcmParametrosempleado, (this.icmParametrosempleado!= null));
        }
        {
            IcmTiendacomisionableBlock theIcmTiendacomisionable;
            theIcmTiendacomisionable = this.getIcmTiendacomisionable();
            strategy.appendField(locator, this, "icmTiendacomisionable", buffer, theIcmTiendacomisionable, (this.icmTiendacomisionable!= null));
        }
        {
            IcmEmpleadosestructuraBlock theIcmEmpleadosestructura;
            theIcmEmpleadosestructura = this.getIcmEmpleadosestructura();
            strategy.appendField(locator, this, "icmEmpleadosestructura", buffer, theIcmEmpleadosestructura, (this.icmEmpleadosestructura!= null));
        }
        {
            IcmParametrosplantillaBlock theIcmParametrosplantilla;
            theIcmParametrosplantilla = this.getIcmParametrosplantilla();
            strategy.appendField(locator, this, "icmParametrosplantilla", buffer, theIcmParametrosplantilla, (this.icmParametrosplantilla!= null));
        }
        {
            IcmTpcalculopaiscadenaBlock theIcmTpcalculopaiscadena;
            theIcmTpcalculopaiscadena = this.getIcmTpcalculopaiscadena();
            strategy.appendField(locator, this, "icmTpcalculopaiscadena", buffer, theIcmTpcalculopaiscadena, (this.icmTpcalculopaiscadena!= null));
        }
        {
            IcmEstadostiendaseccionBlock theIcmEstadostiendaseccion;
            theIcmEstadostiendaseccion = this.getIcmEstadostiendaseccion();
            strategy.appendField(locator, this, "icmEstadostiendaseccion", buffer, theIcmEstadostiendaseccion, (this.icmEstadostiendaseccion!= null));
        }
        {
            IcmParametrospaginacionBlock theIcmParametrospaginacion;
            theIcmParametrospaginacion = this.getIcmParametrospaginacion();
            strategy.appendField(locator, this, "icmParametrospaginacion", buffer, theIcmParametrospaginacion, (this.icmParametrospaginacion!= null));
        }
        {
            IcmParametrospaiscadenaBlock theIcmParametrospaiscadena;
            theIcmParametrospaiscadena = this.getIcmParametrospaiscadena();
            strategy.appendField(locator, this, "icmParametrospaiscadena", buffer, theIcmParametrospaiscadena, (this.icmParametrospaiscadena!= null));
        }
        {
            IcmPlantillacondicionesBlock theIcmPlantillacondiciones;
            theIcmPlantillacondiciones = this.getIcmPlantillacondiciones();
            strategy.appendField(locator, this, "icmPlantillacondiciones", buffer, theIcmPlantillacondiciones, (this.icmPlantillacondiciones!= null));
        }
        {
            IcmParametrospresupuestoBlock theIcmParametrospresupuesto;
            theIcmParametrospresupuesto = this.getIcmParametrospresupuesto();
            strategy.appendField(locator, this, "icmParametrospresupuesto", buffer, theIcmParametrospresupuesto, (this.icmParametrospresupuesto!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            double theReturn;
            theReturn = this.getReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "_return", theReturn), currentHashCode, theReturn, true);
        }
        {
            List<LogMessage> theLogMessage;
            theLogMessage = (((this.logMessage!= null)&&(!this.logMessage.isEmpty()))?this.getLogMessage():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "logMessage", theLogMessage), currentHashCode, theLogMessage, ((this.logMessage!= null)&&(!this.logMessage.isEmpty())));
        }
        {
            IcmWsToolsBlock theIcmWsTools;
            theIcmWsTools = this.getIcmWsTools();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmWsTools", theIcmWsTools), currentHashCode, theIcmWsTools, (this.icmWsTools!= null));
        }
        {
            IcmVentamanualBlock theIcmVentamanual;
            theIcmVentamanual = this.getIcmVentamanual();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmVentamanual", theIcmVentamanual), currentHashCode, theIcmVentamanual, (this.icmVentamanual!= null));
        }
        {
            IcmGlobaltiendaBlock theIcmGlobaltienda;
            theIcmGlobaltienda = this.getIcmGlobaltienda();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmGlobaltienda", theIcmGlobaltienda), currentHashCode, theIcmGlobaltienda, (this.icmGlobaltienda!= null));
        }
        {
            IcmPresupuestosBlock theIcmPresupuestos;
            theIcmPresupuestos = this.getIcmPresupuestos();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmPresupuestos", theIcmPresupuestos), currentHashCode, theIcmPresupuestos, (this.icmPresupuestos!= null));
        }
        {
            IcmBuscadortiendaBlock theIcmBuscadortienda;
            theIcmBuscadortienda = this.getIcmBuscadortienda();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmBuscadortienda", theIcmBuscadortienda), currentHashCode, theIcmBuscadortienda, (this.icmBuscadortienda!= null));
        }
        {
            IcmCabeceratiendaBlock theIcmCabeceratienda;
            theIcmCabeceratienda = this.getIcmCabeceratienda();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmCabeceratienda", theIcmCabeceratienda), currentHashCode, theIcmCabeceratienda, (this.icmCabeceratienda!= null));
        }
        {
            IcmDatosgentiendaBlock theIcmDatosgentienda;
            theIcmDatosgentienda = this.getIcmDatosgentienda();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmDatosgentienda", theIcmDatosgentienda), currentHashCode, theIcmDatosgentienda, (this.icmDatosgentienda!= null));
        }
        {
            IcmGlobalempleadoBlock theIcmGlobalempleado;
            theIcmGlobalempleado = this.getIcmGlobalempleado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmGlobalempleado", theIcmGlobalempleado), currentHashCode, theIcmGlobalempleado, (this.icmGlobalempleado!= null));
        }
        {
            IcmWsOperacionesBlock theIcmWsOperaciones;
            theIcmWsOperaciones = this.getIcmWsOperaciones();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmWsOperaciones", theIcmWsOperaciones), currentHashCode, theIcmWsOperaciones, (this.icmWsOperaciones!= null));
        }
        {
            IcmEmpleadostiendaBlock theIcmEmpleadostienda;
            theIcmEmpleadostienda = this.getIcmEmpleadostienda();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmEmpleadostienda", theIcmEmpleadostienda), currentHashCode, theIcmEmpleadostienda, (this.icmEmpleadostienda!= null));
        }
        {
            IcmParametrosexcelBlock theIcmParametrosexcel;
            theIcmParametrosexcel = this.getIcmParametrosexcel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrosexcel", theIcmParametrosexcel), currentHashCode, theIcmParametrosexcel, (this.icmParametrosexcel!= null));
        }
        {
            IcmPresenciamanualBlock theIcmPresenciamanual;
            theIcmPresenciamanual = this.getIcmPresenciamanual();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmPresenciamanual", theIcmPresenciamanual), currentHashCode, theIcmPresenciamanual, (this.icmPresenciamanual!= null));
        }
        {
            IcmCabeceraempleadoBlock theIcmCabeceraempleado;
            theIcmCabeceraempleado = this.getIcmCabeceraempleado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmCabeceraempleado", theIcmCabeceraempleado), currentHashCode, theIcmCabeceraempleado, (this.icmCabeceraempleado!= null));
        }
        {
            IcmCalendariotiendaBlock theIcmCalendariotienda;
            theIcmCalendariotienda = this.getIcmCalendariotienda();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmCalendariotienda", theIcmCalendariotienda), currentHashCode, theIcmCalendariotienda, (this.icmCalendariotienda!= null));
        }
        {
            IcmCondicionesventaBlock theIcmCondicionesventa;
            theIcmCondicionesventa = this.getIcmCondicionesventa();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmCondicionesventa", theIcmCondicionesventa), currentHashCode, theIcmCondicionesventa, (this.icmCondicionesventa!= null));
        }
        {
            IcmDatosgenempleadoBlock theIcmDatosgenempleado;
            theIcmDatosgenempleado = this.getIcmDatosgenempleado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmDatosgenempleado", theIcmDatosgenempleado), currentHashCode, theIcmDatosgenempleado, (this.icmDatosgenempleado!= null));
        }
        {
            IcmEmpleadosdespentBlock theIcmEmpleadosdespent;
            theIcmEmpleadosdespent = this.getIcmEmpleadosdespent();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmEmpleadosdespent", theIcmEmpleadosdespent), currentHashCode, theIcmEmpleadosdespent, (this.icmEmpleadosdespent!= null));
        }
        {
            IcmEmpleadosdespsalBlock theIcmEmpleadosdespsal;
            theIcmEmpleadosdespsal = this.getIcmEmpleadosdespsal();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmEmpleadosdespsal", theIcmEmpleadosdespsal), currentHashCode, theIcmEmpleadosdespsal, (this.icmEmpleadosdespsal!= null));
        }
        {
            IcmParametrostiendaBlock theIcmParametrostienda;
            theIcmParametrostienda = this.getIcmParametrostienda();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrostienda", theIcmParametrostienda), currentHashCode, theIcmParametrostienda, (this.icmParametrostienda!= null));
        }
        {
            IcmResultadoguardadoBlock theIcmResultadoguardado;
            theIcmResultadoguardado = this.getIcmResultadoguardado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmResultadoguardado", theIcmResultadoguardado), currentHashCode, theIcmResultadoguardado, (this.icmResultadoguardado!= null));
        }
        {
            IcmBandaspresupuestosBlock theIcmBandaspresupuestos;
            theIcmBandaspresupuestos = this.getIcmBandaspresupuestos();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmBandaspresupuestos", theIcmBandaspresupuestos), currentHashCode, theIcmBandaspresupuestos, (this.icmBandaspresupuestos!= null));
        }
        {
            IcmCalendarioempleadoBlock theIcmCalendarioempleado;
            theIcmCalendarioempleado = this.getIcmCalendarioempleado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmCalendarioempleado", theIcmCalendarioempleado), currentHashCode, theIcmCalendarioempleado, (this.icmCalendarioempleado!= null));
        }
        {
            IcmParametrosempleadoBlock theIcmParametrosempleado;
            theIcmParametrosempleado = this.getIcmParametrosempleado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrosempleado", theIcmParametrosempleado), currentHashCode, theIcmParametrosempleado, (this.icmParametrosempleado!= null));
        }
        {
            IcmTiendacomisionableBlock theIcmTiendacomisionable;
            theIcmTiendacomisionable = this.getIcmTiendacomisionable();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmTiendacomisionable", theIcmTiendacomisionable), currentHashCode, theIcmTiendacomisionable, (this.icmTiendacomisionable!= null));
        }
        {
            IcmEmpleadosestructuraBlock theIcmEmpleadosestructura;
            theIcmEmpleadosestructura = this.getIcmEmpleadosestructura();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmEmpleadosestructura", theIcmEmpleadosestructura), currentHashCode, theIcmEmpleadosestructura, (this.icmEmpleadosestructura!= null));
        }
        {
            IcmParametrosplantillaBlock theIcmParametrosplantilla;
            theIcmParametrosplantilla = this.getIcmParametrosplantilla();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrosplantilla", theIcmParametrosplantilla), currentHashCode, theIcmParametrosplantilla, (this.icmParametrosplantilla!= null));
        }
        {
            IcmTpcalculopaiscadenaBlock theIcmTpcalculopaiscadena;
            theIcmTpcalculopaiscadena = this.getIcmTpcalculopaiscadena();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmTpcalculopaiscadena", theIcmTpcalculopaiscadena), currentHashCode, theIcmTpcalculopaiscadena, (this.icmTpcalculopaiscadena!= null));
        }
        {
            IcmEstadostiendaseccionBlock theIcmEstadostiendaseccion;
            theIcmEstadostiendaseccion = this.getIcmEstadostiendaseccion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmEstadostiendaseccion", theIcmEstadostiendaseccion), currentHashCode, theIcmEstadostiendaseccion, (this.icmEstadostiendaseccion!= null));
        }
        {
            IcmParametrospaginacionBlock theIcmParametrospaginacion;
            theIcmParametrospaginacion = this.getIcmParametrospaginacion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrospaginacion", theIcmParametrospaginacion), currentHashCode, theIcmParametrospaginacion, (this.icmParametrospaginacion!= null));
        }
        {
            IcmParametrospaiscadenaBlock theIcmParametrospaiscadena;
            theIcmParametrospaiscadena = this.getIcmParametrospaiscadena();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrospaiscadena", theIcmParametrospaiscadena), currentHashCode, theIcmParametrospaiscadena, (this.icmParametrospaiscadena!= null));
        }
        {
            IcmPlantillacondicionesBlock theIcmPlantillacondiciones;
            theIcmPlantillacondiciones = this.getIcmPlantillacondiciones();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmPlantillacondiciones", theIcmPlantillacondiciones), currentHashCode, theIcmPlantillacondiciones, (this.icmPlantillacondiciones!= null));
        }
        {
            IcmParametrospresupuestoBlock theIcmParametrospresupuesto;
            theIcmParametrospresupuesto = this.getIcmParametrospresupuesto();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrospresupuesto", theIcmParametrospresupuesto), currentHashCode, theIcmParametrospresupuesto, (this.icmParametrospresupuesto!= null));
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof M4LoadobjectOutput) {
            final M4LoadobjectOutput copy = ((M4LoadobjectOutput) draftCopy);
            {
                Boolean _returnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, true);
                if (_returnShouldBeCopiedAndSet == Boolean.TRUE) {
                    double sourceReturn;
                    sourceReturn = this.getReturn();
                    double copyReturn = strategy.copy(LocatorUtils.property(locator, "_return", sourceReturn), sourceReturn, true);
                    copy.setReturn(copyReturn);
                } else {
                    if (_returnShouldBeCopiedAndSet == Boolean.FALSE) {
                    }
                }
            }
            {
                Boolean logMessageShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.logMessage!= null)&&(!this.logMessage.isEmpty())));
                if (logMessageShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<LogMessage> sourceLogMessage;
                    sourceLogMessage = (((this.logMessage!= null)&&(!this.logMessage.isEmpty()))?this.getLogMessage():null);
                    @SuppressWarnings("unchecked")
                    List<LogMessage> copyLogMessage = ((List<LogMessage> ) strategy.copy(LocatorUtils.property(locator, "logMessage", sourceLogMessage), sourceLogMessage, ((this.logMessage!= null)&&(!this.logMessage.isEmpty()))));
                    copy.logMessage = null;
                    if (copyLogMessage!= null) {
                        List<LogMessage> uniqueLogMessagel = copy.getLogMessage();
                        uniqueLogMessagel.addAll(copyLogMessage);
                    }
                } else {
                    if (logMessageShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.logMessage = null;
                    }
                }
            }
            {
                Boolean icmWsToolsShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmWsTools!= null));
                if (icmWsToolsShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmWsToolsBlock sourceIcmWsTools;
                    sourceIcmWsTools = this.getIcmWsTools();
                    IcmWsToolsBlock copyIcmWsTools = ((IcmWsToolsBlock) strategy.copy(LocatorUtils.property(locator, "icmWsTools", sourceIcmWsTools), sourceIcmWsTools, (this.icmWsTools!= null)));
                    copy.setIcmWsTools(copyIcmWsTools);
                } else {
                    if (icmWsToolsShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmWsTools = null;
                    }
                }
            }
            {
                Boolean icmVentamanualShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmVentamanual!= null));
                if (icmVentamanualShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmVentamanualBlock sourceIcmVentamanual;
                    sourceIcmVentamanual = this.getIcmVentamanual();
                    IcmVentamanualBlock copyIcmVentamanual = ((IcmVentamanualBlock) strategy.copy(LocatorUtils.property(locator, "icmVentamanual", sourceIcmVentamanual), sourceIcmVentamanual, (this.icmVentamanual!= null)));
                    copy.setIcmVentamanual(copyIcmVentamanual);
                } else {
                    if (icmVentamanualShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmVentamanual = null;
                    }
                }
            }
            {
                Boolean icmGlobaltiendaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmGlobaltienda!= null));
                if (icmGlobaltiendaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmGlobaltiendaBlock sourceIcmGlobaltienda;
                    sourceIcmGlobaltienda = this.getIcmGlobaltienda();
                    IcmGlobaltiendaBlock copyIcmGlobaltienda = ((IcmGlobaltiendaBlock) strategy.copy(LocatorUtils.property(locator, "icmGlobaltienda", sourceIcmGlobaltienda), sourceIcmGlobaltienda, (this.icmGlobaltienda!= null)));
                    copy.setIcmGlobaltienda(copyIcmGlobaltienda);
                } else {
                    if (icmGlobaltiendaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmGlobaltienda = null;
                    }
                }
            }
            {
                Boolean icmPresupuestosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmPresupuestos!= null));
                if (icmPresupuestosShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmPresupuestosBlock sourceIcmPresupuestos;
                    sourceIcmPresupuestos = this.getIcmPresupuestos();
                    IcmPresupuestosBlock copyIcmPresupuestos = ((IcmPresupuestosBlock) strategy.copy(LocatorUtils.property(locator, "icmPresupuestos", sourceIcmPresupuestos), sourceIcmPresupuestos, (this.icmPresupuestos!= null)));
                    copy.setIcmPresupuestos(copyIcmPresupuestos);
                } else {
                    if (icmPresupuestosShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmPresupuestos = null;
                    }
                }
            }
            {
                Boolean icmBuscadortiendaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmBuscadortienda!= null));
                if (icmBuscadortiendaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmBuscadortiendaBlock sourceIcmBuscadortienda;
                    sourceIcmBuscadortienda = this.getIcmBuscadortienda();
                    IcmBuscadortiendaBlock copyIcmBuscadortienda = ((IcmBuscadortiendaBlock) strategy.copy(LocatorUtils.property(locator, "icmBuscadortienda", sourceIcmBuscadortienda), sourceIcmBuscadortienda, (this.icmBuscadortienda!= null)));
                    copy.setIcmBuscadortienda(copyIcmBuscadortienda);
                } else {
                    if (icmBuscadortiendaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmBuscadortienda = null;
                    }
                }
            }
            {
                Boolean icmCabeceratiendaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmCabeceratienda!= null));
                if (icmCabeceratiendaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmCabeceratiendaBlock sourceIcmCabeceratienda;
                    sourceIcmCabeceratienda = this.getIcmCabeceratienda();
                    IcmCabeceratiendaBlock copyIcmCabeceratienda = ((IcmCabeceratiendaBlock) strategy.copy(LocatorUtils.property(locator, "icmCabeceratienda", sourceIcmCabeceratienda), sourceIcmCabeceratienda, (this.icmCabeceratienda!= null)));
                    copy.setIcmCabeceratienda(copyIcmCabeceratienda);
                } else {
                    if (icmCabeceratiendaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmCabeceratienda = null;
                    }
                }
            }
            {
                Boolean icmDatosgentiendaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmDatosgentienda!= null));
                if (icmDatosgentiendaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmDatosgentiendaBlock sourceIcmDatosgentienda;
                    sourceIcmDatosgentienda = this.getIcmDatosgentienda();
                    IcmDatosgentiendaBlock copyIcmDatosgentienda = ((IcmDatosgentiendaBlock) strategy.copy(LocatorUtils.property(locator, "icmDatosgentienda", sourceIcmDatosgentienda), sourceIcmDatosgentienda, (this.icmDatosgentienda!= null)));
                    copy.setIcmDatosgentienda(copyIcmDatosgentienda);
                } else {
                    if (icmDatosgentiendaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmDatosgentienda = null;
                    }
                }
            }
            {
                Boolean icmGlobalempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmGlobalempleado!= null));
                if (icmGlobalempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmGlobalempleadoBlock sourceIcmGlobalempleado;
                    sourceIcmGlobalempleado = this.getIcmGlobalempleado();
                    IcmGlobalempleadoBlock copyIcmGlobalempleado = ((IcmGlobalempleadoBlock) strategy.copy(LocatorUtils.property(locator, "icmGlobalempleado", sourceIcmGlobalempleado), sourceIcmGlobalempleado, (this.icmGlobalempleado!= null)));
                    copy.setIcmGlobalempleado(copyIcmGlobalempleado);
                } else {
                    if (icmGlobalempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmGlobalempleado = null;
                    }
                }
            }
            {
                Boolean icmWsOperacionesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmWsOperaciones!= null));
                if (icmWsOperacionesShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmWsOperacionesBlock sourceIcmWsOperaciones;
                    sourceIcmWsOperaciones = this.getIcmWsOperaciones();
                    IcmWsOperacionesBlock copyIcmWsOperaciones = ((IcmWsOperacionesBlock) strategy.copy(LocatorUtils.property(locator, "icmWsOperaciones", sourceIcmWsOperaciones), sourceIcmWsOperaciones, (this.icmWsOperaciones!= null)));
                    copy.setIcmWsOperaciones(copyIcmWsOperaciones);
                } else {
                    if (icmWsOperacionesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmWsOperaciones = null;
                    }
                }
            }
            {
                Boolean icmEmpleadostiendaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmEmpleadostienda!= null));
                if (icmEmpleadostiendaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmEmpleadostiendaBlock sourceIcmEmpleadostienda;
                    sourceIcmEmpleadostienda = this.getIcmEmpleadostienda();
                    IcmEmpleadostiendaBlock copyIcmEmpleadostienda = ((IcmEmpleadostiendaBlock) strategy.copy(LocatorUtils.property(locator, "icmEmpleadostienda", sourceIcmEmpleadostienda), sourceIcmEmpleadostienda, (this.icmEmpleadostienda!= null)));
                    copy.setIcmEmpleadostienda(copyIcmEmpleadostienda);
                } else {
                    if (icmEmpleadostiendaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmEmpleadostienda = null;
                    }
                }
            }
            {
                Boolean icmParametrosexcelShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParametrosexcel!= null));
                if (icmParametrosexcelShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrosexcelBlock sourceIcmParametrosexcel;
                    sourceIcmParametrosexcel = this.getIcmParametrosexcel();
                    IcmParametrosexcelBlock copyIcmParametrosexcel = ((IcmParametrosexcelBlock) strategy.copy(LocatorUtils.property(locator, "icmParametrosexcel", sourceIcmParametrosexcel), sourceIcmParametrosexcel, (this.icmParametrosexcel!= null)));
                    copy.setIcmParametrosexcel(copyIcmParametrosexcel);
                } else {
                    if (icmParametrosexcelShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrosexcel = null;
                    }
                }
            }
            {
                Boolean icmPresenciamanualShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmPresenciamanual!= null));
                if (icmPresenciamanualShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmPresenciamanualBlock sourceIcmPresenciamanual;
                    sourceIcmPresenciamanual = this.getIcmPresenciamanual();
                    IcmPresenciamanualBlock copyIcmPresenciamanual = ((IcmPresenciamanualBlock) strategy.copy(LocatorUtils.property(locator, "icmPresenciamanual", sourceIcmPresenciamanual), sourceIcmPresenciamanual, (this.icmPresenciamanual!= null)));
                    copy.setIcmPresenciamanual(copyIcmPresenciamanual);
                } else {
                    if (icmPresenciamanualShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmPresenciamanual = null;
                    }
                }
            }
            {
                Boolean icmCabeceraempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmCabeceraempleado!= null));
                if (icmCabeceraempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmCabeceraempleadoBlock sourceIcmCabeceraempleado;
                    sourceIcmCabeceraempleado = this.getIcmCabeceraempleado();
                    IcmCabeceraempleadoBlock copyIcmCabeceraempleado = ((IcmCabeceraempleadoBlock) strategy.copy(LocatorUtils.property(locator, "icmCabeceraempleado", sourceIcmCabeceraempleado), sourceIcmCabeceraempleado, (this.icmCabeceraempleado!= null)));
                    copy.setIcmCabeceraempleado(copyIcmCabeceraempleado);
                } else {
                    if (icmCabeceraempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmCabeceraempleado = null;
                    }
                }
            }
            {
                Boolean icmCalendariotiendaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmCalendariotienda!= null));
                if (icmCalendariotiendaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmCalendariotiendaBlock sourceIcmCalendariotienda;
                    sourceIcmCalendariotienda = this.getIcmCalendariotienda();
                    IcmCalendariotiendaBlock copyIcmCalendariotienda = ((IcmCalendariotiendaBlock) strategy.copy(LocatorUtils.property(locator, "icmCalendariotienda", sourceIcmCalendariotienda), sourceIcmCalendariotienda, (this.icmCalendariotienda!= null)));
                    copy.setIcmCalendariotienda(copyIcmCalendariotienda);
                } else {
                    if (icmCalendariotiendaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmCalendariotienda = null;
                    }
                }
            }
            {
                Boolean icmCondicionesventaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmCondicionesventa!= null));
                if (icmCondicionesventaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmCondicionesventaBlock sourceIcmCondicionesventa;
                    sourceIcmCondicionesventa = this.getIcmCondicionesventa();
                    IcmCondicionesventaBlock copyIcmCondicionesventa = ((IcmCondicionesventaBlock) strategy.copy(LocatorUtils.property(locator, "icmCondicionesventa", sourceIcmCondicionesventa), sourceIcmCondicionesventa, (this.icmCondicionesventa!= null)));
                    copy.setIcmCondicionesventa(copyIcmCondicionesventa);
                } else {
                    if (icmCondicionesventaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmCondicionesventa = null;
                    }
                }
            }
            {
                Boolean icmDatosgenempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmDatosgenempleado!= null));
                if (icmDatosgenempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmDatosgenempleadoBlock sourceIcmDatosgenempleado;
                    sourceIcmDatosgenempleado = this.getIcmDatosgenempleado();
                    IcmDatosgenempleadoBlock copyIcmDatosgenempleado = ((IcmDatosgenempleadoBlock) strategy.copy(LocatorUtils.property(locator, "icmDatosgenempleado", sourceIcmDatosgenempleado), sourceIcmDatosgenempleado, (this.icmDatosgenempleado!= null)));
                    copy.setIcmDatosgenempleado(copyIcmDatosgenempleado);
                } else {
                    if (icmDatosgenempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmDatosgenempleado = null;
                    }
                }
            }
            {
                Boolean icmEmpleadosdespentShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmEmpleadosdespent!= null));
                if (icmEmpleadosdespentShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmEmpleadosdespentBlock sourceIcmEmpleadosdespent;
                    sourceIcmEmpleadosdespent = this.getIcmEmpleadosdespent();
                    IcmEmpleadosdespentBlock copyIcmEmpleadosdespent = ((IcmEmpleadosdespentBlock) strategy.copy(LocatorUtils.property(locator, "icmEmpleadosdespent", sourceIcmEmpleadosdespent), sourceIcmEmpleadosdespent, (this.icmEmpleadosdespent!= null)));
                    copy.setIcmEmpleadosdespent(copyIcmEmpleadosdespent);
                } else {
                    if (icmEmpleadosdespentShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmEmpleadosdespent = null;
                    }
                }
            }
            {
                Boolean icmEmpleadosdespsalShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmEmpleadosdespsal!= null));
                if (icmEmpleadosdespsalShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmEmpleadosdespsalBlock sourceIcmEmpleadosdespsal;
                    sourceIcmEmpleadosdespsal = this.getIcmEmpleadosdespsal();
                    IcmEmpleadosdespsalBlock copyIcmEmpleadosdespsal = ((IcmEmpleadosdespsalBlock) strategy.copy(LocatorUtils.property(locator, "icmEmpleadosdespsal", sourceIcmEmpleadosdespsal), sourceIcmEmpleadosdespsal, (this.icmEmpleadosdespsal!= null)));
                    copy.setIcmEmpleadosdespsal(copyIcmEmpleadosdespsal);
                } else {
                    if (icmEmpleadosdespsalShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmEmpleadosdespsal = null;
                    }
                }
            }
            {
                Boolean icmParametrostiendaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParametrostienda!= null));
                if (icmParametrostiendaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrostiendaBlock sourceIcmParametrostienda;
                    sourceIcmParametrostienda = this.getIcmParametrostienda();
                    IcmParametrostiendaBlock copyIcmParametrostienda = ((IcmParametrostiendaBlock) strategy.copy(LocatorUtils.property(locator, "icmParametrostienda", sourceIcmParametrostienda), sourceIcmParametrostienda, (this.icmParametrostienda!= null)));
                    copy.setIcmParametrostienda(copyIcmParametrostienda);
                } else {
                    if (icmParametrostiendaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrostienda = null;
                    }
                }
            }
            {
                Boolean icmResultadoguardadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmResultadoguardado!= null));
                if (icmResultadoguardadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmResultadoguardadoBlock sourceIcmResultadoguardado;
                    sourceIcmResultadoguardado = this.getIcmResultadoguardado();
                    IcmResultadoguardadoBlock copyIcmResultadoguardado = ((IcmResultadoguardadoBlock) strategy.copy(LocatorUtils.property(locator, "icmResultadoguardado", sourceIcmResultadoguardado), sourceIcmResultadoguardado, (this.icmResultadoguardado!= null)));
                    copy.setIcmResultadoguardado(copyIcmResultadoguardado);
                } else {
                    if (icmResultadoguardadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmResultadoguardado = null;
                    }
                }
            }
            {
                Boolean icmBandaspresupuestosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmBandaspresupuestos!= null));
                if (icmBandaspresupuestosShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmBandaspresupuestosBlock sourceIcmBandaspresupuestos;
                    sourceIcmBandaspresupuestos = this.getIcmBandaspresupuestos();
                    IcmBandaspresupuestosBlock copyIcmBandaspresupuestos = ((IcmBandaspresupuestosBlock) strategy.copy(LocatorUtils.property(locator, "icmBandaspresupuestos", sourceIcmBandaspresupuestos), sourceIcmBandaspresupuestos, (this.icmBandaspresupuestos!= null)));
                    copy.setIcmBandaspresupuestos(copyIcmBandaspresupuestos);
                } else {
                    if (icmBandaspresupuestosShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmBandaspresupuestos = null;
                    }
                }
            }
            {
                Boolean icmCalendarioempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmCalendarioempleado!= null));
                if (icmCalendarioempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmCalendarioempleadoBlock sourceIcmCalendarioempleado;
                    sourceIcmCalendarioempleado = this.getIcmCalendarioempleado();
                    IcmCalendarioempleadoBlock copyIcmCalendarioempleado = ((IcmCalendarioempleadoBlock) strategy.copy(LocatorUtils.property(locator, "icmCalendarioempleado", sourceIcmCalendarioempleado), sourceIcmCalendarioempleado, (this.icmCalendarioempleado!= null)));
                    copy.setIcmCalendarioempleado(copyIcmCalendarioempleado);
                } else {
                    if (icmCalendarioempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmCalendarioempleado = null;
                    }
                }
            }
            {
                Boolean icmParametrosempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParametrosempleado!= null));
                if (icmParametrosempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrosempleadoBlock sourceIcmParametrosempleado;
                    sourceIcmParametrosempleado = this.getIcmParametrosempleado();
                    IcmParametrosempleadoBlock copyIcmParametrosempleado = ((IcmParametrosempleadoBlock) strategy.copy(LocatorUtils.property(locator, "icmParametrosempleado", sourceIcmParametrosempleado), sourceIcmParametrosempleado, (this.icmParametrosempleado!= null)));
                    copy.setIcmParametrosempleado(copyIcmParametrosempleado);
                } else {
                    if (icmParametrosempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrosempleado = null;
                    }
                }
            }
            {
                Boolean icmTiendacomisionableShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmTiendacomisionable!= null));
                if (icmTiendacomisionableShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmTiendacomisionableBlock sourceIcmTiendacomisionable;
                    sourceIcmTiendacomisionable = this.getIcmTiendacomisionable();
                    IcmTiendacomisionableBlock copyIcmTiendacomisionable = ((IcmTiendacomisionableBlock) strategy.copy(LocatorUtils.property(locator, "icmTiendacomisionable", sourceIcmTiendacomisionable), sourceIcmTiendacomisionable, (this.icmTiendacomisionable!= null)));
                    copy.setIcmTiendacomisionable(copyIcmTiendacomisionable);
                } else {
                    if (icmTiendacomisionableShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmTiendacomisionable = null;
                    }
                }
            }
            {
                Boolean icmEmpleadosestructuraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmEmpleadosestructura!= null));
                if (icmEmpleadosestructuraShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmEmpleadosestructuraBlock sourceIcmEmpleadosestructura;
                    sourceIcmEmpleadosestructura = this.getIcmEmpleadosestructura();
                    IcmEmpleadosestructuraBlock copyIcmEmpleadosestructura = ((IcmEmpleadosestructuraBlock) strategy.copy(LocatorUtils.property(locator, "icmEmpleadosestructura", sourceIcmEmpleadosestructura), sourceIcmEmpleadosestructura, (this.icmEmpleadosestructura!= null)));
                    copy.setIcmEmpleadosestructura(copyIcmEmpleadosestructura);
                } else {
                    if (icmEmpleadosestructuraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmEmpleadosestructura = null;
                    }
                }
            }
            {
                Boolean icmParametrosplantillaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParametrosplantilla!= null));
                if (icmParametrosplantillaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrosplantillaBlock sourceIcmParametrosplantilla;
                    sourceIcmParametrosplantilla = this.getIcmParametrosplantilla();
                    IcmParametrosplantillaBlock copyIcmParametrosplantilla = ((IcmParametrosplantillaBlock) strategy.copy(LocatorUtils.property(locator, "icmParametrosplantilla", sourceIcmParametrosplantilla), sourceIcmParametrosplantilla, (this.icmParametrosplantilla!= null)));
                    copy.setIcmParametrosplantilla(copyIcmParametrosplantilla);
                } else {
                    if (icmParametrosplantillaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrosplantilla = null;
                    }
                }
            }
            {
                Boolean icmTpcalculopaiscadenaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmTpcalculopaiscadena!= null));
                if (icmTpcalculopaiscadenaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmTpcalculopaiscadenaBlock sourceIcmTpcalculopaiscadena;
                    sourceIcmTpcalculopaiscadena = this.getIcmTpcalculopaiscadena();
                    IcmTpcalculopaiscadenaBlock copyIcmTpcalculopaiscadena = ((IcmTpcalculopaiscadenaBlock) strategy.copy(LocatorUtils.property(locator, "icmTpcalculopaiscadena", sourceIcmTpcalculopaiscadena), sourceIcmTpcalculopaiscadena, (this.icmTpcalculopaiscadena!= null)));
                    copy.setIcmTpcalculopaiscadena(copyIcmTpcalculopaiscadena);
                } else {
                    if (icmTpcalculopaiscadenaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmTpcalculopaiscadena = null;
                    }
                }
            }
            {
                Boolean icmEstadostiendaseccionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmEstadostiendaseccion!= null));
                if (icmEstadostiendaseccionShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmEstadostiendaseccionBlock sourceIcmEstadostiendaseccion;
                    sourceIcmEstadostiendaseccion = this.getIcmEstadostiendaseccion();
                    IcmEstadostiendaseccionBlock copyIcmEstadostiendaseccion = ((IcmEstadostiendaseccionBlock) strategy.copy(LocatorUtils.property(locator, "icmEstadostiendaseccion", sourceIcmEstadostiendaseccion), sourceIcmEstadostiendaseccion, (this.icmEstadostiendaseccion!= null)));
                    copy.setIcmEstadostiendaseccion(copyIcmEstadostiendaseccion);
                } else {
                    if (icmEstadostiendaseccionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmEstadostiendaseccion = null;
                    }
                }
            }
            {
                Boolean icmParametrospaginacionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParametrospaginacion!= null));
                if (icmParametrospaginacionShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrospaginacionBlock sourceIcmParametrospaginacion;
                    sourceIcmParametrospaginacion = this.getIcmParametrospaginacion();
                    IcmParametrospaginacionBlock copyIcmParametrospaginacion = ((IcmParametrospaginacionBlock) strategy.copy(LocatorUtils.property(locator, "icmParametrospaginacion", sourceIcmParametrospaginacion), sourceIcmParametrospaginacion, (this.icmParametrospaginacion!= null)));
                    copy.setIcmParametrospaginacion(copyIcmParametrospaginacion);
                } else {
                    if (icmParametrospaginacionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrospaginacion = null;
                    }
                }
            }
            {
                Boolean icmParametrospaiscadenaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParametrospaiscadena!= null));
                if (icmParametrospaiscadenaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrospaiscadenaBlock sourceIcmParametrospaiscadena;
                    sourceIcmParametrospaiscadena = this.getIcmParametrospaiscadena();
                    IcmParametrospaiscadenaBlock copyIcmParametrospaiscadena = ((IcmParametrospaiscadenaBlock) strategy.copy(LocatorUtils.property(locator, "icmParametrospaiscadena", sourceIcmParametrospaiscadena), sourceIcmParametrospaiscadena, (this.icmParametrospaiscadena!= null)));
                    copy.setIcmParametrospaiscadena(copyIcmParametrospaiscadena);
                } else {
                    if (icmParametrospaiscadenaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrospaiscadena = null;
                    }
                }
            }
            {
                Boolean icmPlantillacondicionesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmPlantillacondiciones!= null));
                if (icmPlantillacondicionesShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmPlantillacondicionesBlock sourceIcmPlantillacondiciones;
                    sourceIcmPlantillacondiciones = this.getIcmPlantillacondiciones();
                    IcmPlantillacondicionesBlock copyIcmPlantillacondiciones = ((IcmPlantillacondicionesBlock) strategy.copy(LocatorUtils.property(locator, "icmPlantillacondiciones", sourceIcmPlantillacondiciones), sourceIcmPlantillacondiciones, (this.icmPlantillacondiciones!= null)));
                    copy.setIcmPlantillacondiciones(copyIcmPlantillacondiciones);
                } else {
                    if (icmPlantillacondicionesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmPlantillacondiciones = null;
                    }
                }
            }
            {
                Boolean icmParametrospresupuestoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParametrospresupuesto!= null));
                if (icmParametrospresupuestoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrospresupuestoBlock sourceIcmParametrospresupuesto;
                    sourceIcmParametrospresupuesto = this.getIcmParametrospresupuesto();
                    IcmParametrospresupuestoBlock copyIcmParametrospresupuesto = ((IcmParametrospresupuestoBlock) strategy.copy(LocatorUtils.property(locator, "icmParametrospresupuesto", sourceIcmParametrospresupuesto), sourceIcmParametrospresupuesto, (this.icmParametrospresupuesto!= null)));
                    copy.setIcmParametrospresupuesto(copyIcmParametrospresupuesto);
                } else {
                    if (icmParametrospresupuestoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrospresupuesto = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new M4LoadobjectOutput();
    }

}
