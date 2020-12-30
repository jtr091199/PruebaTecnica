
	package pe.com.eai.reporte.banco.domain;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "ORDENESPAGO")
	public class OrdenesPago {
		@Column(name = "MONTO")
		private String monto;
		@Column(name = "MONEDA")
		private String moneda;
		@Column(name = "ESTADO")
		private String estado;
		@Column(name = "FECHAPAGO")
		private String fechapago;
		@Id
		@GeneratedValue
		@Column(name = "CODIGO")
		private String codigo;
		
		@Column(name = "CODIGOBANK")
		private String codigobank;

		public String getMonto() {
			return monto;
		}

		public void setMonto(String monto) {
			this.monto = monto;
		}

		public String getMoneda() {
			return moneda;
		}

		public void setMoneda(String moneda) {
			this.moneda = moneda;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getFechapago() {
			return fechapago;
		}

		public void setFechapago(String fechapago) {
			this.fechapago = fechapago;
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

