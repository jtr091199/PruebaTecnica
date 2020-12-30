package pe.com.eai.reporte.banco.service;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.com.eai.reporte.banco.domain.BancoListType;
import pe.com.eai.reporte.banco.domain.OrdenesPago;

@Path("/bancoservice")
public interface IBancoService {


	// http://localhost:8080/Reporte_banco/services/bancoservice/getOrdenesPago/USD
	@GET
	@Path("getOrdenesPago/{moneda}")
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public OrdenesPago getOrdenesPago(@PathParam("moneda") String moneda);



	// http://localhost:8080/Reporte_banco/services/bancoservice/getallentidades
	@GET
	@Path("getallentidades")
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public BancoListType getAllEntidades();
}