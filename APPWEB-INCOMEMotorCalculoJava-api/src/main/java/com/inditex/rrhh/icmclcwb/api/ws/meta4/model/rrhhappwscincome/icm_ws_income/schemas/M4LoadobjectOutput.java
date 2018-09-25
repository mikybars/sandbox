
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para M4LoadobjectOutput complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="M4LoadobjectOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="logMessage" type="{http://schemas.meta4.com/}ArrayOfLogMessage"/&gt;
 *         &lt;element name="Icm_Ws_Tools" type="{http://schemas.meta4.com/}Icm_Ws_ToolsBlock"/&gt;
 *         &lt;element name="Icm_Ventamanual" type="{http://schemas.meta4.com/}Icm_VentamanualBlock"/&gt;
 *         &lt;element name="Icm_Globaltienda" type="{http://schemas.meta4.com/}Icm_GlobaltiendaBlock"/&gt;
 *         &lt;element name="Icm_Presupuestos" type="{http://schemas.meta4.com/}Icm_PresupuestosBlock"/&gt;
 *         &lt;element name="Icm_Buscadortienda" type="{http://schemas.meta4.com/}Icm_BuscadortiendaBlock"/&gt;
 *         &lt;element name="Icm_Cabeceratienda" type="{http://schemas.meta4.com/}Icm_CabeceratiendaBlock"/&gt;
 *         &lt;element name="Icm_Datosgentienda" type="{http://schemas.meta4.com/}Icm_DatosgentiendaBlock"/&gt;
 *         &lt;element name="Icm_Globalempleado" type="{http://schemas.meta4.com/}Icm_GlobalempleadoBlock"/&gt;
 *         &lt;element name="Icm_Ws_Operaciones" type="{http://schemas.meta4.com/}Icm_Ws_OperacionesBlock"/&gt;
 *         &lt;element name="Icm_Empleadostienda" type="{http://schemas.meta4.com/}Icm_EmpleadostiendaBlock"/&gt;
 *         &lt;element name="Icm_Parametrosexcel" type="{http://schemas.meta4.com/}Icm_ParametrosexcelBlock"/&gt;
 *         &lt;element name="Icm_Presenciamanual" type="{http://schemas.meta4.com/}Icm_PresenciamanualBlock"/&gt;
 *         &lt;element name="Icm_Cabeceraempleado" type="{http://schemas.meta4.com/}Icm_CabeceraempleadoBlock"/&gt;
 *         &lt;element name="Icm_Calendariotienda" type="{http://schemas.meta4.com/}Icm_CalendariotiendaBlock"/&gt;
 *         &lt;element name="Icm_Condicionesventa" type="{http://schemas.meta4.com/}Icm_CondicionesventaBlock"/&gt;
 *         &lt;element name="Icm_Datosgenempleado" type="{http://schemas.meta4.com/}Icm_DatosgenempleadoBlock"/&gt;
 *         &lt;element name="Icm_Empleadosdespent" type="{http://schemas.meta4.com/}Icm_EmpleadosdespentBlock"/&gt;
 *         &lt;element name="Icm_Empleadosdespsal" type="{http://schemas.meta4.com/}Icm_EmpleadosdespsalBlock"/&gt;
 *         &lt;element name="Icm_Parametrostienda" type="{http://schemas.meta4.com/}Icm_ParametrostiendaBlock"/&gt;
 *         &lt;element name="Icm_Resultadoguardado" type="{http://schemas.meta4.com/}Icm_ResultadoguardadoBlock"/&gt;
 *         &lt;element name="Icm_Bandaspresupuestos" type="{http://schemas.meta4.com/}Icm_BandaspresupuestosBlock"/&gt;
 *         &lt;element name="Icm_Calendarioempleado" type="{http://schemas.meta4.com/}Icm_CalendarioempleadoBlock"/&gt;
 *         &lt;element name="Icm_Parametrosempleado" type="{http://schemas.meta4.com/}Icm_ParametrosempleadoBlock"/&gt;
 *         &lt;element name="Icm_Tiendacomisionable" type="{http://schemas.meta4.com/}Icm_TiendacomisionableBlock"/&gt;
 *         &lt;element name="Icm_Empleadosestructura" type="{http://schemas.meta4.com/}Icm_EmpleadosestructuraBlock"/&gt;
 *         &lt;element name="Icm_Parametrosplantilla" type="{http://schemas.meta4.com/}Icm_ParametrosplantillaBlock"/&gt;
 *         &lt;element name="Icm_Tpcalculopaiscadena" type="{http://schemas.meta4.com/}Icm_TpcalculopaiscadenaBlock"/&gt;
 *         &lt;element name="Icm_Estadostiendaseccion" type="{http://schemas.meta4.com/}Icm_EstadostiendaseccionBlock"/&gt;
 *         &lt;element name="Icm_Parametrospaginacion" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/&gt;
 *         &lt;element name="Icm_Parametrospaiscadena" type="{http://schemas.meta4.com/}Icm_ParametrospaiscadenaBlock"/&gt;
 *         &lt;element name="Icm_Plantillacondiciones" type="{http://schemas.meta4.com/}Icm_PlantillacondicionesBlock"/&gt;
 *         &lt;element name="Icm_Parametrospresupuesto" type="{http://schemas.meta4.com/}Icm_ParametrospresupuestoBlock"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
    @XmlElement(required = true, nillable = true)
    protected ArrayOfLogMessage logMessage;
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
     * Obtiene el valor de la propiedad logMessage.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLogMessage }
     *     
     */
    public ArrayOfLogMessage getLogMessage() {
        return logMessage;
    }

    /**
     * Define el valor de la propiedad logMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLogMessage }
     *     
     */
    public void setLogMessage(ArrayOfLogMessage value) {
        this.logMessage = value;
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

}
