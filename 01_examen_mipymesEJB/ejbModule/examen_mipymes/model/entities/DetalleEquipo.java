package examen_mipymes.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_equipo database table.
 * 
 */
@Entity
@Table(name="detalle_equipo")
@NamedQuery(name="DetalleEquipo.findAll", query="SELECT d FROM DetalleEquipo d")
public class DetalleEquipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle", unique=true, nullable=false)
	private Integer idDetalle;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="equipo", nullable=false)
	private Equipo equipoBean;

	//bi-directional many-to-one association to Jugador
	@ManyToOne
	@JoinColumn(name="jugador", nullable=false)
	private Jugador jugadorBean;

	public DetalleEquipo() {
	}

	public Integer getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Equipo getEquipoBean() {
		return this.equipoBean;
	}

	public void setEquipoBean(Equipo equipoBean) {
		this.equipoBean = equipoBean;
	}

	public Jugador getJugadorBean() {
		return this.jugadorBean;
	}

	public void setJugadorBean(Jugador jugadorBean) {
		this.jugadorBean = jugadorBean;
	}

}