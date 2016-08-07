package Junit.mvc.web.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Junit.mvc.modelo.AccounDAO;
import Junit.mvc.modelo.DAO.GenericDAOImp;
import Junit.mvc.modelo.pojo.Account;
import Junit.mvc.web.bean.AccountBean;
import Junit.mvc.web.service.CRUDService;
@Service(value="accountCRUD")
public class AccounService implements CRUDService<AccountBean>{
	 private static final Logger logger = Logger.getLogger(AccounService.class);

	@Autowired
	private AccounDAO accountDAO;
	
	//servicio para ñla busqueda de account todos
	@Override
	public List<AccountBean> todos() {
		/// obtener 
		List <Account> list=null;
		List <AccountBean> listBean= new ArrayList<>();
		try{
			list= accountDAO.buscarTodos();
			//pasar de modelo.pojo a bean
			if(list!=null)
			for(Account a: list){
				
				listBean.add(this.getAccountBean(a)
						
						);
			}
			else
				logger.info("Sin datos servicio->todos ");
		}catch(Exception e){
			logger.error("Error en Servcio->todos : "+e);
		}
		return listBean;
	}

	@Override
	public AccountBean buscarPorID(int id) {
		// Buscar el elemento
		Account a= accountDAO.buscarPorClave(id);
		AccountBean bean=null;
		if(a!=null){
			// si existe
			///pasar de pojo a bean
			bean = getAccountBean(a);
		}
		return bean;
	}
//metodo para psar de pojo a bean
	private AccountBean getAccountBean(Account a) {
		AccountBean bean= new AccountBean();
		bean.setBalance(a.getBalance());
		bean.setEstado(a.getEstado());
		bean.setId(a.getId());
		bean.setNombre(a.getNombre());
		bean.setNumero(a.getNumero());
		return bean;
	}

	@Override
	public boolean nuevoElemento(AccountBean t) {
		//estado
		boolean e=false;
		try{
		// si biene el dato pasar de bean a pojo
		if(t!=null)
		{
			 
			e=accountDAO.insertar(getAccountPojo(t));
					
		}else
			logger.info("sin dato en para añlmacenar");
		}catch(Exception ex){
			logger.error("en servicio nuevo account : "+ex);
		}
		return e;
	}
// cambiar de bean a pojo
	private Account getAccountPojo(AccountBean t) {
		Account acc= new Account();
		acc.setBalance(t.getBalance());
		acc.setEstado(t.getEstado());
		acc.setId(t.getId());
		acc.setNombre(t.getNombre());
		acc.setNumero(t.getNumero());
		return acc;
	}

	@Override
	public boolean eliminarElemento(Integer id) {
		// estatus
		boolean estatus=false;
		try{
			if(id!=null){
				//esxiste
				Account aEliminar=accountDAO.buscarPorClave(id);
				if(aEliminar!=null){
					
					estatus=accountDAO.borrar(aEliminar);
				}else
					logger.info("no Existe account con id:"+id);
			}else
				logger.info("sin id a eliminar");
		}catch(Exception e){
			logger.error("serviccio eliminar account : "+e);
		}
		
		return estatus;
	}

	@Override
	public boolean actulizar(AccountBean t) {
		// si existe dato camiber pojo a bean
		boolean estatus=false;
		try{
			if(t!=null){
				estatus= accountDAO.salvar(getAccountPojo(t));
			}else logger.info("sin account aactualizar");
			
			
		}catch(Exception e){
			logger.error(e);
		}
		return false;
	}

}
