
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for M4LoadobjectOutput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
public class M4LoadobjectOutput {

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
     * Gets the value of the return property.
     * 
     */
    public double getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
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
     * Gets the value of the icmWsTools property.
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
     * Sets the value of the icmWsTools property.
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
     * Gets the value of the icmVentamanual property.
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
     * Sets the value of the icmVentamanual property.
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
     * Gets the value of the icmGlobaltienda property.
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
     * Sets the value of the icmGlobaltienda property.
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
     * Gets the value of the icmPresupuestos property.
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
     * Sets the value of the icmPresupuestos property.
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
     * Gets the value of the icmBuscadortienda property.
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
     * Sets the value of the icmBuscadortienda property.
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
     * Gets the value of the icmCabeceratienda property.
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
     * Sets the value of the icmCabeceratienda property.
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
     * Gets the value of the icmDatosgentienda property.
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
     * Sets the value of the icmDatosgentienda property.
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
     * Gets the value of the icmGlobalempleado property.
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
     * Sets the value of the icmGlobalempleado property.
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
     * Gets the value of the icmWsOperaciones property.
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
     * Sets the value of the icmWsOperaciones property.
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
     * Gets the value of the icmEmpleadostienda property.
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
     * Sets the value of the icmEmpleadostienda property.
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
     * Gets the value of the icmParametrosexcel property.
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
     * Sets the value of the icmParametrosexcel property.
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
     * Gets the value of the icmPresenciamanual property.
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
     * Sets the value of the icmPresenciamanual property.
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
     * Gets the value of the icmCabeceraempleado property.
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
     * Sets the value of the icmCabeceraempleado property.
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
     * Gets the value of the icmCalendariotienda property.
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
     * Sets the value of the icmCalendariotienda property.
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
     * Gets the value of the icmCondicionesventa property.
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
     * Sets the value of the icmCondicionesventa property.
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
     * Gets the value of the icmDatosgenempleado property.
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
     * Sets the value of the icmDatosgenempleado property.
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
     * Gets the value of the icmEmpleadosdespent property.
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
     * Sets the value of the icmEmpleadosdespent property.
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
     * Gets the value of the icmEmpleadosdespsal property.
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
     * Sets the value of the icmEmpleadosdespsal property.
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
     * Gets the value of the icmParametrostienda property.
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
     * Sets the value of the icmParametrostienda property.
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
     * Gets the value of the icmResultadoguardado property.
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
     * Sets the value of the icmResultadoguardado property.
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
     * Gets the value of the icmBandaspresupuestos property.
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
     * Sets the value of the icmBandaspresupuestos property.
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
     * Gets the value of the icmCalendarioempleado property.
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
     * Sets the value of the icmCalendarioempleado property.
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
     * Gets the value of the icmParametrosempleado property.
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
     * Sets the value of the icmParametrosempleado property.
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
     * Gets the value of the icmTiendacomisionable property.
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
     * Sets the value of the icmTiendacomisionable property.
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
     * Gets the value of the icmEmpleadosestructura property.
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
     * Sets the value of the icmEmpleadosestructura property.
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
     * Gets the value of the icmParametrosplantilla property.
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
     * Sets the value of the icmParametrosplantilla property.
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
     * Gets the value of the icmTpcalculopaiscadena property.
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
     * Sets the value of the icmTpcalculopaiscadena property.
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
     * Gets the value of the icmEstadostiendaseccion property.
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
     * Sets the value of the icmEstadostiendaseccion property.
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
     * Gets the value of the icmParametrospaginacion property.
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
     * Sets the value of the icmParametrospaginacion property.
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
     * Gets the value of the icmParametrospaiscadena property.
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
     * Sets the value of the icmParametrospaiscadena property.
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
     * Gets the value of the icmPlantillacondiciones property.
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
     * Sets the value of the icmPlantillacondiciones property.
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
     * Gets the value of the icmParametrospresupuesto property.
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
     * Sets the value of the icmParametrospresupuesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospresupuestoBlock }
     *     
     */
    public void setIcmParametrospresupuesto(IcmParametrospresupuestoBlock value) {
        this.icmParametrospresupuesto = value;
    }

}
