package model.dataccess;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entities.Purchase;
import model.business.HibernateUtil;

public class PurchaseDataAccess {
	public void savePurchase(Purchase purchase)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(purchase);
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
	
	public void updatePurchase(Purchase purchase)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(purchase);
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
	
	public Purchase getPurchaseById(int purchase_id)
	{
		Transaction transaction = null;
		Purchase purchase = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			purchase = session.get(Purchase.class, purchase_id);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return purchase;
	}
	
	public List<Purchase> getAllPurchases()
	{
		Transaction transaction = null;
		List<Purchase> purchases = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			purchases = (List<Purchase>)session.createQuery("FROM Purchase", Purchase.class).list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return purchases;
	}
	
	public List<Purchase> getAllPurchasesByCustomerId(String bronco_id)
	{
		Transaction transaction = null;
		List<Purchase> purchases = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			purchases = (List<Purchase>)session.createQuery("FROM Purchase WHERE bronco_id = '" + bronco_id + "'", Purchase.class).list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return purchases;
	}
	
	public List<Purchase> getAllPurchasesByCustomerDate(String bronco_id, LocalDate date)
	{
		Transaction transaction = null;
		List<Purchase> purchases = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			purchases = (List<Purchase>)session.createQuery("FROM Purchase WHERE bronco_id = '" + bronco_id + "' AND date > DATE('" + date + "')", Purchase.class).list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return purchases;
	}


	public Purchase deletePurchase(int purchase_id)
	{
		Transaction transaction = null;
		Purchase purchase = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			purchase = session.get(Purchase.class, purchase_id);
			session.delete(purchase);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return purchase;
	}

}
