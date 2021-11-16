package resources;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.entities.Activity;
import model.entities.Address;
import model.entities.Affiliation;
import model.entities.Customer;
import model.entities.Order;
import model.entities.OrderActivity;
import model.entities.Professor;
import model.entities.Status;
import model.entities.Student;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory == null)
		{
			try {
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://localhost:5433/brcm_db");
				settings.put(Environment.USER, "postgres");
				settings.put(Environment.PASS, "password");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				Configuration configuration = new Configuration().setProperties(settings);
				configuration.addAnnotatedClass(Address.class);
				configuration.addAnnotatedClass(Affiliation.class);
				configuration.addAnnotatedClass(Customer.class);
				configuration.addAnnotatedClass(Professor.class);
				configuration.addAnnotatedClass(Student.class);
				configuration.addAnnotatedClass(Status.class);
				configuration.addAnnotatedClass(Activity.class);
				//configuration.addAnnotatedClass(Order.class);
				//configuration.addAnnotatedClass(OrderActivity.class);
			
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

}
