package model.business;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.entities.Activity;
import model.entities.ActivityPurchase;
import model.entities.Address;
import model.entities.Affiliation;
import model.entities.Customer;
import model.entities.Professor;
import model.entities.Purchase;
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
				settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/brcm_database");
				settings.put(Environment.USER, "postgres");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.USE_SQL_COMMENTS, "true"); // Comment out for production
				settings.put(Environment.FORMAT_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "validate"); // Production
				//settings.put(Environment.HBM2DDL_AUTO, "create-drop"); // Adding to seed uncomment 
				Configuration configuration = new Configuration().setProperties(settings);
				configuration.addAnnotatedClass(Address.class);
				configuration.addAnnotatedClass(Affiliation.class);
				configuration.addAnnotatedClass(Customer.class);
				configuration.addAnnotatedClass(Professor.class);
				configuration.addAnnotatedClass(Student.class);
				configuration.addAnnotatedClass(Status.class);
				configuration.addAnnotatedClass(Activity.class);
				configuration.addAnnotatedClass(Purchase.class);
				configuration.addAnnotatedClass(ActivityPurchase.class);
			
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	
	public static void close()
	{
		sessionFactory.close();
	}

}
