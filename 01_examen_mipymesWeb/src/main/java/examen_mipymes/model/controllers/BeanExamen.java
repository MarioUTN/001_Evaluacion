package examen_mipymes.model.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import examen_mipymes.model.entities.DetalleEquipo;
import examen_mipymes.model.entities.Equipo;
import examen_mipymes.model.entities.Jugador;
import examen_mipymes.model.entities.ManagerExamen;
import examen_mipymes.model.entities.PosicionJuego;
import examen_mipymes.model.util.JSFUtil;

@Named
@SessionScoped
public class BeanExamen implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerExamen managerExamen;

	private Equipo equipo;
	private int id_equipo;
	private Jugador jugador;
	private Jugador jugadorActualizar;
	private int id_pos;
	private String id_jugador;
	private double valor_equipo;

	private List<Equipo> listaEquipos;
	private List<PosicionJuego> listaPosicionJuegos;
	private List<DetalleEquipo> listaDetalleEquipos;
	private List<Jugador> listaJugadors;

	public BeanExamen() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void Inicializar() {
		listaEquipos = managerExamen.findAllEquipos();
		listaPosicionJuegos = managerExamen.findAllPosicionsJuegos();
		listaJugadors = managerExamen.findAllJugadores();
		listaDetalleEquipos = new ArrayList<DetalleEquipo>();
		equipo = new Equipo();
		jugador = new Jugador();
	}

	public void actionListenerInsertarEquipo() {
		if (managerExamen.findEquipoByNombre(equipo.getNombreEquipo()).getIdEquipo() == null) {
			equipo = managerExamen.insertarEquipo(equipo);
			listaEquipos = managerExamen.findAllEquipos();
			JSFUtil.crearMensajeInfo("Equipo guardado con exito!" + equipo.getNombreEquipo());
			equipo = new Equipo();
		} else {
			JSFUtil.crearMensajeError("Error al guardar nuevo equipo!"
					+ managerExamen.findEquipoByNombre(equipo.getNombreEquipo()).getNombreEquipo());
		}
	}

	public void actionListenerAgregarJugador() {
		if (managerExamen.buscarJugador(id_jugador, listaDetalleEquipos) == false) {
			listaDetalleEquipos = managerExamen.agregarJugadores(id_jugador, listaDetalleEquipos);
			valor_equipo = managerExamen.valorSubTotal(listaDetalleEquipos);
			JSFUtil.crearMensajeInfo("Se agrego un nuevo jugador!");
		} else {
			JSFUtil.crearMensajeError("No se pudo agregar el jugador");
		}
	}

	public void actionListenerInsertarJugador() {
		JSFUtil.crearMensajeError(jugador.getIdJugador());
		if (managerExamen.findJugadorById(jugador.getIdJugador()) == null) {
			jugador = managerExamen.insertarJugador(jugador, id_pos);
			listaJugadors = managerExamen.findAllJugadores();
			JSFUtil.crearMensajeInfo("Jugador insertado!");
		} else {
			JSFUtil.crearMensajeError("Error al guardar Jugador");
		}
		jugador = new Jugador();
	}

	public void seleccionarJugador(String id_jugador) {
		jugadorActualizar = managerExamen.findJugadorById(id_jugador);
		JSFUtil.crearMensajeInfo("Jugador seleccionado: "+jugadorActualizar.getNombres());
	}
	
	public void actionListenerActualizarJugador() {
		jugadorActualizar=managerExamen.actualizarJugador(jugadorActualizar, id_pos,listaDetalleEquipos);
		listaJugadors=managerExamen.findAllJugadores();
		valor_equipo=managerExamen.valorSubTotal(listaDetalleEquipos);
		JSFUtil.crearMensajeInfo("Jugador actualizado!"+jugadorActualizar.getApellidos());
	}

	public void actionListenerEliminarDetalle(int index) {
		listaDetalleEquipos=managerExamen.eliminarJugadorDetalle(index, listaDetalleEquipos);
		valor_equipo=managerExamen.valorSubTotal(listaDetalleEquipos);
	}
	
	public void actionListenerGuardarEquipo() {
		//equipo = managerExamen.guardarEquipo(id_equipo, listaDetalleEquipos, valor_equipo);
		listaEquipos=managerExamen.findAllEquipos();
		JSFUtil.crearMensajeInfo("Equipo guardado correctamenet! "+id_equipo);
	}
	
	public void actionListenerActualizar() {
		listaEquipos=managerExamen.findAllEquipos();
	}
	
	public List<Jugador> getListaJugadors() {
		return listaJugadors;
	}

	public void setListaJugadors(List<Jugador> listaJugadors) {
		this.listaJugadors = listaJugadors;
	}

	public void setListaEquipos(List<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	public List<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setId_equipo(int id_equipo) {
		this.id_equipo = id_equipo;
	}

	public int getId_equipo() {
		return id_equipo;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public List<PosicionJuego> getListaPosicionJuegos() {
		return listaPosicionJuegos;
	}

	public void setListaPosicionJuegos(List<PosicionJuego> listaPosicionJuegos) {
		this.listaPosicionJuegos = listaPosicionJuegos;
	}

	public List<DetalleEquipo> getListaDetalleEquipos() {
		return listaDetalleEquipos;
	}

	public void setListaDetalleEquipos(List<DetalleEquipo> listaDetalleEquipos) {
		this.listaDetalleEquipos = listaDetalleEquipos;
	}

	public void setId_pos(int id_pos) {
		this.id_pos = id_pos;
	}

	public int getId_pos() {
		return id_pos;
	}

	public void setId_jugador(String id_jugador) {
		this.id_jugador = id_jugador;
	}

	public String getId_jugador() {
		return id_jugador;
	}

	public void setValor_equipo(double valor_equipo) {
		this.valor_equipo = valor_equipo;
	}

	public double getValor_equipo() {
		return valor_equipo;
	}

	public void setJugadorActualizar(Jugador jugadorActualizar) {
		this.jugadorActualizar = jugadorActualizar;
	}

	public Jugador getJugadorActualizar() {
		return jugadorActualizar;
	}
}
