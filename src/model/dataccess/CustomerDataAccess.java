package model.dataccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entities.ActivityPurchase;
import model.entities.ActivityPurchaseId;
import model.entities.Customer;
import model.entities.Purchase;
import model.business.HibernateUtil;

public class CustomerDataAccess {
	
	public void saveCustomer(Customer customer)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(customer);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
	}
	
	public void updateCustomer(Customer customer)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(customer);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
	}
	
	public Customer getCustomerById(String bronco_id)
	{
		Transaction transaction = null;
		Customer customer = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			customer = session.get(Customer.class, bronco_id);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return customer;
	}
	
	public List<Customer> getAllCustomers()
	{
		Transaction transaction = null;
		List<Customer> customers = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			customers = (List<Customer>) session.createQuery("FROM Customer", Customer.class).list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return customers;
	}

	public Customer deleteCustomer(String bronco_id)
	{
		Transaction transaction = null;
		Customer customer = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			List<Purchase> purchases = (List<Purchase>) session.createQuery("FROM Purchase WHERE bronco_id = '" + bronco_id + "'", Purchase.class).list();
			Purchase purchase = null;
			for(Purchase temp: purchases)
			{
				ActivityPurchase activity_purchase = null;
				List<ActivityPurchase> activity_purchases = (List<ActivityPurchase>) session.createQuery("FROM ActivityPurchase WHERE purchase_id = '" + purchase.getPurchaseId() + "'", ActivityPurchase.class).list();
				for(ActivityPurchase temp2: activity_purchases)
				{
					transaction = session.beginTransaction();
					activity_purchase = session.get(ActivityPurchase.class, temp2.getPrimaryKey());
					session.delete(activity_purchase);
					transaction.commit();
				}
				transaction = session.beginTransaction();
				purchase = session.get(Purchase.class, temp.getPurchaseId());
				session.delete(purchase);
				transaction.commit();
			}
			transaction = session.beginTransaction();
			customer = session.get(Customer.class, bronco_id);
			session.delete(customer);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return customer;
	}
}
