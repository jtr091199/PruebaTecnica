package pe.com.eai.reporte.banco.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BANCOS")
public class Bancos {
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "DIRECCION")
	private String direccion;
	@Column(name = "FECHA")
	private String fecharegistro;
	@Id
	@GeneratedValue
	@Column(name = "CODIGO")
	private String codigo;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<OrdenesPago> ordenes;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Sucursales> sucursales;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(String fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
