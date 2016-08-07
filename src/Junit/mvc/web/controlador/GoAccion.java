package Junit.mvc.web.controlador;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Junit.mvc.modelo.DAO.GenericDAOImp;
import Junit.mvc.web.bean.AccountBean;
import Junit.mvc.web.service.CRUDService;
import Junit.mvc.web.service.Impl.AccounService;

@Controller
public class GoAccion {
	 private static final Logger logger = Logger.getLogger(GoAccion.class);
@Autowired
CRUDService<AccountBean> accountCRUD;
	@RequestMapping(value="/go")
	public String go(){
		accountCRUD.todos();
		return "inicio";
	}
}
