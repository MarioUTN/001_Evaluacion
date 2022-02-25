package examen_mipymes.model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import examen_mipymes.model.util.JSFUtil;

/**
 * Session Bean implementation class ManagerExamen
 */
@Stateless
@LocalBean
public class ManagerExamen {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ManagerExamen() {
		// TODO Auto-generated constructor stub
	}

	public List<Equipo> findAllEquipos() {
		return entityManager.createNamedQuery("Equipo.findAll", Equipo.class).getResultList();
	}

	public List<Jugador> findAllJugadores() {
		return entityManager.createNamedQuery("Jugador.findAll", Jugador.class).getResultList();
	}

	public List<PosicionJuego> findAllPosicionsJuegos() {
		return entityManager.createNamedQuery("PosicionJuego.findAll", PosicionJuego.class).getResultList();
	}

	public List<DetalleEquipo> findAllDetallesEquipos() {
		return entityManager.createNamedQuery("DetalleEquipo.findAll", DetalleEquipo.class).getResultList();
	}

	public Equipo findEquipoByNombre(String nombre) {
		Query query = entityManager.createQuery("select e from Equipo e where e.nombreEquipo='" + nombre + "'",
				Equipo.class);
		Equipo equipo = new Equipo();
		try {
			equipo = (Equipo) query.getSingleResult();
			if (equipo != null) {
				return equipo;
			} else {
				equipo = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return equipo;

	}

	public Equipo insertarEquipo(Equipo equipo) {
		if (findEquipoByNombre(equipo.getNombreEquipo()).getIdEquipo() == null) {
			equipo.setValorTotal(new BigDecimal(0));
			equipo.setNumeroJugadores(25);
			entityManager.persist(equipo);
			return equipo;
		} else {
			return null;
		}
	}

	public Jugador findJugadorById(String id_jugador) {
		return entityManager.find(Jugador.class, id_jugador);
	}

	public Jugador insertarJugador(Jugador jugador, int id_pos) {
		PosicionJuego posicionJuego = entityManager.find(PosicionJuego.class, id_pos);
		if (findJugadorById(jugador.getIdJugador()) == null) {
			jugador.setPosicionJuegoBean(posicionJuego);
			jugador.setFechaNacimiento(new Date());
			entityManager.persist(jugador);
			return jugador;
		} else {
			return null;
		}
	}

	public Jugador actualizarJugador(Jugador jugadorActualizar, int id_pos, List<DetalleEquipo> listaDetalleEquipos) {
		PosicionJuego posicionJuego = entityManager.find(PosicionJuego.class, id_pos);
		jugadorActualizar.setPosicionJuegoBean(posicionJuego);
		jugadorActualizar.setFechaNacimiento(new Date());
		entityManager.merge(jugadorActualizar);
		for (DetalleEquipo detalleEquipo : listaDetalleEquipos) {
			if (detalleEquipo.getJugadorBean().getIdJugador().equals(jugadorActualizar.getIdJugador())) {
				detalleEquipo.setJugadorBean(jugadorActualizar);
			}
		}
		return jugadorActualizar;

	}

	public boolean buscarJugador(String jugador, List<DetalleEquipo> listaDetalleEquipos) {
		boolean j = false;
		for (DetalleEquipo detalleEquipo : listaDetalleEquipos) {
			if (detalleEquipo.getJugadorBean().getIdJugador().equals(jugador)) {
				j = true;
				break;
			}
		}
		return j;
	}

	public double formatearDecimales(Double numero, Integer numeroDecimales) {
		return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
	}

	public double valorSubTotal(List<DetalleEquipo> det) {
		double subTotal = 0;
		for (DetalleEquipo detjug : det) {
			subTotal += detjug.getJugadorBean().getValorJugador().doubleValue();
		}
		return formatearDecimales(subTotal, 2);
	}

	public List<DetalleEquipo> agregarJugadores(String id_jugador, List<DetalleEquipo> listaDetalleEquipos) {
		DetalleEquipo detalleEquipo = new DetalleEquipo();
		Jugador jugador = findJugadorById(id_jugador);
		detalleEquipo.setJugadorBean(jugador);
		if (listaDetalleEquipos == null || listaDetalleEquipos.size() == 0) {
			listaDetalleEquipos = new ArrayList<DetalleEquipo>();
			listaDetalleEquipos.add(detalleEquipo);
		} else {
			listaDetalleEquipos.add(detalleEquipo);
		}
		return listaDetalleEquipos;
	}

	public List<DetalleEquipo> eliminarJugadorDetalle(int index, List<DetalleEquipo> listaDetalleEquipos) {
		listaDetalleEquipos.remove(index);
		return listaDetalleEquipos;
	}

	public Equipo guardarEquipo(int id_equipo, List<DetalleEquipo> listaDetalleEquipos, double valor_equipo) {
		Equipo equipo = entityManager.find(Equipo.class, id_equipo);
		equipo.setValorTotal(new BigDecimal(valor_equipo));
		entityManager.merge(equipo);
		for (DetalleEquipo detalleEquipo : listaDetalleEquipos) {
			detalleEquipo.setEquipoBean(equipo);
			entityManager.persist(detalleEquipo);
		}
		return equipo;
	}
}
