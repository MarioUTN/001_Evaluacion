package examen_mipymes.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the equipo database table.
 * 
 */
@Entity
@Table(name="equipo")
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_equipo", unique=true, nullable=false)
	private Integer idEquipo;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fecha;

	@Column(name="nombre_equipo", nullable=false, length=60)
	private String nombreEquipo;

	@Column(name="numero_jugadores", nullable=false)
	private Integer numeroJugadores;

	@Column(name="valor_total", nullable=false, precision=8, scale=2)
	private BigDecimal valorTotal;

	//bi-directional many-to-one association to DetalleEquipo
	@OneToMany(mappedBy="equipoBean")
	private List<DetalleEquipo> detalleEquipos;

	public Equipo() {
	}

	public Integer getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombreEquipo() {
		return this.nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public Integer getNumeroJugadores() {
		return this.numeroJugadores;
	}

	public void setNumeroJugadores(Integer numeroJugadores) {
		this.numeroJugadores = numeroJugadores;
	}

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<DetalleEquipo> getDetalleEquipos() {
		return this.detalleEquipos;
	}

	public void setDetalleEquipos(List<DetalleEquipo> detalleEquipos) {
		this.detalleEquipos = detalleEquipos;
	}

	public DetalleEquipo addDetalleEquipo(DetalleEquipo detalleEquipo) {
		getDetalleEquipos().add(detalleEquipo);
		detalleEquipo.setEquipoBean(this);

		return detalleEquipo;
	}

	public DetalleEquipo removeDetalleEquipo(DetalleEquipo detalleEquipo) {
		getDetalleEquipos().remove(detalleEquipo);
		detalleEquipo.setEquipoBean(null);

		return detalleEquipo;
	}

}