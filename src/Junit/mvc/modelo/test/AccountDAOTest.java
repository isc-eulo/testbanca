package Junit.mvc.modelo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
///hace referencias para ejecutar las pruebas de esa clase en lugar de
// @test indica metodo de prueba

import Junit.mvc.modelo.AccounDAO;
import Junit.mvc.modelo.pojo.Account;
import Junit.mvc.web.bean.AccountBean;
//@RunWith(SpringJUnit4ClassRunner.class)
/// para ijectar lo beans 
//@ContextConfiguration(locations="file:WebContent/WEB-INF/spring-servlet.xml")
public class AccountDAOTest {
	private final static Logger logger =LoggerFactory.getLogger(AccountDAOTest.class);
	@Autowired
	private AccounDAO accountDAO;
	
	@Test
	public void testFindAll(){
		/// obtener 
		logger.info("prueba DAO busacr todos");
				List <Account> list=null;
				try{
					list= accountDAO.buscarTodos();
					 assertNotNull("Account list is null.", list);
					logger.info("fint test se todos");
					//pasar de modelo.pojo a bean
				
				}catch(Exception e){
					logger.error("Error en preuva todos : "+e);
				}
	}

	
	@Test 
	public void tesnuevo(){
		logger.info("prueba DAO NUEVO");
		try{
			// si biene el dato pasar de bean a pojo
		 Account a= new Account();
		 a.setBalance("test");
		 a.setEstado("test");
		 a.setId(100);
		 a.setNombre("test");
		 a.setNumero("1000");
		 assertTrue(accountDAO.insertar(a));
				
						
				logger.info("fint test inserto");
			}catch(Exception ex){
				logger.error("en test nuevo account : "+ex);
			}
	}

	@Test 
	public void tesActulzar(){
		logger.info("prueba DAO Actialziar");
		try{
			// si biene el dato pasar de bean a pojo
		 Account a= new Account();
		 a.setBalance("test Actulizar");
		 a.setEstado("test Actualziar");
		 a.setId(100);
		 a.setNombre("test Actualizar");
		 a.setNumero("1000");
			assertTrue(	accountDAO.salvar(a));
						
				logger.info("fin test Actualzio");
				logger.info("prueba DAO busacr por id");
				Account n= accountDAO.buscarPorClave(100);
				assertNotNull(n);
				assertEquals(n.getId(), a.getId());
				assertEquals(n.getBalance(), a.getBalance());
				assertEquals(n.getEstado(), a.getEstado());
				assertEquals(n.getNombre(), a.getNombre());
				assertEquals(n.getNumero(), a.getNumero());
			}catch(Exception ex){
				logger.error("en test acuzlizar : "+ex);
			}
	}
	
	@Test 
	public void tesElimiina(){
		logger.info("prueba DAO Elimina");
		try{
			// si biene el dato pasar de bean a pojo
		 Account a= new Account();
		 a.setBalance("test");
		 a.setEstado("test");
		 a.setId(100);
		 a.setNombre("test");
		 a.setNumero("1000");
			assertTrue(	 accountDAO.borrar(a));
						
				logger.info("fin  test elimino");
			}catch(Exception ex){
				logger.error("en test elimina account : "+ex);
			}
	}
	// se ejcuta al crearse la clase
	@BeforeClass
	public static void inicializacionClass(){
	logger.info("Inicialización de la clase de Test...!");
	}
	
	
	// se ejecuta al finalizar


	@AfterClass
	public static void finalizacionClass(){
	logger.info("Finalización de la clase de Test...!");

	}
	// se ejecut antes q los metodos de prueba
	@Before
	public void inicializacion(){
	logger.info("Inicialización de método de prueba ...!");
	}
	// sejecuta depues de los metods de prueba
	@After
	public void finalizacion2(){
	logger.info("Finalización de método de prueba 2...!");
	}
	
}
