package Junit.mvc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class HibernateHelper {
	private static final SessionFactory SESSION_FACTORY=crearSessionFactory();

	private static SessionFactory crearSessionFactory() {
		try {
			return new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("\n Fatal error creando la session a la BD:\n    "+ex+"\n");
            throw new ExceptionInInitializerError(ex);

		}

	}
	
	public static SessionFactory getSessionFactory(){
		return SESSION_FACTORY;
	}
}
