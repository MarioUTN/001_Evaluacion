package examen_mipymes.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the jugador database table.
 * 
 */
@Entity
@Table(name="jugador")
@NamedQuery(name="Jugador.findAll", query="SELECT j FROM Jugador j")
public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_jugador", unique=true, nullable=false, length=10)
	private String idJugador;

	@Column(nullable=false, length=60)
	private String apellidos;

	@Column(nullable=false, precision=131089)
	private BigDecimal dorsal;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento", nullable=false)
	private Date fechaNacimiento;

	@Column(nullable=false, length=60)
	private String nombres;

	@Column(name="valor_jugador", nullable=false, precision=8, scale=2)
	private BigDecimal valorJugador;

	//bi-directional many-to-one association to DetalleEquipo
	@OneToMany(mappedBy="jugadorBean")
	private List<DetalleEquipo> detalleEquipos;

	//bi-directional many-to-one association to PosicionJuego
	@ManyToOne
	@JoinColumn(name="posicion_juego", nullable=false)
	private PosicionJuego posicionJuegoBean;

	public Jugador() {
	}

	public String getIdJugador() {
		return this.idJugador;
	}

	public void setIdJugador(String idJugador) {
		this.idJugador = idJugador;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public BigDecimal getDorsal() {
		return this.dorsal;
	}

	public void setDorsal(BigDecimal dorsal) {
		this.dorsal = dorsal;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public BigDecimal getValorJugador() {
		return this.valorJugador;
	}

	public void setValorJugador(BigDecimal valorJugador) {
		this.valorJugador = valorJugador;
	}

	public List<DetalleEquipo> getDetalleEquipos() {
		return this.detalleEquipos;
	}

	public void setDetalleEquipos(List<DetalleEquipo> detalleEquipos) {
		this.detalleEquipos = detalleEquipos;
	}

	public DetalleEquipo addDetalleEquipo(DetalleEquipo detalleEquipo) {
		getDetalleEquipos().add(detalleEquipo);
		detalleEquipo.setJugadorBean(this);

		return detalleEquipo;
	}

	public DetalleEquipo removeDetalleEquipo(DetalleEquipo detalleEquipo) {
		getDetalleEquipos().remove(detalleEquipo);
		detalleEquipo.setJugadorBean(null);

		return detalleEquipo;
	}

	public PosicionJuego getPosicionJuegoBean() {
		return this.posicionJuegoBean;
	}

	public void setPosicionJuegoBean(PosicionJuego posicionJuegoBean) {
		this.posicionJuegoBean = posicionJuegoBean;
	}

}