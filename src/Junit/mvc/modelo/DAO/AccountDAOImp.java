package Junit.mvc.modelo.DAO;

import org.springframework.stereotype.Repository;

import Junit.mvc.modelo.AccounDAO;
import Junit.mvc.modelo.pojo.Account;
@Repository(value="accountDAO")
public class AccountDAOImp extends GenericDAOImp<Account,Integer> implements AccounDAO{

}
