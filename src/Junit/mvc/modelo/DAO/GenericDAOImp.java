package Junit.mvc.modelo.DAO;



import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Junit.mvc.modelo.GenericDAO;
import Junit.mvc.util.HibernateHelper;


public abstract class GenericDAOImp <T, id extends Serializable> implements GenericDAO<T, id>{
	private Class<T> claseDePersistencia;
	 private static final Logger logger = Logger.getLogger(GenericDAOImp.class);
	public GenericDAOImp() {
		this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.GenericDAO#buscarTodos()
	 */
	
	/* (non-Javadoc)
	 * @see sistema.telemetria.Modelo.GenericDAO#buscarTodos()
	 */
	@Override
	public List buscarTodos() {
		SessionFactory sessionFactory = null;
		org.hibernate.classic.Session session = null;
		 List lista = null;
		try {
			System.out.println("--------" +claseDePersistencia.getSimpleName().toLowerCase() +"-------------");
			sessionFactory = HibernateHelper.getSessionFactory();
			session = sessionFactory.openSession();
			lista = session.createQuery("from "+claseDePersistencia.getSimpleName()+" o").list();
			System.out.println("\n-----consulta general------  "
					+ claseDePersistencia.getSimpleName() + "\n");
			
		}	catch(Exception e){
			logger.error(Thread.currentThread().getStackTrace()[1].getMethodName(), e);
            throw e;	
		} finally {
			
			session.close();
			sessionFactory.close();
			return lista;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.GenericDAO#insertar(T)
	 */
	
	/* (non-Javadoc)
	 * @see sistema.telemetria.Modelo.GenericDAO#insertar(T)
	 */
	@Override
	public boolean insertar(T objeto) {
		boolean ex = false;
		SessionFactory sessionFactory = null;
		org.hibernate.classic.Session session = null;
		org.hibernate.Transaction transaction = null;
		try {
			sessionFactory = HibernateHelper.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			// insertando
			session.persist(objeto);
			transaction.commit();
			ex = true;
			System.out.print("modifcacion en: "
					+ claseDePersistencia.getSimpleName() + "\n");

		} catch (PersistenceException e) {
			transaction.rollback();
			ex = false;
			logger.error(Thread.currentThread().getStackTrace()[1].getMethodName(), e);
            throw e;
		} finally {
			session.close();
			sessionFactory.close();
		}
		return ex;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.GenericDAO#salvar(T)
	 */
	
	/* (non-Javadoc)
	 * @see sistema.telemetria.Modelo.GenericDAO#salvar(T)
	 */
	@Override
	public boolean salvar(T objeto) {
		SessionFactory sessionFactory = null;
		org.hibernate.classic.Session session = null;
		org.hibernate.Transaction transaction = null;
		boolean ex = false;
		try {
			sessionFactory = HibernateHelper.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(objeto);
			transaction.commit();
			ex = true;
			System.out.print("modifcacion en: "
					+ claseDePersistencia.getSimpleName() + "\n");

		} catch (PersistenceException e) {
			transaction.rollback();
			ex = false;
			logger.error(Thread.currentThread().getStackTrace()[1].getMethodName(), e);
            throw e;
		} finally {

			session.close();
			sessionFactory.close();
		}

		return ex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.GenericDAO#buscarPorClave(id)
	 */

	/* (non-Javadoc)
	 * @see sistema.telemetria.Modelo.GenericDAO#buscarPorClave(id)
	 */
	@Override
	public T buscarPorClave(id id) {

		
		
		
		SessionFactory sessionFactory = null;
		org.hibernate.classic.Session session = null;
		T objeto=null;
		try {
			sessionFactory = HibernateHelper.getSessionFactory();
			session = sessionFactory.openSession();
			objeto = (T) session.get(claseDePersistencia, id);
			System.out.println("\n-----consulta general------  "
					+ claseDePersistencia.getSimpleName() + "\n");
			return objeto;

		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	/* (non-Javadoc)
	 * @see sistema.telemetria.Modelo.GenericDAO#borrar(T)
	 */
	@Override
	public boolean borrar (T objeto){

		SessionFactory sessionFactory = null;
		org.hibernate.classic.Session session = null;
		org.hibernate.Transaction transaction = null;
		boolean ex = false;
		try {
			sessionFactory = HibernateHelper.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(objeto);
			transaction.commit();
			ex = true;
			System.out.print("modifcacion en: "
					+ claseDePersistencia.getSimpleName() + "\n");

		} catch (PersistenceException e) {
			transaction.rollback();
			ex = false;
			logger.error(Thread.currentThread().getStackTrace()[1].getMethodName(), e);
            throw e;
		} finally {

			session.close();
			sessionFactory.close();
		}

		return ex;
		
	}
}

