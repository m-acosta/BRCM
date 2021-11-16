package model.dataccess;

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
			purchases = session.createQuery("from purchase").list();
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
