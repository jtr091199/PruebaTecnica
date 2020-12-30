package pe.com.eai.reporte.banco.service;

import java.util.List;

import pe.com.eai.reporte.banco.domain.BancoListType;
import pe.com.eai.reporte.banco.domain.Bancos;
import pe.com.eai.reporte.banco.domain.OrdenesPago;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bancoService")
public class BancoServiceImpl implements IBancoService {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public OrdenesPago getOrdenesPago(String moneda) {
OrdenesPago orden = (OrdenesPago) sessionFactory.getCurrentSession().get(OrdenesPago.class, moneda);

		OrdenesPago getOrden = new OrdenesPago	();
		getOrden.setCodigo(orden.getCodigo());
		getOrden.setEstado(orden.getEstado());
		getOrden.setMoneda(orden.getMoneda());
		return getOrden;
	}



	@SuppressWarnings("unchecked")
	@Transactional
	public BancoListType getAllEntidades() {

		List<Bancos> lstBanco = sessionFactory.getCurrentSession().createCriteria(Bancos.class).list();

		
		BancoListType bancoListType = new BancoListType();

		for(Bancos banco : lstBanco) {
			
			Bancos bancoType = new Bancos();
			bancoType.setCodigo(banco.getCodigo());
			bancoType.setDireccion(banco.getDireccion());
			bancoType.setFecharegistro(banco.getFecharegistro());
			bancoListType.getbancoType().add(bancoType);
		}
		return bancoListType;
	}
}