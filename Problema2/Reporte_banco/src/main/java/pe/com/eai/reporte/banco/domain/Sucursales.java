
	package pe.com.eai.reporte.banco.domain;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "SUCURSALES")
	public class Sucursales {
		@Column(name = "NOMBRE")
		private String nombre;
		@Column(name = "DIRECCION")
		private String direccion;
		@Column(name = "FECHA")
		private String fecharegistro;
		@Id
		@GeneratedValue
		@Column(name = "ID")
		private String codigo;
		@Column(name = "CODIGOBANK")
		private String codigobank;
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
		public String getCodigobank() {
			return codigobank;
		}
		public void setCodigobank(String codigobank) {
			this.codigobank = codigobank;
		}

	
	}

