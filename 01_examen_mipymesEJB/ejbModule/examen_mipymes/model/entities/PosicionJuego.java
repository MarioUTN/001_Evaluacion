package examen_mipymes.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the posicion_juego database table.
 * 
 */
@Entity
@Table(name="posicion_juego")
@NamedQuery(name="PosicionJuego.findAll", query="SELECT p FROM PosicionJuego p")
public class PosicionJuego implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_posicion", unique=true, nullable=false)
	private Integer idPosicion;

	@Column(name="nombre_posicion", nullable=false, length=60)
	private String nombrePosicion;

	//bi-directional many-to-one association to Jugador
	@OneToMany(mappedBy="posicionJuegoBean")
	private List<Jugador> jugadors;

	public PosicionJuego() {
	}

	public Integer getIdPosicion() {
		return this.idPosicion;
	}

	public void setIdPosicion(Integer idPosicion) {
		this.idPosicion = idPosicion;
	}

	public String getNombrePosicion() {
		return this.nombrePosicion;
	}

	public void setNombrePosicion(String nombrePosicion) {
		this.nombrePosicion = nombrePosicion;
	}

	public List<Jugador> getJugadors() {
		return this.jugadors;
	}

	public void setJugadors(List<Jugador> jugadors) {
		this.jugadors = jugadors;
	}

	public Jugador addJugador(Jugador jugador) {
		getJugadors().add(jugador);
		jugador.setPosicionJuegoBean(this);

		return jugador;
	}

	public Jugador removeJugador(Jugador jugador) {
		getJugadors().remove(jugador);
		jugador.setPosicionJuegoBean(null);

		return jugador;
	}

}