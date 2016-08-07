package Junit.mvc.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import Junit.mvc.web.service.Impl.AccounService;

public class HibernateHelper {
	 private static final Logger logger = Logger.getLogger(HibernateHelper.class);
	private static final SessionFactory SESSION_FACTORY=crearSessionFactory();

	private static SessionFactory crearSessionFactory() {
		try {
			return new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			logger.fatal("-----Fatal error creando la session a la BD:   "+ex+"");
            throw new ExceptionInInitializerError(ex);

		}

	}
	
	public static SessionFactory getSessionFactory(){
		return SESSION_FACTORY;
	}
}
