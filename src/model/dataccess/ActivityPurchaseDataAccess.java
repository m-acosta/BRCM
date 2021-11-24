package model.dataccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entities.Activity;
import model.entities.ActivityPurchase;
import model.entities.ActivityPurchaseId;
import model.business.HibernateUtil;

public class ActivityPurchaseDataAccess {
	public void saveActivityPurchase(ActivityPurchase activity_purchase)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(activity_purchase);
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
	
	public void updateActivityPurchase(ActivityPurchase activity_purchase)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(activity_purchase);
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
	
	public ActivityPurchase getActivityPurchaseById(ActivityPurchaseId primary_key)
	{
		Transaction transaction = null;
		ActivityPurchase activity_purchase = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			activity_purchase = session.get(ActivityPurchase.class, primary_key);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return activity_purchase;
	}
	
	public List<ActivityPurchase> getActivityPurchaseByActivity(String activity)
	{
		Transaction transaction = null;
		List<ActivityPurchase> activity_purchases = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			activity_purchases = (List<ActivityPurchase>)session.createQuery("FROM Activity_purchase A WHERE A.activity_name =" + activity, ActivityPurchase.class).list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return activity_purchases;
	}
	
	public List<ActivityPurchase> getActivityPurchaseByPurchaseId(int purchase_id)
	{
		Transaction transaction = null;
		List<ActivityPurchase> activity_purchases = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			activity_purchases = (List<ActivityPurchase>)session.createQuery("FROM ActivityPurchase WHERE purchase_id =" + purchase_id, ActivityPurchase.class).list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return activity_purchases;
	}
	
	public List<ActivityPurchase> getAllActivityPurchases()
	{
		Transaction transaction = null;
		List<ActivityPurchase> activity_purchases = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			activity_purchases = session.createQuery("from activity_purchase").list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return activity_purchases;
	}

	public ActivityPurchase deleteActivityPurchase(ActivityPurchaseId primary_key)
	{
		Transaction transaction = null;
		ActivityPurchase activity_purchase = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			activity_purchase = session.get(ActivityPurchase.class, primary_key);
			session.delete(activity_purchase);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return activity_purchase;
	}

}
